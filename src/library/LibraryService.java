package library;

public interface LibraryService {
    void addBook(String title, String author);
    Book[] getAllBooks();
    Book getBookById(int id);
    boolean deleteBook(int id);
}
