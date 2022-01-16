package com.project.questapp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "menu")
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long parentId;

    @Column(length = 3, columnDefinition = "integer default '0'")
    Integer siralama;

    String menuName;
    String menuSeflink;
    String icon;



}
