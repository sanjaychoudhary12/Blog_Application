package com.sanjayfirst.blog.services.impl;

import com.sanjayfirst.blog.entities.Comment;
import com.sanjayfirst.blog.entities.Post;
import com.sanjayfirst.blog.exception.ResourceNotFoundException;
import com.sanjayfirst.blog.payloads.CommentDto;
import com.sanjayfirst.blog.repositories.CommentRepository;
import com.sanjayfirst.blog.repositories.PostRepository;
import com.sanjayfirst.blog.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {

        Post post = this.postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "post id ", postId));

        Comment comment = this.modelMapper.map(commentDto, Comment.class);

        comment.setPost(post);

        Comment savedComment = this.commentRepository.save(comment);

        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {

        Comment com = this.commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));
        this.commentRepository.delete(com);
    }

}
