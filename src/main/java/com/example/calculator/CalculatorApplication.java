package com.example.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
        Scanner in = new Scanner(System.in);
        String chk;

        String question;
        do {
            Calculator cal = new Calculator();
            System.out.println("-------------");
            System.out.println("계산기 START");
            System.out.println("-------------");
            System.out.print("수식 (뒤에 = 붙일것): ");
            question=in.next();
            cal.setQeustion(question);
            System.out.println("답 = "+cal.cal());
            System.out.print("더 사용하시겠습니까?(o/x) : ");
            chk=in.next();
        }while (chk.equals("o"));
    }
}
