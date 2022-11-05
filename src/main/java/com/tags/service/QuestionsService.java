package com.tags.service;

import java.util.List;

import com.tags.exceptions.QuestionException;
import com.tags.exceptions.TagsException;
import com.tags.model.QuestionDto;
import com.tags.model.Questions;

public interface QuestionsService {
	
	public Questions createQuestions(QuestionDto question) throws QuestionException;
	
	public Questions updateQuestions( Integer qId, QuestionDto question) throws QuestionException;
	
	public Questions addTagsToQuestions( Integer qId, Integer tagId) throws QuestionException, TagsException;
	
	public List<Questions> getQuestionsByTagName( String tagName) throws QuestionException;


}
