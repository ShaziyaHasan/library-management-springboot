/**
 * BookServiceImplementor
 * 
 * @author shaziyahasan
 *
 * Implementation class for the BookService Interface
 */

package com.nagarro.librarymanagement.services.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.librarymanagement.entities.Author;
import com.nagarro.librarymanagement.entities.Book;
import com.nagarro.librarymanagement.entities.BookDTO;
import com.nagarro.librarymanagement.repository.BookRepository;
import com.nagarro.librarymanagement.services.interfaces.AuthorService;
import com.nagarro.librarymanagement.services.interfaces.BookService;
import com.nagarro.librarymanagement.utils.Mapper;

@Service
public class BookServiceImplementor implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private Mapper mapper;

	/* add a book */
	@Override
	public BookDTO addBook(BookDTO book) {

		BookDTO bookToReturn = null;

		// check if a book with the same bookCode exists in table
		BookDTO bookInTable = getBookById(book.getBookCode());

		if (bookInTable == null) {

			// get author of that particular id
			Author author = authorService.getAuthorById(book.getAuthorId());

			// convert dto to entity
			Book bookToSave = mapper.DTOToEntity(book, author);

			// save the entity
			bookRepository.save(bookToSave);

			// convert entity to dto
			bookToReturn = mapper.entityToDTO(bookToSave);
		}

		return bookToReturn;
	}

	/* get all books */
	
	@Override
	public List<BookDTO> getBooks() {
		List<Book> books = bookRepository.findAll();
		List<BookDTO> booksToReturn = books.stream()
				.map(book -> mapper.entityToDTO(book))
				.collect(Collectors.toList());
		
		return booksToReturn;
	}

	/* get a book by its id */
	
	@Override
	public BookDTO getBookById(Integer id) {
		BookDTO bookToReturn = null;

		try {
			Optional<Book> bookFound = bookRepository.findById(id);

			if (bookFound.isPresent()) {
				bookToReturn = mapper.entityToDTO(bookFound.get());
			}

		} catch (NoSuchElementException e) {
			System.out.println("No book found in the table having this book code");
			e.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return bookToReturn;
	}

	/* delete a book */
	
	@Override
	public void deleteBook(Integer id) {
		if (getBookById(id) != null) {

			BookDTO bookInTable = getBookById(id);

			// get author of that particular id
			Author author = authorService.getAuthorById(bookInTable.getAuthorId());

			bookRepository.delete(mapper.DTOToEntity(getBookById(id), author));
		}
	}

	/* update a book */
	
	@Override
	public BookDTO updateBook(BookDTO book, Integer id) {

		// get book to be updated
		BookDTO bookInTable = getBookById(id);

		if (bookInTable != null) {
			
			//update the attributes
			bookInTable.setBookName(book.getBookName());
			bookInTable.setAuthorId(book.getAuthorId());

			// get author of that particular id
			Author author = authorService.getAuthorById(bookInTable.getAuthorId());

			// convert dto to entity
			Book bookEntity = mapper.DTOToEntity(bookInTable, author);

			// save the entity
			bookRepository.save(bookEntity);

			// convert entity to dto
			bookInTable = mapper.entityToDTO(bookEntity);
		}

		return bookInTable;
	}
}
