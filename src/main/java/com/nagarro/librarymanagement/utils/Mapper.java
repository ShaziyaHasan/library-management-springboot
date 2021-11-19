/**
 * Mapper
 * 
 * @author shaziyahasan
 *
 * Mapper class for managing mapping of dto and entity
 */
 
package com.nagarro.librarymanagement.utils;

import org.springframework.stereotype.Service;

import com.nagarro.librarymanagement.entities.Author;
import com.nagarro.librarymanagement.entities.Book;
import com.nagarro.librarymanagement.entities.BookDTO;

@Service
public class Mapper {

	// mapper method for entity to DTO
	
	public BookDTO entityToDTO(Book book) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setAuthorId(book.getAuthor().getAuthorId());
		bookDTO.setBookCode(book.getBookCode());
		bookDTO.setBookName(book.getBookName());
		bookDTO.setAddedOn(book.getAddedOn());
		return bookDTO;
	}

	// mapper method for DTO to Entity
	
	public Book DTOToEntity(BookDTO bookDTO, Author author) {
		Book book = new Book();
		book.setAuthor(author);
		book.setBookCode(bookDTO.getBookCode());
		book.setBookName(bookDTO.getBookName());
		book.setAddedOn(bookDTO.getAddedOn());
		return book;
	}
}
