package br.com.erpa.domain.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	
	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long number;
	
	private String customersCPF;
	private String customerName;
	private String description;
	
	private BigDecimal totalValue;
		
	private Date dateInsert;
	
	@OneToMany
	private HashSet<OrdersItem> listSetOrdemItem = new HashSet<OrdersItem>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public HashSet<OrdersItem> getListSetOrdemItem() {
		return listSetOrdemItem;
	}

	public void setListSetOrdemItem(HashSet<OrdersItem> listSetOrdemItem) {
		this.listSetOrdemItem = listSetOrdemItem;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}
	
	
	
	
}
