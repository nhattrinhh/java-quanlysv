/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlysinhvien1;

/**
 *
 * @author asus
 */import java.io.*;
import java.net.*;
import java.util.Scanner;

public class StudentClient {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 8888;

        try (
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            Scanner scanner = new Scanner(System.in)
        ) {
            String input;
            while (true) {
                System.out.print("Nhập mã sinh viên (hoặc 'quit' để thoát): ");
                input = scanner.nextLine();
                out.println(input);
                if ("quit".equalsIgnoreCase(input)) break;
            }
        } catch (IOException e) {
            System.out.println("Lỗi client: " + e.getMessage());
        }
    }
}
