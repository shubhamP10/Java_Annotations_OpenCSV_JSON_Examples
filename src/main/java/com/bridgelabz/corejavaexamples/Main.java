package com.bridgelabz.corejavaexamples;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int i=0,choice;
        Scanner input = new Scanner(System.in);
        while (i == 0) {
            System.out.println("1. @Annotations Example\n" +
                    "2. OpenCSV Examples\n" +
                    "3. Exit");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    AnnotationExample.annotationExample();
                    break;
                case 2:
                    OpenCSVExample.csvExample();
                    break;
                case 3:
                    i=1;
                    break;
                default:
                    System.out.println("Enter Valid Option please...");
            }
        }
    }
}
