package com.myblog.blogapp.payload;

import lombok.Data;

@Data
public class CommentDto  {

    private long id;
    private String body;
    private String email;
    private String name;
}
