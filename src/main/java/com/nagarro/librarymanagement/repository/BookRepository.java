/**
 * LibraryRepository
 * 
 * @author shaziyahasan
 *
 * Interface for extending JpaRepository
 */
 
package com.nagarro.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.librarymanagement.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
