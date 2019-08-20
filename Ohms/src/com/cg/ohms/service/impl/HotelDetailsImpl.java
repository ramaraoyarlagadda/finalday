package com.cg.ohms.service.impl;

import com.cg.ohms.dao.HotelDetailsDaoImpl;
import com.cg.ohms.dao.IHotelDetailsDao;
import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.HotelException;
import com.cg.ohms.service.IHotel;
import com.cg.ohms.utility.ExceptionMessages;
import com.cg.ohms.utility.ValidateHotelDetails;

public class HotelDetailsImpl implements IHotel {
	/**
	 * This class contains the Impl part for
	 * methods in interface.
	 */
	HotelDetailsDTO hotelDetailsDTO=new HotelDetailsDTO();
	ValidateHotelDetails validate=new ValidateHotelDetails();
	public boolean addHotelDetails(HotelDetailsDTO hotelDetailsEntity) throws HotelException{
		/**
		 * This method takes values and validates
		 * after validating it calls the daoimpl method
		 */
		HotelDetailsDaoImpl dtoImpl=new HotelDetailsDaoImpl();
        String hotelId=hotelDetailsEntity.getHotelId();
		validate.isValidHotelId(hotelId);
       String hotelName=hotelDetailsEntity.getHotelName();
       validate.isValidHotelName(hotelName);
       String hotelAddress=hotelDetailsEntity.getHotelAddress();
       validate.isValidHotelAddress(hotelAddress);
       int noofRooms=hotelDetailsEntity.getNumOfRooms();
       validate.isValidNumberOfRooms(noofRooms);
       /**
        * here after validation it passes values to daoimpl
        * for adding values to the data base
        */
       boolean flag= dtoImpl.addDetails(hotelDetailsEntity);
      	if(!flag) {
      		/**
      		 * after doing adding to database it returns boolean value
      		 * if not equals to flag something exception occurs
      		 */
      			throw new HotelException(ExceptionMessages.ADDINGERROR);
      	}
      	
      	else {
      		/**
      		 * after doing adding to database it returns boolean value
      		 * equals to flag and returns true to ui layer
      		 */
      		return true;
      	}
   }
    public  HotelDetailsDTO viewHotelDetails(String viewId) throws  HotelException {
    	/**
    	 * it takes hotelid first validates
    	 *  and views details related to that id.
    	 */
		validate.isValidHotelId(viewId);
		IHotelDetailsDao hotelDetailsDao=new HotelDetailsDaoImpl();
		 HotelDetailsDTO hotelDetailsDTO=hotelDetailsDao.viewDetails(viewId);
		 /**
		  * It calls daoimpl method and gets 
		  * details related to hotelid entered 
		  */
		 if(hotelDetailsDTO.getHotelId()==null) {
			 throw new HotelException(ExceptionMessages.NOTFOUNDVIEWID);
		 }
		 else {
		 return hotelDetailsDTO; }
        
    }
	@Override
	public boolean modifyByHotelName(String hotelId, String hotelName) throws HotelException {
		validate.isValidHotelId(hotelId);
		validate.isValidHotelName(hotelName);
        IHotelDetailsDao hotelDetailsDao=new HotelDetailsDaoImpl();
        boolean result= hotelDetailsDao.modifyName(hotelId, hotelName);
		if(!result) {
			throw new HotelException(ExceptionMessages.MODIFYERROR);
		}
		return result;
	}
	@Override
	public boolean modifyByHotelAddress(String hotelId, String hotelAddress) throws HotelException{
		validate.isValidHotelId(hotelId);
		validate.isValidHotelAddress(hotelAddress);
		IHotelDetailsDao hotelDetailsDao=new HotelDetailsDaoImpl();
		boolean flag=hotelDetailsDao.modifyAddress(hotelId, hotelAddress);
	    if(!flag) {
	    	throw new HotelException(ExceptionMessages.MODIFYERROR);
	    }
		return flag;
	}
	@Override
	public boolean modifyByNumOfRooms(String hotelId, int numOfRooms) throws HotelException {
		validate.isValidHotelId(hotelId);
		validate.isValidNumberOfRooms(numOfRooms);
		IHotelDetailsDao hotelDetailsDao=new HotelDetailsDaoImpl();
		boolean flag=hotelDetailsDao.modifyRooms(hotelId, numOfRooms);
	    if(!flag) {
	    	throw new HotelException(ExceptionMessages.MODIFYERROR);
	    }
	
		
		return flag;
	}
	@Override
	public boolean deleteHotelDetails(String hotelId) throws  HotelException {
		validate.isValidHotelId(hotelId);
		IHotelDetailsDao hotelDetailsDao=new HotelDetailsDaoImpl();
		boolean flag=hotelDetailsDao.deleteDetails(hotelId);
		if(!flag) {
			throw new HotelException(ExceptionMessages.DELETELIST);
		}
		return flag;
	}
}
