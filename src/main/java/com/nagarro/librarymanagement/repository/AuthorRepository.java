/**
 * AuthorRepository
 * 
 * @author shaziyahasan
 *
 * Interface for extending JpaRepository
 */
 
package com.nagarro.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nagarro.librarymanagement.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
