package com.zootycoon.animal.controller;

import java.util.List;

import org.mapstruct.Mapper;

import com.zootycoon.animal.dto.AnimalDTO;
import com.zootycoon.animal.vo.AnimalVO;

@Mapper(componentModel = "spring")
public interface DTOMapper {

	AnimalDTO toAnimalDTO(AnimalVO animalVO);

	List<AnimalDTO> toAnimalDTO(List<AnimalVO> animalVO);

	AnimalVO toAnimalVO(AnimalDTO animalDTO);

}
