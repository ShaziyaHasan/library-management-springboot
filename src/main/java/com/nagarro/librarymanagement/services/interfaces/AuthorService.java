/**
 * AuthorService
 * 
 * @author shaziyahasan
 *
 * Interface to declare all the service methods for author entity
 */

package com.nagarro.librarymanagement.services.interfaces;

import java.util.List;
import com.nagarro.librarymanagement.entities.Author;

public interface AuthorService {

	// to add a new author
	public Author addAuthor(Author author);

	// to retrieve all the authors
	public List<Author> getAuthors();

	// to get a particular author
	public Author getAuthorById(Integer authorId);

	// to remove an author
	public void deleteAuthor(Integer authorId);
}
