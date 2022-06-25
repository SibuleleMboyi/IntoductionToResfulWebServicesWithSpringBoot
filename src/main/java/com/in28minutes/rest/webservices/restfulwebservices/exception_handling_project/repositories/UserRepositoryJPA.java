package com.in28minutes.rest.webservices.restfulwebservices.exception_handling_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.rest.webservices.restfulwebservices.exception_handling_project.models.User;

public interface UserRepositoryJPA extends JpaRepository<User, Integer> {

}
