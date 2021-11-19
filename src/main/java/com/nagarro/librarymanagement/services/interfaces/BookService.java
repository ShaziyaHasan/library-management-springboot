/**
 * BookService
 * 
 * @author shaziyahasan
 *
 * Interface to declare all the service methods for book entity
 */

package com.nagarro.librarymanagement.services.interfaces;

import java.util.List;
import com.nagarro.librarymanagement.entities.BookDTO;

public interface BookService {

	// to add a new book
	public BookDTO addBook(BookDTO book);

	// to retrieve all the books
	public List<BookDTO> getBooks();

	// to get a particular book
	public BookDTO getBookById(Integer id);

	//to update a book
	public BookDTO updateBook(BookDTO book, Integer id);
	
	// to delete a book
	public void deleteBook(Integer id);
}
