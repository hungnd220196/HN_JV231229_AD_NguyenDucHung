package bai1.ra.businessImp;

import bai1.ra.business.IShop;

import java.util.List;
import java.util.Scanner;

import static bai1.ra.run.BookManagement.authorList;

public class Book implements IShop, Comparable<Book> {

    private int bookId;
    private String bookName;
    private String title;
    private int NumberOfPage;
    private Author author;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private Boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPage, Author author, float importPrice, float exportPrice, int quantity, Boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        NumberOfPage = numberOfPage;
        this.author = author;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPage() {
        return NumberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        NumberOfPage = numberOfPage;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập mã sách ");
        this.bookId = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập tên sách ");
        this.bookName = scanner.nextLine();
        System.out.println("Mời bạn nhập giá nhập sách ");
        this.importPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Mời bạn nhập số lượng sách ");
        this.quantity = Integer.parseInt(scanner.nextLine());
        this.exportPrice = this.importPrice * RATE;
        System.out.println("mời bạn nhập tên tác giả");
        this.author = getAuthorNameInput(authorList);
        System.out.println("mời bạn nhập trạng thái sách");
        this.bookStatus = Boolean.valueOf(scanner.nextLine());

    }

    public Author getAuthorNameInput(List<Author> authorList) {
        Scanner scanner = new Scanner(System.in);
        // hiển thị danh sách phòng ban
        System.out.println("Danh sách tác giả");
        for (int i = 0; i < authorList.size(); i++) {
            System.out.printf("| STT : %d | Name : %-15s |\n", i + 1, authorList.get(i).getAuthorName());
        }
        while (true) {
            System.out.println("Nhập vào vị trí tác giả (theo STT)");
            int index = Integer.parseInt(scanner.nextLine());
            if (index >= 1 && index <= authorList.size()) {

                return authorList.get(index - 1);
            }
            System.err.println("Vi tri nhap khong hơp lẹ, vui lòng chọn lại");
        }

    }

    @Override
    public void displayData() {
        System.out.printf("| BookID : %-5s | NameBook : %-10s | AuthorName : %-10s |ExportPrice: %.2f| quantity : %d | Trạng thái: %10s\n",
                this.bookId, this.bookName, this.author.getAuthorName(), this.exportPrice, this.quantity, this.bookStatus ? "Đang bán" : "Không bán");
        System.out.println("----------------------------------------------------------------------------------");


    }

    @Override
    public int compareTo(Book o) {
        return Float.compare(this.exportPrice, o.getExportPrice());
    }
}
