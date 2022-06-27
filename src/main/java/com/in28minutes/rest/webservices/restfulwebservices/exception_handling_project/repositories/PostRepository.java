package com.in28minutes.rest.webservices.restfulwebservices.exception_handling_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.rest.webservices.restfulwebservices.exception_handling_project.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
