package com.zootycoon.animal.controller;

import java.util.List;

import org.mapstruct.Mapper;

import com.zootycoon.animal.dto.AnimalDTO;
import com.zootycoon.animal.vo.AnimalVO;

@Mapper(componentModel = "spring")
public interface DTOMapper {

	List<AnimalDTO> toAnimalDTO(List<AnimalVO> animalVOList);

	AnimalVO toAnimalVO(AnimalDTO animalDTO);

}
