package com.bookstore.web.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Chapter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chapterId;

	private String title;
	private Integer chapterNumber;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_fk")
	private Book book;

	public Chapter() {
	}

	public Chapter(String title, Integer chapterNumber) {
		this.title = title;
		this.chapterNumber = chapterNumber;
	}

	public Chapter(int chapterId, String title, Integer chapterNumber) {
		this.chapterId = chapterId;
		this.title = title;
		this.chapterNumber = chapterNumber;
	}

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getChapterNumber() {
		return chapterNumber;
	}

	public void setChapterNumber(Integer chapterNumber) {
		this.chapterNumber = chapterNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Chapter [chapterId=");
		builder.append(chapterId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", chapterNumber=");
		builder.append(chapterNumber);
		builder.append("]");
		return builder.toString();
	}

}
