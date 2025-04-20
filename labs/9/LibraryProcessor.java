import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LibraryProcessor {
    public static void main(String[] args) {
        try {
            // Чтение файла XML
            File xmlFile = new File("library.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Нормализация структуры XML
            document.getDocumentElement().normalize();

            // Получение списка книг
            NodeList bookList = document.getElementsByTagName("book");

            System.out.println("Список всех книг:");
            double totalPrice = 0;

            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);

                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;

                    // Получение данных книги
                    String id = bookElement.getAttribute("id");
                    String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                    String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                    int year = Integer.parseInt(bookElement.getElementsByTagName("year").item(0).getTextContent());
                    String genre = bookElement.getElementsByTagName("genre").item(0).getTextContent();
                    double price = Double.parseDouble(bookElement.getElementsByTagName("price").item(0).getTextContent());

                    // Вывод информации о книге
                    System.out.printf("ID: %s, Название: %s, Автор: %s, Год: %d, Жанр: %s, Цена: %.2f%n",
                            id, title, author, year, genre, price);

                    // Подсчёт общей цены
                    totalPrice += price;
                }
            }

            // Вычисление средней цены
            double avgPrice = totalPrice / bookList.getLength();
            System.out.printf("%nСредняя цена книг: %.2f%n", avgPrice);

            // Фильтрация по жанру
            String filterGenre = "Роман"; // Задайте жанр для фильтрации
            System.out.printf("%nКниги жанра '%s':%n", filterGenre);
            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);

                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;
                    String genre = bookElement.getElementsByTagName("genre").item(0).getTextContent();
                    String title = bookElement.getElementsByTagName("title").item(0).getTextContent();

                    if (genre.equals(filterGenre)) {
                        System.out.println(title);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
