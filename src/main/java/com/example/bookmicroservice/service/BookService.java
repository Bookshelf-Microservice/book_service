package com.example.bookmicroservice.service;

import com.example.bookmicroservice.entity.Book;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@AllArgsConstructor
@Service
public class BookService {
    public final FirebaseInitializer firebaseInitializer;

    public List<Book> getAllBooks() throws ExecutionException, InterruptedException {

        List<Book> bookList = new ArrayList<Book>();
        CollectionReference cr = firebaseInitializer.getFirebase().collection("books");
        ApiFuture<QuerySnapshot> querySnapshot =  cr.get();
        for(DocumentSnapshot doc : querySnapshot.get().getDocuments()){
            bookList.add(doc.toObject(Book.class));
        }
        for(Book book:bookList){
            System.out.println(book.getBookName());
        }
        return bookList;
    }

    public Book getBook(String bookName)  throws ExecutionException, InterruptedException{
        CollectionReference cr = firebaseInitializer.getFirebase().collection("books");
        ApiFuture<QuerySnapshot> querySnapshot =  cr.get();

        for(DocumentSnapshot doc : querySnapshot.get().getDocuments()){
            if(Objects.equals(doc.get("bookName"), bookName)) {
                return  doc.toObject(Book.class);
            }
        }
        return null;
    }
}
