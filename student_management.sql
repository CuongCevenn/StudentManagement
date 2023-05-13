-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 13, 2023 lúc 06:33 PM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB-log
-- Phiên bản PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `student_management`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `course`
--

CREATE TABLE `course` (
  `course_id` varchar(20) NOT NULL,
  `name_course` varchar(50) NOT NULL,
  `student_id` varchar(12) NOT NULL,
  `student_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `course`
--

INSERT INTO `course` (`course_id`, `name_course`, `student_id`, `student_name`) VALUES
('INT1001_1', 'CNPM', '21029183', 'hduasdhsuadn'),
('INT1001_1', 'CNPM', '21983213', 'djnjkdsfdjsk'),
('INT1001_1', 'CNPM', '22222222', 'Cường'),
('INT1001_1', 'CNPM', '90827123', 'Cuong');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `login`
--

CREATE TABLE `login` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', 'administrator'),
('cuongnguyen', 'CuongNguyen');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student`
--

CREATE TABLE `student` (
  `id` varchar(12) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `birthday` varchar(10) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `classObj` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `student`
--

INSERT INTO `student` (`id`, `fullname`, `birthday`, `gender`, `email`, `address`, `phone`, `classObj`) VALUES
('12234323', 'Trần Văn Hùng', '2003-11-22', 'Male', 'hungtv03@gmail.com', 'Thạch Hòa- Thạch Thất - Hà Nội', '0982134234', 'K66CB'),
('12354435', 'HSDN', '2004-11-03', 'Male', 'adbc@gmail.com', 'Ha Noi', '0981234325', 'K65CB'),
('21029183', 'hduasdhsuadn', '1996-04-25', 'Female', 'sadsadsad@hotmail.com', 'Ha Noi - Viet Nam', '0987612345', 'K56CC'),
('21983213', 'djnjkdsfdjsk', '2004-04-07', 'Male', 'sadsadsad', 'sadsadsad', 'dsdssdsdsds', 'dsadsajd'),
('22222222', 'Cường', '2005-04-06', 'Male', 'cuongiii@gmail.com', 'Hà Nội- Việt Nam', '0987890988', 'K66CB'),
('90827123', 'Cuong', '2002-10-26', 'Male', 'cuog@dasd.com', 'Hanoi', '0987654321', 'K65CC'),
('91312984', 'HUdiausn', '2003-04-10', 'Female', 'afads@sadsadas', 'mdmasdsad', '0982732134', 'sạdnjsa');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `teacher`
--

CREATE TABLE `teacher` (
  `id` varchar(12) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `birth` varchar(10) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `quali` varchar(50) DEFAULT NULL,
  `exper` varchar(2) DEFAULT NULL,
  `achie` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `teacher`
--

INSERT INTO `teacher` (`id`, `fullname`, `birth`, `gender`, `email`, `address`, `phone`, `quali`, `exper`, `achie`) VALUES
('45892654', 'John Smith', '1980-07-12', 'Male', 'john.smith@example.com', 'New York City, USA', '+1-555-123-4567', 'PhD in Computer Science', '15', 'Published research paper in top-tier conference'),
('86954321', 'Mary Nguyen', '1992-11-05', 'Female', 'mary.nguyen@example.com', 'Ho Chi Minh City, Vietnam', '+84-123-456-789', 'Master\'s degree in Education', '5', 'Outstanding teacher award in local school district'),
('75361928', 'Alex Lee', '1985-02-20', 'Male', 'alex.lee@example.com', 'London, UK', '+44-789-123-456', 'Bachelor\'s degree in History', '10', 'Published book on the history of England'),
('65432189', 'Emma Brown', '1991-04-30', 'Female', 'emma.brown@example.com', 'Sydney, Australia', '+61-2-1234-5678', 'PhD in Physics', '8', 'Presented research at international conference'),
('98765432', 'David Kim', '1978-09-15', 'Male', 'david.kim@example.com', 'Seoul, South Korea', '+82-2-1234-5678', 'Master\'s degree in Business Administration', '12', 'Entrepreneurship award in the tech industry'),
('12345678', 'Karen Chang', '1987-12-25', 'Female', 'karen.chang@example.com', 'Taipei, Taiwan', '+886-2-1234-567', 'PhD in Chemistry', '9', 'Published research paper in scientific journal'),
('45678912', 'Samantha Chen', '1994-06-18', 'Female', 'samantha.chen@example.com', 'Shanghai, China', '+86-21-1234-567', 'Bachelor\'s degree in English', '4', 'Excellence in teaching award at local language school'),
('36925814', 'Jackie Wu', '1982-03-10', 'Female', 'jackie.wu@example.com', 'Hong Kong', '+852-1234-5678', 'Master\'s degree in Psychology', '7', 'Research grant from local funding agency'),
('58291736', 'Andrew Brown', '1973-08-05', 'Male', 'andrew.brown@example.com', 'Melbourne, Australia', '+61-3-1234-5678', 'PhD in Engineering', '20', 'Inventor of patented technology'),
('27653489', 'Jonathan Lee', '1988-11-20', 'Male', 'jonathan.lee@example.com', 'Singapore', '+65-1234-5678', 'Master\'s degree in Economics', '6', 'Co-authored book on economic policy'),
('12987654', 'Catherine Kim', '1981-02-17', 'Female', 'catherine.kim@example.com', 'Seoul, South Korea', '+82-2-1234-5678', 'PhD in Sociology', '11', 'Research published in top sociology journal'),
('12567890', 'giangvien2', '1980-05-12', 'Male', 'giangvien2@vnu.edu.vn', 'Hai Phong', '0987654321', 'tiến sĩ', '8', 'được vinh danh là nhà giáo dạy giỏi năm 2022'),
('12678901', 'giangvien3', '1978-09-20', 'Male', 'giangvien3@vnu.edu.vn', 'Nam Dinh', '0765432109', 'giáo sư', '15', 'đạt giải nhất hội thi giải toán trên Internet'),
('12789012', 'giangvien4', '1985-11-05', 'Female', 'giangvien4@vnu.edu.vn', 'Ninh Binh', '0369852147', 'thạc sĩ', '6', 'được tuyển chọn đại diện cho Việt Nam tham gia hội nghị khoa học quốc tế tại Mỹ'),
('12890123', 'giangvien5', '1983-08-22', 'Male', 'giangvien5@vnu.edu.vn', 'Bac Ninh', '0198765432', 'tiến sĩ', '10', 'có nhiều bài báo công bố trên các tạp chí uy tín trong lĩnh vực máy học'),
('12901234', 'giangvien6', '1976-02-01', 'Female', 'giangvien6@vnu.edu.vn', 'Thai Nguyen', '0987654321', 'giáo sư', '20', 'được bổ nhiệm làm chuyên gia tư vấn cho một công ty lớn trong lĩnh vực kinh tế'),
('13012345', 'giangvien7', '1982-07-14', 'Male', 'giangvien7@vnu.edu.vn', 'Ha Giang', '0369852147', 'thạc sĩ', '5', 'được tuyển chọn làm giảng viên cho một trường đại học hàng đầu tại Singapore'),
('13123456', 'giangvien8', '1979-01-30', 'Female', 'giangvien8@vnu.edu.vn', 'Tuyen Quang', '0123456789', 'tiến sĩ', '12', 'được vinh danh là giáo viên xuất sắc trong công tác giảng dạy năm học 2020-2021'),
('13234567', 'giangvien9', '1981-06-23', 'Male', 'giangvien9@vnu.edu.vn', 'Vinh Phuc', '0987654321', 'giáo sư', '25', 'đạt giải nhất cuộc thi \"Đi tìm người dạy giỏi'),
('12456712', 'giangvien10', '1980-03-15', 'Male', 'gianttte@vnu.edu.vn', 'Ho Chi Minh', '0987654321', 'tiến sĩ', '12', 'nhận giải bạc Cuộc thi toán học châu Á 2020'),
('12456345', 'Trần Hoàng Việt', '1979-11-28', 'Male', 'giagdfdn3@vnu.edu.vn', 'Ha Noi', '0912345678', 'tiến sĩ', '10', 'công bố 3 bài báo quốc tế về khoa học máy tính'),
('12456789', 'Nguyễn Quang Vinh', '1985-06-03', 'Female', 'gigfđf4@vnu.edu.vn', 'Da Nang', '0934567891', 'tiến sĩ', '8', 'có kinh nghiệm giảng dạy tại đại học Yale trong 2 năm'),
('12456123', 'Nguyễn Huy Sơn', '1982-12-21', 'Male', 'geqdáen51@vnu.edu.vn', 'Ho Chi Minh', '0978123456', 'tiến sĩ', '15', 'nhận giải thưởng Giáo sư trẻ tiêu biểu của năm 2019'),
('12456784', 'Lương Định Của', '1977-05-01', 'Female', 'giangvien36@vnu.edu.vn', 'Ha Noi', '0987123456', 'thạc sĩ', '6', 'được tuyển chọn làm thành viên trong đội tuyển Olympic Toán học quốc gia'),
('12456321', 'Vũ Văn Bằng', '1983-02-14', 'Female', 'riti57@vnu.edu.vn', 'Da Nang', '0909123456', 'thạc sĩ', '3', 'có bài báo được đăng trên tạp chí khoa học Nature'),
('12456890', 'Dương Thành Nghĩa', '1984-08-08', 'Male', 'akan8@vnu.edu.vn', 'Ho Chi Minh', '0976123456', 'tiến sĩ', '13', 'nhận giải thưởng ở Cuộc thi Vật lý châu Á 2018'),
('12456456', 'Đại Nam Hos', '1981-04-01', 'Female', 'gnikovien91@vnu.edu.vn', 'Ha Noi', '0988123456', 'thạc sĩ', '7', 'có kinh nghiệm làm việc trong ngành CNTT tại Silicon Valley trong 5 năm'),
('12456781', 'Trần Trúc Mai', '1978-10-10', 'Male', 'gqgaien12@vnu.edu.vn', 'Da Nang', '0989123456', 'tiến sĩ', '9', 'được chọn làm giảng viên tại Đại học Stanford');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`course_id`,`student_id`),
  ADD KEY `fk_student_course` (`student_id`);

--
-- Chỉ mục cho bảng `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD KEY `classObj` (`classObj`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `fk_student_course` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
