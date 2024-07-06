package com.hj.hs_study.bankTransaction_240706;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<BankTransactionDto, Long> {

}
