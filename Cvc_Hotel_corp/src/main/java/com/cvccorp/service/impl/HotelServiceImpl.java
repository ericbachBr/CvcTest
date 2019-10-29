package com.cvccorp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cvccorp.model.Hotel;
import com.cvccorp.service.HotelService;
import com.cvccorp.utils.CvcCorpBroker;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private CvcCorpBroker broker;

	@Override
	public List<Hotel> getAllById(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		final ResponseEntity<List<Hotel>> response = restTemplate.exchange(broker.getUrlCity() + id, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Hotel>>() {
				});
		List<Hotel> list = response.getBody();
		return list;

	}

	@Override
	public List<Hotel> getAllByHotel(Integer hotelId) {
		RestTemplate restTemplate = new RestTemplate();
		final ResponseEntity<List<Hotel>> response = restTemplate.exchange(broker.getUrlHotel() + hotelId, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Hotel>>() {
				});
		List<Hotel> list = response.getBody();
		return list;
	}


}
