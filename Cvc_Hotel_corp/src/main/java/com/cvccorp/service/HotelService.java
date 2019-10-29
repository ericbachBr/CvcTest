package com.cvccorp.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cvccorp.model.Hotel;

@Service
public interface HotelService {
	
	List<Hotel> getAllById(Integer id);

	List<Hotel> getAllByHotel(Integer hotelId);

}
