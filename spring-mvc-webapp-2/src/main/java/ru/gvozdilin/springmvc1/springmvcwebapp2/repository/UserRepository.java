package ru.gvozdilin.springmvc1.springmvcwebapp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gvozdilin.springmvc1.springmvcwebapp2.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
