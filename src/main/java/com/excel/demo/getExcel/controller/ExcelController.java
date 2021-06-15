package com.excel.demo.getExcel.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.excel.demo.getExcel.entity.*;
import com.excel.demo.getExcel.service.*;
import com.excel.demo.getExcel.utils.PoiUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Action;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysAccountService sysAccountService;
    @Autowired
    private ISysOrgService sysOrgService;
    @Autowired
    private SysAccountRoleRelaService sysAccountRoleRelaService;
    @Autowired
    private WaterTestService waterTestService;

    @RequestMapping("/getExcelRole")
    @Transactional
    public void getExcelRole() throws Exception {
        File file =  new File("D:\\work\\shuju.xls");
        InputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), inputStream);
        List<WaterTest> waterTests = PoiUtils.importRole2List(multipartFile);
        waterTests.stream().forEach(e->{
            waterTestService.save(e);
        });
        System.out.println("导入完成");
    }


    @RequestMapping("/getExcel")
    @Transactional
    public void getExcel() throws Exception {
        File file =  new File("D:\\work\\test.xls");
        int count = sysUserService.count();
        System.out.println(count);

        InputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), inputStream);
        List<SysUser> sysUsers = PoiUtils.importUser2List(multipartFile);
        sysUsers.stream().forEach(e->{
            if(!"".equals(e.getCn())){
                System.out.println(e);
                sysUserService.save(e);
            }
        });
        System.out.println("导入完成");
    }

    @Transactional
    @RequestMapping("/getExcel2")
    public void getExcel2() throws Exception {
        File file =  new File("D:\\work\\test2.xls");
        InputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), inputStream);
        List<SysAccount> sysAccounts = PoiUtils.importAccount2List(multipartFile);
        sysAccounts.stream().forEach(e->{
            if(!"".equals(e.getAccountName())){
                System.out.println(e);
                sysAccountService.save(e);
            }
        });
        System.out.println("导入完成");
    }

    @RequestMapping("/getExcel3")
    public void getExcel3() throws Exception {
        File file =  new File("D:\\work\\test3.xls");
        InputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), inputStream);
        List<SysOrg> sysOrgs = PoiUtils.importOrg2List(multipartFile);
        sysOrgService.saveBatch(sysOrgs);
    }
    @PostMapping("/updateShuju")
    public void updateShuju() throws Exception {
        List<WaterTest> list = waterTestService.list();
        list.stream().forEach(e->{
            List<WaterTest> year = waterTestService.list(new QueryWrapper<WaterTest>().eq("year", e.getYear()));
            Double all = 0.0;
            for(WaterTest f : year){
                all += f.getPeopleAll();
            };
            e.setGdpOfPeppleAll(e.getGdp()/e.getPeopleAll());
            e.setLifeInAll(e.getWaterLife()/e.getWaterAll());
            e.setWaterOfGdp(e.getWaterAll()/e.getGdp());
            waterTestService.updateById(e);
        });
    }

    @PostMapping("/getShuju2")
    public void getShuju2(String year1,String year2) throws Exception {
        for(int i=2007;i<=2019;i++){
            double peopleAll = 0.0;
            double gdp = 0.0;
            double peopleCity = 0.0;
            double waterAll = 0.0;
            double waterLife = 0.0;
            List<WaterTest> waterTests = waterTestService.list(new QueryWrapper<WaterTest>().eq("year", i));
            for(WaterTest waterTest : waterTests){
                peopleAll +=waterTest.getPeopleAll();
                gdp += waterTest.getGdp();
                peopleCity+=waterTest.getPeopleCity();
                waterAll+=waterTest.getWaterAll();
                waterLife+=waterTest.getWaterLife();
            };
            WaterTest waterTest = new WaterTest();
            waterTest.setYear(String.valueOf(i));
            waterTest.setCity("山东省");
            waterTest.setPeopleAll(peopleAll);
            waterTest.setGdp(gdp);
            waterTest.setPeopleCity(peopleCity);
            waterTest.setWaterAll(waterAll);
            waterTest.setWaterLife(waterLife);
            waterTestService.save(waterTest);
        }
    }


    @PostMapping("/getShuju")
    public void getShuju(@RequestBody Map<String,Object> map) throws Exception {
        String year1 = map.get("year1").toString();
        String year2 = map.get("year2").toString();
        //小年份
        List<WaterTest> waterTests1 = waterTestService.list(new QueryWrapper<WaterTest>().eq("year", year1));
        //大年份
        List<WaterTest> waterTests2 = waterTestService.list(new QueryWrapper<WaterTest>().eq("year", year2));

        waterTests2.stream().forEach(e->{
            WaterTest waterTest = waterTests1.stream().filter(f -> f.getCity().equals(e.getCity())).collect(Collectors.toList()).get(0);
            double common = (e.getWaterLife() - waterTest.getWaterLife()) / (Math.log(e.getWaterLife()) - Math.log(waterTest.getWaterLife()));
            double detes = common * Math.log(e.getLifeInAll() / waterTest.getLifeInAll());
            double detet = common * Math.log(e.getWaterOfGdp() / waterTest.getWaterOfGdp());
            double detee = common * Math.log(e.getGdpOfPeppleAll() / waterTest.getGdpOfPeppleAll());
            double detep = common * Math.log(e.getPeopleAll() / waterTest.getPeopleAll());
            double detedw = e.getWaterLife() - waterTest.getWaterLife();
            e.setDetee(detee);
            e.setDetep(detep);
            e.setDetes(detes);
            e.setDetet(detet);
            e.setDetedw(detedw);
            e.setDetedws(detee+detep+detes+detet);
            waterTestService.updateById(e);
        });
    }


}
