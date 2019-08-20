package com.cg.ohms.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.ohms.exceptions.HotelException;

public class Connect {
	public static  Connection getConnection() throws HotelException {
		Connection connection=null;
		if(connection==null) {
			try {
				
				connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","system");
			} catch (SQLException e) {
				throw new HotelException(ExceptionMessages.CONNECTIONERROR);
			}
			
		}
		return connection;
		
	}

}
