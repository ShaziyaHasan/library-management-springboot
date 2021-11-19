/**
 * Book
 * 
 * @author shaziyahasan
 *
 * Entity class for Book
 */
package com.nagarro.librarymanagement.entities;

import java.util.Date;

public class BookDTO {
	
	private Integer bookCode;

	private String bookName;

	private Date addedOn;

	private Integer authorId;

	public BookDTO() {
		super();
	}

	/**
	 * @param bookCode
	 * @param bookName
	 * @param addedOn
	 * @param author
	 */
	public BookDTO(Integer bookCode, String bookName, Date addedOn, Integer authorId) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.addedOn = addedOn;
		this.authorId = authorId;
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

	/**
	 * @return the authorId
	 */
	public Integer getAuthorId() {
		return authorId;
	}

	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", bookName=" + bookName + ", addedOn=" + addedOn + ", author="
				+ authorId + "]";
	}
}
