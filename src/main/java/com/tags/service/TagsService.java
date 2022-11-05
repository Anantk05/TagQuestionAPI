package com.tags.service;

import java.util.List;

import com.tags.exceptions.TagsException;
import com.tags.model.TagDto;
import com.tags.model.Tags;

public interface TagsService {

	public Tags createTags(TagDto tag) throws TagsException;
	
	public List<Tags> getTagsByQuestionName( String qName ) throws TagsException;
	
	
}
