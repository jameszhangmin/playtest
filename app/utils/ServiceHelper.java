package utils;

import dao.BookDao;
import dao.BookService;

public class ServiceHelper {
	public static BookService getBookService(){
		return new BookDao();
	}
}
