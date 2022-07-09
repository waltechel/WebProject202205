package com.zootycoon.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zootycoon.animal.entity.AnimalEntity;

public interface AnimalRepository extends JpaRepository<AnimalEntity, String>{

}
