package com.excel.demo.getExcel.utils;


import com.excel.demo.getExcel.entity.*;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author:再来
 * @Date:2021/1/14
 * @Content:
 */
public class PoiUtils {
    // 从excel文件中导入数据

    /**
     * 解析excel
     *
     * @param file
     * @return
     */
    public static List<SysUser> importUser2List(MultipartFile file) throws IOException {
        List<SysUser> lists = new ArrayList<SysUser>();
        if (file.isEmpty()) {
            throw new IOException("excil为空");
        }

            // 根据上传文件的流获取一个 HSSFWorkbook 对象
        HSSFWorkbook workbook = null;
        try {
            workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("请使用载模板上传");
        }
            // 获取 workbook 中表单的个数
            int numberOfSheets = workbook.getNumberOfSheets();

            // 遍历表单
            for ( int i = 0; i < numberOfSheets; i++ ) {
                HSSFSheet sheet = workbook.getSheetAt(i);
                // 对于每个表单，先获取行数
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                for ( int j = 0; j < physicalNumberOfRows; j++ ) {
                    if (j == 0) {
                        continue;//标题行跳过
                    }
                    HSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue;//没数据跳过
                    }
                    SysUser sysUser = new SysUser();
                    String row0 =row.getCell(0)==null?"":row.getCell(0).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(0).getNumericCellValue()):row.getCell(0).toString();
                    String row1 =row.getCell(1)==null?"":row.getCell(1).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(1).getNumericCellValue()):row.getCell(1).toString();
                    String row2 =row.getCell(2)==null?"":row.getCell(2).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(2).getNumericCellValue()):row.getCell(2).toString();
                    String row3 =row.getCell(3)==null?"":row.getCell(3).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(3).getNumericCellValue()):row.getCell(3).toString();
                    String row4 =row.getCell(4)==null?"":row.getCell(4).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(4).getNumericCellValue()):row.getCell(4).toString();
                    String row5 =row.getCell(5)==null?"":row.getCell(5).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(5).getNumericCellValue()):row.getCell(5).toString();
                    String row6 =row.getCell(6)==null?"":row.getCell(6).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(6).getNumericCellValue()):row.getCell(6).toString();
                    String row7 =row.getCell(7)==null?"":row.getCell(7).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(7).getNumericCellValue()):row.getCell(7).toString();
                    sysUser.setAppId("1354721207640866817");
                    sysUser.setUserId(row1);//id
                    sysUser.setOrgCode(row2);
                    sysUser.setCompanyId("1354722520332210177");
                    sysUser.setCn(row0);//用户名
                    sysUser.setSn(getPinyin(row0));
                    sysUser.setStatus("0");
                    sysUser.setEmployeeType("1");
                    sysUser.setMobile(row3);
                    sysUser.setCreateTime(new Date().toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime());
                    sysUser.setUpdatedTime(new Date().toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime());
                    lists.add(sysUser);
                }
            }

        // 将遍历得到的数据集合返回
        return lists;
    }

    public static List<SysAccount> importAccount2List(MultipartFile file) throws IOException {
        List<SysAccount> lists = new ArrayList<SysAccount>();
        if (file.isEmpty()) {
            throw new IOException("excil为空");
        }

        // 根据上传文件的流获取一个 HSSFWorkbook 对象
        HSSFWorkbook workbook = null;
        try {
            workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("请使用载模板上传");
        }
        // 获取 workbook 中表单的个数
        int numberOfSheets = workbook.getNumberOfSheets();

        // 遍历表单
        for ( int i = 0; i < numberOfSheets; i++ ) {
            HSSFSheet sheet = workbook.getSheetAt(i);
            // 对于每个表单，先获取行数
            int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
            for ( int j = 0; j < physicalNumberOfRows; j++ ) {
                if (j == 0) {
                    continue;//标题行跳过
                }
                HSSFRow row = sheet.getRow(j);
                if (row == null) {
                    continue;//没数据跳过
                }
                SysAccount sysAccount = new SysAccount();
                String row0 =row.getCell(0)==null?"":row.getCell(0).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(0).getNumericCellValue()):row.getCell(0).toString();
                String row1 =row.getCell(1)==null?"":row.getCell(1).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(1).getNumericCellValue()):row.getCell(1).toString();
                String row2 =row.getCell(2)==null?"":row.getCell(2).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(2).getNumericCellValue()):row.getCell(2).toString();
                String row3 =row.getCell(3)==null?"":row.getCell(3).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(3).getNumericCellValue()):row.getCell(3).toString();
                String row4 =row.getCell(4)==null?"":row.getCell(4).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(4).getNumericCellValue()):row.getCell(4).toString();
                String row5 =row.getCell(5)==null?"":row.getCell(5).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(5).getNumericCellValue()):row.getCell(5).toString();
                String row6 =row.getCell(6)==null?"":row.getCell(6).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(6).getNumericCellValue()):row.getCell(6).toString();
                String row7 =row.getCell(7)==null?"":row.getCell(7).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(7).getNumericCellValue()):row.getCell(7).toString();
                sysAccount.setCustomAccountId(row2);//账户id
                sysAccount.setAccountId(row1);
                sysAccount.setUserId(row1);//userId
                sysAccount.setAppId("1354721207640866817");
                sysAccount.setAccountName(row0);//账户名称
                sysAccount.setLoginName(row3);//登录名称
                sysAccount.setLoginPass("123456Wp!@#");
                sysAccount.setStatus("0");
                sysAccount.setCreateTime(new Date().toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime());
                sysAccount.setUpdatedTime(new Date().toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime());
                sysAccount.setInitialPasswordFlag("1");
                lists.add(sysAccount);
            }
        }

        // 将遍历得到的数据集合返回
        return lists;
    }

    public static List<SysOrg> importOrg2List(MultipartFile file) throws IOException{
        List<SysOrg> lists = new ArrayList<SysOrg>();
        if (file.isEmpty()) {
            throw new IOException("excil为空");
        }

        // 根据上传文件的流获取一个 HSSFWorkbook 对象
        HSSFWorkbook workbook = null;
        try {
            workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("请使用载模板上传");
        }
        // 获取 workbook 中表单的个数
        int numberOfSheets = workbook.getNumberOfSheets();
        //新建一个组织
        SysOrg sysOrg1 = new SysOrg();
        sysOrg1.setAppId("1354721207640866817");
        sysOrg1.setCompanyId("1354722520332210177");
        sysOrg1.setOrgCode("37001000");
        sysOrg1.setParentOrgCode("0");
        sysOrg1.setDisplayName("省公司");
        sysOrg1.setStyle("1");
        sysOrg1.setStatus("0");
        sysOrg1.setCreateTime(new Date().toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime());
        sysOrg1.setUpdatedTime(new Date().toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime());
        lists.add(sysOrg1);
        // 遍历表单
        for ( int i = 0; i < numberOfSheets; i++ ) {
            HSSFSheet sheet = workbook.getSheetAt(i);
            // 对于每个表单，先获取行数
            int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
            for ( int j = 0; j < physicalNumberOfRows; j++ ) {
                if (j == 0) {
                    continue;//标题行跳过
                }
                HSSFRow row = sheet.getRow(j);
                if (row == null) {
                    continue;//没数据跳过
                }
                SysOrg sysOrg = new SysOrg();
                String row0 =row.getCell(0)==null?"":row.getCell(0).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(0).getNumericCellValue()):row.getCell(0).toString();
                String row1 =row.getCell(1)==null?"":row.getCell(1).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(1).getNumericCellValue()):row.getCell(1).toString();
                String row2 =row.getCell(2)==null?"":row.getCell(2).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(2).getNumericCellValue()):row.getCell(2).toString();
                String row3 =row.getCell(3)==null?"":row.getCell(3).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(3).getNumericCellValue()):row.getCell(3).toString();
                String row4 =row.getCell(4)==null?"":row.getCell(4).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(4).getNumericCellValue()):row.getCell(4).toString();
                String row5 =row.getCell(5)==null?"":row.getCell(5).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(5).getNumericCellValue()):row.getCell(5).toString();
                String row6 =row.getCell(6)==null?"":row.getCell(6).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(6).getNumericCellValue()):row.getCell(6).toString();
                String row7 =row.getCell(7)==null?"":row.getCell(7).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(7).getNumericCellValue()):row.getCell(7).toString();
                if("".equals(row1)){
                    continue;//没数据跳过
                }
                String[] split = row1.split(",");
                String s = split[split.length - 1];
                sysOrg.setAppId("1354721207640866817");
                sysOrg.setCompanyId("1354722520332210177");
                sysOrg.setOrgCode(row0);
                if(row2.equals("00320000000000000000")){
                    Pattern p = Pattern.compile("济南|青岛|淄博|枣庄|东营|烟台|潍坊|济宁|泰安|威海|日照|滨州|德州|聊城|临沂|菏泽|莱芜");
                    Matcher m = p.matcher(s); // 获取 matcher 对象
                    if(m.find()){
                        sysOrg.setParentOrgCode("0");
                    }else{
                        sysOrg.setParentOrgCode("37001000");
                    }
                }else{
                    sysOrg.setParentOrgCode(row2);
                }
                sysOrg.setDisplayName(s);
                sysOrg.setDisplayOrder(row3);
                sysOrg.setStyle(row4);
                sysOrg.setStatus("0");
                sysOrg.setCreateTime(new Date().toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime());
                sysOrg.setUpdatedTime(new Date().toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime());
                lists.add(sysOrg);
            }
        }

        // 将遍历得到的数据集合返回
        return lists;
    }

    /**
     * @param china (字符串 汉字)
     * @return 汉字转拼音 其它字符不变
     */
    public static String getPinyin(String china){
        HanyuPinyinOutputFormat formart = new HanyuPinyinOutputFormat();
        formart.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        formart.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        formart.setVCharType(HanyuPinyinVCharType.WITH_V);
        char[] arrays = china.trim().toCharArray();
        String result = "";
        try {
            for (int i=0;i<arrays.length;i++) {
                char ti = arrays[i];
                if(Character.toString(ti).matches("[\\u4e00-\\u9fa5]")){ //匹配是否是中文
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(ti,formart);
                    result += temp[0];
                }else{
                    result += ti;
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }

        return result;
    }

    public static List<WaterTest> importRole2List(MultipartFile file) throws IOException {
        List<WaterTest> lists = new ArrayList<WaterTest>();
        if (file.isEmpty()) {
            throw new IOException("excil为空");
        }

        // 根据上传文件的流获取一个 HSSFWorkbook 对象
        HSSFWorkbook workbook = null;
        try {
            workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("请使用载模板上传");
        }
        // 获取 workbook 中表单的个数
        int numberOfSheets = workbook.getNumberOfSheets();

        // 遍历表单
        for ( int i = 0; i < numberOfSheets; i++ ) {
            HSSFSheet sheet = workbook.getSheetAt(i);
            // 对于每个表单，先获取行数
            int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
            for ( int j = 0; j < physicalNumberOfRows; j++ ) {
                if (j == 0) {
                    continue;//标题行跳过
                }
                HSSFRow row = sheet.getRow(j);
                if (row == null) {
                    continue;//没数据跳过
                }
                WaterTest waterTest =new WaterTest();
                String row0 =row.getCell(0)==null?"":row.getCell(0).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(0).getNumericCellValue()):row.getCell(0).toString();
                String row1 =row.getCell(1)==null?"":row.getCell(1).getCellType().equals(CellType.NUMERIC)?String.valueOf((int)row.getCell(1).getNumericCellValue()):row.getCell(1).toString();
                String row2 =row.getCell(2)==null?"":row.getCell(2).getCellType().equals(CellType.NUMERIC)?String.valueOf((double)row.getCell(2).getNumericCellValue()):row.getCell(2).toString();
                String row3 =row.getCell(3)==null?"":row.getCell(3).getCellType().equals(CellType.NUMERIC)?String.valueOf((double)row.getCell(3).getNumericCellValue()):row.getCell(3).toString();
                String row4 =row.getCell(4)==null?"":row.getCell(4).getCellType().equals(CellType.NUMERIC)?String.valueOf((double)row.getCell(4).getNumericCellValue()):row.getCell(4).toString();
                String row5 =row.getCell(5)==null?"":row.getCell(5).getCellType().equals(CellType.NUMERIC)?String.valueOf((double)row.getCell(5).getNumericCellValue()):row.getCell(5).toString();
                String row6 =row.getCell(6)==null?"":row.getCell(6).getCellType().equals(CellType.NUMERIC)?String.valueOf((double)row.getCell(6).getNumericCellValue()):row.getCell(6).toString();
                String row7 =row.getCell(7)==null?"":row.getCell(7).getCellType().equals(CellType.NUMERIC)?String.valueOf((double)row.getCell(7).getNumericCellValue()):row.getCell(7).toString();
                waterTest.setYear(row0);
                waterTest.setCity(row1);
                waterTest.setPeopleAll(Double.valueOf(row2));
                waterTest.setGdp(Double.valueOf(row3));
                waterTest.setPeopleCity(Double.valueOf(row4));
                waterTest.setWaterAll(Double.valueOf(row5));
                waterTest.setWaterLife(Double.valueOf(row6));
                lists.add(waterTest);
            }
        }

        // 将遍历得到的数据集合返回
        return lists;
    }
}
