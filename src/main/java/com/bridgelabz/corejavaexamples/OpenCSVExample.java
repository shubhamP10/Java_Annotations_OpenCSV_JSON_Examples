package com.bridgelabz.corejavaexamples;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCSVExample {
    private static final String SAMPLE_CSV_PATH = "./users.csv";

    public static void csvExample() throws IOException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_PATH));

            CSVReader csvReader = new CSVReader(reader);
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("***************************");
                System.out.println("Name : " + nextRecord[0]);
                System.out.println("Email : " + nextRecord[1]);
                System.out.println("Phone : " + nextRecord[2]);
                System.out.println("Country : " + nextRecord[3]);
                System.out.println("***************************");
            }
            Reader reader2 = Files.newBufferedReader(Paths.get(SAMPLE_CSV_PATH));
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader2)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<CSVUser> csvUsers = csvToBean.parse();
            System.out.println("Form List<>");
            for (CSVUser csvUser : csvUsers) {
                System.out.println("NAME : " + csvUser.getName());
                System.out.println("EMAIL : " + csvUser.getEmail());
            }

        } finally {

        }
    }
}
