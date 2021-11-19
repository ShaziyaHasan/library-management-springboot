/**
 * Author
 * 
 * @author shaziyahasan
 *
 * Entity class for Author
 */
package com.nagarro.librarymanagement.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "author_details")
public class Author implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer authorId;

	@Column(name = "author_name")
	private String authorName;

	public Author() {
		super();
	}

	/**
	 * @param authorId
	 * @param authorName
	 */
	public Author(Integer authorId, String authorName) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
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

	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + "]";
	}
}
