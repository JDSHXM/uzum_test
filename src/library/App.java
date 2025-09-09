package library;

public class App {
    public static void result() {
        LibraryService service = new LibraryServiceImpl();
        LibraryMenu menu = new LibraryMenu(service);
        menu.start();
    }
}
