
import java.util.Date;

public class Movimentacao {

	private String codigoMovimentacao;
	private Date dataAtual;
	private double TotalValorPago;
	private int numeroBoleto;

	public String getCodigoMovimentacao() {
		return codigoMovimentacao;
	}

	public void setCodigoMovimentacao(String codigoMovimentacao) {
		this.codigoMovimentacao = codigoMovimentacao;
	}

	public Date getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}

	public double getTotalValorPago() {
		return TotalValorPago;
	}

	public void setTotalValorPago(double totalValorPago) {
		TotalValorPago = totalValorPago;
	}

	public int getNumeroBoleto() {
		return numeroBoleto;
	}

	public void setNumeroBoleto(int numeroBoleto) {
		this.numeroBoleto = numeroBoleto;
	}

}
