package com.hj.hs_study.bankTransaction_240706;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bank")
@Slf4j
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

    // 3. localhost:8081에서 10분마다 전송되는 [전체 입출금액의 total]를 H2 DB에 저장
    @PostMapping("/deposit/total/upload")
    public void saveDepositTotalUpload(@RequestBody BankTransactionDto bankTransactionDto) throws IOException {
        log.info(String.valueOf(bankTransactionDto));
        bankService.saveDepositTotalUpload(bankTransactionDto);
    }

    // 4. localhost:8081에서 10분마다 전송되는 [useCode 정렬된 리스트]를 H2 DB에 저장
    @PostMapping("/useCode/sort/upload")
    public void saveSortedListUpload(@RequestBody BankTransactionDto bankTransactionDto) throws IOException {
        log.info(String.valueOf(bankTransactionDto));
        bankService.saveSortedListUpload(bankTransactionDto);
    }

}
