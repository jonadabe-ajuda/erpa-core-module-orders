package br.com.erpa.application.command;

import br.com.erpa.application.dto.OrdersDTO;
import br.com.erpa.domain.entity.OrdersEntity;
import br.com.erpa.domain.repository.RepositoryOrders;

public class RecoverOrdersNumber {
	
	private final RepositoryOrders repositoryOrders;

	public RecoverOrdersNumber(RepositoryOrders repositoryOrders) {
		this.repositoryOrders = repositoryOrders;
	}
	public OrdersDTO execute ( Long number ) {
		
		OrdersEntity  ordersEntity = repositoryOrders.findByOrders(number);
		
		if ( ordersEntity != null ) {
			OrdersDTO ordersDTO = new OrdersDTO();
			ordersDTO.setNumber(ordersEntity.getNumber());
			ordersDTO.setDescription(ordersEntity.getDescription());
			ordersDTO.setCustomersCPF(ordersEntity.getCustomersCPF());
			ordersDTO.setCustomersName(ordersEntity.getCustomerName());
			ordersEntity.getListSetOrderItem().forEach( item -> {
				ordersDTO.addItems(item.getProductCode(), item.getProductName(), item.getAmount(), item.getValue());
			});
			return ordersDTO;
		} else {
			return new OrdersDTO();
		}

	}	

}
