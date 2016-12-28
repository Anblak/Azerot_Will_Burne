package com.azerot.dao;



import com.azerot.entity.Area;

//import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;


public interface AreaAzerotDao extends JpaRepository<Area, Integer> {

////	@Query("select distinct a from Area a left join fetch a.inst")
//	List<Area>findAreaWithInst();
////	@Query("select distinct a from Area a left join fetch a.inst where a.id =:id")
//	Area findAreaWithInst(@Param("id") int id);
	
}
