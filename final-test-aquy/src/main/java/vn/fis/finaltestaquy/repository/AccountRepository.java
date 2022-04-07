package vn.fis.finaltestaquy.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.fis.finaltestaquy.entity.Account;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> findById(Long id);
    Account findByAccountNumber(String accountNumber);
    List<Account> findAccountByCustomer_Id(Long id);
}
