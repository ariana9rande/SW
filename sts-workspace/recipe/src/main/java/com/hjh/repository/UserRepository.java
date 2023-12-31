package com.hjh.repository;

import com.hjh.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository	extends JpaRepository<User, Long>
{
	User getByUid(String uid);
}
