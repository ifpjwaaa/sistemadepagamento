package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.ConnectionFactory;
import entidades.Credito;


public class CreditoDao {

private Connection connection;
	
	public CreditoDao() {
		
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
	}

	public void inserir(Credito credito) {		
		 
		String sql = "Insert into credito(Cod_credito,Valor_credito,Nome_cliente,Data_emissao) values (?,?,?,?)";
		
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			
			st.setString(1, credito.getCodigoCredito());
			st.setDouble(2, credito.getValorCredito());
			st.setString(3, credito.getNomeCliente());
			st.setDate(4, new java.sql.Date(credito.getDataEmissao().getTime()));
			
			
			st.execute();
			connection.close();
			
		} catch (SQLException e) {
			  throw new RuntimeException(e);
			

}
	}
}
