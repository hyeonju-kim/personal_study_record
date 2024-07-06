package com.hj.hs_study.bankTransaction_240706;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {
    private final BankRepository bankRepository;

    // 1. 전체 입출금액의 total
    public long getDepositTotal() throws IOException {

        List<BankTransaction> transactions = FileService.convertToBT();

        long totalDeposit = 0;
        for (BankTransaction transaction : transactions) {
            totalDeposit += transaction.getDeposit();
        }
        return totalDeposit;
    }

    // 2. 사용구분코드(A1, A2, A3) 순으로 정렬 (같다면 원래 순서)
    public List<BankTransaction> sortByUseCode() throws IOException {

        List<BankTransaction> transactions = FileService.convertToBT();

        Collections.sort(transactions, new Comparator<BankTransaction>() {
            @Override
            public int compare(BankTransaction o1, BankTransaction o2) {
                return o1.getUseCode().compareTo(o2.getUseCode());
            }
        });
        return transactions;
    }

    // 3. localhost:8081에서 10분마다 전송되는 [전체 입출금액의 total]를 H2 DB에 저장
    public void saveDepositTotalUpload(BankTransactionDto bankTransactionDto) {
        bankRepository.save(bankTransactionDto);
    }

    // 4. localhost:8081에서 10분마다 전송되는 [useCode 정렬된 리스트]를 H2 DB에 저장
    public void saveSortedListUpload(BankTransactionDto bankTransactionDto) {
        bankRepository.save(bankTransactionDto);
    }

}
