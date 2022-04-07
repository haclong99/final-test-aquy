package vn.fis.finaltestaquy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.fis.finaltestaquy.entity.Transaction;

import java.time.LocalDateTime;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    Transaction findByTransactionDate(LocalDateTime transactionDate);
}
