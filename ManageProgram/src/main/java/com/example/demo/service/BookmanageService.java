package com.example.demo.service;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.example.demo.constants.ExceptionMessageCode;
import com.example.demo.entity.Book;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.exception.DuplicateBookException;
import com.example.demo.exception.InvalidDataException;
//import com.example.demo.entity.BookID;
import com.example.demo.repository.BookmanageRepository;


@Service
public class BookmanageService {

    private final BookmanageRepository bookmanageRepository;
    
    public List<Book> searchAll() {
		return bookmanageRepository.findAll();
	}

    public BookmanageService(BookmanageRepository bookmanageRepository) {
        this.bookmanageRepository = bookmanageRepository;
    }

    public Book searchNumber(int bookNo) {
        return bookmanageRepository.findById(bookNo)
                .orElseThrow(() -> new BookNotFoundException("번호로 찾을 수 없는 책입니다: " + bookNo));
    }

    public Book updateBook(int bookNo, Book book) {
        Book existingBook = bookmanageRepository.findById(bookNo)
                .orElseThrow(() -> new BookNotFoundException("번호로 찾을 수 없는 책입니다: " + bookNo));
        existingBook.setBookTitle(book.getBookTitle());
        existingBook.setBookWriter(book.getBookWriter());
        return bookmanageRepository.save(existingBook);
    }

    public Book deleteBook(int bookNo) {
        return bookmanageRepository.findById(bookNo)
                .map(book -> {
                    bookmanageRepository.delete(book);
                    return book;
                })
                .orElseThrow(() -> new BookNotFoundException("번호로 찾을 수 없는 책입니다: " + bookNo));
    }

    public Book insertBook(Book book) {
        validateBook(book);
        bookmanageRepository.findById(book.getBookNo())
            .ifPresent(existingBook -> {
                throw new DuplicateBookException("이미 등록된 책 번호입니다: " + book.getBookNo());
            });

        List<Book> booksWithSameTitle = bookmanageRepository.findByBookTitle(book.getBookTitle());
        if (!booksWithSameTitle.isEmpty()) {
            throw new DuplicateBookException("이미 등록된 책 제목입니다: " + book.getBookTitle());
        }

        return bookmanageRepository.save(book);
    }

    private void validateBook(Book book) {
        if (book.getBookNo() <= 0 || book.getBookNo() > 9999) {
            throw new InvalidDataException("잘못된 책 번호입니다.");
        }
        if (book.getBookTitle() == null || book.getBookTitle().isEmpty() || book.getBookTitle().length() > 100) {
            throw new InvalidDataException("잘못된 책 제목입니다.");
        }
        if (book.getBookWriter() == null || book.getBookWriter().isEmpty() || book.getBookWriter().length() > 50 || !book.getBookWriter().matches("^[a-zA-Z\\s가-힣]*$")) {
            throw new InvalidDataException("잘못된 작가 정보입니다.");
        }
    }
}



//기존 동작코드
//@Service
//public class BookmanageService {
//
//    private final BookmanageRepository bookmanageRepository;
//
//    public BookmanageService(BookmanageRepository bookmanageRepository) {
//        this.bookmanageRepository = bookmanageRepository;
//    }
//
//    public List<Book> searchAll() {
//        return bookmanageRepository.findAll();
//    }
//
//    public Book searchNumber(int bookNo) {
//        return bookmanageRepository.findById(bookNo)
//                .orElseThrow(() -> new BookNotFoundException("번호로 찾을 수 없는 책입니다: " + bookNo));
//    }
//
//    public Book updateBook(int bookNo, Book book) {
//        Book oneBook = bookmanageRepository.findById(bookNo)
//                .orElseThrow(() -> new BookNotFoundException("번호로 찾을 수 없는 책입니다: " + bookNo));
//        
//        oneBook.setBookTitle(book.getBookTitle());
//        oneBook.setBookWriter(book.getBookWriter());
//        return bookmanageRepository.save(oneBook);
//    }
//
//    public Book deleteBook(int bookNo) {
//        return bookmanageRepository.findById(bookNo)
//            .map(existingBook -> {
//                bookmanageRepository.delete(existingBook);
//                return existingBook;
//            })
//            .orElseThrow(() -> new BookNotFoundException("삭제할 책이 존재하지 않습니다.!!!!!"));
//    }
//
//    public Book insertBook(Book book) {
//        if (book.getBookNo() == 0 || book.getBookWriter() == null || book.getBookTitle() == null) {
//            throw new InvalidDataException("책번호를 0으로 만들거나 공란으로 두지마세요");
//        }
//
//        // 중복된 BookNo 확인
//        if(bookmanageRepository.existsById(book.getBookNo())) {
//            throw new DuplicateBookException("이미 존재하는 책 번호입니다: " + book.getBookNo());
//        }
//
//        return bookmanageRepository.save(book);
//    }
//}



// 기존 동작 코드
//@Service
//public class BookmanageService {
//
//	private BookmanageRepository bookmanageRepository;
//	
//	
//
//	public BookmanageService(BookmanageRepository bookmanageRepository) {
//		this.bookmanageRepository = bookmanageRepository;
//	}
//
//	public List<Book> searchAll() {
//		return bookmanageRepository.findAll();
//	}
//
//	public Book searchNumber(BookID bookId) {
//		return bookmanageRepository.findById(bookId).orElse(null);
//	}
//
//	public Book updateBook(BookID bookId, Book book) throws Exception {
//	    Book oneBook = bookmanageRepository.findById(bookId).orElse(null);
//	    if (oneBook == null) {
//	        throw new Exception("번호로 찾을수 없는 책 입니다" + bookId);
//	    }
//	    oneBook.setBookWriter(book.getBookWriter());
//	    return bookmanageRepository.save(oneBook);
//	}
//
//	public Book deleteBook(BookID bookId) throws Exception {
//	    Optional<Book> optionalBook = bookmanageRepository.findById(bookId);
//	    if (optionalBook.isPresent()) {
//	        Book book = optionalBook.get();
//	        bookmanageRepository.delete(book);
//	        return book;
//	    } else {
//	        throw new Exception("삭제할 책이 존재하지 않습니다.");
//	    }
//	}
//	public Book insertBook(Book book) throws Exception {
//	    if (book.getBookID() == null || book.getBookID().getBookNo() == 0 || book.getBookWriter() == null) {
//	        throw new Exception("입력된 정보가 부족합니다.");
//	    }
//	    return bookmanageRepository.save(book);
//	}
//}


// 동작수정 두번째
//@Service
//public class BookmanageService {
//
//    private final BookmanageRepository bookmanageRepository;
//    private final MessageSource messageSource;
//    private final HttpServletRequest request;
//
//    public BookmanageService(BookmanageRepository bookmanageRepository, MessageSource messageSource, HttpServletRequest request) {
//        this.bookmanageRepository = bookmanageRepository;
//        this.messageSource = messageSource;
//        this.request = request;
//    }
//
//    public List<Book> searchAll() {
//        return bookmanageRepository.findAll();
//    }
//
//    public Book searchNumber(int bookNo) {
//        return bookmanageRepository.findById(bookNo)
//                .orElseThrow(() -> new BookNotFoundException()); // Modified
//    }
//
//    public Book updateBook(int bookNo, Book book) {
//        Book existingBook = bookmanageRepository.findById(bookNo)
//                .orElseThrow(BookNotFoundException::new); // Modified
//        existingBook.setBookTitle(book.getBookTitle());
//        existingBook.setBookWriter(book.getBookWriter());
//        return bookmanageRepository.save(existingBook);
//    }
//
//    public Book deleteBook(int bookNo) {
//        return bookmanageRepository.findById(bookNo)
//                .map(book -> {
//                    bookmanageRepository.delete(book);
//                    return book;
//                })
//                .orElseThrow(BookNotFoundException::new); // Modified
//    }
//
//    public Book insertBook(Book book) {
//        validateBook(book);
//        bookmanageRepository.findById(book.getBookNo())
//            .ifPresent(existingBook -> {
//                throw new DuplicateBookException(); // Modified
//            });
//
//        List<Book> booksWithSameTitle = bookmanageRepository.findByBookTitle(book.getBookTitle());
//        if (!booksWithSameTitle.isEmpty()) {
//            throw new DuplicateBookException(); // Modified
//        }
//
//        return bookmanageRepository.save(book);
//    }
//
//    private void validateBook(Book book) {
//        if (book.getBookNo() <= 0 || book.getBookNo() > 9999) {
//            throw new InvalidDataException(); // Modified
//        }
//        if (book.getBookTitle() == null || book.getBookTitle().isEmpty() || book.getBookTitle().length() > 100) {
//            throw new InvalidDataException(); // Modified
//        }
//        if (book.getBookWriter() == null || book.getBookWriter().isEmpty() || book.getBookWriter().length() > 50 || !book.getBookWriter().matches("^[a-zA-Z\\s가-힣]*$")) {
//            throw new InvalidDataException(); // Modified
//        }
//    }
//}

// 기존 동작 코드
//@Service
//public class BookmanageService {
//
//    private BookmanageRepository bookmanageRepository;
//
//    public BookmanageService(BookmanageRepository bookmanageRepository) {
//        this.bookmanageRepository = bookmanageRepository;
//    }
//
//    public List<Book> searchAll() {
//        return bookmanageRepository.findAll();
//    }
//
//    public Book searchNumber(int bookNo) {
//        return bookmanageRepository.findById(bookNo).orElse(null);
//    }
//
//    public Book updateBook(int bookNo, Book book) throws Exception {
//        Book oneBook = bookmanageRepository.findById(bookNo).orElse(null);
//        if (oneBook == null) {
//            throw new Exception("번호로 찾을 수 없는 책입니다: " + bookNo);
//        }
//        oneBook.setBookTitle(book.getBookTitle());
//        oneBook.setBookWriter(book.getBookWriter());
//        return bookmanageRepository.save(oneBook);
//    }
//
//    public Book deleteBook(int bookNo) throws Exception {
//        Optional<Book> optionalBook = bookmanageRepository.findById(bookNo);
//        if (optionalBook.isPresent()) {
//            Book book = optionalBook.get();
//            bookmanageRepository.delete(book);
//            return book;
//        } else {
//            throw new Exception("삭제할 책이 존재하지 않습니다.");
//        }
//    }
//
//    public Book insertBook(Book book) throws Exception {
//        if (book.getBookNo() == 0 || book.getBookWriter() == null || book.getBookTitle() == null) {
//            throw new Exception("입력된 정보가 부족합니다.");
//        }
//        return bookmanageRepository.save(book);
//    }



//@Service
//public class BookmanageService {
//
//    private final BookmanageRepository bookmanageRepository;
//    private final MessageSource messageSource;
//    private final HttpServletRequest request;
//
//
//
//    public BookmanageService(BookmanageRepository bookmanageRepository, MessageSource messageSource, HttpServletRequest request) {
//        this.bookmanageRepository = bookmanageRepository;
//        this.messageSource = messageSource;
//        this.request = request;
//    }
//
//    public List<Book> searchAll() {
//        return bookmanageRepository.findAll();
//    }
//
//    public Book searchNumber(int bookNo) {
//        return bookmanageRepository.findById(bookNo)
//                .orElseThrow(() -> new BookNotFoundException(ExceptionMessageCode.BOOK_NOT_FOUND.getCode()));
//    }
//
//    public Book updateBook(int bookNo, Book book) {
//        System.out.println("book : " + book);
//        Book existingBook = bookmanageRepository.findById(bookNo).orElseThrow(() -> new BookNotFoundException(ExceptionMessageCode.BOOK_NOT_FOUND.getCode()));
//        existingBook.setBookTitle(book.getBookTitle());
//        existingBook.setBookWriter(book.getBookWriter());
//        return bookmanageRepository.save(existingBook);
//    }
//
//    public Book deleteBook(int bookNo) {
//        return bookmanageRepository.findById(bookNo)
//                .map(book -> {
//                    bookmanageRepository.delete(book);
//                    return book;
//                })
//                .orElseThrow(() -> new BookNotFoundException(ExceptionMessageCode.BOOK_NOT_FOUND.getCode()));
//    }
//    
// 
//    
//    public Book insertBook(Book book) {
//        validateBook(book);
//        
//        // 동일한 번호 체크
//        bookmanageRepository.findById(book.getBookNo())
//            .ifPresent(existingBook -> {
//                throw new DuplicateBookException(ExceptionMessageCode.DUPLICATE_BOOK_NUMBER);
//            });
//
//        // 동일한 제목 체크
//        List<Book> booksWithSameTitle = bookmanageRepository.findByBookTitle(book.getBookTitle());
//        if (!booksWithSameTitle.isEmpty()) {
//            throw new DuplicateBookException(ExceptionMessageCode.DUPLICATE_BOOK_TITLE);
//        }
//
//        return bookmanageRepository.save(book);
//    }
//
//    
//    // 벨리데이트 메서드로 변경
//    private void validateBook(Book book) {
//        if (book.getBookNo() <= 0) {
//            throw new InvalidDataException(ExceptionMessageCode.BOOK_NUMBER_MIN);
//        } else if (book.getBookNo() > 9999) {
//            throw new InvalidDataException(ExceptionMessageCode.BOOK_NUMBER_MAX);
//        }
//        if (book.getBookTitle() == null || book.getBookTitle().isEmpty() 
//            || book.getBookTitle().length() > 100) {
//            throw new InvalidDataException(ExceptionMessageCode.BOOK_TITLE_SIZE);
//        }
//        if (book.getBookWriter() == null || book.getBookWriter().isEmpty()) {
//            throw new InvalidDataException(ExceptionMessageCode.BOOK_WRITER_EMPTY);
//        } else if (book.getBookWriter().length() > 50) {
//            throw new InvalidDataException(ExceptionMessageCode.BOOK_WRITER_SIZE);
//        } else if (!book.getBookWriter().matches("^[a-zA-Z\\s가-힣]*$")) {
//            throw new InvalidDataException(ExceptionMessageCode.BOOK_WRITER_PATTERN);
//        }
//    }
    
    
   // 최초의 인서트 메서드
//    public Book insertBook(Book book) {
//    	
//   	 bookmanageRepository.findById(book.getBookNo())
//        .ifPresent(existingBook -> {
//            throw new DuplicateBookException("해당 번호의 책이 이미 존재합니다.");
//        });
//
//    return bookmanageRepository.save(book);
//    
//   }

    
// 기존 인서트 코드    
//    public Book insertBook(Book book) {
//        // 데이터 유효성 검사
//        if (book.getBookNo() <= 0 || book.getBookNo() > 9999) {
//            throw new InvalidDataException("책 번호는 1과 9999 사이의 값이어야 합니다.");
//        }
//        
//        if (book.getBookTitle() == null || book.getBookTitle().isEmpty() 
//            || book.getBookTitle().length() > 100) {
//            throw new InvalidDataException("제목은 한자 이상 100자 미만으로 설정해주세요.");
//        }
//        
//        if (book.getBookWriter() == null || book.getBookWriter().isEmpty() 
//            || book.getBookWriter().length() > 50 
//            || !book.getBookWriter().matches("^[a-zA-Z\\s가-힣]*$")) {
//            throw new InvalidDataException("작가명은 한글과 영문으로만 작성하세요.");
//        }
//
//        // 중복 책 확인
//        bookmanageRepository.findById(book.getBookNo())
//            .ifPresent(existingBook -> {
//                throw new DuplicateBookException("해당 번호의 책이 이미 존재합니다.");
//            });
//
//        return bookmanageRepository.save(book);
//    }





    
		

