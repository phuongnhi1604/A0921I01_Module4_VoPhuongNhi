package com.codegym.furama_management.model.Dto;

import com.codegym.furama_management.model.AttachService;
import com.codegym.furama_management.model.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class ContractDetailDto implements Validator {
    private int contract_detail_id;
    private Contract contract;
    private AttachService attachService;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDetailDto contractDetailDto = (ContractDetailDto) target;
        if (contractDetailDto.getQuantity() <= 0){
            errors.rejectValue("quantity","number.compare","Bị lỗi");
        }
    }
}
