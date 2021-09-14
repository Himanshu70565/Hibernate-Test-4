package com.bookstore.model.service;

import com.bookstore.model.persistance.BookDao;
import com.bookstore.model.persistance.BookDaoImpl;
import com.bookstore.web.entities.Book;

public class BookServiceImpl implements BookService{

	private BookDao bookDao;
	
	public BookServiceImpl() {
		bookDao=new BookDaoImpl();
	}
	
	@Override
	public void persistObjectGraph(Book book) {
		bookDao.persistObjectGraph(book);		
	}

	@Override
	public Book retrieveObjectGraph(String isbn) {
		return bookDao.retrieveObjectGraph(isbn);
	}

}
