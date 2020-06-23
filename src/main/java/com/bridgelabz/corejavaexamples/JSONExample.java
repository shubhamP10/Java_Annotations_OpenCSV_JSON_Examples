package com.bridgelabz.corejavaexamples;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class JSONExample {
    private static final String SAMPLE_CSV_PATH = "./users.csv";
    private static final String SAMPLE_JSON_PATH = "./users.json";

    public static void jsonExample() throws IOException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_PATH));
            CsvToBeanBuilder<CSVUser> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CSVUser.class).withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVUser> csvToBean = csvToBeanBuilder.build();
            List<CSVUser> csvUserList = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(csvUserList);
            FileWriter writer = new FileWriter(SAMPLE_JSON_PATH);
            writer.write(json);
            writer.close();
            BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_PATH));
            CSVUser[] userObj = gson.fromJson(br,CSVUser[].class);
            List<CSVUser> csvUserList1 = Arrays.asList(userObj);
            System.out.println(csvUserList1.get(0));
        } finally {

        }
    }
}
