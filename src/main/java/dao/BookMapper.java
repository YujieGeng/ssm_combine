package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Books;

import java.awt.print.Book;
import java.util.List;

/**
 * @description
 * @author:yujie
 * @Created on 2020/6/18
 */
public interface BookMapper {

    //add one book
    int addBook(Books books);


    //delete a book
    int deleteBookById(@Param("bookId") int id);


    //update a book
    int updateBook(Books books);


    //query one book
    Books queryBookById(@Param("bookId") int id);


    //query all books
    List<Books> queryAllBooks();


    //query a book by name
    Books queryBookByName(@Param("bookName") String name);
}
