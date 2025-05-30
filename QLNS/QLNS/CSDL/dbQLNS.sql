USE [master]
GO 

CREATE DATABASE [dbQLNS]
 CONTAINMENT = NONE
 ON  PRIMARY 

( NAME = N'dbQLNS', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\dbQLNS.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 

( NAME = N'dbQLNS_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\dbQLNS_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [dbQLNS] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [dbQLNS].[dbo].[sp_fulltext_database] @action =N'enable'
end
GO
ALTER DATABASE [dbQLNS] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [dbQLNS] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [dbQLNS] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [dbQLNS] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [dbQLNS] SET ARITHABORT OFF 
GO
ALTER DATABASE [dbQLNS] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [dbQLNS] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [dbQLNS] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [dbQLNS] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [dbQLNS] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [dbQLNS] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [dbQLNS] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [dbQLNS] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [dbQLNS] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [dbQLNS] SET  DISABLE_BROKER 
GO
ALTER DATABASE [dbQLNS] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [dbQLNS] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [dbQLNS] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [dbQLNS] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [dbQLNS] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [dbQLNS] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [dbQLNS] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [dbQLNS] SET RECOVERY FULL 
GO
ALTER DATABASE [dbQLNS] SET  MULTI_USER 
GO
ALTER DATABASE [dbQLNS] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [dbQLNS] SET DB_CHAINING OFF 
GO
ALTER DATABASE [dbQLNS] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [dbQLNS] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [dbQLNS] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'dbQLNS', N'ON'
GO
ALTER DATABASE [dbQLNS] SET QUERY_STORE = OFF
GO
USE [dbQLNS]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [dbQLNS]
GO
/****** Object:  Table [dbo].[CHUCVU]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET DATEFORMAT dmy
CREATE TABLE [dbo].[CHUCVU](
	[MaCV] [nvarchar](50) NOT NULL,
	[ChucVu] [nvarchar](250) NULL,
	[DinhDoanh] [nvarchar](250) NULL,
 CONSTRAINT [PK_CHUCVU] PRIMARY KEY CLUSTERED 
(
	[MaCV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTHD]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTHD](
	[MaHD] [nvarchar](50) NOT NULL,
	[MaSP] [nvarchar](50) NOT NULL,
	[DonGia] [money] NULL,
	[SoLuong] [int] NULL,
	[ThanhTien] [money] NULL,
 CONSTRAINT [PK_CTHD] PRIMARY KEY CLUSTERED 
(
	[MaHD],[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOADON]     ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOADON](
	[MaHD] [nvarchar](50) NOT NULL,
	[MaNV] [nvarchar](50) NULL,
	[MaKH] [nvarchar](50) NULL,
	[NgayLap] [date] NULL,
	[TongTien] [money] NULL,
	[ThanhCong] [int] NULL,
	[NhapSach] [int] DEFAULT 0,
 CONSTRAINT [PK_HOADON] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHANVIEN]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHANVIEN](
	[MaNV] [nvarchar](50) NOT NULL,
	[TenNV] [nvarchar](250) NULL,
	[NgaySinh] [date] NULL,
	[NgayVaoLam] [date] NULL,
	[SoChungMinh] [nvarchar](50) NULL,
	[MaCV] [nvarchar](50) NULL,
	[SDT] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[Luong] [money] NULL
 CONSTRAINT [PK_NHANVIEN] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NXB]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NXB](
	[MaNXB] [nvarchar](50) NOT NULL,
	[TenNXB] [nvarchar](250) NULL,
	[SDT] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
 CONSTRAINT [PK_NXB] PRIMARY KEY CLUSTERED 
(
	[MaNXB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SACH]   ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SACH](
	[MaSach] [nvarchar](50) NOT NULL,
	[TenSach] [nvarchar](250) NULL,
	[MaNXB] [nvarchar](50) NULL,
	[TacGia] [nvarchar](250) NULL,
	[GiaBan] [money] NULL,
	[TheLoai] [nvarchar](150) NULL,
	[SoLuong] [int] NULL,
	[Discount] [int] NULL,
 CONSTRAINT [PK_SACH] PRIMARY KEY CLUSTERED 
(
	[MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[DANHMUC](
	[MaSach] [nvarchar](50) NOT NULL,
	[TenSach] [nvarchar](250) NULL,
	[MaNXB] [nvarchar](50) NULL,
	[TacGia] [nvarchar](250) NULL,
	[TheLoai] [nvarchar](150) NULL,
	[SoLuong] [int] NULL,
 CONSTRAINT [PK_DANHMUC] PRIMARY KEY CLUSTERED 
(
	[MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NCC_VPP]     ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NCCVPP](
	[MaNCCVPP] [nvarchar](50) NOT NULL,
	[TenNCCVPP] [nvarchar](250) NULL,
	[SDT] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
 CONSTRAINT [PK_NCCVPP] PRIMARY KEY CLUSTERED 
(
	[MaNCCVPP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VPP]     ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VPP](
	[MaVPP] [nvarchar](50) NOT NULL,
	[TenVPP] [nvarchar](250) NULL,
	[MaNCCVPP] [nvarchar](50) NULL,
	[GiaBanVPP] [money] NULL,
	[DanhMuc] [nvarchar](150) NULL,
	[SoLuong] [int] NULL,
	[Discount] [int] NULL,
 CONSTRAINT [PK_VPP] PRIMARY KEY CLUSTERED 
(
	[MaVPP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

/****** Object:  Table [dbo].[TAIKHOAN]   ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO 
CREATE TABLE [dbo].[TAIKHOAN](
	[MaTk] [nvarchar](50) NOT NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[MaNV] [nvarchar](50) NULL,
	[BaoCao] [TINYINT] DEFAULT 0,
	[TaiKhoan] [TINYINT] DEFAULT 0,
	[MaVach] [TINYINT] DEFAULT 0,
	[Sach] [TINYINT] DEFAULT 0,
	[NXB] [TINYINT] DEFAULT 0,
	[NHanVien] [TINYINT] DEFAULT 0,
	[HoaDon] [TINYINT] DEFAULT 0,
	[NCCVPP] [TINYINT] DEFAULT 0,
	[VPP] [TINYINT] DEFAULT 0,
	[KhachHang] [TINYINT] DEFAULT 0,
 CONSTRAINT [PK_TAIKHOAN] PRIMARY KEY CLUSTERED 
(
	[MaTk] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TONKHO](
	[MaTK] [nvarchar](50) NOT NULL,
	[MaSP] [nvarchar](50) NOT NULL,
	[TonDau] [nvarchar](50) NULL,
	[Nhap] [int] NULL,
	[Xuat] [int] NULL,
	[TonCuoi] [nvarchar](50) NULL,
	[Thang] [int] NULL,
	[Nam] [int] NULL,
 CONSTRAINT [PK_TONKHO] PRIMARY KEY CLUSTERED 
(
	[MaTK],[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
CREATE TABLE [dbo].KHACHHANG(
	[MaKH] [nvarchar](50) NOT NULL,
	[TenKH] [nvarchar](50) NOT NULL,
	[Sdt] [nvarchar](50) NULL,
	[Diem] [money] NULL,
 CONSTRAINT [PK_KHACHHANG] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[NXB] ([MaNXB], [TenNXB], [SDT], [DiaChi], [Email]) VALUES (N'nxb01', N'HVCNBCVT', N'0997852545', N'Hà Nội', N'ptit@gmal.com')
INSERT [dbo].[NXB] ([MaNXB], [TenNXB], [SDT], [DiaChi], [Email]) VALUES (N'nxb02', N'Kim Đồng', N'0197816153', N'TP HCm', N'kimdong@gmail.com')
INSERT [dbo].[NXB] ([MaNXB], [TenNXB], [SDT], [DiaChi], [Email]) VALUES (N'nxb03', N'Dương Văn Quân', N'0334055295', N'Hà Nội', N'quandv@gmail.com') --thêm
INSERT [dbo].[NXB] ([MaNXB], [TenNXB], [SDT], [DiaChi], [Email]) VALUES (N'nxb04', N'Hà Minh Quang', N'03839316289', N'TP HCM', N'quanghm@gmail.com') --thêm
INSERT [dbo].[NXB] ([MaNXB], [TenNXB], [SDT], [DiaChi], [Email]) VALUES (N'nxb05', N'Nguyễn Thị Thu Quyên', N'03438222135', N'Hà Nội', N'quyenntt@gmail.com') --thêm
INSERT [dbo].[NXB] ([MaNXB], [TenNXB], [SDT], [DiaChi], [Email]) VALUES (N'nxb06', N'Nguyễn Tiến Đạt', N'03438221581', N'Hà Nội', N'datnt@gmail.com') --thêm
INSERT [dbo].[NXB] ([MaNXB], [TenNXB], [SDT], [DiaChi], [Email]) VALUES (N'nxb07', N'PTIT', N'02439710717', N'Hà Nội', N'ptitHN@stu.edu.vn') --thêm


INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's01', N'SQL server', N'nxb01', N'Nguyễn Hữu Cầm', 150000.0000, N'Giáo trình', 49, 50.0)
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's02', N'OOP', N'nxb02', N'Quân', 200000.0000, N'Giáo trình', 49, 5)
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's03', N'java', N'nxb01', N'CamNH', 200000.0000, N'Giáo trình', 49, 10)
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's04', N'Truyện cười', N'nxb02', N'Quang', 120000.0000, N'Truyện', 19, 0)
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's05', N'UML', N'nxb01', N'Đạt', 250000.0000, N'Giáo trình', 99, 15)
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's06', N'English', N'nxb02', N'PTITER', 130000.0000, N'Ngoại Ngữ', 9, 10)
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's07', N'Cẩm nang làm đẹp', N'nxb03', N'Thu Quyên', 111200.0000, N'Tự sự', 9, 10) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's08', N'Quỷ nhập tràng', N'nxb03', N'Pom Nguyễn', 151200.0000, N'Truyện phim', 59, 10) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's09', N'TOEIC', N'nxb03',  N'PTIT', 156000.0000, N'English', 50, 10) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's10', N'Thần Số Học Ứng Dụng',  N'nxb03', N'Joy Woodward', 103200.0000, N'Tự sự', 40, 10) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's11', N'Thao Túng Ký Ức', N'nxb03',  N'Tiến sĩ Julia Shaw', 143200.0000, N'Tự sự', 30, 10) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's12', N'Tuồng hát cải lương Khảo & luận - 10 năm bổn tuồng đề yếu (1922-1931)', N'nxb03',  N'Nguyễn Phúc An', 224000.0000, N'Tự sự', 20, 10) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's13', N'Vấn vương hương vị bánh quê', N'nxb03',  N'Trần Minh Thương', 72000.0000, N'Tự sự', 15, 10) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's14', N'Chuyện vui thời kháng chiến ở Đất Thép', N'nxb03',  N'Đặng Đức Thưởng', 64000.0000, N'Tự sự', 13, 10) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's15', N'Bổn cũ soạn lại 3 - Những bài học thuộc lòng Tân Quốc Văn Giáo Khoa Thư (Thích hợp cho lứa tuổi các lớp Trung - Tiểu học)', N'nxb03',  N'Trần Văn Chánh', 132000.0000, N'Tự sự', 16, 10) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's16', N'Thương những miền qua', N'nxb03',  N'Nguyễn Thị Hậu', 84000.0000, N'Tự sự', 20, 10) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's17', N'VÕ VĂN KIỆT TRĂM NĂM TRONG MỘT CHỮ DÂN', N'nxb03',  N'Nhiều tác giả', 112000.0000, N'Tự sự', 20, 20) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's18', N'Hồ Chí Minh: Đổi mới - Hội nhập - Phát triển', N'nxb03',  N'PGS. TS. Bùi Đình Phong', 144000.0000, N'Tự sự', 25, 20) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's19', N'Những con chữ ngoài trang sách', N'nxb03',  N'Trần Đình Ba', 132000.0000, N'Tự sự', 15, 20) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's20', N'Di Chúc Của Chủ Tịch Hồ Chí Minh (VHVN)', N'nxb03',  N'Chủ tịch Hồ Chí Minh', 24000.0000, N'Tự sự', 18, 20) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's21', N'Đảng Cho Ta Mùa Xuân', N'nxb03',  N'Võ Trường Sơn', 32000.0000, N'Tự sự', 37, 20) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's22', N'Danh nhân khoa học & lược sử khoa học thế giới (Quyển 1 từ thời cổ đại đến cuối thế kỷ thứ 18) SLK', N'nxb03',  N'Lâm Thành Mỹ', 136000.0000, N'Tự sự', 27, 20) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's23', N'Quân sư & những "vụ án"', N'nxb03',  N'Lê Đắc Hoàng Hựu', 60000.0000, N'Tự sự', 27, 20) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's24', N'CHUYỆN LÀNG TRÊN MẠNG', N'nxb03', N'Phạm Ngọc Hiền', 48000.0000, N'Tự sự', 21, 20) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's25', N'NGANG QUA VƯỜN CÂY DẦU', N'nxb03', N'Nguyễn Thiện Bản', 84000.0000,  N'Tự sự', 21, 20) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's26', N'Sống đẹp là sống đạo', N'nxb03', N'Huệ Khải', 76000.0000,  N'Tự sự', 10, 20) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's27', N'Tôi học Phật', N'nxb03', N'BS. Đỗ Hồng Ngọc', 320000.0000,  N'Tự sự', 17, 20) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's28', N'Dĩ bất biến - Ứng vạn biến', N'nxb03', N'Lê Hưng VKD', 72000.0000,  N'Tự sự', 27, 20) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's29', N'Bảo vệ môi trường qua góc nhìn của tôn giáo và triết học', N'nxb03', N'Thích Nhuận Đạt', 100000.0000,  N'Tự sự',57, 20) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's30', N'THẾ GIỚI CỦA PEPPA - THƯ VIỆN', N'nxb02',N'Nhiều tác giả', 21000.0000,  N'Truyện tranh',38, 30) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's31', N'THẾ GIỚI CỦA PEPPA - NHỮNG CON SỐ', N'nxb02',N'Nhiều tác giả', 21000.0000,  N'Truyện tranh',38, 30) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's32', N'THẾ GIỚI CỦA PEPPA - TỦ ĐỒ CHƠI', N'nxb02',N'Nhiều tác giả', 21000.0000,  N'Truyện tranh',29, 30) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's33', N'THẾ GIỚI CỦA PEPPA - NÀNG TIÊN RĂNG', N'nxb02',N'Nhiều tác giả', 21000.0000,  N'Truyện tranh',19, 30) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's34', N'BOXSET CÁ VOI ĐÊM BÃO VÀ NHỮNG CÂU CHUYỆN KHÁC (4 QUYỂN)', N'nxb02',N'Benji Davies', 140000.0000,  N'Truyện tranh',39, 30) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's35', N'365 NGÀY KỂ CHUYỆN', N'nxb02',N'Benji Davies', 175000.0000,  N'Truyện tranh',49, 30) --
INSERT [dbo].[SACH] ([MaSach], [TenSach], [MaNXB], [TacGia], [GiaBan], [TheLoai], [SoLuong], [Discount]) VALUES (N's36', N'THIỆN VÀ ÁC VÀ CỔ TÍCH', N'nxb02',N'Thủy Nguyên', 149000.0000,  N'Truyện tranh',21, 30) --


INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD01',N'NV01', N'kh01', N'01/01/2025', 7500000.0000, 1, 1)
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD02',N'NV01', N'kh02', N'01/01/2025', 150000.0000,1, 0)
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD03',N'NV01', N'kh03', N'01/02/2025', 10000000.0000,1, 1)
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD04',N'NV01', N'kh04', N'01/02/2025', 200000.0000, 1, 0)
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD05',N'NV01', N'kh05', N'01/03/2025', 10000000.0000, 1, 1)
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD06',N'NV01', N'kh06', N'01/03/2025', 200000.0000, 1, 0)
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD07',N'NV01', N'kh03', N'01/04/2025', 2400000.0000, 1, 1)
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD08',N'NV01', N'kh02', N'01/04/2025', 120000.0000, 1, 0)
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD09',N'NV01', N'kh04', N'01/04/2025', 25000000.0000, 1, 1)
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD10',N'NV01', N'kh05', N'01/04/2025', 250000.0000, 1, 0)
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD11',N'NV01', N'kh07', N'01/04/2025', 1300000.0000, 1, 1)
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD12',N'NV01', N'kh05', N'01/04/2025', 130000.0000, 1, 0)
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD13',N'NV01', N'kh05', N'01/04/2025', 130000.0000, 1, 0)--
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD14',N'NV01', N'kh05', N'01/04/2025', 130000.0000, 1, 0)--
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD15',N'NV01', N'kh05', N'01/04/2025', 130000.0000, 1, 0)--
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD16',N'NV01', N'kh05', N'01/05/2025', 130000.0000, 1, 0)--
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD17',N'NV01', N'kh05', N'01/05/2025', 130000.0000, 1, 0)--
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD18',N'NV01', N'kh05', N'01/05/2025', 130000.0000, 1, 0)--
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD19',N'NV01', N'kh05', N'01/05/2025', 130000.0000, 1, 0)--
INSERT [dbo].[HOADON] ([MaHD], [MaNV], [MaKH], [NgayLap], [TongTien], [ThanhCong], [NhapSach]) VALUES ('HD20',N'NV01', N'kh05', N'01/05/2025', 130000.0000, 1, 0)--

INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD01', N's01', 150000.0000, 50, 7500000.0000)
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD02', N's01', 150000.0000, 1, 150000.0000)
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD03', N's02', 200000.0000, 50, 10000000.0000)
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD04', N's02', 120000.0000, 1, 200000.0000)
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD05', N's03', 250000.0000, 50, 10000000.0000)
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD06', N's03', 130000.0000, 1, 200000.0000)
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD07', N's04', 150000.0000, 20, 2400000.0000)
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD08', N's04', 200000.0000, 1, 120000.0000)
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD09', N's05', 200000.0000, 100, 25000000.0000)
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD10', N's05', 120000.0000, 1, 250000.0000)
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD11', N's06', 250000.0000, 10, 1300000.0000)
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD12', N's06', 130000.0000, 1, 130000.0000)
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD13', N's06', 130000.0000, 1, 130000.0000)	--
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD14', N's06', 130000.0000, 1, 130000.0000)	--
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD15', N's06', 130000.0000, 1, 130000.0000)	--
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD16', N's06', 130000.0000, 1, 130000.0000)	--
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD17', N's06', 130000.0000, 1, 130000.0000)	--
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD18', N's06', 130000.0000, 1, 130000.0000)	--
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD19', N's06', 130000.0000, 1, 130000.0000)	--
INSERT [dbo].[CTHD] ([MaHD], [MaSP], [DonGia], [SoLuong], [ThanhTien]) VALUES ('HD20', N's06', 130000.0000, 1, 130000.0000)	--

INSERT [dbo].[TAIKHOAN] ([MaTk], [username], [password], [MaNV], [BaoCao], [TaiKhoan], [MaVach], [Sach], [NXB], [NhanVien], [HoaDon], [NCCVPP], [VPP], [KhachHang]) VALUES (N'tk01', N'admin', N'admin',N'NV01', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
INSERT [dbo].[TAIKHOAN] ([MaTk], [username], [password], [MaNV], [BaoCao], [TaiKhoan], [MaVach], [Sach], [NXB], [NhanVien], [HoaDon], [NCCVPP], [VPP], [KhachHang]) VALUES (N'tk02', N'thungan', N'thungan',N'NV02', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)


INSERT [dbo].CHUCVU ([MaCV], [ChucVu], [DinhDoanh]) VALUES ('CV01', N'Admin', N'Quản lý hệ thống')
INSERT [dbo].CHUCVU ([MaCV], [ChucVu], [DinhDoanh]) VALUES ('CV02', N'Thu ngân', N'Thanh toán hóa đơn cho khách')
INSERT [dbo].CHUCVU ([MaCV], [ChucVu], [DinhDoanh]) VALUES ('CV03', N'Nhân viên mua hàng', N'Lên kế hoạch mua các đầu sách, dụng cụ,...')
INSERT [dbo].CHUCVU ([MaCV], [ChucVu], [DinhDoanh]) VALUES ('CV04', N'Nhân viên IT', N'Sửa chữa, quản lý, hỗ trợ kỹ thuật')
INSERT [dbo].CHUCVU ([MaCV], [ChucVu], [DinhDoanh]) VALUES ('CV05', N'Nhân viên kho', N'Quản lý kho')
INSERT [dbo].CHUCVU ([MaCV], [ChucVu], [DinhDoanh]) VALUES ('CV06', N'Nhân viên an ninh', N'Bảo đảm an ninh')
INSERT [dbo].CHUCVU ([MaCV], [ChucVu], [DinhDoanh]) VALUES ('CV07', N'Nhân viên kế toán', N'Chịu trách nhiệm về các vấn đề liên quan đến tài chính, dòng tiền')

INSERT [dbo].[NHANVIEN]([MaNV], [TenNV], [NgaySinh], [NgayVaoLam], [SoChungMinh],[MaCV], [SDT], [Email], [Luong]) VALUES (N'NV01',N'Dương Văn Quân',N'1/1/2003',N'10/2/2025' ,N'012356789',N'CV01',N'012356789',N'quandv@gmail.com', 10000000.000)
INSERT [dbo].[NHANVIEN]([MaNV], [TenNV], [NgaySinh], [NgayVaoLam], [SoChungMinh],[MaCV], [SDT], [Email], [Luong]) VALUES (N'NV02',N'Nguyễn Tiến Đạt',N'1/2/2003',N'21/1/2025' ,N'012356789',N'CV02',N'012356789',N'datnt@gmai.com', 10000000.000)
INSERT [dbo].[NHANVIEN]([MaNV], [TenNV], [NgaySinh], [NgayVaoLam], [SoChungMinh],[MaCV], [SDT], [Email], [Luong]) VALUES (N'NV03',N'Nguyễn Thị Thu Quyên',N'1/3/2003',N'31/12/2024' ,N'012356789',N'CV03',N'012356789',N'quyenntt@gmai.com', 10000000.000)
INSERT [dbo].[NHANVIEN]([MaNV], [TenNV], [NgaySinh], [NgayVaoLam], [SoChungMinh],[MaCV], [SDT], [Email], [Luong]) VALUES (N'NV04',N'Hà Minh Quang',N'1/4/2003',N'20/01/2025' ,N'012356789',N'CV04',N'012356789',N'quanghm@gmai.com', 10000000.000)
INSERT [dbo].[NHANVIEN]([MaNV], [TenNV], [NgaySinh], [NgayVaoLam], [SoChungMinh],[MaCV], [SDT], [Email], [Luong]) VALUES (N'NV05',N'Nguyên Văn E',N'1/5/2003',N'11/08/2024' ,N'012356789',N'CV05',N'012356789',N'enguyenvan@gmai.com', 10000000.000)
INSERT [dbo].[NHANVIEN]([MaNV], [TenNV], [NgaySinh], [NgayVaoLam], [SoChungMinh],[MaCV], [SDT], [Email], [Luong]) VALUES (N'NV06',N'Nguyên Văn F',N'1/6/2003',N'01/03/2024' ,N'012356789',N'CV06',N'012356789',N'fnguyenvan@gmai.com', 10000000.000)
INSERT [dbo].[NHANVIEN]([MaNV], [TenNV], [NgaySinh], [NgayVaoLam], [SoChungMinh],[MaCV], [SDT], [Email], [Luong]) VALUES (N'NV07',N'Nguyên Văn G',N'1/7/2003',N'22/12/2025' ,N'012356789',N'CV07',N'012356789',N'gnguyenvan@gmai.com', 10000000.000)
INSERT [dbo].[NHANVIEN]([MaNV], [TenNV], [NgaySinh], [NgayVaoLam], [SoChungMinh],[MaCV], [SDT], [Email], [Luong]) VALUES (N'NV08',N'Nguyên Văn H',N'1/8/2003',N'23/11/2024' ,N'012356789',N'CV02',N'012356789',N'hnguyenvan@gmai.com', 10000000.000)
INSERT [dbo].[NHANVIEN]([MaNV], [TenNV], [NgaySinh], [NgayVaoLam], [SoChungMinh],[MaCV], [SDT], [Email], [Luong]) VALUES (N'NV09',N'Nguyên Văn J',N'1/9/2003',N'24/02/2025' ,N'012356789',N'CV03',N'012356789',N'jnguyenvan@gmai.com', 10000000.000)

INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK01', N's01', 0, 50, 1, 49, 1, 2024)

INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK02', N's01', 49, 0, 0, 49, 2, 2025)
INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK03', N's02', 0, 50, 1, 49, 2, 2025)

INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK04', N's01', 49, 0, 0, 49, 3, 2025)
INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK05', N's02', 49, 0, 0, 49, 3, 2025)
INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK06', N's03', 0, 50, 1, 49, 3, 2025)

INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK07', N's01', 49, 0, 0, 49, 4, 2024)
INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK08', N's02', 49, 0, 0, 49, 4, 2024)
INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK09', N's03', 49, 0, 0, 49, 4, 2024)
INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK10', N's04', 0, 20, 1, 19, 4, 2025)
INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK11', N's05', 0, 100, 1, 99, 4, 2024)
INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK12', N's06', 0, 10, 1, 9, 4, 2025)

INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK13', N's07', 0, 50, 1, 49, 1, 2025)

INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK14', N's07', 49, 0, 0, 49, 2, 2025)
INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK15', N's08', 0, 50, 1, 49, 2, 2025)

INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK16', N's07', 49, 0, 0, 49, 3, 2025)
INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK17', N's08', 49, 0, 0, 49, 3, 2025)
INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK18', N's09', 0, 50, 1, 49, 3, 2025)

INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK19', N's07', 49, 0, 0, 49, 4, 2025)
INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK20', N's08', 49, 0, 0, 49, 4, 2025)
INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK21', N's09', 49, 0, 0, 49, 4, 2025)
INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK22', N's10', 0, 20, 1, 19, 4, 2025)
INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK23', N's11', 0, 100, 1, 99, 4, 2025)
INSERT [dbo].[TONKHO]([MaTK], [MaSP], [TonDau], [Nhap], [Xuat], [TonCuoi], [Thang], [Nam]) VALUES (N'TK24', N's12', 0, 10, 1, 9, 4, 2025)


INSERT [dbo].[NCCVPP] ([MaNCCVPP], [TenNCCVPP], [SDT], [DiaChi], [Email]) VALUES (N'ncc01', N'Thiên Long', N'1900 866 819', N'Tp HCM', N'salesonline@thienlongvn.com')
INSERT [dbo].[NCCVPP] ([MaNCCVPP], [TenNCCVPP], [SDT], [DiaChi], [Email]) VALUES (N'ncc02', N'Huyền Anh', N'0903317294', N'Tp HCM', N'vpphuyenanh2020@gmail.com')
INSERT [dbo].[NCCVPP] ([MaNCCVPP], [TenNCCVPP], [SDT], [DiaChi], [Email]) VALUES (N'ncc03', N'Group 9', N'0899189499', N'Tp HCM', N'group9@gmail.com')
INSERT [dbo].[NCCVPP] ([MaNCCVPP], [TenNCCVPP], [SDT], [DiaChi], [Email]) VALUES (N'ncc04', N'Hoàng Hà', N'02838473239', N'Tp HCM', N'vpphoangha48@gmail.com')


INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v01', N'Bút bi Thiên Long TL027 - xanh', N'ncc01', 5000.0000, N'Bút', 15, 10)
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v02', N'BÌA GIẤY MÀU A4 180 GSM', N'ncc02', 50000.0000, N'Bìa giấy', 10, 5)
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v03', N'Giấy A4 Uni Plus 80 gsm màng co', N'ncc03', 76000.0000, N'Giấy A4', 10, 10)
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v04', N'Giấy A4 Uni Plus 72 gsm màng co', N'ncc03', 69000.0000, N'Giấy A4', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v05', N'Giấy A4 Excel 70 gsm', N'ncc03', 54000.0000, N'Giấy A4', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v06', N'Giấy A4 Viva 70 gsm', N'ncc03', 67000.0000, N'Giấy A4', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v07', N'Giấy A4 Nano 68 gsm', N'ncc03', 64000.0000, N'Giấy A4', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v08', N'Giấy A4 Delight 70 gsm', N'ncc03', 66000.0000, N'Giấy A4', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v09', N'Giấy A4 PaperOne 70 gsm', N'ncc03', 73000.0000, N'Giấy A4', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v10', N'Giấy A4 PaperOne 80 gsm', N'ncc03', 85000.0000, N'Giấy A4', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v11', N'Giấy A4 PaperOne 100 gsm', N'ncc03', 114000.0000, N'Giấy A4', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v12', N'Giấy A4 Quality 70 gsm', N'ncc03', 68000.0000, N'Giấy A4', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v13', N'Giấy A4 IK Plus 70 gsm', N'ncc03', 114000.0000, N'Giấy A4', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v14', N'Giấy A4 Thái Lan màu 80 gsm', N'ncc03', 70000.0000, N'Giấy A4', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v15', N'Bút chì chuốt Staedtler 134', N'ncc03', 3300.0000, N'Bút chì', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v16', N'Bút chì chuốt Gstar P333 3B', N'ncc03', 2000.0000, N'Bút chì', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v17', N'Bút chì bấm Pentel AX105', N'ncc03', 7700.0000, N'Bút chì', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v18', N'Bút chì chuốt Tiệp Khắc KOH 2B,4B,6B', N'ncc03', 2400.0000, N'Bút chì', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v19', N'Bút chì xé Gstar 7600B', N'ncc03', 5100.0000, N'Bút chì', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v20', N'Chuốt chì Thiên Long S-01', N'ncc03', 2700.0000, N'Chuốt bút chì', 10, 10)--	
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v21', N'Ruột chì 2B Yoyo', N'ncc03', 3000.0000, N'Ruột bút chì', 10, 10)--	
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v22', N'Kim bấm số 3 Việt Đức', N'ncc03', 8000.0000, N'Kim bấm', 10, 10)--	
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v23', N'Bấm lỗ 9670', N'ncc03', 232000.0000, N'Bấm lỗ', 10, 10)--	
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v24', N'Máy bấm giá Hongsheng MX-5500EOS - có nắp', N'ncc03', 68000.0000, N'Máy bấm giá', 10, 10)--	
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v25', N'Kẹp nhựa màu C62', N'ncc03', 1500.0000, N'Kẹp nhựa', 10, 10)--	
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v26', N'Hộp đựng kim kẹp Deli nam châm 9881', N'ncc03', 22000.0000, N'Hộp đựng kim kẹp', 10, 10)--	
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v27', N'Ruột chì 2B Yoyo', N'ncc03', 3000.0000, N'Ruột bút chì', 10, 10)--	
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v28', N'Kẹp giấy C82', N'ncc03', 4800.0000, N'Kẹp giấy', 10, 10)--	
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v29', N'Bấm kim số 10 SDI', N'ncc03', 24400.0000, N'Bấm kim số', 10, 10)--	
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v30', N'Bấm kim nhựa số 10 Gstar 910', N'ncc03', 22100.0000, N'Bấm kim số', 10, 10)--	
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v31', N'Bấm kim số 10 KW.Trio 5270 chính hãng', N'ncc03', 27600.0000, N'Bấm kim số', 10, 10)--	
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v32', N'Bấm kim số 10 KW.Trio Pollex 5106 chính hãng', N'ncc03', 36100.0000, N'Bấm kim số', 10, 10)--	
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v33', N'Bấm kim số 10 Plus', N'ncc03', 35600.0000, N'Bấm kim số', 10, 10)--	
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v34', N'BÚT BI TL-095', N'ncc01', 8000.0000, N'Bút bi', 10, 20)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v35', N'BÚT BI TL-093', N'ncc01', 9000.0000, N'Bút bi', 10, 20)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v36', N'BÚT BI TL-048', N'ncc01', 8000.0000, N'Bút bi', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v37', N'BÚT BI TL-049', N'ncc01', 9000.0000, N'Bút bi', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v38', N'MỰC BÚT LÔNG BẢNG WBI-01', N'ncc01', 15000.0000, N'Bút lông bảng', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v39', N'BÚT LÔNG BẢNG WB-03', N'ncc01', 10000.0000, N'Bút lông bảng', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v40', N'BÚT LÔNG BẢNG WB-02', N'ncc01', 11000.0000, N'Bút lông bảng', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v41', N'BÚT DẠ QUANG HL-012', N'ncc01', 9000.0000, N'Bút dạ quang', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v42', N'BÚT DẠ QUANG HL-07', N'ncc01', 18000.0000, N'Bút bi', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v43', N'BÚT DẠ QUANG HL-03', N'ncc01', 1700.0000, N'Bút bi', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v44', N'BÚT LÔNG KIM FL-04', N'ncc01', 91000.0000, N'Bút lông kim', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v45', N'THƯỚC THẲNG SR-031', N'ncc01', 85000.0000, N'Thước thẳng', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v46', N'THƯỚC THẲNG SR-026', N'ncc01', 12000.0000, N'Thước thẳng', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v47', N'THƯỚC THẲNG SR-024', N'ncc01', 34000.0000, N'Thước thẳng', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v48', N'THƯỚC THẲNG SR-02', N'ncc01', 16000.0000, N'Thước thẳng', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v49', N'THƯỚC THẲNG SR-03', N'ncc01', 16000.0000, N'Thước thẳng', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v50', N'BÚT XÓA CP-06', N'ncc01', 27999.0000, N'Bút xoá', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v51', N'BÚT XÓA CP-05', N'ncc01', 20000.0000, N'Bút xoá', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v52', N'BÚT XÓA CP-02', N'ncc01', 22000.0000, N'Bút xoá', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v53', N'COMPA C-018', N'ncc01', 16000.0000, N'Compa', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v54', N'COMPA C-017', N'ncc01', 16000.0000, N'Compa', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v55', N'COMPA C-016', N'ncc01', 16000.0000, N'Compa', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v56', N'COMPA Y C-020', N'ncc01', 16000.0000, N'Compa', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v57', N'COMPA C-014', N'ncc01', 16000.0000, N'Compa', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v58', N'COMPA C-011', N'ncc01', 16000.0000, N'Compa', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v59', N'COMPA C-09', N'ncc01', 16000.0000, N'Compa', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v60', N'COMPA C-08', N'ncc01', 16000.0000, N'Compa', 10, 10)--
INSERT [dbo].[VPP] ([MaVPP], [TenVPP], [MaNCCVPP], [GiaBanVPP], [DanhMuc], [SoLuong], [Discount]) VALUES (N'v61', N'COMPA C-02', N'ncc01', 16000.0000, N'Compa', 10, 10)--


INSERT [dbo].[KHACHHANG] ([MaKH], [TenKH], [Sdt], [Diem]) VALUES (N'kh01', N'Nguyễn Tiến Đạt', N'0933754987', 21300.000)
INSERT [dbo].[KHACHHANG] ([MaKH], [TenKH], [Sdt], [Diem]) VALUES (N'kh02', N'Nguyễn Thị Thu Quyên', N'0123456789', 11100.000)
INSERT [dbo].[KHACHHANG] ([MaKH], [TenKH], [Sdt], [Diem]) VALUES (N'kh03', N'Hà Minh Quang', N'9876543210', 15000.000)
INSERT [dbo].[KHACHHANG] ([MaKH], [TenKH], [Sdt], [Diem]) VALUES (N'kh04', N'Dương Văn Quân', N'0707237806', 3200.000)
INSERT [dbo].[KHACHHANG] ([MaKH], [TenKH], [Sdt], [Diem]) VALUES (N'kh05', N'Nguyễn Thị B', N'0362434969', 5600.000)
INSERT [dbo].[KHACHHANG] ([MaKH], [TenKH], [Sdt], [Diem]) VALUES (N'kh06', N'Nguyễn Thị B', N'0362434969', 11500.000)
INSERT [dbo].[KHACHHANG] ([MaKH], [TenKH], [Sdt], [Diem]) VALUES (N'kh07', N'Nguyễn Văn A', N'0327209786', 0)

GO
ALTER TABLE [dbo].[CTHD]  WITH CHECK ADD  CONSTRAINT [kh_HoaDon] FOREIGN KEY([MaHD])
REFERENCES [dbo].[HOADON] ([MaHD])
GO
ALTER TABLE [dbo].[CTHD] CHECK CONSTRAINT [kh_HoaDon]
GO
ALTER TABLE [dbo].[HOADON]  WITH CHECK ADD  CONSTRAINT [fk_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NHANVIEN] ([MaNV])
GO
ALTER TABLE [dbo].[HOADON] CHECK CONSTRAINT [fk_NhanVien]
GO
ALTER TABLE [dbo].[NHANVIEN]  WITH CHECK ADD  CONSTRAINT [fk_ChucVu] FOREIGN KEY([MaCV])
REFERENCES [dbo].[CHUCVU] ([MaCV])
GO
ALTER TABLE [dbo].[NHANVIEN] CHECK CONSTRAINT [fk_ChucVu]
GO
ALTER TABLE [dbo].[SACH]  WITH CHECK ADD  CONSTRAINT [fk_NXB] FOREIGN KEY([MaNXB])
REFERENCES [dbo].[NXB] ([MaNXB])
GO
ALTER TABLE [dbo].[VPP]  WITH CHECK ADD  CONSTRAINT [fk_NCCVPP] FOREIGN KEY([MaNCCVPP])
REFERENCES [dbo].[NCCVPP] ([MaNCCVPP])
GO
ALTER TABLE [dbo].[SACH] CHECK CONSTRAINT [fk_NXB]
GO
ALTER TABLE [dbo].[TAIKHOAN]  WITH CHECK ADD  CONSTRAINT [fk_TaiKhoan_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NHANVIEN] ([MaNV])
GO
ALTER TABLE [dbo].[TAIKHOAN] CHECK CONSTRAINT [fk_TaiKhoan_NhanVien]

GO
CREATE PROCEDURE GetTonKhoThangHienTai
	@nam nvarchar(4), @thang nvarchar(2)
AS
BEGIN
	SELECT S.MaSach,  S.TenSach, V.MaVPP, V.TenVPP,
	S.SoLuong+COALESCE(SUM(CASE WHEN H.NhapSach=0 THEN C.SoLuong ELSE 0 END), 0)-COALESCE(SUM(CASE WHEN H.NhapSach=1 THEN C.SoLuong ELSE 0 END), 0) AS TonDauS,
	V.SoLuong+COALESCE(SUM(CASE WHEN H.NhapSach=0 THEN C.SoLuong ELSE 0 END), 0)-COALESCE(SUM(CASE WHEN H.NhapSach=1 THEN C.SoLuong ELSE 0 END), 0) AS TonDauVPP,
	SUM(CASE WHEN H.NhapSach=1 THEN C.SoLuong ELSE 0 END) AS Nhap,
	SUM(CASE WHEN H.NhapSach=0 THEN C.SoLuong ELSE 0 END) AS Xuat,
	S.SoLuong AS TonCuoiS,
	V.SoLuong AS TonCuoiVPP
	FROM CTHD AS C
	LEFT JOIN SACH AS S ON C.MaSP=S.MaSach
	LEFT JOIN VPP AS V ON C.MaSP=V.MaVPP
	LEFT JOIN HOADON AS H ON C.MaHD=H.MaHD
	WHERE YEAR(H.NgayLap)=@nam AND MONTH(H.NgayLap)=@thang AND H.ThanhCong=1
	GROUP BY S.MaSach, S.TenSach, S.SoLuong, V.MaVPP, V.TenVPP, V.SoLuong

	UNION

	SELECT S.MaSach, S.TenSach, NULL, NULL,
		S.SoLuong, NULL, NULL, NULL, S.SoLuong AS TonCuoiS, NULL
	FROM SACH AS S
	LEFT JOIN CTHD AS C ON S.MaSach = C.MaSP
	WHERE C.MaSP IS NULL

	UNION

	SELECT NULL, NULL, V.MaVPP, V.TenVPP,
		NULL, V.SoLuong, NULL, NULL, NULL, V.SoLuong AS TonCuoiVPP
	FROM VPP AS V
	LEFT JOIN CTHD AS C ON V.MaVPP = C.MaSP
	WHERE C.MaSP IS NULL;

END
GO
CREATE PROCEDURE DoanhThuCacThang
AS
BEGIN
	SELECT MONTH(months.Thang) AS Thang, COALESCE(SUM(CTHD.ThanhTien), 0) AS DoanhThu
	FROM (
        SELECT DATEADD(month, number - 1, DATEFROMPARTS(YEAR(GETDATE()), 1, 1)) AS Thang
		FROM master.dbo.spt_values
		WHERE type =N'P' AND number BETWEEN 1 AND 12) AS months
	LEFT JOIN 
		HOADON ON MONTH(HOADON.NgayLap) = MONTH(months.Thang) AND YEAR(HOADON.NgayLap) = YEAR(months.Thang) AND HOADON.NhapSach = 0
	LEFT JOIN 
		CTHD ON HOADON.MaHD = CTHD.MaHD
	GROUP BY 
		MONTH(months.Thang)
END
GO
USE [master]
GO
ALTER DATABASE [dbQLNS] SET  READ_WRITE 
GO