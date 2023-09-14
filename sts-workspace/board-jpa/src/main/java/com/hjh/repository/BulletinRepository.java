package com.hjh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hjh.model.entity.Bulletin;

public interface BulletinRepository extends JpaRepository<Bulletin, Integer>
{
	
}
