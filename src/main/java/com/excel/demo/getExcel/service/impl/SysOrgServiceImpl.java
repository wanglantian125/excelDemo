package com.excel.demo.getExcel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.excel.demo.getExcel.dao.SysAccountDao;
import com.excel.demo.getExcel.dao.SysOrgDao;
import com.excel.demo.getExcel.entity.SysAccount;
import com.excel.demo.getExcel.entity.SysOrg;
import com.excel.demo.getExcel.service.ISysAccountService;
import com.excel.demo.getExcel.service.ISysOrgService;
import org.springframework.stereotype.Service;

@Service
public class SysOrgServiceImpl extends ServiceImpl<SysOrgDao, SysOrg> implements ISysOrgService {
}
