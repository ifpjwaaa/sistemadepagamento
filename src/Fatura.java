
import java.util.Date;

public class Fatura {

	 int codigoFatura;
	 Date dataVencimento;
	 double valorTotal;
	 String nomeCliente;
	
	

	public int getCodigoFatura() {
		return codigoFatura;
	}

	public void setCodigoFatura(int codigoFatura) {
		this.codigoFatura = codigoFatura;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

}
