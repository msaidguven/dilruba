package com.project.questapp.entities;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String userUnic;
    String userName;
    String nickName;
    String userEmail;
    String userPassword;
    String profileAvatar;

    Date uyeTarih;
    Date lastSeen;

    Integer createPostCount;
    Integer correctAnswerCount;
    Integer wrongAnswerCount;
}