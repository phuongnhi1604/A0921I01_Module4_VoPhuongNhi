package com.codegym.furama_management.dto;

import com.codegym.furama_management.model.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDto {
    private int employee_id;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "[a-zA-Z\\s]{2,50}", message = "Tên chứa kí tự khác hoặc quá dài")
    private String employee_name;
    private String employee_birthday;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^[0-9]{10,12}$", message = "CMND chưa đúng định dạng")
    private String employee_id_card;

    @Min(value = 1, message = "Phai nhap so duong.")
    private double employee_salary;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^(84|0)9([0|1])[0-9]{7}$", message = "SĐT chưa đúng định dạng")
    private String employee_phone;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "(\\W|^)[\\w.+\\-]*@gmail\\.com(\\W|$)", message = "Email chưa đúng định dạng")
    private String employee_email;

    @NotBlank(message = "Không được để trống")
    private String employee_address;

    private Position position;
    private EducationDegree educationDegree;
    private Division division;

    private User user;
    private List<Contract> contractList = new ArrayList<>();

    public EmployeeDto() {
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_birthday() {
        return employee_birthday;
    }

    public void setEmployee_birthday(String employee_birthday) {
        this.employee_birthday = employee_birthday;
    }

    public String getEmployee_id_card() {
        return employee_id_card;
    }

    public void setEmployee_id_card(String employee_id_card) {
        this.employee_id_card = employee_id_card;
    }

    public double getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public String getEmployee_address() {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

}
