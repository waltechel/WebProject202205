package com.zootycoon.animal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 추가한 부분
@Entity
@Table(name = "ANIMAL")
//
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AnimalEntity {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "ANIMAL_ID")
	private String id;
	private String species;
	
	@Column(name = "ANIMAL_NAME")
	private String name;
	private int age;
	private String isAlive;

}