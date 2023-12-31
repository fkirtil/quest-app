package com.project.questapp.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Bu class database'e maplenecek ::belirtir
@Table(name="user")
@Data
public class User {

    @Id
    private Long id;

    private String userName;
    private String password;
}
