package com.bookstore.model.persistance;

import com.bookstore.web.entities.Book;

public interface BookDao {
	public void persistObjectGraph(Book book);
	public Book retrieveObjectGraph(String isbn);
}
