-- Tạo CSDL
CREATE DATABASE IF NOT EXISTS quanlysinhvien;
USE quanlysinhvien;

-- Tạo bảng sinh viên
CREATE TABLE IF NOT EXISTS sinhvien (
    maSV VARCHAR(10) PRIMARY KEY,
    hoTen VARCHAR(100),
    ngaySinh DATE,
    gioiTinh VARCHAR(10),
    diemTB FLOAT,
    nganhHoc VARCHAR(50)
);

-- Thêm dữ liệu mẫu
INSERT INTO sinhvien (maSV, hoTen, ngaySinh, gioiTinh, diemTB, nganhHoc)
VALUES 
('SV001', 'Nguyễn Văn A', '2002-01-15', 'Nam', 8.5, 'CNTT'),
('SV002', 'Trần Thị B', '2002-03-22', 'Nữ', 7.9, 'Kinh tế'),
('SV003', 'Lê Văn C', '2001-11-30', 'Nam', 6.8, 'Điện tử');
INSERT INTO sinhvien (maSV, hoTen, ngaySinh, gioiTinh, diemTB, nganhHoc)
VALUES 
('SV004', 'Phạm Thị D', '2002-05-17', 'Nữ', 9.0, 'Khoa học máy tính'),
('SV005', 'Hoàng Văn E', '2001-09-12', 'Nam', 6.5, 'Cơ điện tử'),
('SV006', 'Đỗ Thị F', '2002-07-04', 'Nữ', 7.2, 'Kế toán'),
('SV007', 'Ngô Văn G', '2000-12-10', 'Nam', 8.1, 'Quản trị kinh doanh'),
('SV008', 'Lý Tsys_configsys_confighị H', '2001-03-28', 'Nữ', 8.9, 'Y dược'),
('SV009', 'Mai Văn I', '2003-06-19', 'Nam', 7.7, 'Kỹ thuật phần mềm'),
('SV010', 'Tạ Thị J', '2002-08-01', 'Nữ', 9.5, 'Ngôn ngữ Anh'),
('SV011', 'Trịnh Văn K', '2001-10-14', 'Nam', 5.9, 'Công nghệ ô tô'),
('SV012', 'Vũ Thị L', '2002-02-22', 'Nữ', 7.8, 'Tài chính ngân hàng'),
('SV013', 'Đinh Văn M', '2000-11-11', 'Nam', 6.2, 'Xây dựng');

SELECT * FROM sinhvien;
