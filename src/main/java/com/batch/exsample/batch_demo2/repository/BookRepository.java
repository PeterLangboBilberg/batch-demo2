package com.batch.exsample.batch_demo2.repository;

import com.batch.exsample.batch_demo2.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
}
