package com.project.questapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_author", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    User user;

    String postUnic;
    String postImg;
    String property;
    Long cikmisSoru;
    Character dCevap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ders_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Menu menu;

    Long konuId;

    Date postTarih;

    int begeniSayisi;
    int yorumSayisi;
    int postCount;
    int dogruCount;
    int yanlisCount;
    int countCevapOnay;
    int yayin;





    @Lob
    @Column(columnDefinition = "text")
    String postContent;


}
