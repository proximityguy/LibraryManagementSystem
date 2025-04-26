package com.library;

import java.util.Scanner;

//	class Books begins here	->
class Books 
{
	private String bookId;
	private String title;
	private String author;
	private int bookCopies;

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

	public int getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(int bookCopies) {
		this.bookCopies = bookCopies;
	}

//	to display book object one by one
	public void displayBookDetails() {		
		System.out.println("Id: " + getBookId() + "\n" 
						 + "Title: " + getTitle() + "\n" 
						 + "Author: " + getAuthor() + "\n"
						 + "Copies: " + getBookCopies());
	}
	
//	to  search book object from array of books by using Id, it will return the very book object
	public static Books searchBookById(Books[] bookArray, String id) {
		for (Books book : bookArray) {
			if(book != null && book.getBookId().equals(id))
				return book;
		}
		return null;
	}
	
//	to delete a book object from the bookArray using Id, it will return a new array
	public static Books[] deleteBook(Books[] bookArray, Books bookToDelete) {
		Books[] resultArray = new Books[bookArray.length - 1];
		
		int k = 0;
		for(int i = 0; i < bookArray.length; i++) {
			if(bookArray[i] == bookToDelete) continue;
			resultArray[k] = bookArray[i];
			k++;
		}
		return resultArray;
	}

}

//	class Users begins here	->
class Users {
	private String userId;
	private String userName;

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


	void displayUserDetails() {
		System.out.println("Id: " + getUserId() + "\n" 
						 + "name: " + getUserName() + "\n");
	}

}

//	main class LibraryManagementSystem begins here	->
public class LibraryManagementSystem 
{
	static Books[] bookArray = new Books[20];
	static Users[] userArray = new Users[20];
	static int bookCount = 0;
	static int userCount = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println(
							"************************* \n"
							+ "Library Management System \n" +
							"************************* \n" 
							+ "1. Book Module \n"
							+ "2. User Module \n" 
							+ "3. Library Module \n" 
							+ "4. Exit Application \n"
							+ "Enter Module Choice : ");

			short moduleChoice = sc.nextShort();
			sc.nextLine();

			switch (moduleChoice) {
//		case 1 --> module book
			case 1:
					System.out.println(
					  "1. add book \n" 
					+ "2. view all books \n"
					+ "3. view book by ID \n" 
					+ "4. remove book \n"
					+ "5. Exit the application \n" 
					+ "Enter choice : ");

					short bookChoice = sc.nextShort();
					sc.nextLine();
//		inner switch of book module ->
					switch (bookChoice) {
					case 1:
						System.out.println("add book method running");

						if (bookCount < 20) {
							bookArray[bookCount] = new Books();		//	bookArray is created here

							System.out.println("enter book id: ");
//							sc.nextLine();
							String id = sc.nextLine();
							bookArray[bookCount].setBookId(id);

							System.out.println("enter book title: ");
							String title = sc.nextLine();
							bookArray[bookCount].setTitle(title);

							System.out.println("enter author name: ");
							String author = sc.nextLine();
							bookArray[bookCount].setAuthor(author);

							System.out.println("enter no of copies: ");
							short copies = sc.nextShort();
							sc.nextLine();
							bookArray[bookCount].setBookCopies(copies);
							bookCount++;
							
						} else {
							System.err.println("book self is full... \n"
											 + "can not add more books.!");
						}
						break;	//	break for outer new switch

					case 2:
						System.err.println("List of all books \n"
										 + "------------------");
						if(bookCount < 1) {
							System.err.println("no books in the library.. \n"
											 + "add new books to the library");
							break;
						}
						
						for (int i = 0; i < bookCount; i++) {
							bookArray[i].displayBookDetails();
							System.err.println("------------------");
						}
\						break;

					case 3:
						if(bookCount < 1) {
							System.err.println("library is empty..."
											 + "add new books to the library");
							break;
						}
						
						System.out.println("search book by id \n"
										 + "enter book id: ");
						String searchId = sc.nextLine();
						System.out.println("count - " + bookCount); // ^^^^^^^^^^^^^^^^
						Books bookFound = Books.searchBookById(bookArray, searchId);
						System.out.println("count - " + bookCount); // ^^^^^^^^^^^^^^^^
						if(bookFound != null) {
							System.err.println("------------------");
							bookFound.displayBookDetails();
							System.err.println("------------------");
						} else {
							System.err.println("no such book id exists...");
						}
						break;
						
					case 4:
						if(bookCount < 1) {
							System.err.println("library is empty..."
											 + "add new books to the library");
							break;
						}
						
						System.out.println("to remove book \n"
										 + "enter the book's ID to remove: ");
						String deleteId = sc.nextLine();
						Books bookToDelete = Books.searchBookById(bookArray, deleteId);
						
						if(bookToDelete == null) {
							System.err.println("no such book id exists...");
							break;
						}
						bookArray = Books.deleteBook(bookArray, bookToDelete);
						System.err.println("book id " + deleteId + " deleted...");
						bookCount--;
						break;

					case 5:
						System.err.println("Exiting the application... :)");
						System.exit(0);

					default:
						System.err.println("invalid choice in book module... :( \n"
										 + "enter a valid choice...! \n"
										 + "returning to Main Menu... :)");
						break;

					}
					break;	//	break for outer main switch

//		case 2 -> module user
			case 2:
				System.out.println(
						"1. add user \n"  
					  + "2. view all users \n" 
					  + "3. remove user \n"
					  + "4. Exit the application \n" 
					  + "Enter choice : ");

				short userChoice = sc.nextShort();
				System.out.println("your choice in user module : " + userChoice);
//				inner switch of user module	->
				switch (userChoice) {
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					break;
				case 4:
					System.err.println("Exiting the application... :)");
					System.exit(0);

				default:
					System.err.println("invalid choice in book module... :( \n"
							 + "enter a valid choice...! \n"
							 + "returning to Main Menu... :)");
					break;
				}
				break;	//	break for outer main switch

//		case 3 -> module library
			case 3:
				System.out.println(
						"1. issue book \n" 
					  + "2. return book \n" 
					  + "3. search book by title \n"
					  + "4. Exit the application \n" 
					  + "Enter choice : ");

				short libraryChoice = sc.nextShort();
				System.out.println("your choice in library module : " + libraryChoice);
				break;	//	break for outer main switch

//		case 4 -> exit the application
			case 4:
				System.err.println("Exiting the application... :)");
				System.exit(0);

//		default case -> for invalid inputs
			default:
				System.err.println(
						"Invalid choice.. :( \n" 
					  + "Enter a valid choice ..! \n" 
					  + "returning to Main Menu.. :) \n");
			}

		}
//		sc.close();
	}

}
