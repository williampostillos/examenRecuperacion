package com.tecsup.petclinic.mapper;

import com.tecsup.petclinic.domain.PetTO;
import com.tecsup.petclinic.entities.Pet;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-10T22:53:11-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class PetMapperImpl implements PetMapper {

    @Override
    public Pet toPet(PetTO petTO) {

        Pet pet = new Pet();

        if ( petTO != null ) {
            if ( petTO.getBirthDate() != null ) {
                pet.setBirthDate( new Date( petTO.getBirthDate().getTime() ) );
            }
            if ( petTO.getId() != null ) {
                pet.setId( petTO.getId() );
            }
            pet.setName( petTO.getName() );
            if ( petTO.getTypeId() != null ) {
                pet.setTypeId( petTO.getTypeId() );
            }
            if ( petTO.getOwnerId() != null ) {
                pet.setOwnerId( petTO.getOwnerId() );
            }
        }

        return pet;
    }

    @Override
    public PetTO toPetTO(Pet pet) {

        PetTO petTO = new PetTO();

        if ( pet != null ) {
            petTO.setBirthDate( pet.getBirthDate() );
            petTO.setId( (int) pet.getId() );
            petTO.setName( pet.getName() );
            petTO.setTypeId( pet.getTypeId() );
            petTO.setOwnerId( pet.getOwnerId() );
        }

        return petTO;
    }

    @Override
    public List<PetTO> toPetTOList(List<Pet> petList) {
        if ( petList == null ) {
            return new ArrayList<PetTO>();
        }

        List<PetTO> list = new ArrayList<PetTO>( petList.size() );
        for ( Pet pet : petList ) {
            list.add( toPetTO( pet ) );
        }

        return list;
    }

    @Override
    public List<Pet> toPetList(List<PetTO> petTOList) {
        if ( petTOList == null ) {
            return new ArrayList<Pet>();
        }

        List<Pet> list = new ArrayList<Pet>( petTOList.size() );
        for ( PetTO petTO : petTOList ) {
            list.add( toPet( petTO ) );
        }

        return list;
    }
}
