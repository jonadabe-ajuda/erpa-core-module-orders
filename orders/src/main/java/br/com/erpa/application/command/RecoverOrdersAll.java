package br.com.erpa.application.command;

import java.util.ArrayList;
import java.util.List;

import br.com.erpa.application.dto.OrdersDTO;
import br.com.erpa.domain.repository.RepositoryOrders;

public class RecoverOrdersAll {
	
	private final RepositoryOrders repositoryOrders;

	public RecoverOrdersAll(RepositoryOrders repositoryOrders) {
		this.repositoryOrders = repositoryOrders;
	}
	
	public List<OrdersDTO> execute () {
	
		List<OrdersDTO> listaOrderDTO = new ArrayList<OrdersDTO>();
		repositoryOrders.listaAllOrders().forEach( order -> {
			OrdersDTO ordersDTO = new OrdersDTO();
			ordersDTO.setNumber(order.getNumber());
			ordersDTO.setDescription(order.getDescription());
			ordersDTO.setCustomersCPF(order.getCustomersCPF());
			ordersDTO.setCustomersName(order.getCustomerName());
			ordersDTO.getListSetOrdersItemDTOs().forEach( item -> {
				ordersDTO.addItems(item.getProductCode(), item.getProductName(), item.getAmount(), item.getValue());
			});
			listaOrderDTO.add(ordersDTO);
		});


		return listaOrderDTO;
	}	
	

}
