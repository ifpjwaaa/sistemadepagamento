<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>FATURA</h1>
	<form action="boletos.jsp" method="post">
		
	Nome: <input type="text" name="nome"><br>
	Data Vencimento: <input type="text" name="dataVencimento"><br>
	Valor Total R$: <input type="text" name="valor"><br>
	Quantidade de Boletos: <input type="text" name="qtdBoletos" ><br>
	
	<button type="submit">Processar</button><br><br><br><br><br>
	
	
	</form>
	 






</body>
</html>