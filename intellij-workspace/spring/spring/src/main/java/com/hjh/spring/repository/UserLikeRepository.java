package com.hjh.spring.repository;

import com.hjh.spring.model.entity.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLikeRepository extends JpaRepository<UserLike, Long>
{
}
