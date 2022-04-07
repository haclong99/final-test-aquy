package vn.fis.finaltestaquy.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TransactionDto {
    private Long id;
    @NotEmpty(message = "số tài khoản thực hiện chuyển khoản không được bỏ trống")
    private Long fromAccount;
    @NotEmpty(message = "số tài khoản nhận chuyển khoản không được bỏ trống")
    private Long toAccount;
    @NotEmpty(message = "số tiền thực hiện chuyển khoản không được bỏ trống")
    private Double amount;
    private String content;
}
