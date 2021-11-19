/**
 * BookController
 * 
 * @author shaziyahasan
 *
 * Controller class for book entity
 */
package com.nagarro.librarymanagement.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import com.nagarro.librarymanagement.entities.Book;
import com.nagarro.librarymanagement.entities.BookDTO;
import com.nagarro.librarymanagement.services.interfaces.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;


	/* to get all the books */

	@GetMapping("/book")
	public ResponseEntity<List<BookDTO>> getAllBooks() {
		try {
			List<BookDTO> books = bookService.getBooks();

			if (books.isEmpty() || books.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(books, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/* to get a particular book */

	@GetMapping("/book/{id}")
	public ResponseEntity<BookDTO> getBook(@Valid @PathVariable Integer id) {
		BookDTO book = bookService.getBookById(id);
		
		if (book != null) {
			return new ResponseEntity<BookDTO>(book, HttpStatus.OK);
		}
		
		return new ResponseEntity<BookDTO>(HttpStatus.NOT_FOUND);
	}

	/* Controller to handle adding a new book */

	@PostMapping("/book")
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<BookDTO> saveBook(@Valid @RequestBody BookDTO book) {
		try {
			BookDTO bookSaved = bookService.addBook(book);
			
			//if book created
			if (bookSaved != null) {
				return new ResponseEntity<BookDTO>(bookSaved, HttpStatus.CREATED);
			} 
			
			return new ResponseEntity<BookDTO>(HttpStatus.CONFLICT);
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
			return new ResponseEntity<BookDTO>(HttpStatus.CONFLICT);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<BookDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/* Controller to handle updation of a book */

	@PutMapping("/book/{id}")
	public BookDTO updateBook(@Valid @RequestBody BookDTO bookDTO, @PathVariable @Min(1) Integer id) {
		BookDTO bookUpdated = null;
		
		try {
			bookUpdated = bookService.updateBook(bookDTO, id);
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookUpdated;
	}

	/* Controller to handle deleting a book */

	@DeleteMapping("/book/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable @Min(1) Integer id) {
		try {
			bookService.deleteBook(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
