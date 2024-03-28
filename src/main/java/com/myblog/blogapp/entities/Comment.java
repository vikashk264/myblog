package com.myblog.blogapp.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String body;
    private String email;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY) //Lazy loading : we load the entity as per the requirement. Eager loading : All the entity are loaded  when the project is started and made available in the project.
    // Here Post is the Parent table and Comment is the Child Table . Comment is mapped to post
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
}
