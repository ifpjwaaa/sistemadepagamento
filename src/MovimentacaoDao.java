


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



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
	 
	String sql = "Insert into movimentacao(Cod_movimentacao,Data_atual,Numero_boletos,Total_valor_pago) values (?,?,?,?)";
	
	try {
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, movimentacao.getCodigoMovimentacao());
		st.setDate(2, new java.sql.Date(movimentacao.getDataAtual().getTime()));
		st.setInt(3, movimentacao.getNumeroBoleto());
		st.setDouble(4, movimentacao.getTotalValorPago());
		
		
		st.execute();
		connection.close();

	} catch (SQLException e) {
		  throw new RuntimeException(e);
		
	}	
}
}