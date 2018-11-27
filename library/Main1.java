package library;

public class Main1 {

    public static void main(String[] args) {
        
        book b1 = new book(1, "Матричный анализ", "matrix.jpeg", null, 1989, 655);
        b1.appendAuthor(new author(1, "Хорн", "Роджер", "", "Р"));
        b1.appendAuthor(new author(2, "Джонсон", "Чарльз", "", "Ч"));
        b1.setPubl(new publ(1, "Москва \"Мир\"", "М.: Мир"));
        
        System.out.println(b1.getBibliostr());
    }
    
}
