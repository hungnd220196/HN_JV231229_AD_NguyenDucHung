package bai2;

import java.util.Scanner;
import java.util.Stack;

public class URLManagement {
    private static Stack<String> history = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập URL muốn truy cập");
            System.out.println("2. Quay lại");
            System.out.println("3. Thoát");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập URL muốn truy cập: ");
                    String url = scanner.nextLine();
                    pushUrl(url);
                    break;
                case 2:
                    navigateBack();
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }

        } while (true);
    }

    private static void pushUrl(String url) {
        history.push(url);
        System.out.println("Đã thêm URL vào lịch sử.");
    }

    private static void navigateBack() {
        if (history.isEmpty()) {
            System.out.println("Lịch sử trống rỗng.");
        } else {
            String previousUrl = history.pop();
            System.out.println("URL trước đó: " + previousUrl);
        }
    }
}

