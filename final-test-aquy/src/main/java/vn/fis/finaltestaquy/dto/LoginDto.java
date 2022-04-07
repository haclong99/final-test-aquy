package vn.fis.finaltestaquy.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginDto {
    @NotNull(message = "không được để trống")
    private String usernameOrEmail;
    private String password;
}
