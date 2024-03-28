package com.myblog.blogapp.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDto {

    private long id;
    @NotNull
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;
    @NotNull
    @Size(min = 10, message = "Post description should have at least 10 characters or ,more")
    private String description;
    @NotNull
    @NotBlank
    private String content;

}
//16:00 41:06 02/1/23
// spring validation class