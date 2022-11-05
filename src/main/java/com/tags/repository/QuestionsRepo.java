package com.tags.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tags.model.Questions;
import com.tags.model.Tags;

public interface QuestionsRepo extends JpaRepository<Questions, Integer>{

	public Questions findByTitle(String title);
	
	@Query("select q.tags from Questions q where q.title like %?1%")
	public List<Tags> getTagsByQuestionName(String title);

}
