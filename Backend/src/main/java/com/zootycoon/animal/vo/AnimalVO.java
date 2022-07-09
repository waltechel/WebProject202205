package com.zootycoon.animal.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AnimalVO {
	
	private String id;
	private String species;
	private String name;
	private int age;
	private String isAlive;

}
