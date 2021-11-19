/**
 * Book
 * 
 * @author shaziyahasan
 *
 * Entity class for Book
 */
package com.nagarro.librarymanagement.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "book_details")
public class Book {

	@Id
	private Integer bookCode;

	@Column(name = "book_name")
	private String bookName;

	@CreationTimestamp
	@Column(name = "added_on", nullable = false, updatable = false)
	private Date addedOn;

	@OneToOne
	@JoinColumn(name = "author_of_book")
	private Author author;

	public Book() {
		super();
	}

	/**
	 * @param bookCode
	 * @param bookName
	 * @param addedOn
	 * @param author
	 */
	public Book(Integer bookCode, String bookName, Date addedOn, Author author) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.addedOn = addedOn;
		this.author = author;
	}

	public Integer getBookCode() {
		return bookCode;
	}

	public void setBookCode(Integer bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", bookName=" + bookName + ", addedOn=" + addedOn + ", author="
				+ author.getAuthorName() + "]";
	}
}
