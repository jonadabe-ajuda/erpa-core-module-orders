package br.com.erpa.application.command;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.erpa.application.MocksPopuled;
import br.com.erpa.application.dto.OrdersDTO;
import br.com.erpa.application.dto.OrdersItemDTO;
import br.com.erpa.domain.exception.ExceptionValidFields;
import br.com.erpa.infra.RepositoryOrdersMysql;

class SaveOrdersTest {
	
	@Mock
	RepositoryOrdersMysql repositoryOrdersMysql;
	private AutoCloseable closeable;
	private SaveOrders saveOrders;
	
	@BeforeEach
	public void beforeEach() {
		closeable = MockitoAnnotations.openMocks(this);
		saveOrders = new SaveOrders(repositoryOrdersMysql);
	}	

	@Test
	void saveWithFieldError () {
		OrdersDTO ordersDTO = MocksPopuled.MockOrdersDTO();
		ordersDTO.setNumber(null);
		Exception exception = assertThrows(ExceptionValidFields.class, () -> saveOrders.execute(ordersDTO));
		assertTrue(exception.getMessage().contains("Error"));
	
	}
	
	@Test
	void saveWithFieldItemError () {
		OrdersDTO ordersDTO = MocksPopuled.MockOrdersDTO();
		ordersDTO.getListSetOrdersItemDTOs().add(new OrdersItemDTO("M", "MOU", new BigDecimal(30), new BigDecimal(10)));
		Exception exception = assertThrows(ExceptionValidFields.class, () -> saveOrders.execute(ordersDTO));
		assertTrue(exception.getMessage().contains("Error"));
	
	}
	
	
	@Test
	void saveWithFieldOK () {
		OrdersDTO ordersDTO = MocksPopuled.MockOrdersDTO();
		saveOrders.execute(ordersDTO);
		Mockito.verify(repositoryOrdersMysql).insertOrders(Mockito.any());
	
	}	
	
	@AfterEach
    void closeService() throws Exception {
        closeable.close();
    }	
		

}
