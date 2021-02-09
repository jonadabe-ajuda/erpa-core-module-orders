package br.com.erpa.infra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.erpa.domain.entity.OrdersEntity;
import br.com.erpa.domain.model.Orders;
import br.com.erpa.domain.model.OrdersItem;
import br.com.erpa.domain.repository.RepositoryOrders;

public class RepositoryOrdersMysql implements RepositoryOrders {

	private final String unitPersistence;
	private BigDecimal totalValueOrder;
	
	public RepositoryOrdersMysql(String unitPersistence) {
		this.unitPersistence = unitPersistence;
	}
	
	private EntityManagerFactory entityManagerFactory() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitPersistence);
		return emf; 
	}	
	
	public void insertOrders(OrdersEntity ordersEntity) {
		EntityManager em = entityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(convertToOrders(ordersEntity));
		em.getTransaction().commit();
		
	}

	public void updateOrders(OrdersEntity ordersEntity) {
		EntityManager em = entityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Orders orders =  bankFindByOrder(em, ordersEntity.getNumber());
		orders.setNumber(ordersEntity.getNumber());
		orders.setCustomersCPF(ordersEntity.getCustomersCPF());
		orders.setCustomerName(ordersEntity.getCustomerName());
		orders.setDescription(ordersEntity.getDescription());
		orders.getListSetOrdemItem().addAll(ordersEntity.getListSetOrderItem());
		for ( OrdersItem item : ordersEntity.getListSetOrderItem() ) {
			totalValueOrder = totalValueOrder.add(item.getValue());
		}
		em.getTransaction().commit();
		
	}

	public void deleteOrders(OrdersEntity ordersEntity) {
		EntityManager em = entityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Orders order =  bankFindByOrder(em, ordersEntity.getNumber());
		em.remove(order);
		em.getTransaction().commit();
		
	}

	public OrdersEntity findByOrders(Long number) {
		EntityManager em = entityManagerFactory().createEntityManager();
		return convertToOrdersEntity(bankFindByOrder(em, number));
	}

	public List<OrdersEntity> listaAllOrders() {
		EntityManager em = entityManagerFactory().createEntityManager();
		String sql = "SELECT orders FROM Orders orders ";
		Query query = em.createQuery(sql);
		List<Orders> listOrders = new ArrayList<Orders>();
		List<OrdersEntity> listOrdersEntity = new ArrayList<OrdersEntity>();
		listOrders = query.getResultList();
		for ( Orders order : listOrders ) {
			listOrdersEntity.add(convertToOrdersEntity(order));
		}
		return listOrdersEntity;
	}
	
	
	private Orders bankFindByOrder(EntityManager em, Long number) {
		String sql = "SELECT order FROM Orders order where order.number = :number ";
		Query query = em.createQuery(sql);
		query.setParameter("number",number);
		query.setMaxResults(1);
		return (Orders) query.getSingleResult();		
	}
	
	private OrdersEntity convertToOrdersEntity( Orders orders ) {
		OrdersEntity ordersEntity = new OrdersEntity(orders.getNumber());
		ordersEntity.setCustomersCPF(orders.getCustomersCPF());
		ordersEntity.setCustomerName(orders.getCustomerName());
		ordersEntity.setDescription(orders.getDescription());
		ordersEntity.getListSetOrderItem().addAll(orders.getListSetOrdemItem());
		return ordersEntity;
	}
	
	private Orders convertToOrders( OrdersEntity ordersEntity ) {
		Orders orders = new Orders();
		orders.setNumber(ordersEntity.getNumber());
		orders.setCustomersCPF(ordersEntity.getCustomersCPF());
		orders.setCustomerName(ordersEntity.getCustomerName());
		orders.setDescription(ordersEntity.getDescription());
		orders.setDateInsert(new Date());
		orders.getListSetOrdemItem().addAll(ordersEntity.getListSetOrderItem());
		return orders;
	}


			

}
