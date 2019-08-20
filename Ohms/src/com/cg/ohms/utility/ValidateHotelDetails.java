package com.cg.ohms.utility;

import com.cg.ohms.exceptions.HotelException;

public class ValidateHotelDetails {
	
	public boolean isValidHotelId(String hotelId) throws HotelException{
		
		if(!hotelId.matches("[1-9]{1}[0-9]{5}")) {
			throw new HotelException(ExceptionMessages.INVALIDHOTELID);
		}
		return true;
	}
	public boolean isValidHotelName(String hotelName) throws HotelException{
		if (!hotelName.matches("^[a-zA-Z]*$") || hotelName.isEmpty()) {
			throw new HotelException(ExceptionMessages.INVALIDHOTELNAME);
		}

		return true;

	}
	public boolean isValidHotelAddress(String hotelAddress) throws HotelException{
		if (!hotelAddress.matches("^[\\\\$#\\\\+{}:\\\\?\\\\.,~@\\\"a-zA-Z0-9 ]+$") || hotelAddress.isEmpty()) {
			throw new HotelException(ExceptionMessages.INVALIDHOTELADDRESS);
		}
		return true;
	}
	public boolean isValidNumberOfRooms(int numOfRooms) throws HotelException{
		String rooms=Integer.toString(numOfRooms);
		if(!(rooms.matches("[0-9]{1,3}"))||rooms.isEmpty()) {
			throw new HotelException(ExceptionMessages.INVALIDNUMBEROFROOMS);
		}
		return true;
	}
	
	

}
