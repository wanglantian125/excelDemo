package com.excel.demo.getExcel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.excel.demo.getExcel.dao.SysAccountDao;
import com.excel.demo.getExcel.dao.SysUserDao;
import com.excel.demo.getExcel.entity.SysAccount;
import com.excel.demo.getExcel.entity.SysUser;
import com.excel.demo.getExcel.service.ISysAccountService;
import com.excel.demo.getExcel.service.ISysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysAccountServiceImpl extends ServiceImpl<SysAccountDao, SysAccount> implements ISysAccountService {
}

