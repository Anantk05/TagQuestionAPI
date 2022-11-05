package com.tags.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Tags {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tagId;
	
	@Size(min = 3, max = 15, message = "Tag Name should be min 3 and max 15 character!")
	private String tagName;
	
	@Size(min = 15, message = "Description should be min 15 characters long!")
	private String tagDesc;
	
	@ManyToMany
	@JoinTable(name = "Question_Tag", joinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "tagId"), 
	inverseJoinColumns = @JoinColumn(name = "q_id", referencedColumnName = "qId") )
	@JsonIgnore
	private List<Questions> questions;
	
}
