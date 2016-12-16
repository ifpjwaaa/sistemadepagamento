package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.ConnectionFactory;
import entidades.Credito;
import entidades.Movimentacao;
import entidades.Pagamento;

public class MovimentacaoDao {

private Connection connection;

public  MovimentacaoDao() {
	
	try {
		this.connection = new ConnectionFactory().getConnection();
	} catch (Exception e) {
		 throw new RuntimeException(e);
	}
}
public void inserir(Movimentacao movimentacao) {		
	 
	String sql = "Insert into pagamento(Cod_movimentacao,Data_atual,Numero_boletos,Total_valor_pago) values (?,?,?,?)";
	
	try {
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, movimentacao.getCodigoMovimentacao());
		st.setDate(3, new java.sql.Date(movimentacao.getDataAtual().getTime()));
		st.setInt(2, movimentacao.getNumeroBoleto());
		st.setDouble(4, movimentacao.getTotalValorPago());
		
		
		st.execute();
		connection.close();

	} catch (SQLException e) {
		  throw new RuntimeException(e);
		
	}	
}
}