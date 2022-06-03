package com.codegym.furama_management.model.Dto;

import com.codegym.furama_management.model.Contract;
import com.codegym.furama_management.model.RentType;
import com.codegym.furama_management.model.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class ServiceDto implements Validator {
    private int service_id;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "[a-zA-Z0-9\\s]{3,60}", message = "Tên chứa kí tự khác hoặc quá dài")
    private String service_name;

    private int service_area;
    private double service_cost;
    private int service_max_people;
    private RentType rentType;
    private ServiceType serviceType;

    private String standard_room;
    private String description_other_convenience;
    private double pool_area;
    private int number_of_floors;
    private List<Contract> contractList= new ArrayList<>();

    public ServiceDto() {
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getService_area() {
        return service_area;
    }

    public void setService_area(int service_area) {
        this.service_area = service_area;
    }

    public double getService_cost() {
        return service_cost;
    }

    public void setService_cost(double service_cost) {
        this.service_cost = service_cost;
    }

    public int getService_max_people() {
        return service_max_people;
    }

    public void setService_max_people(int service_max_people) {
        this.service_max_people = service_max_people;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public void setDescription_other_convenience(String description_other_convenience) {
        this.description_other_convenience = description_other_convenience;
    }

    public double getPool_area() {
        return pool_area;
    }

    public void setPool_area(double pool_area) {
        this.pool_area = pool_area;
    }

    public int getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(int number_of_floors) {
        this.number_of_floors = number_of_floors;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;
        if (serviceDto.getService_area() <= 0){
            errors.rejectValue("service_area","number.compare","Bị lỗi");
        }
        if (serviceDto.getService_cost() <= 0){
            errors.rejectValue("service_cost","number.compare","Bị lỗi");
        }
        if (serviceDto.getService_max_people() <= 0){
            errors.rejectValue("service_max_people","number.compare","Bị lỗi");
        }
        if (serviceDto.getPool_area() <= 0){
            errors.rejectValue("pool_area","number.compare","Bị lỗi");
        }
        if (serviceDto.getNumber_of_floors() <= 0){
            errors.rejectValue("number_of_floors","number.compare","Bị lỗi");
        }
    }
}
