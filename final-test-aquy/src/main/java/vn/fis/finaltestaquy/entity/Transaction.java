package vn.fis.finaltestaquy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime transactionDate;
    private Double amount;
    @Enumerated(EnumType.ORDINAL)
    private StatusTransaction status;
    private String content;
    private String errorReason;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "from_account_id",referencedColumnName="id")
    @JsonIgnoreProperties("from_account")
    private Account fromAccount;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "to_account_id",referencedColumnName="id")
    @JsonIgnoreProperties("to_account")
    private Account toAccount;
}
