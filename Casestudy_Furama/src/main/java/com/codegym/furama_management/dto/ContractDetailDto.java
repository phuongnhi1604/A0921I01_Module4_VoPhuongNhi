package com.codegym.furama_management.dto;

import com.codegym.furama_management.model.AttachService;
import com.codegym.furama_management.model.Contract;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;


public class ContractDetailDto {
    @Min(value = 1, message = "Phai nhap so duong.")
    private int contract_detail_id;
    private Contract contract;
    private AttachService attachService;
    @Min(value = 1, message = "Phai nhap so duong.")
    private int quantity;

    public ContractDetailDto() {
    }

    public int getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(int contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
