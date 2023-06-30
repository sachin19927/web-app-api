package com.service.developersjourneysource.mapper;

import com.service.developersjourneysource.entity.Library;
import com.service.developersjourneysource.model.LibraryRecord;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-30T19:30:51+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class LibraryMapperImpl implements LibraryMapper {

    @Override
    public Library recordDataToEntity(LibraryRecord libraryRecord) {
        if ( libraryRecord == null ) {
            return null;
        }

        Library library = new Library();

        library.setBookTitle( libraryRecord.title() );
        library.setBookCategory( libraryRecord.category() );
        library.setBookAuthor( libraryRecord.author() );
        library.setEmailId( libraryRecord.email() );
        library.setPublishedYear( libraryRecord.year() );
        library.setPublishedPrice( libraryRecord.price() );
        library.setPublishedDate( libraryRecord.insertedDate() );
        library.setModifiedDate( libraryRecord.modifiedDate() );
        library.setId( libraryRecord.id() );
        library.setPages( libraryRecord.pages() );

        return library;
    }

    @Override
    public LibraryRecord entityDataToRecord(Library library) {
        if ( library == null ) {
            return null;
        }

        String title = null;
        String category = null;
        String author = null;
        String email = null;
        int year = 0;
        double price = 0.0d;
        LocalDateTime insertedDate = null;
        LocalDateTime modifiedDate = null;
        Long id = null;
        int pages = 0;

        title = library.getBookTitle();
        category = library.getBookCategory();
        author = library.getBookAuthor();
        email = library.getEmailId();
        year = library.getPublishedYear();
        price = library.getPublishedPrice();
        insertedDate = library.getPublishedDate();
        modifiedDate = library.getModifiedDate();
        id = library.getId();
        pages = library.getPages();

        LibraryRecord libraryRecord = new LibraryRecord( id, title, category, author, email, year, price, pages, insertedDate, modifiedDate );

        return libraryRecord;
    }

    @Override
    public List<LibraryRecord> entityListToRecordList(List<Library> library) {
        if ( library == null ) {
            return null;
        }

        List<LibraryRecord> list = new ArrayList<LibraryRecord>( library.size() );
        for ( Library library1 : library ) {
            list.add( entityDataToRecord( library1 ) );
        }

        return list;
    }
}
