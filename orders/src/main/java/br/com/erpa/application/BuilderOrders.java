package br.com.erpa.application;

import java.math.BigDecimal;
import java.util.HashSet;

import br.com.erpa.application.dto.OrdersItemDTO;
import br.com.erpa.domain.entity.OrdersEntity;

public class BuilderOrders {
	
	private OrdersEntity ordersEntity;
	
	public BuilderOrders withOrders(Long number, String description) {
		this.ordersEntity = new OrdersEntity(number);
		this.ordersEntity.setDescription(description);
		return this;
	}
	
	public BuilderOrders withCustomer(String cpf, String name) {
		this.ordersEntity.setCustomersCPF(cpf);
		this.ordersEntity.setCustomerName(name);
		return this;
	}
	
	public BuilderOrders addItems(HashSet<OrdersItemDTO> listSetOrdemsItemDTO) {
		for ( OrdersItemDTO item : listSetOrdemsItemDTO )
			this.ordersEntity.addItems(item.getProductCode(), item.getProductName(), item.getAmount(), item.getValue());
		return this;
	}

	public OrdersEntity create() {
		return this.ordersEntity;
	}	
	

}
