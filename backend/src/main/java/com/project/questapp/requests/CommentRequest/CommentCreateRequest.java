package com.project.questapp.requests.CommentRequest;

import lombok.Data;

@Data
public class CommentCreateRequest {
    Long id;
    String commentContent;
    Long postId;
    Long userId;
}
