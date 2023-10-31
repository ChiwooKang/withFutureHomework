package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@Data
//@Entity
//@Table(name = "book")
//@NoArgsConstructor
//@AllArgsConstructor
//
//public class Book {
//
//	
//	@ApiModelProperty(example = "도서관리 프로그램")
//	@Id
//	@EmbeddedId
//	private BookID bookID;
//	private String bookWriter;
//}


//@Getter
//@Setter
//@Data
//@Entity
//@Table(name = "book")
//@NoArgsConstructor
//@AllArgsConstructor
//public class Book {
//    @ApiModelProperty(example = "도서관리 프로그램")
//    @Id
//    @EmbeddedId
//    private BookID bookID;
//
//    @Column(name = "book_title") // bookTitle을 별도의 필드로 추가
//    private String bookTitle;
//
//    private String bookWriter;
//}
//
//@Getter
//@Setter
//@Data
//@Entity
//@Table(name = "book")
//@NoArgsConstructor
//@AllArgsConstructor
//public class BookSpare {
//
//    @ApiModelProperty(example = "도서관리 프로그램")
//    @Id
//    @Column(name = "book_no")
//    @NotNull(message = "책 번호는 null 일 수 없습니다..")
//    @Min(value = 1, message = "책번호는 1이상이여야 합니다.")
//    @Max(value = 9999, message = "책 번호는 9999이하여야 합니다.")
//    private int bookNo;
//
//    @Column(name = "book_title")
//    @Size(min = 1, max = 100, message = "제목은 한자 이상 100자 미만으로 설정해주세요.")
//    private String bookTitle;
//    
//    @NotEmpty(message = "제목을 작성해주세요")
//    @Size(min = 1, max = 50, message = "작가명은 한자 이상 50자 미만으로 작성해주세요.")
//    @Pattern(regexp = "^[a-zA-Z\\s가-힣]*$", message = "작가명은 한글과 영문으로만 작성하세요.")
//    private String bookWriter;
//}
//
