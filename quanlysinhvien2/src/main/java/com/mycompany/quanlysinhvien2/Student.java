package com.mycompany.quanlysinhvien2;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private String studentId;      // mã sinh viên
    private String fullName;       // họ tên
    private Date birthDate;        // ngày sinh
    private String gender;         // giới tính
    private double averageScore;   // điểm TB
    private String major;          // ngành học

    // Constructor theo thứ tự mới: maSV, hoTen, ngaySinh, gioiTinh, diemTB, nganhHoc
    public Student(String studentId, String fullName, Date birthDate, String gender, double averageScore, String major) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.averageScore = averageScore;
        this.major = major;
    }

    // Getter methods
    public String getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", averageScore=" + averageScore +
                ", major='" + major + '\'' +
                '}';
    }
}
