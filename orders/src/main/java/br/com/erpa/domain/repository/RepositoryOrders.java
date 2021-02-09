package br.com.erpa.domain.repository;

import java.util.List;

import br.com.erpa.domain.entity.OrdersEntity;

public interface RepositoryOrders {
	
	public void insertOrders(OrdersEntity ordersEntity);
	public void updateOrders(OrdersEntity ordersEntity);
	public void deleteOrders(OrdersEntity ordersEntity);
	public OrdersEntity findByOrders(Long number);
	public List<OrdersEntity> listaAllOrders();	

}
