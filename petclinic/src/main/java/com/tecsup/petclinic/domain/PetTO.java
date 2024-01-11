package com.tecsup.petclinic.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PetTO {
    private Integer id;
    private String name;
    private Date birthDate;
    private Integer typeId;
    private Integer ownerId;
}
