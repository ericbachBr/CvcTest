package com.cvccorp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cvccorp.model.Hotel;
import com.cvccorp.service.HotelService;
import com.cvccorp.utils.CalculateUtils;

@RestController
@RequestMapping("/api/v1")
public class HotelController {
	@Autowired
	private HotelService hotelService;

	private static final Logger logger = LoggerFactory.getLogger(HotelController.class);

	@GetMapping("/city")
	public ResponseEntity<List<Hotel>> getHotelList(@RequestParam Integer cityCode) {

		List<Hotel> responseList = new ArrayList<Hotel>();
		responseList = hotelService.getAllById(cityCode);

		return ResponseEntity.ok().body(responseList);

	}

	@GetMapping("/cityPrice")
	public ResponseEntity<List<Hotel>> getListAndPrice(@RequestParam Integer cityCode, @RequestParam String checkin,
			@RequestParam String checkout, @RequestParam Integer adults, @RequestParam Integer childs) {

		List<Hotel> responseList = new ArrayList<Hotel>();
		List<Hotel> listHotels = new ArrayList<Hotel>();
	
		listHotels = hotelService.getAllById(cityCode);
	
		listHotels.forEach(r -> responseList.add(CalculateUtils.calculatePrice(r, checkin, checkout, adults, childs)));
		
		
		return ResponseEntity.ok().body(responseList);

	}
	
	@GetMapping("/hotelPrice")
	public ResponseEntity<List<Hotel>> getListAndPriceHotel(@RequestParam Integer hotelId, @RequestParam String checkin,
			@RequestParam String checkout, @RequestParam Integer adults, @RequestParam Integer childs) {

		List<Hotel> responseList = new ArrayList<Hotel>();
		List<Hotel> listHotels = new ArrayList<Hotel>();
	
		listHotels = hotelService.getAllByHotel(hotelId);
	
		listHotels.forEach(r -> responseList.add(CalculateUtils.calculatePrice(r, checkin, checkout, adults, childs)));
		
		
		return ResponseEntity.ok().body(responseList);

	}
	
	
	
}
