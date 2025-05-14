/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysinhvien2;

/**
 *
 * @author asus
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class StudentClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập mã sinh viên (hoặc 'quit' để thoát): ");
            String maSV = scanner.nextLine();
            if (maSV.equalsIgnoreCase("quit")) break;

            try (
                Socket socket = new Socket("localhost", 9999);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ) {
                out.println(maSV);
                String response = in.readLine();
                String line;
                System.out.println("Server trả về:");
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (IOException e) {
                System.out.println("Lỗi kết nối đến server");
            }
        }

        scanner.close();
    }
}



