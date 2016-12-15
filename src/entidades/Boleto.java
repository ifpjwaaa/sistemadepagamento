package entidades;
import java.util.Date;

public class Boleto {

	private String codigoBoleto;
	private Date dataPagamento;
	private double valorPago;
	private int qtdBoletos;

	public String getCodigoBoleto() {
		return codigoBoleto;
	}

	public void setCodigoBoleto(String codigoBoleto) {
		this.codigoBoleto = codigoBoleto;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	public int getQtdBoletos() {
		return qtdBoletos;
	}

	public void setQtdBoletos(int qtdBoletos) {
		this.qtdBoletos = qtdBoletos;
	}

}
