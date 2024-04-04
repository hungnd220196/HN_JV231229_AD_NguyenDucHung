package bai3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueManagement {
    public static void main(String[] args) {
        Queue<String> customerQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập tên khách hàng chờ mua vé xem phim\n" +
                    "2. Khách tiếp theo\n" +
                    "3. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên khách hàng: ");
                    String customerName = scanner.nextLine();
                    customerQueue.add(customerName);
                    System.out.println("Đã thêm khách hàng " + customerName + " vào hàng đợi.");
                    break;
                case 2:
                    if (!customerQueue.isEmpty()) {
                        String nextCustomer = customerQueue.poll();
                        System.out.println("Khách hàng tiếp theo là: " + nextCustomer);
                    } else {
                        System.out.println("Hàng đợi trống.");
                    }
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        } while (true);

    }
}
