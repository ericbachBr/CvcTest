package com.cvccorp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

	private Integer roomID;
	private String categoryName;
	private double totalPrice;
	private Price price;
	
	
}
