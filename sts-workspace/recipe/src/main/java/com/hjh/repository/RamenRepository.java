package com.hjh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hjh.model.entity.Ramen;

public interface RamenRepository extends JpaRepository<Ramen, Integer>
{

}
