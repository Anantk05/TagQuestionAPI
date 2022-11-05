package com.tags.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tags.model.Questions;
import com.tags.model.Tags;

public interface TagsRepo extends JpaRepository<Tags, Integer> {
	
	public Tags findByTagName(String tagName);
	
	@Query("select t.questions from Tags t where t.tagName like %?1%")
	public List<Questions> getQuestionByTagName(String tagName);

}
