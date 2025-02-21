package com.gaozhiyuan.doCharage.mapper.primary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gaozhiyuan.doCharage.model.XdReceivingAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;

/**
* @author Administrator
* @description 针对表【xd_receiving_account(收款账户表)】的数据库操作Mapper
* @createDate 2025-02-20 13:56:25
* @Entity com.gaozhiyuan.doCharage.model.XdReceivingAccount
*/
@Mapper
public interface XdReceivingAccountMapper extends BaseMapper<XdReceivingAccount> {
    int countByCid(@Param("cid") Integer cid);
}




