package com.diorgenes.model.caixa;

import java.io.Serializable;
import java.math.BigDecimal;

import com.diorgenes.model.PagtoForma;

public class PagtoDetalhes implements Serializable {

	private static final long serialVersionUID = -954270192659849247L;

	private Long id;

	private PagtoForma forma;

	private Integer parcelas;

	private BigDecimal valorPago;

	private Pagto pagto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PagtoForma getForma() {
		return forma;
	}

	public void setForma(PagtoForma forma) {
		this.forma = forma;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public Pagto getPagto() {
		return pagto;
	}

	public void setPagto(Pagto pagto) {
		this.pagto = pagto;
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
		PagtoDetalhes other = (PagtoDetalhes) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
