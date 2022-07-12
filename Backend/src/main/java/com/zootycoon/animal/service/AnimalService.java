package com.zootycoon.animal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zootycoon.animal.entity.AnimalEntity;
import com.zootycoon.animal.repository.AnimalRepository;
import com.zootycoon.animal.vo.AnimalVO;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private VOMapper voMapper;

	public List<AnimalVO> getAllAnimalList() {
		List<AnimalEntity> animalEntities = animalRepository.findAll();
		List<AnimalVO> animalVOes = voMapper.toAnimalVO(animalEntities);
		return animalVOes;
	}

	public List<AnimalVO> getAllAliveAnimalList() {
		List<AnimalEntity> animalEntities = animalRepository
												.findAll()
												.stream()
												.filter(a -> "Y".equals(a.getIsAlive()))
												.collect(Collectors.toList());
				
		List<AnimalVO> animalVOes = voMapper.toAnimalVO(animalEntities);
		return animalVOes;
	}

	public List<AnimalVO> getAnimalById(String id) {
		List<AnimalEntity> animalEntities = animalRepository
												.findAll()
												.stream()
												.filter(a -> id.equals(a.getId()))
												.collect(Collectors.toList());
		
		List<AnimalVO> animalVOes = voMapper.toAnimalVO(animalEntities);
		return animalVOes;
	}

}
