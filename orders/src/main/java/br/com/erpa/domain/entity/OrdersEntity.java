package br.com.erpa.domain.entity;

import java.math.BigDecimal;
import java.util.HashSet;

import br.com.erpa.domain.model.OrdersItem;

public class OrdersEntity {
	
	private Long number;
	private String customersCPF;
	private String customerName;
	private String description;
	private HashSet<OrdersItem> listSetOrderItem = new HashSet<OrdersItem>();
	
	public OrdersEntity(Long number) {
		this.number = number;
	}

	private BigDecimal totalValue;

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getCustomersCPF() {
		return customersCPF;
	}

	public void setCustomersCPF(String customersCPF) {
		this.customersCPF = customersCPF;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	public HashSet<OrdersItem> getListSetOrderItem() {
		return listSetOrderItem;
	}
	
	public void addItems( String productCode, String productName, BigDecimal amount, BigDecimal value) {
		listSetOrderItem.add( new OrdersItem(productCode, productName, amount, value));
	}	

}
