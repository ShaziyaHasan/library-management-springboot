/**
 * AuthorServiceImplementor
 * 
 * @author shaziyahasan
 *
 * Implementation class for the AuthorService Interface
 */

package com.nagarro.librarymanagement.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.librarymanagement.entities.Author;
import com.nagarro.librarymanagement.repository.AuthorRepository;
import com.nagarro.librarymanagement.services.interfaces.AuthorService;

@Service
public class AuthorServiceImplementor implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Author addAuthor(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public Author getAuthorById(Integer authorId) {
		return authorRepository.getById(authorId);
	}

	@Override
	public void deleteAuthor(Integer authorId) {
		if(getAuthorById(authorId) != null) {
			authorRepository.deleteById(authorId);
		}
	}

}
