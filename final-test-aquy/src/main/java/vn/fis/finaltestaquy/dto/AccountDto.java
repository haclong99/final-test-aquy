package vn.fis.finaltestaquy.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AccountDto {
    @NotEmpty(message = "số tài khoản không được để trống")
    private String accountNumber;
    private Double balance;
}
