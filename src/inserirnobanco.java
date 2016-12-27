

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/inserirnobanco")
public class inserirnobanco extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int qtd = Integer.parseInt(request.getParameter("qtd"));	
		PrintWriter out1 = response.getWriter(); 
		double soma = 0;

String nome = request.getParameter("nome");
String datavencimento = request.getParameter("datavencimento"); 

Date dataConvertida = null;

try {
	dataConvertida = new SimpleDateFormat("dd/MM/yyyy").parse(datavencimento);
} catch (ParseException e) {
	System.out.println("Data Informada Errada");
	e.printStackTrace();
}


String valor = request.getParameter("valor");
Double valorDouble = Double.parseDouble(valor.replaceAll("\\.","").replace(",","."));



out1.println("<html>");
out1.println("<body>");


out1.println("Nome = "+nome);	
out1.println("<br>");
out1.println("Data de Vencimento = "+datavencimento);	
out1.println("<br>");
out1.println("valor Total = "+valor);	
out1.println("<br>");
out1.println("-------------------------------------------");		
out1.println("</body>");
out1.println("</html>");
		
		Boleto boleto = new Boleto();
		BoletoDao dao1 = new BoletoDao();
		
		Pagamento pagamento = new Pagamento();
		PagamentoDao dao2 = new PagamentoDao();
		
for(int i=1; i<=qtd ; i++){
			
			String valorBoleto = request.getParameter("valorBoleto"+i);
			Double valorDoubleboleto = Double.parseDouble(valorBoleto.replaceAll("\\.","").replace(",","."));
			
			
			soma +=valorDoubleboleto;
			
			
			String dataPagamento = request.getParameter("dataPagamento"+i); 
			
		
		
			Date dataConvertidaboleto = null;

			try {
				dataConvertidaboleto = new SimpleDateFormat("dd/MM/yyyy").parse(dataPagamento);
			} catch (ParseException e) {
				System.out.println("Data Informada Errada");
				e.printStackTrace();
			}
			
			
			
			
			boleto.setValorPago(valorDoubleboleto);
			
			boleto.setDataPagamento(dataConvertidaboleto);
			
			dao1.inserirBoleto(boleto);
			
			
			pagamento.setValorPago(valorDoubleboleto);
			pagamento.setDataPagamento(dataConvertidaboleto);
			
			dao2.inserirPagamento(pagamento);
			 
			
			
			out1.println("<html>");
			out1.println("<body>");
			out1.println("<br>");
			out1.println("Valor do Boleto = "+valorBoleto);	
			out1.println("<br>");
			out1.println("Data de Pagamento = "+dataPagamento);	
			out1.println("<br>");
			out1.println("-------------------------------------------");	
			out1.println("<br>");
			out1.println("<br>");
			out1.println("</body>");
			out1.println("</html>");
		
}



Fatura fatura = new Fatura();
fatura.setNomeCliente(nome); 
fatura.setDataVencimento(dataConvertida);
fatura.setValorTotal(valorDouble);


FaturaDao dao = new FaturaDao();
dao.inserir(fatura);


Movimentacao movimentacao = new Movimentacao();

movimentacao.setNumeroBoleto(qtd);
movimentacao.setTotalValorPago(valorDouble);

Date now = new Date(System.currentTimeMillis());

movimentacao.setDataAtual(now); 
 

MovimentacaoDao dao4 = new MovimentacaoDao();
dao4.inserir(movimentacao);







out1.println("<html>");
out1.println("<body>");
 

out1.println("Fatura Adicionada com Sucesso");
out1.println("</br>");

out1.println("-------------------------------------------");

out1.println("</br>");


out1.println("valor total da Fatura = "+valor);	

out1.println("</br>");
out1.println("-------------------------------------------");
 
out1.println("</br>");


out1.println("Valor pago em Boleto(s) = "+soma);	


out1.println("</br>");
//Caso a soma dos boletos seja menor que o valor da fatura, marcar a fatura como NÃO-PAGA.


if(soma < valorDouble){

	out1.println("FATURA NÃO PAGA");
	
	
}





out1.println("</br>");

//4) Caso a soma dos boletos seja maior ou igual ao valor da fatura, marcar a fatura como PAGA.



if(soma >= valorDouble){

	out1.println("FATURA PAGA");
	
	
}


Credito credito = new Credito();
CreditoDao dao5 = new CreditoDao();

double valoradicional = 0;

//Caso a soma dos boletos ultrapasse o valor da fatura, deverá ser gerado um crédito com o valor adicional.

if(soma > valorDouble){
	valoradicional = soma - valorDouble;
	
	credito.setDataEmissao(dataConvertida);
	credito.setValorCredito(valoradicional);
	credito.setNomeCliente(nome);
	
	
	
	
	dao5.inserir(credito);
	
	out1.println("</br>");
	
	out1.println("FOI GERADO CRÉDITO DE R$  = " +valoradicional);
	
}

else{
out1.println("</br>");
	
	out1.println("NÃO FOI GERADO CRÉDITO ");
	
}

//Será gerada uma movimentação para registrar a operação realizada contendo a data atual, a quantidade de
//boletos recebida e a soma dos valores destes boletos.



out1.println("</body>");
out1.println("/<html>");





	}

}
