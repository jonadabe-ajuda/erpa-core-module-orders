package br.com.erpa.application.command;

import br.com.erpa.application.dto.OrdersDTO;
import br.com.erpa.domain.entity.OrdersEntity;
import br.com.erpa.domain.exception.ExceptionValidFields;
import br.com.erpa.domain.repository.RepositoryOrders;
import br.com.erpa.validator.ValidatorBean;

public class DeleteOrders {
	
	private final RepositoryOrders repositoryOrders;

	public DeleteOrders(RepositoryOrders repositoryOrders) {
		this.repositoryOrders = repositoryOrders;
	}
	
	public void execute ( OrdersDTO ordersDTO ) {
		if ( !ValidatorBean.Validator().validate(ordersDTO).isEmpty()) throw new ExceptionValidFields("Error valid fields",null);
		OrdersEntity ordersEntity = new OrdersEntity(ordersDTO.getNumber());
		repositoryOrders.deleteOrders(ordersEntity);
	}	
	

}
