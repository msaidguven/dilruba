package com.project.questapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "gunluk_rapor")
@Data
public class DailyReports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    User user;

    @Column(length = 3)
    Integer  uploadPostCount;

    @Column(length = 3)
    Integer  uploadCommentCount;

    @Column(length = 4)
    Integer  readPostCount;

    @Column(length = 4)
    Integer  correctPostCount;

    @Column(length = 4)
    Integer  wrongPostCount;

    @Column(length = 10)
    String reportDate;
}
