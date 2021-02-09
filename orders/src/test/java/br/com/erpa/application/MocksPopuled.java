package br.com.erpa.application;

import java.math.BigDecimal;

import br.com.erpa.application.dto.OrdersDTO;
import br.com.erpa.application.dto.OrdersItemDTO;

public class MocksPopuled {
	
	public static OrdersDTO MockOrdersDTO() {
		OrdersDTO ordersDTO = new OrdersDTO();
		ordersDTO.setNumber(1l);
		ordersDTO.setDescription("pedido para testes");
		ordersDTO.setCustomersCPF("12345678901");
		ordersDTO.setCustomersName("Client teste");
		ordersDTO.getListSetOrdersItemDTOs().add(new OrdersItemDTO("SD-0001", "SC SAMSUNG 500G", new BigDecimal(10), new BigDecimal(150.90)));
		ordersDTO.getListSetOrdersItemDTOs().add(new OrdersItemDTO("PL-0010", "PLACA DE REDE 100GB", new BigDecimal(10), new BigDecimal(150.90)));
				
		return ordersDTO;
	}		

}
