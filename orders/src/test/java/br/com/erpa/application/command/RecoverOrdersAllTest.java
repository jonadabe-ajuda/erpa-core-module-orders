package br.com.erpa.application.command;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.erpa.application.dto.OrdersDTO;
import br.com.erpa.infra.RepositoryOrdersMysql;

class RecoverOrdersAllTest {

	@Test
	void recoverAll() {
		RecoverOrdersAll recoverAll = new RecoverOrdersAll(new RepositoryOrdersMysql("erpa-loja"));
		List<OrdersDTO> listaOrdem = recoverAll.execute();
	}

}
