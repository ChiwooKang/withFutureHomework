package com.example.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor

public class Book {

	
	@ApiModelProperty(example = "도서관리 프로그램")
	@Id
	@EmbeddedId
	private BookID bookID;
	private String bookWriter;
}
