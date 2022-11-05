package com.tags.model;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

	@Size(min = 3, max = 25, message = "Question title should be min 3 and max 25 character!")
	private String title;
	
	@Size(min = 15, message = "Question description should be min 15 characters!")
	private String qDesc;
}
