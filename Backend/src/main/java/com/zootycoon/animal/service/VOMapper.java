package com.zootycoon.animal.service;

import java.util.List;

import org.mapstruct.Mapper;

import com.zootycoon.animal.entity.AnimalEntity;
import com.zootycoon.animal.vo.AnimalVO;

@Mapper(componentModel = "spring")
public interface VOMapper {

	List<AnimalVO> toAnimalVO(List<AnimalEntity> animalEntities);

	AnimalEntity toAnimalEntity(AnimalVO animalVO);

}
