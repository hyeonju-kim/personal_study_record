package com.hj.hs_study.bankTransaction_240706;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

@Service
@RequiredArgsConstructor
public class FileService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static List<BankTransaction> convertToBT() throws IOException {
        File file = new File("C:\\java\\hs_study\\240706_java_test\\src\\main\\resources\\history.csv");
        Path filePath = Path.of(file.getPath()); // 1. Path객체로 filePath 읽고
        List<String> lines = Files.readAllLines(filePath); // 2. Files를 직접 readAllLines
        List<BankTransaction> bankTransactions = new ArrayList<>();
        for (String line : lines) {
            String[] values = line.split(",");

            if (values.length == 4) {
                try {
                    Date date = dateFormat.parse(values[0]);
                    long deposit = Long.parseLong(values[1]);
                    String description = values[2];
                    String useCode = values[3];



                    BankTransaction bankTransaction = new BankTransaction(date, deposit, description, useCode);
                    bankTransactions.add(bankTransaction);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return bankTransactions;
    }
}

