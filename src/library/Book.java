package library;

public class Book {
    private static int counter = 1;
    private final int id;
    private String title;
    private String author;

    public Book(String title, String author) {
        this.id = counter++;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
}