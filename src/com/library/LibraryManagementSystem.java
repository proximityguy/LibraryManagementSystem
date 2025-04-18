package com.library;
import java.util.Scanner;

class Books
{
	private String bookId;
	private String title;
	private String author;
	private short bookCopies;
//	private boolean isAvailable;
	
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public short getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(short bookCopies) {
		this.bookCopies = bookCopies;
	}
	

//	public boolean isAvailable() {
//		return isAvailable;
//	}
//
//	public void setAvailable(boolean isAvailable) {
//		this.isAvailable = isAvailable;
//	}
	
	
	void displayBookDetails(){
		System.out.println(
				  "Id: " + bookId + "\n"
				+ "Title: " + title + "\n"
				+ "Author: " + author + "\n"
				+ "Copies: " + bookCopies);
	}

	
}

class Users
{
	private String userId;
	private String userName;
	String[] borrowedBooks;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String[] getBorrowedBooks() {
		return borrowedBooks;
	}
	public void setBorrowedBooks(String[] borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
	
	void displayUserDetails() {
		System.out.println(
				  "Id: " + userId + "\n"
				+ "name: " + userName + "\n");
		for(int i = 0; i < borrowedBooks.length; i++) {
			System.out.println("id: " + getBorrowedBooks()[i]);
			System.out.println("title: " + getBorrowedBooks()[i]);
		}
	}
	
	
}


public class LibraryManagementSystem 
{
	
	public static void main(String[] args) {
		
		Books[] book = new Books[20];
		Users[] user = new Users[20];
		int bookCount = 0;
		int userCount = 0;
		
//		while(true) {
		System.out.println(
				  "Library Management System \n"
				+ "************************* \n"
				+ "1. Book Module \n"
				+ "2. User Module \n"
				+ "3. Library Module \n"
				+ "4. Exit Application \n"
				+ "Enter Module Choice : ");

		Scanner sc = new Scanner(System.in);
		short moduleChoice = sc.nextShort(); 
		System.out.println("your choice is : " + moduleChoice);
		
		
		switch(moduleChoice)
		{
//		case 1 --> module book
		case 1: System.out.println(
				  "1. add book \n"
				+ "2. view book by id \n"
				+ "3. view all books \n"
				+ "4. remove book \n"
				+ "5. return to Main Menu \n"
				+ "6. Exit the application \n"
				+ "Enter choice : ");
		
		short bookChoice = sc.nextShort();
		System.out.println("your choice in book module : " + bookChoice);
//		inner switch of book module ->
		switch(bookChoice) {
		case 1: System.out.println("add book method running");
						
			if(bookCount <= 20) {
				System.out.println("enter book id: ");
				String id = sc.nextLine();
				book[bookCount].setBookId(id);
				
				System.out.println("enter book title: ");
				String title = sc.nextLine();
				book[bookCount].setTitle(title);
				
				System.out.println("enter author name: ");
				String author = sc.nextLine();
				book[bookCount].setAuthor(author);
				
				System.out.println("enter no of copies: ");
				short copies = sc.nextShort();
				book[bookCount].setBookCopies(copies);
				bookCount++;
			} else {
				System.out.println("book self is full.. can not add more books.!");
			}
			break;
			
		case 2: System.out.println("view book by id");
		break;
		
		case 3: System.out.println("view all books");
		for(int i = 0; i < bookCount; i++) {
			System.out.println(
					  "book: " + i + "\n"
					+ "id: " + book[i].getBookId() + "\n"
					+ "title: " + book[i].getTitle() + "\n"
					+ "author: " + book[i].getAuthor() + "\n"
					+ "copies: " + book[i].getBookCopies());
		}
		break;
		
		case 4: System.out.println("remove book");
		break;
		
		case 5: System.out.println("return to Main Menu");
		break;
		
		case 6: System.out.println("Exit the application");
		break;
		
		default: System.out.println("invalid choice in book module");
		
		}
		break;
		
//		case 2 -> module user
		case 2: System.out.println(
				  "1. add user \n"
				+ "2. view user by Id \n"
				+ "3. view all users \n"
				+ "4. remove user \n"
				+ "5. return to Main Menu \n"
				+ "6. Exit the application \n"
				+ "Enter choice : ");
		
		short userChoice = sc.nextShort();
		System.out.println("your choice in user module : " + userChoice);
		break;
		
//		case 3 -> module library
		case 3: System.out.println(
				  "1. issue book \n"
				+ "2. return book \n"
				+ "3. search book by title \n"
				+ "4. return to Main Menu \n"
				+ "5. Exit the application \n"
				+ "Enter choice : ");
		
		short libraryChoice = sc.nextShort();
		System.out.println("your choice in library module : " + libraryChoice);
		break;
		
//		case 4 -> exit the application
		case 4: System.out.println("Exiting the application.. :)");
		System.exit(moduleChoice);
		
//		default case -> for invalid inputs
		default: 
			System.out.println("Invalid choice.. :( \n"
					+ "Enter a valid choice ..! \n"
					+ "returning to Main Menu.. :) \n");
		}
		
		sc.close();
//		}
	}

}
