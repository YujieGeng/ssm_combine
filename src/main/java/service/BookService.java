package service;

import org.apache.ibatis.annotations.Param;
import pojo.Books;

import java.util.List;

/**
 * @description
 * @author:yujie
 * @Created on 2020/6/18
 */
public interface BookService {


    //add one book
    int addBook(Books books);


    //delete a book
    int deleteBookById(int id);


    //update a book
    int updateBook(Books books);


    //query one book
    Books queryBookById(int id);


    //query all books
    List<Books> queryAllBooks();
}


