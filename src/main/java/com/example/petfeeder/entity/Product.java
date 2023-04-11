package com.example.petfeeder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Product {
    @Id
    @GeneratedValue
    private int id ;
    private String name ;
    private int breakfast;
    private int lunch;
    private int dinner;


}

