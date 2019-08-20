package com.cg.ohms.service;

import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.HotelException;

public interface IHotel {
	/**
	 * 
	 * @param hotelDetailsEntity
	 * @return boolean value
	 * @throws HotelException
	 */
	public boolean addHotelDetails(HotelDetailsDTO hotelDetailsEntity) throws  HotelException;
	/**
	 * 
	 * @param hotelId
	 * @return boolean value
	 * @throws HotelException
	 */
	public boolean deleteHotelDetails(String hotelId) throws HotelException;
	/**
	 * 
	 * @param viewId
	 * @return hoteldetailsDTO 
	 * @throws HotelException
	 */
	public HotelDetailsDTO viewHotelDetails(String viewId) throws  HotelException;
	/**
	 * 
	 * @param hotelId
	 * @param hotelName
	 * @return boolean value
	 * @throws HotelException
	 */
	public boolean modifyByHotelName(String hotelId, String hotelName) throws  HotelException;
	public boolean modifyByHotelAddress(String hotelId, String hotelAddress) throws HotelException;
	public boolean modifyByNumOfRooms(String hotelId,int modifyNumOfRooms) throws HotelException;
	

}
