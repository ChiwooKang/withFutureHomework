package com.example.demo.constants;

public enum ExceptionMessageCode {
    
	//스테이터스 코드상 
    BOOK_NOT_FOUND("book.error.notfound"),
  //  DUPLICATE_BOOK("book.error.duplicate"),
    DUPLICATE_BOOK_NUMBER("duplicate.book.number"),
    DUPLICATE_BOOK_TITLE("duplicate.book.title"),
    INVALID_DATA("invalid.data"),
    
    INVALID_BOOK_NUMBER_FORMAT("invalid.book.number.format"),
    
    // 벨리데이션 거를것
    BOOK_NUMBER_NULL("book.number.null"),
//    BOOK_NUMBER_OUT_OF_RANGE("book.number.min"),
    BOOK_NUMBER_MIN("book.number.min"),
    BOOK_NUMBER_MAX("book.number.max"),
    BOOK_TITLE_SIZE("book.title.size"),
    BOOK_WRITER_EMPTY("book.writer.notempty"),
    BOOK_WRITER_SIZE("book.writer.size"),
    BOOK_WRITER_PATTERN("book.writer.pattern");


    private final String code;

    ExceptionMessageCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
