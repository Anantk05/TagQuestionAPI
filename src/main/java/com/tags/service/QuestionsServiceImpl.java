package com.tags.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tags.exceptions.QuestionException;
import com.tags.exceptions.TagsException;
import com.tags.model.QuestionDto;
import com.tags.model.Questions;
import com.tags.model.Tags;
import com.tags.repository.QuestionsRepo;
import com.tags.repository.TagsRepo;

@Service
public class QuestionsServiceImpl implements QuestionsService{

	@Autowired
	QuestionsRepo qRepo;
	
	@Autowired
	TagsRepo tRepo;
	
	@Override
	public Questions createQuestions(QuestionDto question) throws QuestionException {
		
		Questions exQ = qRepo.findByTitle(question.getTitle());
		
		if( exQ != null ) {
			throw new QuestionException("Question is already present!");
		}
		Questions newQ = new Questions();
		newQ.setTitle(question.getTitle());
		newQ.setQDesc(question.getQDesc());
		
		return qRepo.save(newQ);
	}

	@Override
	public Questions updateQuestions(Integer qId, QuestionDto question) throws QuestionException {
		
		Questions exQ = qRepo.findById(qId).orElseThrow( ()-> new QuestionException("Question is not present..."));
		
		exQ.setTitle(question.getTitle());
		exQ.setQDesc(question.getQDesc());
		
		return qRepo.save(exQ);
	}

	@Override
	public Questions addTagsToQuestions(Integer qId, Integer tagId) throws QuestionException, TagsException {
		
		Questions question = qRepo.findById(qId).orElseThrow( ()-> new QuestionException("Question not found"));
		
		Tags tag = tRepo.findById(tagId).orElseThrow( ()-> new TagsException("Tag not found!"));
		
		question.getTags().add(tag);
		tag.getQuestions().add(question);
		tRepo.save(tag);
		return qRepo.save(question);
	}

	@Override
	public List<Questions> getQuestionsByTagName(String tagName) throws QuestionException {
		
		List<Questions> qList = tRepo.getQuestionByTagName(tagName);
		
		if( qList.isEmpty()) {
			throw new QuestionException("No question found with this Tag!");
		}
		
		return qList;
	}

}
