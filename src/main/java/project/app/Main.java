package project.app;

import project.libs.*;

public class Main {
    public static void main(String[] args) {
        // for any code write in app eiei
        Book book1 = new Book();
        book1.setNameBook("ThinkPython");
        book1.setNameWriter("Chotipat");
        book1.setPublisher("Rukpim");
        ArmInsertDB.insertBook(book1.getNameBook(), book1.getNameWriter(), book1.getPublisher());
    }
}
