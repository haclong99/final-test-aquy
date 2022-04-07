package vn.fis.finaltestaquy.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class CustomerDto {
    private Long id;
    @NotEmpty(message = "Tên không được bỏ trống")
    @Max(value = 100, message = "độ dài nhỏ hơn 100 ký tự")
    private String name;
    @NotEmpty(message = "ngày sinh không được để trống")
    private LocalDateTime birthday;
    @NotEmpty(message = "địa chỉ không được bỏ trống")
    private String address;
    @NotEmpty(message = "Số CMT/ Căn cước không được để trống")
    @Max(value = 10, message = "độ dài 10 ký tự số")
    private String identityNo;
    @Max(value = 10, message = "độ dài 10 số")
    private String mobile;
    private String customerType;
}
