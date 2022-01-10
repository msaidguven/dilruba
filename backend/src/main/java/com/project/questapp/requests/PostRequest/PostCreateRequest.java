package com.project.questapp.requests.PostRequest;

import lombok.Data;

@Data
public class PostCreateRequest {

    Long Id;
    String postContent;
    Long userId;

}
