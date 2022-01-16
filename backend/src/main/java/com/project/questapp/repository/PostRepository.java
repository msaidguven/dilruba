package com.project.questapp.repository;

import java.util.List;

import com.project.questapp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
	List<Post> findByUserId(Long userId);
}
