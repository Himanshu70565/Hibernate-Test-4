package com.bookstore.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.bookstore.model.service.BookService;
import com.bookstore.model.service.BookServiceImpl;
import com.bookstore.web.entities.Book;
import com.bookstore.web.entities.Chapter;
import com.bookstore.web.entities.Publisher;

public class Main {
	public static void main(String[] args) {
		
		//Example 1
//		Publisher publisher = new Publisher("MANN", "Manning Publications Co.");
//		Book book = new Book("9781617290459", "Java Persistence with Hibernate, Second Edition", publisher);

		List<Chapter> chapters = new ArrayList<Chapter>();
		Chapter chapter1 = new Chapter("Introducing JPA and Hibernate", 1);
		chapters.add(chapter1);
		Chapter chapter2 = new Chapter("Domain Models and Metadata", 2);
		chapters.add(chapter2);
//		book.setChapters(chapters);

		
		
		//Example 2 
		Publisher publisher1 = new Publisher("Arihant");
		Book book1 = new Book("Java 8 in action");
		Chapter ch1 = new Chapter("Exceptional Handling", 1);

		List<Chapter> chaptersList=new ArrayList<>();
		chaptersList.add(ch1);
		
		List<Book> bookList=new ArrayList<>();
		bookList.add(book1);
		
		book1.setPublisher(publisher1);
		book1.setChapters(chaptersList);

		publisher1.setBooks(bookList);
		
		ch1.setBook(book1);
		
		BookService bookService = new BookServiceImpl();
		bookService.persistObjectGraph(book1);

	}
}
