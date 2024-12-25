package com.batch.exsample.batch_demo2.batch;

import com.batch.exsample.batch_demo2.entity.BookEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class BookTitleProcessor implements ItemProcessor<BookEntity,BookEntity> {

    @Override
    public BookEntity process(BookEntity item) throws Exception {
        log.info("Processing title {}", item);
        item.setTitle(item.getTitle().toUpperCase());
        return item;
    }
}
