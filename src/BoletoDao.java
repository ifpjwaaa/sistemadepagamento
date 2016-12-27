

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class BoletoDao {
	
private Connection connection;
	
	public BoletoDao() {
		
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
	}
	public void inserirBoleto(Boleto boleto) {		
	 
	String sql = "Insert into boleto(Data_Pagamento,Valor_pago) values (?,?)";
	
	try {
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setDate(1, new java.sql.Date(boleto.getDataPagamento().getTime()));
		st.setDouble(2, boleto.getValorPago());
		
		
		
		st.execute();
		//connection.close();

	} catch (SQLException e) {
		  throw new RuntimeException(e);
		
	}	
}


}
