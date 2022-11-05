package com.tags.model;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagDto {

	@Size(min = 3, max = 15, message = "Tag Name should be min 3 and max 15 character!")
	private String tagName;
	
	@Size(min = 15, message = "Description should be min 15 characters long!")
	private String tagDesc;
}
