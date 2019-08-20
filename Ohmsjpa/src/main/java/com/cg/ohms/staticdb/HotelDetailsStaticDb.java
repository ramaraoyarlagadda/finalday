package com.cg.ohms.staticdb;

import java.util.ArrayList;
import java.util.List;

import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.HotelException;
import com.cg.ohms.utility.ExceptionMessages;

public class HotelDetailsStaticDb {
	
	
	private static List<HotelDetailsDTO> hotelList=new ArrayList<HotelDetailsDTO>();

	public static List<HotelDetailsDTO> getHotelList() throws HotelException {
		if(!hotelList.isEmpty())
		{
		return hotelList;
		}
		else {
			throw new HotelException(ExceptionMessages.EMPTYLIST);
		}
	}

		
	static {
		hotelList.add(new HotelDetailsDTO("1234", "royalpark", "kakinada", 50));
		hotelList.add(new HotelDetailsDTO("7896", "HotelGrand", "Hyderabad", 150));
		
		
	}

	public void setHotelList(HotelDetailsDTO hotelDetailsDTO) {
		hotelList.add(hotelDetailsDTO);
		
	}

}
