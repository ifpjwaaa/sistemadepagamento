package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FaturaDao;
import entidades.Boleto;
import entidades.Fatura;

@WebServlet(urlPatterns = "/adicionafatura")
public class InserirFaturaServlet extends HttpServlet {

	private static final long serialVersionUID = -1886254045136326173L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String dataVencimento = request.getParameter("dataVencimento");
		String valor = request.getParameter("valor");
		String nome = request.getParameter("nome");

		Date dataConvertida = null;
		boolean erroConversaoData = false;

		try {
			dataConvertida = new SimpleDateFormat("yyyy/MM/dd").parse(dataVencimento);
		} catch (ParseException e) {
			erroConversaoData = true;
			System.out.println("erro");
		}

		if (erroConversaoData == false) {

			Fatura fatura = new Fatura();

			fatura.setDataVencimento(dataConvertida);
			fatura.setValorTotal(Double.parseDouble(valor));
			fatura.setNomeCliente(nome);

			FaturaDao dao = new FaturaDao();
			dao.inserir(fatura);
		}	
			
			String dataPagamento = request.getParameter("dataPagamento");
			String qtdBoleto = request.getParameter("qtdBoletos");
			String valorBoleto = request.getParameter("valorBoleto");
			
			Date data = null;
			boolean erroConversao = false;

			try {
				data = new SimpleDateFormat("yyyy/MM/dd").parse(dataPagamento);
			} catch (ParseException e) {
				erroConversao = true;
				System.out.println("erro");
			}

			if (erroConversao == false) {
			
				Boleto boleto = new Boleto();
				boleto.setDataPagamento(data);
				boleto.setValorPago(Double.parseDouble(valorBoleto));
				boleto.setQtdBoletos(Integer.parseInt(qtdBoleto));
			}
		}

	}

