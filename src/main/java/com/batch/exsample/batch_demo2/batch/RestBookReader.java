package com.batch.exsample.batch_demo2.batch;

import com.batch.exsample.batch_demo2.entity.BookEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class RestBookReader implements ItemReader<BookEntity> {

    private final String url;

    private final RestTemplate restTemplate;

    private int nextBook;

    private List<BookEntity> bookEntityList;

    public RestBookReader(String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    @Override
    public BookEntity read() throws Exception {
       if(this.bookEntityList == null){
           bookEntityList = fetchBook();
       }
       BookEntity book = null;
       if(nextBook <bookEntityList.size()){
           book = bookEntityList.get(nextBook);
           nextBook++;
       }else{
          nextBook = 0;
          bookEntityList = null;
       }
        return book;
    }

    private List<BookEntity> fetchBook() {
        ResponseEntity<BookEntity[]> responce = restTemplate.getForEntity(this.url,BookEntity[].class);

        BookEntity[] books = responce.getBody();
        if(books != null){
            return Arrays.asList(books);
        }else{
            return null;
        }
    }
}
