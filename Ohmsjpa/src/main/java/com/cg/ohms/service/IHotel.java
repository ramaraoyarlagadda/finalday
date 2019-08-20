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
	 * @param hotelDetailsDTO
	 * @return boolean value
	 * @throws HotelException
	 */
	public boolean deleteHotelDetails(HotelDetailsDTO hotelDetailsDTO) throws HotelException;
	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return hoteldetailsDTO 
	 * @throws HotelException
	 */
	public HotelDetailsDTO viewHotelDetails(HotelDetailsDTO viewId) throws  HotelException;
	/**
	 * 
	 * @param hotelId
	 * @param hotelName
	 * @return boolean value
	 * @throws HotelException
	 */
	public boolean modifyByHotelName(HotelDetailsDTO modifyName) throws  HotelException;
	public boolean modifyByHotelAddress(HotelDetailsDTO modifyAddress) throws HotelException;
	public boolean modifyByNumOfRooms(HotelDetailsDTO modifyRooms) throws HotelException;
	public HotelDetailsDTO viewHotelDetails() throws HotelException;

}
