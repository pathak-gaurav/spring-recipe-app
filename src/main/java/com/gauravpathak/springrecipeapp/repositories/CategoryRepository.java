package com.gauravpathak.springrecipeapp.repositories;

import com.gauravpathak.springrecipeapp.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
