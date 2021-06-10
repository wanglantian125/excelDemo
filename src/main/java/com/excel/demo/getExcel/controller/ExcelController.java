package com.excel.demo.getExcel.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
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
        List<SysOrg> sysOrgs =sysOrgService.list();
        sysOrgs.stream().forEach(e->{
            if(e.getDisplayName().endsWith("公司")){
                e.setStyle("2");
            }else{
                e.setStyle("1");
            }
            sysOrgService.updateById(e);
        });
        System.out.println("success");
    }
}
