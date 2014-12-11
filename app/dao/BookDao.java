package dao;

import java.util.ArrayList;
import java.util.List;

import models.Book;

public class BookDao implements BookService {

	public List<Book> getAllBooks() {
		List<Book> list = new ArrayList<Book>();
		list.add(new Book(1L, "犯罪心理档案", 8.40));
		list.add(new Book(2L, "墨迹", 5.90));
		list.add(new Book(3L, "帝国的惆怅", 3.95));
		return list;
	}

}
