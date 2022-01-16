package com.project.questapp.services;

import com.project.questapp.entities.Menu;
import com.project.questapp.repository.MenuRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    private MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAllMenuByParentId(Long parentId){
        return menuRepository.findByParentId(parentId);
    }

    public Menu getOneMenuById(Long menuId){
        return menuRepository.findById(menuId).orElse(null);
    }

    public Menu createOneMenu(@RequestBody Menu newMenu){
        return menuRepository.save(newMenu);
    }
}
