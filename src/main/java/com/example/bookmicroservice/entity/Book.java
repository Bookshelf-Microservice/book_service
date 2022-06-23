package com.example.bookmicroservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Book {
    private String bookName;
    private String bookAuthor;
    private String bookPublishingHouse;
    private String bookUrl;

}
