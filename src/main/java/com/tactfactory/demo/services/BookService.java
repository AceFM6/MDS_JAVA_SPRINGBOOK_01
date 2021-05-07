package com.tactfactory.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tactfactory.demo.entities.Book;
import com.tactfactory.demo.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	
	public List<Book> findAll() {
		return this.repository.findAll();
	}

	
	
}
