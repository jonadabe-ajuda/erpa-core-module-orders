package br.com.erpa.application.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class OrdersItemDTO {
	
	@NotNull
	@NotEmpty
	@Size(min = 3,max = 50,message = "CustomerDTO field name between 2 and 50")
	private String productCode;
	
	
	@NotNull
	@NotEmpty
	@Size(min = 5,max = 100,message = "CustomerDTO field number equal 11")
	private String productName;
	
	@NotNull
	private BigDecimal value;
	
	@NotNull
	private BigDecimal amount;
	
	public OrdersItemDTO(String productCode, String productName, BigDecimal value, BigDecimal amount) {
		this.productCode = productCode;
		this.productName = productName;
		this.value = value;
		this.amount = amount;
	}

	public String getProductCode() {
		return productCode;
	}

	public String getProductName() {
		return productName;
	}

	public BigDecimal getValue() {
		return value;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	
	

}
