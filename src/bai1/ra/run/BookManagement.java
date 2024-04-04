package bai1.ra.run;

import bai1.ra.businessImp.Author;
import bai1.ra.businessImp.Book;

import java.util.*;

public class BookManagement {
    public static List<Author> authorList = new ArrayList<>();
    public static List<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập số tác giả và nhập thông tin các tác giả \n" +
                    "2. Nhập số sách và nhập thông tin các sách \n" +
                    "3. Sắp xếp sách theo giá xuất sách tăng dần (Comparable/Comparator)\n" +
                    "4. Tìm kiếm sách theo tên tác giả sách \n" +
                    "5. Thoát ");
            System.out.println("Mời bạn nhập lựa chọn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addAuthor();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    sortByPriceAscending();
                    break;
                case 4:
                    searchByAuthor();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("lựa chọn không hợp lệ, vui lòng nhập lại");
            }
        }
    }

    private static void searchByAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên tác giả");
        String inputAuthorName = scanner.nextLine();
        if (bookList.stream().anyMatch(book -> book.getAuthor().getAuthorName().equals(inputAuthorName))) {
            bookList.stream().filter(book -> book.getAuthor().getAuthorName().equals(inputAuthorName)).forEach(Book::displayData);
        } else {
            System.out.println("Không có sách nào");
        }
    }

    private static void sortByPriceAscending() {
        Collections.sort(bookList);
//        bookList.sort(Comparator.comparingDouble(Book::getExportPrice));
        System.out.println("đã sắp xếp theo giá bán tăng dần");
        for (int i = 0; i < bookList.size(); i++) {
            bookList.get(i).displayData();
        }
    }

    private static void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("mời bạn nhập số lượng sách muốn thêm");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Book book = new Book();
            book.inputData();
            bookList.add(book);
        }
        //hiển thị
        for (int i = 0; i < bookList.size(); i++) {
            bookList.get(i).displayData();
        }

    }

    private static void addAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("mời bạn nhập số lượng tác giả muốn thêm");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Author author = new Author();
            author.inputData();
            authorList.add(author);

        }
        //hiển thị
        for (int i = 0; i < authorList.size(); i++) {
            authorList.get(i).displayData();
        }

    }
}
