package com.project.questapp.requests.PostLikeRequest;

import lombok.Data;

@Data
public class RequestPostLikeCreate {
    Long Id;
    Long userId;
    Long postId;
}
