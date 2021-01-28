package com.excel.demo.getExcel.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.excel.demo.getExcel.entity.SysOrg;
import com.excel.demo.getExcel.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysOrgDao extends BaseMapper<SysOrg> {
}
