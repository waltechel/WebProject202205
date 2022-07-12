package com.zootycoon.animal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zootycoon.animal.dto.AnimalDTO;
import com.zootycoon.animal.dto.ResponseDTO;
import com.zootycoon.animal.service.AnimalService;
import com.zootycoon.animal.vo.AnimalVO;

@RestController
@RequestMapping("/animal")
public class AnimalController {

	@Autowired
	private AnimalService animalService;

	@Autowired
	private DTOMapper dtoMapper;

	@GetMapping("/all")
	public ResponseEntity<?> getAllAnimalList() {
		
		List<AnimalVO> animalVOList = animalService.getAllAnimalList();
		List<AnimalDTO> animalDTOList = dtoMapper.toAnimalDTO(animalVOList);

		ResponseDTO<AnimalDTO> responseDTO = ResponseDTO.<AnimalDTO>builder()
				.data(animalDTOList).build();
		
		return ResponseEntity.ok().body(responseDTO);

	}
	
	@GetMapping("/all-alive")
	public ResponseEntity<?> getAllAliveAnimalList() {
		
		List<AnimalVO> animalVOList = animalService.getAllAliveAnimalList();
		List<AnimalDTO> animalDTOList = dtoMapper.toAnimalDTO(animalVOList);

		ResponseDTO<AnimalDTO> responseDTO = ResponseDTO.<AnimalDTO>builder()
				.data(animalDTOList).build();
		
		return ResponseEntity.ok().body(responseDTO);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAnimalbyId(@PathVariable String id) {
		
		List<AnimalVO> animalVOList = animalService.getAnimalById(id);
		List<AnimalDTO> animalDTOList = dtoMapper.toAnimalDTO(animalVOList);

		ResponseDTO<AnimalDTO> responseDTO = ResponseDTO.<AnimalDTO>builder()
				.data(animalDTOList).build();
		
		return ResponseEntity.ok().body(responseDTO);

	}
	
	@PostMapping()
	public ResponseEntity<?> createAnimal(@RequestBody AnimalDTO animalDTO) {
		
		AnimalVO animalVO = dtoMapper.toAnimalVO(animalDTO);
		
		List<AnimalVO> animalVOList = animalService.createAnimal(animalVO);
		List<AnimalDTO> animalDTOList = dtoMapper.toAnimalDTO(animalVOList);

		ResponseDTO<AnimalDTO> responseDTO = ResponseDTO.<AnimalDTO>builder()
				.data(animalDTOList).build();
		
		return ResponseEntity.ok().body(responseDTO);

	}

}
