package com.gaozhiyuan.doCharage;

import com.gaozhiyuan.doCharage.mapper.primary.XdCompanyMapper;
import com.gaozhiyuan.doCharage.mapper.primary.XdReceivingAccountMapper;
import com.gaozhiyuan.doCharage.model.XdReceivingAccount;
import com.gaozhiyuan.doCharage.service.XdReceivingAccountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CreatAccCount {

    @Autowired
    XdCompanyMapper xdCompanyMapper;
    @Autowired
    XdReceivingAccountMapper xdReceivingAccountMapper;
    @Test
  public void  DoCreat() {
        xdCompanyMapper.selectAll().forEach(x -> {
            int i = xdReceivingAccountMapper.countByCid(x.getId());
            log.info("公司：{}，已有{}个收款账号", x.getName(), i);
            if (i <= 0) {
                xdReceivingAccountMapper.insert(new XdReceivingAccount().builder().cid(x.getId())
                        .accountType(1)
                        .accountName(x.getName()).accountNumber("")
                        .createTime((int) System.currentTimeMillis())
                        .alterTime((int) System.currentTimeMillis()).build());
            }
        });


    }
}
