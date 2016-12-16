package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.ConnectionFactory;
import entidades.Pagamento;

public class PagamentoDao {
	
private Connection connection;
	
	public PagamentoDao() {
		
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
	}
	public void inserir(Pagamento pagamento) {		
		 
		String sql = "Insert into pagamento(Cod_pagamento,Valor_pago,Data_pagamento,Tipo_pagamento) values (?,?,?,?)";
		
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			
			st.setString(1, pagamento.getCodigoPagamento());
			st.setDouble(2, pagamento.getValorPago());
			st.setDate(3, new java.sql.Date(pagamento.getDataPagamento().getTime()));
			st.setString(4, pagamento.getTipoPagamento());
			
			
			st.execute();
			connection.close();

		} catch (SQLException e) {
			  throw new RuntimeException(e);
			
		}	
}
}
