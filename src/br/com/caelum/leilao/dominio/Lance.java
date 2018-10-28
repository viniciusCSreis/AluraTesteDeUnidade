package br.com.caelum.leilao.dominio;

import java.util.Objects;

public class Lance {

	private Usuario usuario;
	private double valor;
	
	public Lance(Usuario usuario, double valor) {
		this.usuario = usuario;
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public double getValor() {
		return valor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Lance lance = (Lance) o;
		return Double.compare(lance.valor, valor) == 0 &&
				Objects.equals(usuario, lance.usuario);
	}

}
