package com.project.questapp.requests.PostRequest;

import lombok.Data;

@Data
public class PostCreateRequest {

    Long id;
    String postContent;
    Long userId;
    Long dersId;
    Long konuId;

    String dCevap;
    String postImg;
    String property;

}
