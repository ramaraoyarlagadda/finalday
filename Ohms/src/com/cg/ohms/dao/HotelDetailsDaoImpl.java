package com.cg.ohms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.HotelException;
import com.cg.ohms.utility.Connect;
import com.cg.ohms.utility.ExceptionMessages;
import com.cg.ohms.utility.Queries;

public class HotelDetailsDaoImpl implements IHotelDetailsDao {
	 int check=0;
	 HotelDetailsDTO hotelDetailsDTO=new HotelDetailsDTO();
	 PreparedStatement preparedStatement=null;
	
	@Override
	public HotelDetailsDTO viewDetails(String viewId) throws HotelException {
		Connection connection=Connect.getConnection();
		 String sqlQuery=Queries.VIEWDETAILS;
		 
		 try {
		 PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, viewId);
		 ResultSet resultSet=preparedStatement.executeQuery();
		 
			while(resultSet.next()) {
				if(resultSet.getString(1).equalsIgnoreCase(viewId)) {
				
				hotelDetailsDTO.setHotelId(resultSet.getString(1));
				hotelDetailsDTO.setHotelName(resultSet.getString(2));
				hotelDetailsDTO.setHotelAddress(resultSet.getString(3));
				hotelDetailsDTO.setNumOfRooms(resultSet.getInt(4));
				 return hotelDetailsDTO;
				}
			}
			preparedStatement.close();
		} catch (SQLException e) {
			throw new HotelException(ExceptionMessages.EMPTYLIST);
		}
		 return hotelDetailsDTO;
		
	}
	public boolean addDetails(HotelDetailsDTO hotelDetailsDTO) throws HotelException {
		Connection connection=Connect.getConnection();
		String sqlQuery=Queries.ADDDETAILS;
	    
		
		try {
			PreparedStatement preparedStatement =connection.prepareStatement(sqlQuery);
				 preparedStatement.setString(1, hotelDetailsDTO.getHotelId());
				 preparedStatement.setString(2, hotelDetailsDTO.getHotelName());
				 preparedStatement.setString(3, hotelDetailsDTO.getHotelAddress());
				 preparedStatement.setLong(4, hotelDetailsDTO.getNumOfRooms());
			     check=preparedStatement.executeUpdate();
			    if(check==1) {
			    	connection.commit();
			    	return true;	
			    }
			    preparedStatement.close();
		} catch (SQLException e) {
	     throw new HotelException(ExceptionMessages.MESSAGE2);
		}
		return true;
		
	}
	@Override
	public boolean modifyName(String hotelId,String hotelName) throws HotelException {
		Connection connection=Connect.getConnection();
		String sqlQuery=Queries.MODIFYNAME;
		try {
			 preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, hotelName);
			preparedStatement.setString(2, hotelId);
			check=preparedStatement.executeUpdate();
			System.out.println(check);
			if(check==1) {
				connection.commit();
				return true;
			}
			preparedStatement.close();
			
		} catch (SQLException e) {
			throw new HotelException(ExceptionMessages.NOTFOUND);
			
		}
		return false;
	}
	@Override
	public boolean modifyAddress(String hotelId,String hotelAddress) throws HotelException {
		Connection connection=Connect.getConnection();
		String sqlQuery=Queries.MODIFYADDRESS;
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setString(2, hotelId);
			preparedStatement.setString(1, hotelAddress);
			check=preparedStatement.executeUpdate();
			if(check==1) {
				connection.commit();
				return true;
			}
			preparedStatement.close();
		} catch (SQLException e) {
			throw new HotelException(ExceptionMessages.NOTFOUND);
			
		}
		
		return false;
	}
	@Override
	public boolean modifyRooms(String hotelId,int numOfRooms) throws HotelException {
		Connection connection=Connect.getConnection();
		String sqlQuery=Queries.MODIFYROOMS;
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setString(2, hotelId);
			preparedStatement.setInt(1, numOfRooms);
			check=preparedStatement.executeUpdate();
			if(check==1) {
				connection.commit();
				return true;
			}
			preparedStatement.close();
		} catch (SQLException e) {
			throw new HotelException(ExceptionMessages.NOTFOUND);
			
		}
		
		return false;
	}
	@Override
	public boolean deleteDetails(String hotelId) throws HotelException {
		Connection connection=Connect.getConnection();
		String sqlQuery=Queries.DELETEDETAILS;
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, hotelId);
			check=preparedStatement.executeUpdate();
			if(check==1) {
				connection.commit();
				return true;
			}
			preparedStatement.close();
		} catch (SQLException e) {
			
			throw new HotelException(ExceptionMessages.DELETELIST);
		}
		
		return false;
	}
 


	
	
}
