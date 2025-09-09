package library;
import java.util.Scanner;

public class LibraryMenu {
    private final LibraryService library;
    private final Scanner scanner = new Scanner(System.in);

    public LibraryMenu(LibraryService library) {
        this.library = library;
    }

    public void start() {
        boolean b = true;
        while (b) {
            menu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> listBooks();
                case 3 -> getBook();
                case 4 -> deleteBook();
                case 5 -> {
                    System.out.println("👋 Выход из программы.");
                    b = false;
                }
                default -> System.out.println("❌ Неверный выбор!");
            }
        }
    }

    public void menu(){
        System.out.printf("------------------------------------%n");
        System.out.printf("|    ** 📚 Меню библиотеки: **    |%n");
        System.out.printf("------------------------------------%n");
        System.out.printf("| 1 | Добавить книгу               |%n");
        System.out.printf("------------------------------------%n");
        System.out.printf("| 2 | Показать все книги           |%n");
        System.out.printf("------------------------------------%n");
        System.out.printf("| 3 | Найти книгу по ID            |%n");
        System.out.printf("------------------------------------%n");
        System.out.printf("| 4 | Удалить книгу ✂             |%n");
        System.out.printf("------------------------------------%n");
        System.out.printf("| 5 | Exit \uD83D\uDEAA                      |%n");
        System.out.printf("------------------------------------%n");
        System.out.print("Ваш выбор: ");
    }

    private void addBook() {
        System.out.print("Название книги: ");
        String title = scanner.nextLine();
        System.out.print("Автор: ");
        String author = scanner.nextLine();
        library.addBook(title, author);
        System.out.println("✅ Книга успешно добавлена!");
    }

    private void listBooks() {
        Book[] books = library.getAllBooks();
        if (books.length == 0) {
            System.out.println("Библиотека пуста!");
        } else {
            System.out.printf("%-5s %-30s %-20s%n", "ID", "Название", "Автор");
            System.out.println("----------------------------------------------------");
            for (Book b : books) {
                System.out.printf("%-5d %-30s %-20s%n",
                        b.getId(), b.getTitle(), b.getAuthor());
            }
        }
    }

    private void getBook() {
        System.out.print("Введите ID книги: ");
        int id = scanner.nextInt();
        Book book = library.getBookById(id);
        if (book != null) {
            System.out.printf("%-5s %-30s %-20s%n", "ID", "Название", "Автор");
            System.out.println("----------------------------------------------------");
            System.out.printf("%-5d %-30s %-20s%n",
                    book.getId(), book.getTitle(), book.getAuthor());
        } else {
            System.out.println("❌ Книга не найдена!");
        }
    }

    private void deleteBook() {
        System.out.print("Введите ID книги для удаления: ");
        int id = scanner.nextInt();
        boolean deleted = library.deleteBook(id);
        if (deleted) {
            System.out.println("🗑 Книга удалена!");
        } else {
            System.out.println("❌ Книга не найдена!");
        }
    }
}
