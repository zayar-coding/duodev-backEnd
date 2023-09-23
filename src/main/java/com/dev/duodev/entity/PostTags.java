package com.dev.duodev.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post_tags")
public class PostTags {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "postId", referencedColumnName = "id")
    private Post post;  // Create a Post object to represent the foreign key relationship
    @ManyToOne
    @JoinColumn(name = "tagId", referencedColumnName = "id")
    private Tag tag;
}
