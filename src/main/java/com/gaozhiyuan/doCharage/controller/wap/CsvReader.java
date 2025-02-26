package com.gaozhiyuan.doCharage.controller.wap;

import com.gaozhiyuan.doCharage.model.LcElongHotels;
import com.gaozhiyuan.doCharage.service.LcElongHotelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CsvReader {

    @Autowired
    LcElongHotelsService lcElongHotelsService;

    public void processCsvFiles() {
        LcElongHotels lcElongHotels =  lcElongHotelsService.getById("53");
        System.out.println(lcElongHotels);

    }

    public static void main(String[] args) {
        CsvReader csvReader = new CsvReader();
        csvReader.processCsvFiles();
    }
}

