package com.myblog.blogapp.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name="posts",
        uniqueConstraints = {@UniqueConstraint(columnNames={"title"})}
      )
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title", nullable = false)
    private String title;
    @Column(name="description", nullable = false)
    private String description;
    @Column(name="content", nullable = false)
    private String content;

    //Bidirectional mapping Onetomany manytoone it become bidirectional mapping.
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    // Cascade means any changes being done on parent will have impact on child.
            // orphanRemoval = true means I delete the post after that comments become orphan

    Set<Comment> comments;

}

