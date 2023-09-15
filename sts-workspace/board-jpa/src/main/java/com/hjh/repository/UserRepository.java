package com.hjh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hjh.model.entity.BoardUser;

public interface UserRepository extends JpaRepository<BoardUser, Long>
{

}
