package com.sanjayfirst.blog.repositories;

import com.sanjayfirst.blog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}