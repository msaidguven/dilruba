package com.project.questapp.controllers;

import com.project.questapp.entities.Menu;
import com.project.questapp.services.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/{parentId}")
    public List<Menu> getAllMenuByParentId (@PathVariable Long parentId){
        return menuService.getAllMenuByParentId(parentId);
    }

    @GetMapping("/{menuId")
    public Menu getOneMenuById(@PathVariable Long parentId){
        return menuService.getOneMenuById(parentId);
    }

    @PostMapping("/ekle")
    public Menu createOneMenu(@RequestBody Menu newMenu){
        return menuService.createOneMenu(newMenu);
    }
}
