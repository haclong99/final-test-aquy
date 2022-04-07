package vn.fis.finaltestaquy.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SignUpDto {
    private String name;
    @NotNull(message = "bắt buộc nhập")
    private String username;
    private String email;
    private String phone;
    @NotNull(message = "bắt buộc nhập")
    private String password;
}
