package com.service.developersjourneysource.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.developersjourneysource.entity.Library;
import com.service.developersjourneysource.mapper.LibraryMapper;
import com.service.developersjourneysource.model.LibraryRecord;
import com.service.developersjourneysource.repositry.LibraryRepositry;

@Service
public class LibraryService {

	@Autowired
	private LibraryMapper mapper;
	
	@Autowired
	private LibraryRepositry libraryRepositry;
	
	
	public LibraryRecord saveBook(LibraryRecord bookRecord)
	{
		LibraryRecord savedBook = null;
		try {
			if(bookRecord!=null) {
			Library book = mapper.recordDataToEntity(bookRecord);
			libraryRepositry.save(book);
			savedBook= mapper.entityDataToRecord(book);
			}
		} catch (Exception e) {
			return null;
		}
		return savedBook;
	}
	
	public List<LibraryRecord> getAllBooksData() {
		return mapper.entityListToRecordList(libraryRepositry.findAll());
	}

	public List<LibraryRecord> getAllBooksDataByName(String title) {
		return mapper.entityListToRecordList(libraryRepositry.findByBookTitleContainingIgnoreCase(title));
	}
	
	public LibraryRecord getBookDetails(Long id)
	{
		LibraryRecord bookdetail = null;
		Optional<Library> book = libraryRepositry.findById(id);
		if (book.isPresent()) {
			bookdetail = mapper.entityDataToRecord(book.get());
			return bookdetail;
		}
		else
			return bookdetail;
	}
	
	public LibraryRecord updateBook(Long id)
	{
		LibraryRecord bookdetail = null;
		Optional<Library> book = libraryRepositry.findById(id);
		if (book.isPresent()) {
			bookdetail = mapper.entityDataToRecord(book.get());
			return bookdetail;
		}
		else
			return bookdetail;
	}


	public void deleteAll() {
		libraryRepositry.deleteAll();
	}
	
	
	
	
	
	
}
