package com.hj.hs_study.bankTransaction_240706;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Data
@Service
@RequiredArgsConstructor
public class BankTransaction {

    //LocalDate date;
    private Date date;
    private long deposit; //입출금액
    private String description; // 사용내역
    private String useCode; // 사용구분코드
    //@Getter
   // private static List<BankTransaction> transactions = new ArrayList<>();
    /*
         30-01-2017,-100,Deliveroo,A1
         30-01-2017,-50,Tesco,A2
         01-02-2017,6000,Salary,A3
         02-02-2017,2000,Royalties,A2
         02-02-2017,-4000,Rent,A1
         03-02-2017,3000,Tesco,A3
         05-02-2017,-30,Cinema,A2
      */

//    static {
//        transactions.add(new BankTransaction(new Date(2017, 01, 30), -100, "Deliveroo", "A1"));
//        transactions.add(new BankTransaction(new Date(2017, 01, 30), -50, "Tesco", "A2"));
//        transactions.add(new BankTransaction(new Date(2017, 02, 01), 6000, "Salary", "A3"));
//        transactions.add(new BankTransaction(new Date(2017, 02, 02), 2000, "Royalties", "A2"));
//        transactions.add(new BankTransaction(new Date(2017, 02, 02), -4000, "Rent", "A1"));
//        transactions.add(new BankTransaction(new Date(2017, 02, 03), 3000, "Tesco", "A3"));
//        transactions.add(new BankTransaction(new Date(2017, 02, 05), -30, "Cinema", "A2"));
//    }

    public BankTransaction(Date date, long deposit, String description, String useCode) {
        this.date = date;
        this.deposit = deposit;
        this.description = description;
        this.useCode = useCode;
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "date=" + date +
                ", deposit=" + deposit +
                ", description='" + description + '\'' +
                ", useCode='" + useCode + '\'' +
                '}';
    }
}
