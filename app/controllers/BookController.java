package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Book;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;

import dao.BookService;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.ServiceHelper;
import views.html.book.*;
import views.html.*;

public class BookController extends Controller {
	private static final Logger logger = Logger.getLogger(BookController.class);
	private static BookService bookService = ServiceHelper.getBookService();
	
	public static Result index(){
		logger.info("This is a HTTP GET request...");
		return ok(home.render());
	}
	
	public static Result ajax_list(){
		logger.info("receive list()");
		List<Book> list = bookService.getAllBooks();
		JsonNode jsonNode = Json.toJson(list);
		return ok(jsonNode.toString());
	}
	
	public static Result render_get(){
		logger.info("This is a HTTP GET request...");
		return ok();
	}
	
	public static Result render_post(){
		logger.info("This is a HTTP POST request...");
		return ok();
	}
	
	public static Result add(){
		logger.info("REQUEST GET:book add");
		return ok(add.render());
	}
	
	public static Result add_submit(){
		logger.info("REQUEST POST:book add");
		DynamicForm requestData = Form.form().bindFromRequest();
		String book_id = requestData.get("book_id");
    	String book_name = requestData.get("book_name");
    	String book_price = requestData.get("book_price");
    	List<Book> list = new ArrayList<Book>();
    	try {
			Long id = Long.valueOf(book_id);
			Double price = Double.valueOf(book_price);
	    	Book b = new Book(id, book_name, price);
			list = bookService.getAllBooks();
			list.add(b);
		} catch (Exception e) {
			e.printStackTrace();
			return badRequest();
		}
    	String msg = "NOW new book is added,book list is" + Json.toJson(list);
    	logger.info(msg);
		return ok(msg);
	}
	
}
