package com.aim.recanto.CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aim.recanto.CRUD.model.Post;
 
@Repository
public interface PostRepository extends JpaRepository<Post, Long> { }
