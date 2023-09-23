package com.dev.duodev.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String content;
    private Integer authorId;
    @Column(name = "publishedDate", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedDate;
    @Column(name = "lastModifiedDate", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;


}

/*

 */
