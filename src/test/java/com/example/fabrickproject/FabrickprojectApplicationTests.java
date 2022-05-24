package com.example.fabrickproject;

import com.example.fabrickproject.controllers.MainController;
import com.example.fabrickproject.payloads.BalancePayload;
import com.example.fabrickproject.payloads.TransactionPayload;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FabrickprojectApplicationTests {

	@Test
	void  contextLoads() throws Exception {
		MainController mainController = new MainController();
		String response = mainController.createMoneyTransfer();
			assertEquals("[{\"code\":\"API000\",\"description\":\"it.sella.pagamenti.servizibonifico.exception.ServiziInvioBonificoSubsystemException: it.sella.pagamenti.sottosistemi.SottosistemiException: Errore tecnico CONTO 45685475:Conto 45685475 non esiste\",\"params\":\"\"}]",response);
	}

	@Test
	void contextLoads1()throws Exception{
		MainController mainController = new MainController();
		BalancePayload response = (mainController.getBalance());

		assertEquals("9.17",response.getAvailableBalance());
	}


	@Test
	void contextLoads2()throws Exception{
		MainController mainController = new MainController();

		TransactionPayload response = (mainController.getTransactions());

		assertEquals("224892",response.getTransactionsPayloadParams().get(1).getTransactionId());
	}

}
