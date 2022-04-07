package vn.fis.finaltestaquy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
@Data
public class Account extends BaseEntity{
    @Column(name = "account_number")
    private String accountNumber;
    private Double balance;
    @Enumerated(EnumType.ORDINAL)
    private StatusAccount status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",referencedColumnName="id")
    @JsonIgnoreProperties("accountList")
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="fromAccount", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("fromAccount")
    private List<Transaction> fromAccountList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy="toAccount", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("toAccount")
    private List<Transaction> toAccountList = new ArrayList<>();
}
