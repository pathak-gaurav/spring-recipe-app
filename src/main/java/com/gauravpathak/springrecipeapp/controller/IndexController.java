package com.gauravpathak.springrecipeapp.controller;

import com.gauravpathak.springrecipeapp.model.Category;
import com.gauravpathak.springrecipeapp.model.UnitOfMeasure;
import com.gauravpathak.springrecipeapp.repositories.CategoryRepository;
import com.gauravpathak.springrecipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String showHomePage() {
        Optional<Category> british = categoryRepository.findByDescription("British");
        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println(british.get().getCategoryId());
        System.out.println(teaspoon.get().getUomId());
        return "index";
    }
}
