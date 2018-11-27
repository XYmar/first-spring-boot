package com.xy.test.test.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class RoleEntity {

    @Id
    private String id = UUID.randomUUID().toString();

    private String name;


}
