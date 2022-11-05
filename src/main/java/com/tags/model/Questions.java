package com.tags.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Questions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer qId;
	
	@Size(min = 3, max = 25, message = "Question title should be min 3 and max 25 character!")
	private String title;
	
	@Size(min = 15, message = "Question description should be min 15 characters!")
	private String qDesc;
	
	@ManyToMany(mappedBy = "questions")
	private List<Tags> tags;
	
}
