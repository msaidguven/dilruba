package com.project.questapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ders_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Menu menu;

    @Lob
    @Column(columnDefinition = "text")
    String postContent;

    @Column(nullable = false)
    Long konuId;

    @Column(nullable = false)
    String property;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    Date postTarih;

    String postUnic;
    String postImg;

    Long cikmisSoru;

    @Column(length = 1, columnDefinition = "varchar(1) default 'F'")
    String dCevap;

    @Column(columnDefinition = "integer default 0")
    Integer  postCount;

    @Column(columnDefinition = "integer default 0")
    Integer  likeCount;

    @Column(columnDefinition = "integer default 0")
    Integer  commentCount;

    @Column(columnDefinition = "integer default 0")
    Integer  correctCount;

    @Column(columnDefinition = "integer default 0")
    Integer  wrongCount;

    @Column(columnDefinition = "integer default 0")
    Integer  verifiedAnswersCount;

    @Column(length = 1, columnDefinition = "integer default 1")
    Integer  yayin;



}
