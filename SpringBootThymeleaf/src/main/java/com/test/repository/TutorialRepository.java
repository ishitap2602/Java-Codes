package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.entity.Tutorial;
@Repository
@Transactional
public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {
	
	List<Tutorial> findByTitleContainingIgnoreCase(String keyword);
	
	@Query("UPDATE Tutorial t set t.published = :published where t.id = :id")
	@Modifying
	
	public void updatePublishedStatus(Integer id, boolean published);
	
	
}
