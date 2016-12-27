

import java.sql.*;

public  class ConnectionFactory {             

    public static Connection getConnection() throws SQLException {             
        try {             
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/sistema_pagamento","root","@luno1fpe");
        } catch(ClassNotFoundException e) {             
            throw new SQLException(e.getMessage());             
        }             
    }
} 