package com.cvccorp.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CvcCorpBroker {
	
	@Value("${url.city}")
	private  String urlCity ;
	
	@Value("${url.hotel}")
	private  String urlHotel ;
	
	public String getUrlCity() {
		return urlCity;
	}
	public String getUrlHotel() {
		return urlHotel;
	}
	
	

}
