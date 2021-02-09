package br.com.erpa.application.command;

import br.com.erpa.application.BuilderOrders;
import br.com.erpa.application.dto.OrdersDTO;
import br.com.erpa.domain.entity.OrdersEntity;
import br.com.erpa.domain.exception.ExceptionValidFields;
import br.com.erpa.domain.repository.RepositoryOrders;
import br.com.erpa.validator.ValidatorBean;

public class UpdateOrders {
	
	private final RepositoryOrders repositoryOrders;

	public UpdateOrders(RepositoryOrders repositoryOrders) {
		this.repositoryOrders = repositoryOrders;
	}
	
	
	public void execute ( OrdersDTO ordersDTO ) {
		if ( !ValidatorBean.Validator().validate(ordersDTO).isEmpty() ) throw new ExceptionValidFields("Error valid fields",null);
		OrdersEntity ordersEntity = new BuilderOrders()
										.withOrders(ordersDTO.getNumber(), ordersDTO.getDescription())
										.withCustomer(ordersDTO.getCustomersCPF(), ordersDTO.getCustomersName())
										.addItems(ordersDTO.getListSetOrdersItemDTOs())
										.create();
		repositoryOrders.updateOrders(ordersEntity);
		
	}	
		

}
