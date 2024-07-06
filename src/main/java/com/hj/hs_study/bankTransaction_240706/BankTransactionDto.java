package com.hj.hs_study.bankTransaction_240706;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class BankTransactionDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long depositTotal;
    @OneToMany(mappedBy = "bankTransactionDto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BankTransaction> sortedBankTransaction;

    public BankTransactionDto(long depositTotal) {
        this.depositTotal = depositTotal;
    }

    public BankTransactionDto(List<BankTransaction> sortedBankTransaction) {
        this.sortedBankTransaction = sortedBankTransaction;
    }}
