


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class PagamentoDao {
	
private Connection connection;
	
	public PagamentoDao() {
		
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
	}
	public void inserirPagamento(Pagamento pagamento) {		
		 
		String sql = "Insert into pagamento(Valor_pago,Data_pagamento) values (?,?)";
		
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			
			
			st.setDouble(1, pagamento.getValorPago());
			st.setDate(2, new java.sql.Date(pagamento.getDataPagamento().getTime()));
			//st.setString(3, pagamento.getTipoPagamento());
			
			
			st.execute();
			//connection.close();

		} catch (SQLException e) {
			  throw new RuntimeException(e);
			
		}	
}
}
