package com.diorgenes.model.caixa;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

import com.diorgenes.model.PagtoForma;

public class PagtoTest {

	private Pagto pagto;

	@Before
	public void setUp() {
		pagto = new Pagto();
	}

	@Test
	public void deveCalcularValorTotalSemForma() throws Exception {
		BigDecimal expected = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN);
		assertEquals(expected, pagto.getTotalPagto());
	}

	@Test
	public void deveCalcularValorTotalEmDinheiro() throws Exception {
		BigDecimal expected = new BigDecimal("50").setScale(2, RoundingMode.HALF_DOWN);
		
		PagtoDetalhes dinheiro = new PagtoDetalhes();
		dinheiro.setId(1L);
		dinheiro.setForma(PagtoForma.DINHEIRO);
		dinheiro.setValorPago(new BigDecimal("50"));

		PagtoDetalhes hiper = new PagtoDetalhes();
		hiper.setId(2L);
		hiper.setForma(PagtoForma.CREDITO);
		hiper.setValorPago(new BigDecimal("25.5"));

		pagto.getDetalhes().add(dinheiro);
		pagto.getDetalhes().add(hiper);

		assertEquals(expected, pagto.getTotalPagtoDinheiro());
	}

	@Test
	public void deveCalcularValortotal() throws Exception {
		BigDecimal expected = new BigDecimal("75.5").setScale(2, RoundingMode.HALF_DOWN);
		
		PagtoDetalhes dinheiro = new PagtoDetalhes();
		dinheiro.setId(1L);
		dinheiro.setForma(PagtoForma.DINHEIRO);
		dinheiro.setValorPago(new BigDecimal("50"));

		PagtoDetalhes hiper = new PagtoDetalhes();
		hiper.setId(2L);
		hiper.setForma(PagtoForma.CREDITO);
		hiper.setValorPago(new BigDecimal("25.5"));

		pagto.getDetalhes().add(dinheiro);
		pagto.getDetalhes().add(hiper);

		System.out.println("Valor total=" + pagto.getTotalPagto());
		assertEquals(expected, pagto.getTotalPagto());
	}
}
