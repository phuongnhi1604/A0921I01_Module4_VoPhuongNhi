package com.codegym.furama_management.dto;

import com.codegym.furama_management.model.Customer;
import com.codegym.furama_management.model.Employee;
import com.codegym.furama_management.model.Service;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;


public class ContractDto {
    private int contract_id;
    private String contract_start_date;
    private String contract_end_date;
    @Min(value = 1, message = "Phai nhap so duong.")
    private double contract_deposit;
    @Min(value = 1, message = "Phai nhap so duong.")
    private double contract_total_money;
    private Employee employee;
    private Customer customer;
    private Service service;

    public ContractDto() {
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public String getContract_start_date() {
        return contract_start_date;
    }

    public void setContract_start_date(String contract_start_date) {
        this.contract_start_date = contract_start_date;
    }

    public String getContract_end_date() {
        return contract_end_date;
    }

    public void setContract_end_date(String contract_end_date) {
        this.contract_end_date = contract_end_date;
    }

    public double getContract_deposit() {
        return contract_deposit;
    }

    public void setContract_deposit(double contract_deposit) {
        this.contract_deposit = contract_deposit;
    }

    public double getContract_total_money() {
        return contract_total_money;
    }

    public void setContract_total_money(double contract_total_money) {
        this.contract_total_money = contract_total_money;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

}
