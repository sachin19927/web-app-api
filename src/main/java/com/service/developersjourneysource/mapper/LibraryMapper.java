package com.service.developersjourneysource.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.service.developersjourneysource.entity.Library;
import com.service.developersjourneysource.model.LibraryRecord;

@Mapper
public interface LibraryMapper {

	@Mapping(source = "title" , target = "bookTitle")
	@Mapping(source = "category" , target = "bookCategory")
	@Mapping(source = "author" , target = "bookAuthor")
	@Mapping(source = "year" , target = "publishedYear")
	@Mapping(source = "price" , target = "publishedPrice")
	@Mapping(source = "insertedDate" , target = "publishedDate")
	@Mapping(source = "modifiedDate" , target = "modifiedDate")
	Library recordDataToEntity(LibraryRecord libraryRecord);
	
	@Mapping(source = "bookTitle" , target = "title")
	@Mapping(source = "bookCategory" , target = "category")
	@Mapping(source = "bookAuthor" , target = "author")
	@Mapping(source = "publishedYear" , target = "year")
	@Mapping(source = "publishedPrice" , target = "price")
	@Mapping(source = "publishedDate" , target = "insertedDate")
	@Mapping(source = "modifiedDate" , target = "modifiedDate")
	LibraryRecord entityDataToRecord(Library library);
	
	
	@Mapping(source = "bookTitle" , target = "title")
	@Mapping(source = "bookCategory" , target = "category")
	@Mapping(source = "bookAuthor" , target = "author")
	@Mapping(source = "publishedYear" , target = "year")
	@Mapping(source = "publishedPrice" , target = "price")
	@Mapping(source = "publishedDate" , target = "insertedDate")
	@Mapping(source = "modifiedDate" , target = "modifiedDate")
	List<LibraryRecord> entityListToRecordList(List<Library> library);
}
