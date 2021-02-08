package com.excel.demo.getExcel.controller;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.excel.demo.getExcel.entity.SysAccount;
import com.excel.demo.getExcel.entity.SysOrg;
import com.excel.demo.getExcel.entity.SysUser;
import com.excel.demo.getExcel.service.ISysAccountService;
import com.excel.demo.getExcel.service.ISysOrgService;
import com.excel.demo.getExcel.service.ISysUserService;
import com.excel.demo.getExcel.utils.PoiUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
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


    @RequestMapping("/getExcel")
    public void getExcel() throws Exception {
        File file =  new File("D:\\work\\test.xls");
        InputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), inputStream);
        List<SysUser> sysUsers = PoiUtils.importUser2List(multipartFile);
        System.out.println(sysUsers);
        sysUserService.saveBatch(sysUsers);
    }

    @RequestMapping("/getExcel2")
    public void getExcel2() throws Exception {
        File file =  new File("D:\\work\\test2.xls");
        InputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), inputStream);
        List<SysAccount> sysAccounts = PoiUtils.importAccount2List(multipartFile);
        sysAccountService.saveBatch(sysAccounts);
    }

    @RequestMapping("/getExcel3")
    public void getExcel3() throws Exception {
        File file =  new File("D:\\work\\test3.xls");
        InputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), inputStream);
        List<SysOrg> sysOrgs = PoiUtils.importOrg2List(multipartFile);
        sysOrgService.saveBatch(sysOrgs);
    }

    /*@PostMapping("/excel")
    public void excel(HttpServletResponse response, HttpServletRequest request,
                      @RequestBody Map<String, String> params) throws Exception {
        QueryWrapper<SerBossPubFreeNum> query = getQuery(params);
        List<SerBossPubFreeNum> data = service.list(query);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(null, "SerBossPubFreeNum"),
                SerBossPubFreeNum.class, data);
        String fileName = String.format("SerBossPubFreeNum_%d.xls", System.currentTimeMillis());
        response.setHeader("Content-Disposition", "attachment;Filename="+ fileName);
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }*/
}
