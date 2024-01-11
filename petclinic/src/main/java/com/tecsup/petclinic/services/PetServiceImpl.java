package com.tecsup.petclinic.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.PetNotFoundException;
import com.tecsup.petclinic.repositories.PetRepository;

/**
 *
 * @author jgomezm
 *
 */
@Service
public class PetServiceImpl implements PetService {

	private final PetRepository petRepository;

	public PetServiceImpl(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public Pet create(Pet pet) {
		return petRepository.save(pet);
	}

	@Override
	public Pet findById(long id) throws PetNotFoundException {
		Optional<Pet> owner = petRepository.findById(id);
		if (!owner.isPresent()) {
			throw new PetNotFoundException("Pet not found with id: " + id);
		}
		return owner.get();
	}

	@Override
	public void deleteById(long id) throws PetNotFoundException {
		if (!petRepository.existsById(id)) {
			throw new PetNotFoundException("Pet not found with id: " + id);
		}
		petRepository.deleteById(id);
	}

	@Override
	public List<Pet> findByName(String name) {
		return petRepository.findByName(name);
	}

	@Override
	public List<Pet> findByBirthDate(Date birthDate) {
		return petRepository.findByBirthDate(birthDate);
	}

	@Override
	public List<Pet> findByTypeId(int typeId) {
		return petRepository.findByTypeId(typeId);
	}

	@Override
	public List<Pet> findByOwnerId(int ownerId) {
		return petRepository.findByOwnerId(ownerId);
	}


	@Override
	public Iterable<Pet> findAll() {

		// TODO Auto-generated
		return petRepository.findAll();

	}

	@Override
	public void update(Long id, Pet updatedPet) throws PetNotFoundException {
		Pet existingPet = findById(id);

		// Actualiza los campos que desees del pet existente con los valores del pet actualizado
		existingPet.setName(updatedPet.getName());
		existingPet.setBirthDate(updatedPet.getBirthDate());
		existingPet.setTypeId(updatedPet.getTypeId());
		existingPet.setOwnerId(updatedPet.getOwnerId());

		// Guarda el pet actualizado en el repositorio
		petRepository.save(existingPet);
	}




}