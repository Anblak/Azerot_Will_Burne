package com.azerot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.azerot.entity.World;

public interface WorldAzerotDao extends JpaRepository<World, Integer>{

//
//    @Query("select c from World c left join fetch c.materiky where c.id =:id")
//    World findWorldsWithMateriky(@Param("id") int id);
	
	
}
