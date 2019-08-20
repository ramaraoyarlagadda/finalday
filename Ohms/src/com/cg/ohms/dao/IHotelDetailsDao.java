package com.cg.ohms.dao;

import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.HotelException;

public interface IHotelDetailsDao {
	/**
	 * 
	 * @param viewId
	 * @return 
	 * @throws HotelException
	 */
	public HotelDetailsDTO viewDetails(String viewId) throws HotelException;
	public boolean addDetails(HotelDetailsDTO hotelDetailsDTO) throws HotelException;
	public boolean modifyName(String hotelId, String hotelName) throws HotelException;
	boolean modifyAddress(String hotelId, String hotelAddress) throws HotelException;
	public boolean modifyRooms(String hotelId,int numOfRooms) throws HotelException;
	public boolean deleteDetails(String hotelId) throws HotelException;
	
}
