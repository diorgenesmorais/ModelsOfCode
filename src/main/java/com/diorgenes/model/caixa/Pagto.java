package com.diorgenes.model.caixa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.diorgenes.model.PagtoForma;
import com.diorgenes.model.Pedido;

public class Pagto implements Serializable {

	private static final long serialVersionUID = -5570371943433018374L;

	private Long id;

	private Pedido pedido;

	private Caixa caixa;

	private List<PagtoDetalhes> detalhes = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public List<PagtoDetalhes> getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(List<PagtoDetalhes> detalhes) {
		this.detalhes = detalhes;
	}

	/**
	 * Usando a API do Java 8 em substituição deste código
	 * <pre>
	 * BigDecimal somar = BigDecimal.ZERO;
	 *   for (PagtoDetalhe pagto : formasPagtos) {
	 *   	if (PagtoForma.DINHEIRO.equals(pagto.getFormaPagto())) {
	 *   		somar = somar.add(pagto.getValorPago());
	 *   	}
	 *   }
	 * return somar;
	 * </pre>
	 * @return Total pago em dinheiro
	 */
	public BigDecimal getTotalPagtoDinheiro() {
		return detalhes.stream()
				.filter(p -> PagtoForma.DINHEIRO.equals(p.getForma())) // Lambda
				.map(PagtoDetalhes::getValorPago) // reference the method
				.reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO).setScale(2, RoundingMode.HALF_DOWN);
	}

	public BigDecimal getTotalPagto() {
		return detalhes.stream()
				.map(PagtoDetalhes::getValorPago)
				.reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO).setScale(2, RoundingMode.HALF_DOWN);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagto other = (Pagto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
