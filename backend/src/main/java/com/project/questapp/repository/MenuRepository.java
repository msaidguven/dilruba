package com.project.questapp.repository;

import com.project.questapp.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByParentId(Long parentId);

}
