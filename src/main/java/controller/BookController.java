package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Books;
import service.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author:yujie
 * @Created on 2020/6/18
 */
@Controller
@RequestMapping("/book")
public class BookController {


    //controller层调用service层
    @Autowired
    @Qualifier(value = "BookServiceImpl")
    private BookService bookService;


    //查询全部的书籍并且返回到一个书籍展示页面
    @RequestMapping("/allbooks")
    public String list(Model model){
        List<Books> books = bookService.queryAllBooks();
        model.addAttribute("list", books);
        return "allbooks";
    }

    //跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdatePage(Model model,int id){
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBooks", books);
        return "updateBook";
    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        int i = bookService.updateBook(books);
        if(i>0){
            System.out.println("添加成功");
        }

        return "redirect:/book/allbooks";
    }


    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPage(){
        return "addBook";
    }


    //添加书籍的请求
    @RequestMapping("addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        return "redirect:/book/allbooks"; //重定向到 @RequestMapping("/allbooks")
    }



    //删除书籍
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allbooks";
    }


    //搜索一本书

    @RequestMapping("/searchBook")
    public String searchBook(String queryBookName, Model model) {


        Books books = bookService.queryBookByName(queryBookName);


        List<Books> list = new ArrayList<>();

        if(books==null){
            list=bookService.queryAllBooks();
            model.addAttribute("error", "未查到");
        }else {
            list.add(books);
        }


        model.addAttribute("list",list);


        return "allbooks";
    }
}
