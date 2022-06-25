package com.zootycoon.animal.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AnimalVO {

	private String id;
	private String species;
	private String name;
	private int age;
	private String isAlive;

}
