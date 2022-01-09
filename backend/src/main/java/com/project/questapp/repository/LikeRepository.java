package com.project.questapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp.entities.PostLike;

public interface LikeRepository extends JpaRepository<PostLike, Long> {

	List<PostLike> findByUserIdAndPostId(Long userId, Long postId);

	List<PostLike> findByUserId(Long userId);

	List<PostLike> findByPostId(Long postId);

}
