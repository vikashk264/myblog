package com.myblog.blogapp ;

import com.myblog.blogapp.payload.CommentDto;
import com.myblog.blogapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {
    @Autowired
    public CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {

        this.commentService = commentService;
    }
    
     public CommentController() {
    }

    @PostMapping("posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable("postId") long postId, @RequestBody CommentDto commentDto){
        CommentDto dto = commentService.createComment(postId, commentDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    //localhost:8080/api/posts/1/comments
    @GetMapping("posts/{postId}/comments")
    public List<CommentDto> getAllCommentByPostId(@PathVariable("postId") long postId){
        List<CommentDto> dto = commentService.getCommentByPostId(postId);
        return dto;
    }
    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment (
            @PathVariable("postId") long postId,
            @PathVariable("id") long id,
            @RequestBody CommentDto commentDto
    ){

        CommentDto dto = commentService.updateComment(postId, id, commentDto);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(
            @PathVariable("postId") long postId,
            @PathVariable("id") long commentId
    ){
        commentService.deleteComment(postId,commentId);

        return new ResponseEntity<>("comment is deleted!", HttpStatus.OK);

    }
}
// 20/12/2022