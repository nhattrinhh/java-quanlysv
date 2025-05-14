

package com.mycompany.quanlysinhvien;

import java.io.*;
import java.net.*;
import java.sql.*;

public class StudentServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("Server đang chạy...");

            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("Client đã kết nối: " + client.getInetAddress());

                new Thread(() -> handleClient(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket client) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true)
        ) {
            String maSV = in.readLine(); // Nhận mã sinh viên từ client
            System.out.println("Nhận yêu cầu tra cứu: " + maSV);

            String result = getStudentInfo(maSV); // Truy vấn CSDL
            out.println(result); // Trả kết quả về client
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getStudentInfo(String maSV) {
        String url = "jdbc:mysql://localhost:3306/quanlysinhvien";
        String user = "root"; // đổi nếu cần
        String password = "abc123!@#"; // đổi nếu có mật khẩu

        String query = "SELECT hoTen, ngaySinh, gioiTinh, diemTB, nganhHoc FROM sinhvien WHERE maSV = ?";
        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, maSV);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hoTen = rs.getString("hoTen");
                String ngaySinh = rs.getString("ngaySinh");
                String gioiTinh = rs.getString("gioiTinh");
                String diemTB = rs.getString("diemTB");
                String nganhHoc = rs.getString("nganhHoc");

                return hoTen + "," + ngaySinh + "," + gioiTinh + "," + diemTB + "," + nganhHoc;
            } else {
                return "Không tìm thấy sinh viên";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Lỗi truy vấn CSDL";
        }
    }
}
