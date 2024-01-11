package com.tecsup.petclinic.services;

import java.util.Date;
import java.util.List;

import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.PetNotFoundException;

public interface PetService {

	Pet create(Pet pet);



	Pet findById(long id) throws PetNotFoundException;


	void deleteById(long id) throws PetNotFoundException;


	List<Pet> findByName(String name);

	List<Pet> findByBirthDate(Date birthDate);

	List<Pet> findByTypeId(int typeId);

	List<Pet> findByOwnerId(int ownerId);

	Iterable<Pet> findAll();

	void update(Long id, Pet updatedPet) throws PetNotFoundException;


}