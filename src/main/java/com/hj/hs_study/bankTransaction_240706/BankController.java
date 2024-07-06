package com.hj.hs_study.bankTransaction_240706;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bank")
public class BankController {
    private final BankService bankService;

    // 1. 전체 입출금액의 total
    // http://localhost:8080/bank/deposit/total
    @GetMapping("/deposit/total")
    public long getDepositTotal() throws IOException {
        return bankService.getDepositTotal();
    }

    // 2. 사용구분코드(A1, A2, A3) 순으로 정렬
    // http://localhost:8080/bank/useCode/sort
    @GetMapping("/useCode/sort")
    public List<BankTransaction> sortByUseCode() throws IOException {
        return bankService.sortByUseCode();
    }

}
