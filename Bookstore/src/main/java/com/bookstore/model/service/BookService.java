package com.bookstore.model.service;

import com.bookstore.web.entities.Book;

public interface BookService {
	public void persistObjectGraph(Book book);

	public Book retrieveObjectGraph(String isbn);
}
