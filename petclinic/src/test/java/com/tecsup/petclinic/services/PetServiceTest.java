package com.tecsup.petclinic.services;


import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.PetNotFoundException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PetServiceTest {

	@Autowired
	private PetService petService;

	private static final Logger logger = LoggerFactory.getLogger(PetServiceTest.class);

	@Test
	public void testCreatePet() throws ParseException {
		String NAME = "Hakari";
		String BIRTH_DATE_STRING = "2024-01-10";
		Integer TYPE_ID = 5;
		Integer OWNER_ID = 7;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date BIRTH_DATE = dateFormat.parse(BIRTH_DATE_STRING);

		Pet pet = new Pet(NAME, new java.sql.Date(BIRTH_DATE.getTime()), TYPE_ID, OWNER_ID);
		Pet petCreated = petService.create(pet);

		assertNotNull(petCreated.getId());
		assertEquals(NAME, petCreated.getName());
		assertEquals(BIRTH_DATE, petCreated.getBirthDate());
		assertEquals(TYPE_ID, petCreated.getTypeId());
		assertEquals(OWNER_ID, petCreated.getOwnerId());
	}


	@Test
	public void testUpdatePet() throws PetNotFoundException, ParseException {
		Long existingPetId = 4L;

		Pet existingPet = petService.findById(existingPetId);

		existingPet.setName("UpdatedName");
		existingPet.setBirthDate(new java.sql.Date(new Date().getTime()));

		petService.update(existingPetId, existingPet);

		Pet updatedPet = petService.findById(existingPetId);
		assertEquals("UpdatedName", updatedPet.getName());
	}
}
