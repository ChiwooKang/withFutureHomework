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

@Getter
@Setter
@Data
@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
public class Book {

 //   @ApiModelProperty(example = "도서관리 프로그램")
    @Id
    @Column(name = "book_no")
    @NotNull(message = "{book.number.null}")
    @Min(value = 1, message = "{book.number.min}")
    @Max(value = 9999, message = "{book.number.max}")
    private int bookNo;

    @Column(name = "book_title")
    @Size(min = 1, max = 100, message = "{book.title.size}")
    private String bookTitle;
    
    @NotEmpty(message = "{book.writer.notempty}")
    @Size(min = 1, max = 50, message = "{book.writer.size}")
    @Pattern(regexp = "^[a-zA-Z\\s가-힣]*$", message = "{book.writer.pattern}")
    private String bookWriter;
}

