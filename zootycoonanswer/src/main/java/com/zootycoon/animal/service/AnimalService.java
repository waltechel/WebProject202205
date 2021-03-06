package com.zootycoon.animal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
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
		List<AnimalEntity> animalEntities = animalRepository.findAll().stream().filter(a -> "N".equals(a.getIsAlive()))
				.collect(Collectors.toList());
		List<AnimalVO> animalVOes = voMapper.toAnimalVO(animalEntities);
		return animalVOes;
	}

	public List<AnimalVO> getAnimal(String id) {
		Optional<AnimalEntity> animalEntity = animalRepository.findById(id);
		if (animalEntity.isPresent()) {
			List<AnimalEntity> animalEntities = new ArrayList<>();
			animalEntities.add(animalEntity.get());
			return voMapper.toAnimalVO(animalEntities);
		} else {
			return null;
		}
	}

	public List<AnimalVO> createAnimal(AnimalVO animalVO) {
		AnimalEntity animalEntity = animalRepository.save(voMapper.toAnimalEntity(animalVO));
		List<AnimalEntity> animalEntities = new ArrayList<>();
		animalEntities.add(animalEntity);
		return voMapper.toAnimalVO(animalEntities);
	}

	public List<AnimalVO> updateAnimal(AnimalVO animalVO) {
		AnimalEntity animalEntity = animalRepository.save(voMapper.toAnimalEntity(animalVO));
		List<AnimalEntity> animalEntities = new ArrayList<>();
		animalEntities.add(animalEntity);
		return voMapper.toAnimalVO(animalEntities);
	}

	public void deleteAnimalByName(String name) {
		List<AnimalEntity> animalEntities = animalRepository.findAll();
		for (AnimalEntity animalEntity : animalEntities) {
			if (name.equals(animalEntity.getName()))
				animalRepository.deleteById(animalEntity.getId());
		}
	}

}
