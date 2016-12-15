package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.ConnectionFactory;
import entidades.Fatura;

public class FaturaDao {
	
	private Connection connection;
	
	public FaturaDao() {
		
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
	}
	public void inserir(Fatura fatura) {		
	 
	String sql = "Insert into fatura(Data_Vencimento,Valor_total,Nome_cliente) values (?,?,?)";
	
	try {
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setDate(1, new java.sql.Date(fatura.getDataVencimento().getTime()));
		st.setDouble(2, fatura.getValorTotal());
		st.setString(3, fatura.getNomeCliente());
		
		st.execute();
		connection.close();

	} catch (SQLException e) {
		  throw new RuntimeException(e);
		
	}	
}

}
