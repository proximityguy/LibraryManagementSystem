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
		System.out.println("__________________ \n"
						 + "Id: " + getBookId() + "\n" 
						 + "Title: " + getTitle() + "\n" 
						 + "Author: " + getAuthor() + "\n"
						 + "Copies: " + getBookCopies());
	}
	
//	to search book object from array of books by using Id, it will return that very book object
	public static Books searchBookById(Books[] bookArray, String id) {
		for (Books book : bookArray) {
			if(book != null && book.getBookId().equals(id))
				return book;
		}
		return null;
	}
	
//	to search a book by its title
	public static Books searchBookByTitle(Books[] bookArray, String name) {
		for (Books book : bookArray) {
			if(book.getTitle().equalsIgnoreCase(name.trim())) {
				return book;
			}
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
class Users 
{
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

//	to display user object one by one
	public void displayUserDetails() {
		System.out.println("__________________\n"
						 + "Id: " + getUserId() + "\n" 
						 + "name: " + getUserName());
	}
	
//	to  search user object from array of users by using Id, it will return that very user object
	public static Users searchUserById(Users[] userArray, String id) {
		for (Users user : userArray) {
			if(user != null && user.getUserId().equals(id)) {
				return user;
			}
		}
		return null;
	}
	
//	to delete a book object from the bookArray using Id, it will return a new array
	public static Users[] deleteUser(Users[] userArray, Users userToDelete) {
		Users[] resultArray = new Users[userArray.length - 1];
		
		int k = 0;
		for (int i = 0; i < resultArray.length; i++) {
			if(userArray[i] == userToDelete) continue;
			resultArray[k] = userArray[i];
			k++;
		}
		return resultArray;
	}

}

//	class Library begins here
class Library
{
	
}

//	main class LibraryManagementSystem begins here	->
public class LibraryManagementSystem 
{
	final static int libraryCapacity = 20;
	final static int userLimit = 100;
	
	static Books[] bookArray = new Books[libraryCapacity];
	static Users[] userArray = new Users[userLimit];
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

						if (bookCount < libraryCapacity) {
//							one book object element in the bookArray is created here
							bookArray[bookCount] = new Books();		

							System.out.println("enter book id: ");
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
							
							System.err.println(title + " book is added to the library...");
							bookCount++;
							
						} else {
							System.err.println("book self is full... \n"
											 + "can not add more new books...!");
						}
						break;

					case 2:
						System.err.println("List of all books");
						
						if(bookCount < 1) {
							System.err.println("library is empty... \n"
											 + "add new books to the library");
							break;
						}
						

						for (int i = 0; i < bookCount; i++) {
							bookArray[i].displayBookDetails();
						}
						break;

					case 3:
						if(bookCount < 1) {
							System.err.println("library is empty... \n"
											 + "add new books to the library");
							break;
						}
						
						System.out.println("search book by id \n"
										 + "enter book id: ");
						String searchId = sc.nextLine();
						
						Books bookFound = Books.searchBookById(bookArray, searchId);
						
						if(bookFound != null) {
							bookFound.displayBookDetails();
						} else {
							System.err.println("no such book id exists...");
						}
						break;
						
					case 4:
						if(bookCount < 1) {
							System.err.println("library is empty... \n"
											 + "add new books to the library");
							break;
						}
						
						System.out.println("to remove book \n"
										 + "enter the book's ID: ");
						String deleteId = sc.nextLine();
						
//						searching the book
						Books bookToDelete = Books.searchBookById(bookArray, deleteId);
						if(bookToDelete == null) {
							System.err.println("no such book id exists...");
							break;
						}
						
//						if book found, deleting the book
						bookArray = Books.deleteBook(bookArray, bookToDelete);
						System.err.println("book id " + bookToDelete.getBookId() + "\n"
										  + bookToDelete.getTitle() + " deleted...");
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
					  + "3. view user by ID \n" 
					  + "4. remove user \n"
					  + "5. Exit the application \n" 
					  + "Enter choice : ");

				short userChoice = sc.nextShort();
				sc.nextLine();

//				inner switch of user module	->
				switch (userChoice) {
				case 1:
					
					if(userCount < userLimit) {
//						one user object element in the userArray is created here
						userArray[userCount] = new Users();
						
						System.out.println("enter user id: ");
						String id = sc.nextLine();
						userArray[userCount].setUserId(id);
						
						System.out.println("enter user name: ");
						String name = sc.nextLine();
						userArray[userCount].setUserName(name);
						
						System.err.println("a new user is added");
						userCount++;
					} else {
						System.err.println("user limit is full... \n"
								 + "can not add more users...!");
					}
					
					break;
				case 2:
					System.err.println("List of all users");

					if(userCount < 1) {
						System.err.println("no users exist... \n"
											 + "add new users to use library...!");
						break;
					}
						

					for (int i = 0; i < userCount; i++) {
						userArray[i].displayUserDetails();
					}								
					break;
				case 3:
					if(userCount < 1) {
						System.err.println("no users exist... \n"
										 + "add new users to use library...!");
						break;
					}
					
					System.out.println("search user by ID \n"
									 + "enter user id: ");
					String searchId = sc.nextLine();
					Users userFound = Users.searchUserById(userArray, searchId);
					
					if(userFound != null) {
						userFound.displayUserDetails();
					} else {
						System.out.println("no such user id exists...");
					}
					
					break;
				case 4:
					if(userCount < 1) {
						System.err.println("userList is empty... \n"
										 + "add new users to the library");
						break;
					}
					
					System.out.println("to remove user \n"
									 + "enter the user's ID: ");
					String deleteId = sc.nextLine();
					
//					searching the user
					Users userToDelete = Users.searchUserById(userArray, deleteId);
					if(userToDelete == null) {
						System.err.println("no such user id exists...");
						break;
					}
					
//					if user found, deleting the user
					userArray = Users.deleteUser(userArray, userToDelete);
					System.err.println("user id " + userToDelete.getUserId() + "\n"
									  + userToDelete.getUserName() + " deleted...");
					userCount--;
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

//		case 3 -> module library
			case 3:
				System.out.println(
						"1. issue book \n" 
					  + "2. return book \n" 
					  + "3. search book by title \n"
					  + "4. Exit the application \n" 
					  + "Enter choice : ");

				short libraryChoice = sc.nextShort();
				sc.nextLine();
				
				switch (libraryChoice) {
				case 1:
					System.out.println("enter book id: ");
					String bookId = sc.nextLine();
					System.out.println("enter user id: ");
					String userId = sc.nextLine();
					
					
					break;
				case 2:
					
					break;
				case 3:
					if(bookCount < 1) {
						System.err.println("library is empty... \n"
										 + "add new books to the library");
						break;
					}
					
					System.out.println("enter name of book: ");
					String name = sc.nextLine();
					
//					searching for book
					Books bookFound = Books.searchBookByTitle(bookArray, name);
					
					if(bookFound != null) {
						bookFound.displayBookDetails();
					} else {
						System.err.println("no such book id exists...");
					}
					break;
				case 4:
					System.err.println("Exiting the application... :)");
					System.exit(0);
					
				default:
					System.err.println("invalid choice in library module... :( \n"
					 		 + "enter a valid choice...! \n"
					 		 + "returning to Main Menu... :)");
					break;
				}

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
