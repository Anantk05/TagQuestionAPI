package com.tags.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tags.exceptions.TagsException;
import com.tags.model.TagDto;
import com.tags.model.Tags;
import com.tags.repository.QuestionsRepo;
import com.tags.repository.TagsRepo;

@Service
public class TagsServiceImpl implements TagsService {

	@Autowired
	TagsRepo tRepo;
	
	@Autowired
	QuestionsRepo qRepo;
	
	@Override
	public Tags createTags(TagDto tag) throws TagsException {
		
		Tags newTag = new Tags();
		
		newTag.setTagName(tag.getTagName());
		newTag.setTagDesc(tag.getTagDesc());
		
		return tRepo.save(newTag);
	}

	@Override
	public List<Tags> getTagsByQuestionName(String qName) throws TagsException {
		
		List<Tags> tList = qRepo.getTagsByQuestionName(qName);
		
		if( tList.isEmpty() ) {
			throw new TagsException("Tags not foung with this Question");
		}
		
		return tList;
	}

	
}
