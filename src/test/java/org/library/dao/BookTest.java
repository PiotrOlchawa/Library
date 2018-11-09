package org.library.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.library.domain.Book;
import org.library.repository.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class BookTest {

    @Autowired
    BookDao bookDao;

    @Test
    public void testTitleTestDaoSave(){
    //Given
        Book book = new Book("Book","Author",1997);
        //When
        bookDao.save(book);
        //Then
        Assert.assertEquals(1, book.getId());
    }



}