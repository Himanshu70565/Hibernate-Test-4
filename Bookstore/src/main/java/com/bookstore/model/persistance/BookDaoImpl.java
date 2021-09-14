package com.bookstore.model.persistance;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bookstore.model.persistance.factory.HibernateSessionFactory;
import com.bookstore.web.entities.Book;
import com.bookstore.web.entities.Chapter;
import com.bookstore.web.entities.Publisher;

public class BookDaoImpl implements BookDao {

	private SessionFactory sessionFactory;

	public BookDaoImpl() {
		sessionFactory = HibernateSessionFactory.getSessionFactory();
	}

	public Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public void persistObjectGraph(Book book) {
		Session session = getSession();
		Transaction transaction = session.getTransaction();

		Publisher publisher = book.getPublisher();
		List<Chapter> chapters = book.getChapters();

//		System.out.println(book);
//		System.out.println(publisher);
//		System.out.println(chapters);
		System.out.println(session);
		try {
			transaction.begin();

			session.save(book);
			session.save(publisher);
			session.save(chapters);

			System.out.println("Save ho gye");
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Book retrieveObjectGraph(String isbn) {
		Session session = getSession();
		Transaction transaction = session.getTransaction();
		Book book = null;
		try {
			transaction.begin();

			book = session.get(Book.class, isbn);
			Publisher publisher = book.getPublisher();
			List<Chapter> chapters = book.getChapters();

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return book;
	}

}
