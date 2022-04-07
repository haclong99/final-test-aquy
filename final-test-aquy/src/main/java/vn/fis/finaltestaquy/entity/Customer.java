package vn.fis.finaltestaquy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer extends BaseEntity{
    private String name;
    private LocalDateTime birthday;
    private String address;
    private String identityNo;
    private String mobile;
    private String customerType;
    @Enumerated(EnumType.ORDINAL)
    private StatusCustomer status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="customer", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("customer")
    private List<Account> accountList = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }
}
