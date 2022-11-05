package com.tags.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tags.exceptions.QuestionException;
import com.tags.exceptions.TagsException;
import com.tags.model.QuestionDto;
import com.tags.model.Questions;
import com.tags.service.QuestionsService;

@RestController
@RequestMapping("/question")
public class QuestionsController {

	@Autowired
	QuestionsService qService;
	
	@PostMapping("/create")
	public ResponseEntity<Questions> createQuestionHandler(@Valid @RequestBody QuestionDto question) throws QuestionException{
		
		Questions savedQ = qService.createQuestions(question);
		
		return new ResponseEntity<Questions>( savedQ, HttpStatus.CREATED);
	}
	
	@PatchMapping("/edit/{qId}")
	public ResponseEntity<Questions> updateQeustionHandler( @PathVariable Integer qId, @Valid @RequestBody QuestionDto question) throws QuestionException{
		
		Questions updatedQ = qService.updateQuestions(qId, question);
		
		return new ResponseEntity<Questions>( updatedQ, HttpStatus.OK);
	}
	
	@PostMapping("/add-tags/{tagId}/{qId}")
	public ResponseEntity<Questions> addTagsToQuestionHandler( @PathVariable Integer tagId, @PathVariable Integer qId) throws QuestionException, TagsException{
		
		Questions questionWithTag = qService.addTagsToQuestions(qId, tagId);
		
		return new ResponseEntity<Questions>( questionWithTag, HttpStatus.OK);
	}
	
	@GetMapping("/get-by-tag")
	public ResponseEntity<List<Questions>> getQuestionByTagHandler( @RequestParam String tagName ) throws QuestionException{
		
		List<Questions> qList = qService.getQuestionsByTagName(tagName);
		
		return new ResponseEntity<List<Questions>>( qList, HttpStatus.OK);
	}
	
}
