
package com.cg.ohms.ui;

import java.util.Scanner;

import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.HotelException;
import com.cg.ohms.service.IHotel;
import com.cg.ohms.service.impl.HotelDetailsImpl;

public class HmsMain {
	public static void main(String[] args) {
		 
		do {
			/**
			 * for admin HMS provides four operations as follows
			 */
		System.out.println("Hotel Management provides four operations for admin");
		System.out.println("1.Adding new hotel details\n2.View hotel details\n3.Modify hotel details\n4.Delete hotel details");
		System.out.println("Enter above mentioned number for performing that particular operation");
		Scanner scanner=new Scanner(System.in);
		String option=scanner.next();
		IHotel hotel=null;
		if(hotel==null) {
			 hotel =new HotelDetailsImpl();
		}
		boolean flag;
			try {
				switch (option) {
				case "1":
					/**
					 * This option provides adding hotel details to the data base
					 */
					System.out.println("you entered option for adding hotel details");
					System.out.println("First for adding hotel you need to enter hotelid,hotelname,hoteladdress and numberofrooms");
					System.out.println("1.Enter HotelId for adding hotel");
					String hotelId=scanner.next();
					System.out.println("2.Enter HotelName for adding hotel");
					String hotelName=scanner.next();
					System.out.println("3.Enter HotelAddress for adding hotel");
					String hotelAddress=scanner.next();
					System.out.println("4.Enter Number of Rooms for adding hotel");
					int numOfRooms=scanner.nextInt();
					HotelDetailsDTO hotelDetailsDTO=new HotelDetailsDTO();
					hotelDetailsDTO.setHotelId(hotelId);
					hotelDetailsDTO.setHotelName(hotelName);
					hotelDetailsDTO.setHotelAddress(hotelAddress);
					hotelDetailsDTO.setNumOfRooms(numOfRooms);
					hotel.addHotelDetails(hotelDetailsDTO);
			        System.out.println("Hotel Details added successfully");
					break;
				case "2": 
					/**
					 * This option provides viewing hotel details to the data base
					 */
					System.out.println("You Entered option for viewing hotel details");
					System.out.println("Enter hotelid for viewing hotel");
					String viewId=scanner.next();
					hotelDetailsDTO =hotel.viewHotelDetails(viewId);
					System.out.println("Hotel Name for id you entered->->"+hotelDetailsDTO.getHotelName());
					System.out.println("Hotel Address for id you entered->->"+hotelDetailsDTO.getHotelAddress());
					System.out.println("Number of Rooms for id you entered->->"+hotelDetailsDTO.getNumOfRooms());
					break;
				case "3":
					/**
					 * This option provides modifing hotel details to the data base
					 */
					System.out.println("You Entered option for modifing hotel details");
					System.out.println("Enter your option for modifing");
					System.out.println("1.Modify HotelName\n2.Modify HotelAddress\n3.Modify NumberOfRooms");
					String choice=scanner.next();
					switch(choice) {
					case "1":
						/**
						 * This option provides modifing hotel details 
						 * by changing the existing name with updated name entered by admin
						 * to the data base
						 */
						System.out.println("Enter HotelId  for modification");
						String modifyId1=scanner.next();
						 System.out.println("Enter new Hotelname for modification");
						String modifyName=scanner.next();
						hotel.modifyByHotelName(modifyId1, modifyName);
						flag=hotel.modifyByHotelName(modifyId1,modifyName);
                         if(flag==true) {
                        	 System.out.println("modification done successfully");
                         }
                         else {
                        	 System.out.println("Modification not done successfully");
                         }
     					break;
					case"2":
						/**
						 * This option provides modifing hotel details 
						 * by changing the existing address with updated address entered by admin
						 * to the data base
						 */
						System.out.println("Enter HotelId for modification");
						String modifyId2=scanner.next();
						System.out.println("Enter new Hoteladdress  for modification");
						String modifyAddress=scanner.next();
						hotel.modifyByHotelAddress(modifyId2, modifyAddress);
						flag=hotel.modifyByHotelAddress(modifyId2,modifyAddress);
                        if(flag==true) {
                       	 System.out.println("modification done successfully");
                        }
                        else {
                       	 System.out.println("Modification not done successfully");
                        }					
						break;
					case"3":
						/**
						 * This option provides modifing hotel details 
						 * by changing the existing number of rooms with updated number entered by admin
						 * to the data base
						 */
						System.out.println("Enter HotelId for modification");
						String modifyId3=scanner.next();
						System.out.println("Enter new Number of rooms for modification");
						int modifyNumOfRooms=scanner.nextInt();
						hotel.modifyByNumOfRooms(modifyId3, modifyNumOfRooms);
						flag=hotel.modifyByNumOfRooms(modifyId3,modifyNumOfRooms);
                        if(flag==true) {
                        	/**
                        	 * if modification is done successfully
                        	 * then it prints
                        	 */
                       	 System.out.println("modification done successfully");
                        }
                        else {
                        	/**
                        	 * if modification is not done successfully
                        	 * then it prints
                        	 */
                       	 System.out.println("Modification not done successfully");
                        }
						break;
						default:
							/**
							 * if we inputs any value other than
							 * the above mentioned it prints
							 */
							System.out.println("Enter valid option for modification");
							break;
					}
					
					break;
				case "4":
					/**
					 * This option provides deleting hotel details to the data base
					 */
					System.out.println("You Entered option for deleting hotel details");
					System.out.println("Enter hotelid for deleting hotel details");
					String deleteid=scanner.next();
					flag=hotel.deleteHotelDetails(deleteid);
					if(flag==true) {
						System.out.println("Deletion done successfully");
					}
					else {
						System.out.println("Deletion unsuccessfull");
					}
					break;

				default:
					/**
					 * if we inputs any value other than
					 * the above mentioned it prints
					 */
					System.out.println("Enter valid option for performing operations");
					break;
				}
			}
			catch (HotelException e) {
				System.out.println(e.getMessage());
			}
	}while(true);
				
	}
}
