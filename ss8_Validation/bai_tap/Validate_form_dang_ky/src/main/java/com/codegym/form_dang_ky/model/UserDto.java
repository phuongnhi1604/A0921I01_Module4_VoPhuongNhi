package com.codegym.form_dang_ky.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UserDto implements Validator {
    private int id;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[a-zA-Z]{5,45}$", message = "Tên chưa đúng định dạnh")
    private String firstName;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[a-zA-Z]{5,45}$", message = "Tên chưa đúng định dạng")
    private String lastName;
    @Pattern(regexp = "^(84|0[3|5|7|8|9])+([0-9]{8})$", message = "Số điện thoại chưa đúng định dạng")
    private String phoneNumber;
    private int age;
    @Pattern(regexp = "(\\W|^)[\\w.+\\-]*@gmail\\.com(\\W|$)", message = "Email không đúng định dạng")
    private String email;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (userDto.getAge() < 18){
            errors.rejectValue("age","age.compare","Bị lỗi");
        }
    }
}
