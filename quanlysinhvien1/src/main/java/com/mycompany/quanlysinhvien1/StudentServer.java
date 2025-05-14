package com.mycompany.quanlysinhvien1;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StudentServer {
    private static final int PORT = 8888;
    private static Map<String, Student> studentDatabase = new ConcurrentHashMap<>();

static {
    try {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        studentDatabase.put("SV001", new Student("SV001", "Nguyễn Văn A", sdf.parse("15/08/2000"), "Nam", 8.5, "Công nghệ thông tin"));
        studentDatabase.put("SV002", new Student("SV002", "Trần Thị B", sdf.parse("20/05/2001"), "Nữ", 9.0, "Khoa học máy tính"));
        studentDatabase.put("SV003", new Student("SV003", "Lê Văn C", sdf.parse("10/12/1999"), "Nam", 7.8, "Kỹ thuật phần mềm"));
        studentDatabase.put("SV004", new Student("SV004", "Phạm Thị D", sdf.parse("25/03/2002"), "Nữ", 8.2, "Hệ thống thông tin"));
        studentDatabase.put("SV005", new Student("SV005", "Hoàng Văn E", sdf.parse("05/07/2000"), "Nam", 7.5, "An toàn thông tin"));
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server đang chạy tại cổng " + PORT);
            System.out.println("Đang chờ kết nối từ client...");

            // Tiêu đề bảng
            System.out.println("+----------------------+--------+----------+----------------------+------------+--------+-------+------------------------+");
            System.out.println("| Client IP            | Port   | Mã SV    | Họ tên               | Ngày sinh  | Giới   | Điểm  | Ngành học              |");
            System.out.println("+----------------------+--------+----------+----------------------+------------+--------+-------+------------------------+");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi tạo server: " + e.getMessage());
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"))
            ) {
                String studentId;
                while ((studentId = in.readLine()) != null) {
                    if (studentId.equalsIgnoreCase("quit")) break;

                    Student student = studentDatabase.get(studentId);
                    if (student != null) {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                        // Hiển thị dạng bảng từng cột
                        System.out.printf("| %-20s | %-6d | %-8s | %-20s | %-10s | %-6s | %-5.2f | %-22s |\n",
                                clientSocket.getInetAddress().getHostAddress(),
                                clientSocket.getPort(),
                                studentId,
                                student.getFullName(),
                                sdf.format(student.getBirthDate()),
                                student.getGender(),
                                student.getAverageScore(),
                                student.getMajor()
                        );
                    } else {
                        System.out.printf("| %-20s | %-6d | %-8s | %-66s |\n",
                                clientSocket.getInetAddress().getHostAddress(),
                                clientSocket.getPort(),
                                studentId,
                                "Không tìm thấy sinh viên"
                        );
                    }
                }
            } catch (IOException e) {
                System.out.println("Lỗi khi xử lý kết nối từ client: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

