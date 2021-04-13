package com.tactfactory.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tactfactory.demo.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	
	
}
