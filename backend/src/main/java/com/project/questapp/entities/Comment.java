package com.project.questapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Post post;

    @Column(name = "comment_author_ip")
    String authorIpAdress;

    Date commentDate;

    @Column(length = 5, name = "cevap_onay_sayisi", columnDefinition = "integer default '0'")
    Integer verifiedAnswersCount;

    @Lob
    @Column(columnDefinition = "text")
    String commentContent;

    @Column(columnDefinition = "text")
    String commentImage;

    @Column(length = 5, name = "yorum_begeni_sayisi", columnDefinition = "integer default '0'")
    Integer likeCount;

    @Column(length = 1, columnDefinition = "integer default '1'")
    Integer yayin;

}
