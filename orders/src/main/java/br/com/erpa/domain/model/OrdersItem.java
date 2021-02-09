package br.com.erpa.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class OrdersItem {
	
	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String productCode;
	private String productName;

	private BigDecimal amount;
	private BigDecimal value;
	
	@ManyToOne
	@JoinColumn(name="idOrdem", nullable=false)
	private Orders ordem;
	
	public OrdersItem() {}

	public OrdersItem(String productCode, String productName, BigDecimal amount, BigDecimal value) {
		this.productCode = productCode;
		this.productName = productName;
		this.amount = amount;
		this.value = value;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Orders getOrdem() {
		return ordem;
	}

	public void setOrdem(Orders ordem) {
		this.ordem = ordem;
	}
	

}
