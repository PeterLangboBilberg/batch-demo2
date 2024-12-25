package com.batch.exsample.batch_demo2.batch;

import com.batch.exsample.batch_demo2.entity.BookEntity;
import com.batch.exsample.batch_demo2.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class BookWriter implements ItemWriter<BookEntity> {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void write(Chunk<? extends BookEntity> chunk)  {
    log.info("writing: {} ",chunk.getItems().size());
    bookRepository.saveAll(chunk.getItems());
    }


}
