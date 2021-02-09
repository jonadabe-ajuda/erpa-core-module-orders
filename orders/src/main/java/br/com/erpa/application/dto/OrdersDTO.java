package br.com.erpa.application.dto;

import java.math.BigDecimal;
import java.util.HashSet;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class OrdersDTO {
	
	@NotNull
	private Long number;
	
	@NotNull
	@NotEmpty
	@Size(min = 5,max = 100,message = "OrdersDTO field description between 5 and 100")
	private String description;
	
	@NotNull
	@NotEmpty
	@Size(min = 11,max = 11,message = "CustomerDTO field customersCPF equal 11")
	private String customersCPF;
	
	@NotNull
	@NotEmpty
	@Size(min = 5,max = 100,message = "CustomerDTO field customersName between 5 and 100")
	private String customersName;
	
	@Valid
	private HashSet<OrdersItemDTO> listSetOrdersItemDTOs = new HashSet<OrdersItemDTO>();
	
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getCustomersCPF() {
		return customersCPF;
	}
	public void setCustomersCPF(String customersCPF) {
		this.customersCPF = customersCPF;
	}
	public String getCustomersName() {
		return customersName;
	}
	public void setCustomersName(String customersName) {
		this.customersName = customersName;
	}
	public HashSet<OrdersItemDTO> getListSetOrdersItemDTOs() {
		return listSetOrdersItemDTOs;
	}

	public void addItems( String productCode, String productName, BigDecimal amount, BigDecimal value) {
		listSetOrdersItemDTOs.add(new OrdersItemDTO(productCode, productName, value, amount));
	}
	

}
