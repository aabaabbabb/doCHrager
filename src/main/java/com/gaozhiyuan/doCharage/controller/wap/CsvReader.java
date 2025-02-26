package com.gaozhiyuan.doCharage.controller.wap;

import com.gaozhiyuan.doCharage.model.LcElongHotels;
import com.gaozhiyuan.doCharage.service.LcElongHotelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class CsvReader {

    private final LcElongHotelsService lcElongHotelsService;

    @Autowired
    public CsvReader(LcElongHotelsService lcElongHotelsService) {
        this.lcElongHotelsService = lcElongHotelsService;
    }
    public void processCsvFiles() {
        LcElongHotels lcElongHotels = lcElongHotelsService.getById("53");
        System.out.println(lcElongHotels);
    }

    public static void main(String[] args) {
        // 在Spring Boot应用中，通常不需要手动创建Bean，Spring会自动管理Bean的生命周期
        ApplicationContext context = SpringApplication.run(CsvReader.class, args);
        CsvReader csvReader = context.getBean(CsvReader.class);
        csvReader.processCsvFiles();
    }
}

