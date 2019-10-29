package com.cvccorp.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
	
	private Integer id;
    private String name;
    private Integer cityCode;
    private String cityName;
    private List<Room> rooms;

}
