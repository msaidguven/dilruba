package com.project.questapp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "osym_sinavlari")
@Data
public class OsymSinavlari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 4, nullable = false)
    Integer yil;

    @Column(length = 20, nullable = false)
    String sinav;

    @Column(length = 20, nullable = false)
    String grup;

    @Column(length = 100, nullable = false)
    String link;

}
