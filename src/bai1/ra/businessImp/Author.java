package bai1.ra.businessImp;

import bai1.ra.business.IShop;

import java.util.Scanner;

public class Author implements IShop {
    private int authorId;
    private String authorName;
    private Boolean sex;
    private int year;

    public Author() {
    }

    public Author(int authorId, String authorName, Boolean sex, int year) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.sex = sex;
        this.year = year;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập mã tác gỉa");
        this.authorId = Integer.parseInt(scanner.nextLine());
        System.out.println("mời bạn nhập tên tác giả");
        this.authorName = scanner.nextLine();
        System.out.println("mời bạn nhập giới tính tác giả");
        this.sex = Boolean.valueOf(scanner.nextLine());
        System.out.println("mời bạn nhập năm sinh tác giả");
        this.year = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("| Mã tác giả: %-3d  | Tên tác giả: %-8s \n", this.authorId, this.authorName);
        System.out.println("-------------------------------------------");
    }
}
