package library;

public class LibraryServiceImpl implements LibraryService {
    private Book[] books = new Book[0];

    @Override
    public void addBook(String title, String author) {
        Book newBook = new Book(title, author);
        Book[] newArray = new Book[books.length + 1];
        for (int i = 0; i < books.length; i++) {
            newArray[i] = books[i];
        }
        newArray[books.length] = newBook;
        books = newArray;
    }

    @Override
    public Book[] getAllBooks() {
        return books;
    }

    @Override
    public Book getBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    @Override
    public boolean deleteBook(int id) {
        int index = -1;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == id) {
                index = i;
                break;
            }
        }
        if (index == -1) return false;

        Book[] newArray = new Book[books.length - 1];
        for (int i = 0, j = 0; i < books.length; i++) {
            if (i != index) {
                newArray[j++] = books[i];
            }
        }
        books = newArray;
        return true;
    }
}