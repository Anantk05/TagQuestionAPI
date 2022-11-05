package com.tags.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tags.exceptions.TagsException;
import com.tags.model.TagDto;
import com.tags.model.Tags;
import com.tags.service.TagsService;

@RestController
@RequestMapping("/tag")
public class TagsController {

	@Autowired
	TagsService tService;
	
	@PostMapping("/add")
	public ResponseEntity<Tags> createQuestionHandler(@Valid @RequestBody TagDto tag) throws TagsException {
		
		Tags savedTag = tService.createTags(tag);
		
		return new ResponseEntity<Tags>( savedTag, HttpStatus.CREATED);
	}
	
	@GetMapping("/get-by-question")
	public ResponseEntity<List<Tags>> getTagByQuestionHandler( @RequestParam String qTitle ) throws TagsException {
		
		List<Tags> tList = tService.getTagsByQuestionName(qTitle);
		
		return new ResponseEntity<List<Tags>>( tList, HttpStatus.OK);
	}
}
