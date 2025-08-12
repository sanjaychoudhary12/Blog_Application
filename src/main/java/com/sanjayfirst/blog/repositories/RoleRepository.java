package com.sanjayfirst.blog.repositories;

import com.sanjayfirst.blog.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}