package com.aim.recanto.CRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.aim.recanto.CRUD.model.Post;
import com.aim.recanto.CRUD.repository.PostRepository;

@Service
public class PostService {
     
    @Autowired
    private PostRepository repository;
     
    public List<Post> findAll() {
        return repository.findAll();
    }
     
    public Post findOne(Long id) {
        return repository.getOne(id);
    }
     
    public Post save(Post post) {
        return repository.saveAndFlush(post);
    }
     
    public void delete(Long id) {
        repository.deleteById(id);
    }
}