package com.cvccorp.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;

import com.cvccorp.model.Hotel;
import com.cvccorp.model.Room;

public class CalculateUtils {
	
	
	public static Hotel calculatePrice(Hotel hotel, String checkin, String checkout, Integer adults, Integer childs) {
		Hotel hotelCalc = hotel;
		hotelCalc.getRooms().forEach(r -> calculatePriceRoom(r, checkin, checkout, adults, childs));

		return hotelCalc;
	}

	private static Room calculatePriceRoom(Room r, String checkin, String checkout, Integer adults, Integer childs) {
		Room room = r;
		DateTime dateCheckin = DateTime.parse(checkin, 
                DateTimeFormat.forPattern("dd/MM/yyyy"));
		DateTime dateCheckout = DateTime.parse(checkout, 
                DateTimeFormat.forPattern("dd/MM/yyyy"));
	
		int totalDays = Days.daysBetween(dateCheckin, dateCheckout).getDays();
		double adultPrice = totalDays * r.getPrice().getAdult() * adults;
		double childPrice = totalDays * r.getPrice().getAdult() * childs;
		double total = ((adultPrice/0.7) + (childPrice/0.7));
		 BigDecimal bd = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
		room.setTotalPrice(bd.doubleValue());
		// TODO Auto-generated method stub
		return room;
	}


}
