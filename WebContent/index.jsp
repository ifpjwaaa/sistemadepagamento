<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>FATURA</h1>
	<form method="get">
		
	Data Vencimento: <input type="text" name="dataVencimento"><br>
	Valor R$: <input type="text" name="valor"><br>
	Nome: <input type="text" name="nome"><br>
	Quantidade de Boletos: <input type="text" name="qtdBoletos" ><br>
	
	<button>Processar</button><br><br><br><br><br>
	
	
	</form>
	<%
	
	if(request.getParameter("qtdBoletos") != null){
		int qtd = Integer.parseInt(request.getParameter("qtdBoletos"));	%>
		<h1>Boletos</h1>
	<%for (int i = 1; i <= qtd; i++) {
		%>
		
		<form action="adicionafatura" method="get">
		<table>
		<tr>
		<td>Data de pagamento:</td> <td><input type="text" name="dataPagamento"></td><br>
		</tr>
		<tr>
		<td>Valor R$:</td><td> <input type="text" name="valorBoleto"><br></td>
		</tr>
		</table>	
		
		</form>
	<%
	}%><button>Processar</button>
	<%}
	%>
	
	
	
	</body>
</html>