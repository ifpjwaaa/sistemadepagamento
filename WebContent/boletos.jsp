<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
	
	if(request.getParameter("qtdBoletos") != null){
		int qtd = Integer.parseInt(request.getParameter("qtdBoletos"));	
		String nome = request.getParameter("nome");
		String datavencimento = request.getParameter("dataVencimento");
		String valor = request.getParameter("valor");
		%>
		<h1>Boletos</h1>
	<%for (int i = 1; i <= qtd; i++) {
		double quantidade=qtd;
		%>
		
		<form action="inserirnobanco" method="post">
		<table>
		<tr>
		<td>Data de pagamento:</td> <td><input type="text" name="dataPagamento<%=i%>"></td><br>
		</tr>
		<tr>
		<td>Valor R$:</td><td> <input type="text" name="valorBoleto<%=i%>"><br></td>
		</tr>
		
		 <input type = "hidden"   name="nome"  value="<%=nome%>" >
  <input type = "hidden"   name="datavencimento"  value="<%=datavencimento%>" >
   <input type = "hidden"   name="valor"  value="<%=valor%>" >
		<input type="hidden" name="qtd" value="<%=qtd%>"> 
		</table>	
		 
	<%
	}%> 

		<button type="submit">Processar</button>
		</form>
	<%}
	%>


</body>
</html>