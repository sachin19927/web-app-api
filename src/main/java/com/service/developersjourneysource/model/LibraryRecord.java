package com.service.developersjourneysource.model;

import java.time.LocalDateTime;

public record LibraryRecord(Long id,String title,String category,String author,String email,int year,double price,
		LocalDateTime insertedDate,LocalDateTime modifiedDate) {

}
