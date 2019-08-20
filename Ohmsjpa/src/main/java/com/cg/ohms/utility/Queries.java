package com.cg.ohms.utility;

public final class  Queries {

	public static String ADDDETAILS = "insert into hoteldetails(hotelid,hotelname,hoteladdress,numberofrooms) values(?,?,?,?)";
	public static String VIEWDETAILS = "select hotelid,hotelname,hoteladdress,numberofrooms from hoteldetails where hotelid=?";
	public static String MODIFYNAME = "update hoteldetails set hotelname=? where hotelid=?";
	public static String MODIFYADDRESS = "update hoteldetails set hoteladdress=? where hotelid=?";
	public static String MODIFYROOMS = "update hoteldetails set numberofrooms=? where hotelid=? ";
	public static String DELETEDETAILS = "delete from hoteldetails where hotelid=?"; 

}
