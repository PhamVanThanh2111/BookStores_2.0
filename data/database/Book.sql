USE [master]
GO
/****** Object:  Database [Book]    Script Date: 27/07/2024 14:14:21 ******/
CREATE DATABASE [Book]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Book', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\Book.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Book_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\Book_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [Book] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Book].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Book] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Book] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Book] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Book] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Book] SET ARITHABORT OFF 
GO
ALTER DATABASE [Book] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Book] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Book] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Book] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Book] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Book] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Book] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Book] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Book] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Book] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Book] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Book] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Book] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Book] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Book] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Book] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Book] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Book] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Book] SET  MULTI_USER 
GO
ALTER DATABASE [Book] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Book] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Book] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Book] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Book] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Book] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Book] SET QUERY_STORE = ON
GO
ALTER DATABASE [Book] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [Book]
GO
/****** Object:  Table [dbo].[Ca]    Script Date: 27/07/2024 14:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ca](
	[maCa] [nvarchar](3) NOT NULL,
	[tenCa] [nvarchar](2) NOT NULL,
	[thoiGian] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maCa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 27/07/2024 14:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[donGia] [real] NOT NULL,
	[soLuong] [int] NOT NULL,
	[maHoaDon] [nvarchar](7) NOT NULL,
	[maSanPham] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC,
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDonCho]    Script Date: 27/07/2024 14:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDonCho](
	[donGia] [real] NOT NULL,
	[soLuong] [int] NOT NULL,
	[maHoaDonCho] [nvarchar](8) NOT NULL,
	[maSanPham] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHoaDonCho] ASC,
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhieuDatHang]    Script Date: 27/07/2024 14:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuDatHang](
	[donGia] [real] NOT NULL,
	[soLuong] [int] NOT NULL,
	[maPhieuDatHang] [nvarchar](7) NOT NULL,
	[maSanPham] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhieuDatHang] ASC,
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DungCuHocTap]    Script Date: 27/07/2024 14:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DungCuHocTap](
	[mucTieuSuDung] [nvarchar](100) NULL,
	[maSanPham] [nvarchar](10) NOT NULL,
	[maNhaCungCap] [nvarchar](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 27/07/2024 14:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [nvarchar](7) NOT NULL,
	[ngayLap] [date] NOT NULL,
	[thanhTien] [real] NOT NULL,
	[maKhachHang] [nvarchar](7) NULL,
	[maNhanVien] [nvarchar](6) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonCho]    Script Date: 27/07/2024 14:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonCho](
	[maHoaDonCho] [nvarchar](8) NOT NULL,
	[ngayLap] [date] NOT NULL,
	[thanhTien] [real] NOT NULL,
	[maKhachHang] [nvarchar](7) NULL,
	[maNhanVien] [nvarchar](6) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHoaDonCho] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 27/07/2024 14:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [nvarchar](7) NOT NULL,
	[diaChi] [nvarchar](110) NULL,
	[gioiTinh] [nvarchar](5) NULL,
	[soDienThoai] [nvarchar](10) NOT NULL,
	[tenKhachHang] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 27/07/2024 14:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[maNhaCungCap] [nvarchar](7) NOT NULL,
	[diaChi] [nvarchar](120) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[soDienThoai] [nvarchar](10) NOT NULL,
	[tenNhaCungCap] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 27/07/2024 14:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nvarchar](6) NOT NULL,
	[cCCD] [nvarchar](12) NOT NULL,
	[chucVu] [nvarchar](10) NOT NULL,
	[diaChi] [nvarchar](120) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[gioiTinh] [nvarchar](5) NOT NULL,
	[hinhAnh] [nvarchar](50) NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[ngayVaoLam] [date] NOT NULL,
	[soDienThoai] [nvarchar](10) NOT NULL,
	[tenNhanVien] [nvarchar](50) NOT NULL,
	[maCa] [nvarchar](3) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaXuatBan]    Script Date: 27/07/2024 14:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaXuatBan](
	[maNhaXuatBan] [nvarchar](7) NOT NULL,
	[diaChi] [nvarchar](120) NULL,
	[email] [nvarchar](50) NULL,
	[soDienThoai] [nvarchar](10) NOT NULL,
	[tenNhaXuatBan] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNhaXuatBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuDatHang]    Script Date: 27/07/2024 14:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDatHang](
	[maPhieuDatHang] [nvarchar](7) NOT NULL,
	[ngayLap] [date] NOT NULL,
	[thanhTien] [real] NOT NULL,
	[maKhachHang] [nvarchar](7) NOT NULL,
	[maNhanVien] [nvarchar](6) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhieuDatHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sach]    Script Date: 27/07/2024 14:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sach](
	[namXuatBan] [int] NOT NULL,
	[soTrang] [int] NOT NULL,
	[tacGia] [nvarchar](50) NOT NULL,
	[maSanPham] [nvarchar](10) NOT NULL,
	[maNhaXuatBan] [nvarchar](7) NOT NULL,
	[maTheLoaiSach] [nvarchar](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 27/07/2024 14:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSanPham] [nvarchar](10) NOT NULL,
	[giaBan] [real] NOT NULL,
	[giaNhap] [real] NOT NULL,
	[hinhAnh] [nvarchar](50) NOT NULL,
	[soLuongTon] [int] NOT NULL,
	[tenSanPham] [nvarchar](50) NOT NULL,
	[trangThai] [bit] NOT NULL,
	[xuatXu] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 27/07/2024 14:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[matKhau] [nvarchar](20) NOT NULL,
	[taiKhoan] [nvarchar](6) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[taiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TheLoaiSach]    Script Date: 27/07/2024 14:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TheLoaiSach](
	[maTheLoaiSach] [nvarchar](7) NOT NULL,
	[tenTheLoaiSach] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maTheLoaiSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Ca] ([maCa], [tenCa], [thoiGian]) VALUES (N'C01', N'01', N'09h - 16h')
INSERT [dbo].[Ca] ([maCa], [tenCa], [thoiGian]) VALUES (N'C02', N'02', N'16h - 22h')
GO
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00001', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (4000, 2, N'HD00002', N'DCHT00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (63000, 2, N'HD00002', N'S00003')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (40000, 1, N'HD00003', N'S00010')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (160000, 2, N'HD00004', N'S00008')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (63000, 1, N'HD00005', N'S00003')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (150000, 2, N'HD00006', N'S00009')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (160000, 1, N'HD00007', N'S00008')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (160000, 1, N'HD00008', N'S00008')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00009', N'DCHT00006')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (7000, 2, N'HD00009', N'DCHT00008')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (63000, 2, N'HD00010', N'S00003')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (220000, 2, N'HD00011', N'S00007')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00012', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (627000, 2, N'HD00013', N'DCHT00012')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (250000, 1, N'HD00014', N'DCHT00011')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00014', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (6000, 2, N'HD00015', N'DCHT00007')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00016', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (720000, 2, N'HD00017', N'DCHT00009')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00017', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 3, N'HD00018', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00019', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00020', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00021', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00022', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (5000, 2, N'HD00023', N'DCHT00010')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00023', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (310000, 2, N'HD00023', N'S00006')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (250000, 2, N'HD00024', N'S00004')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (250000, 2, N'HD00025', N'S00004')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (230000, 10, N'HD00026', N'S00004')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (7000, 1, N'HD00027', N'DCHT00005')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (5500000, 10, N'HD00028', N'DCHT00009')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (6270000, 10, N'HD00029', N'DCHT00012')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (7000, 1, N'HD00030', N'DCHT00002')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (7000, 2, N'HD00031', N'DCHT00002')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00032', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (2300000, 10, N'HD00033', N'S00004')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (2700000, 10, N'HD00034', N'S00006')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00035', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00036', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00037', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00038', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (5000, 3, N'HD00039', N'DCHT00003')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (220000, 2, N'HD00039', N'S00007')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (100000, 2, N'HD00040', N'S00002')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (40000, 1, N'HD00041', N'S00010')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00042', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (150000, 2, N'HD00043', N'S00009')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (220000, 1, N'HD00044', N'S00007')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00045', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00046', N'DCHT00006')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00047', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (5000, 2, N'HD00048', N'DCHT00004')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00049', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00050', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (7000, 2, N'HD00051', N'DCHT00005')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (7000, 1, N'HD00052', N'DCHT00005')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00053', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00054', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00055', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00056', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00057', N'DCHT00006')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00058', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00059', N'DCHT00006')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (6000, 2, N'HD00060', N'DCHT00007')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00060', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00061', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00062', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00063', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (7000, 2, N'HD00064', N'DCHT00002')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (200000, 1, N'HD00064', N'S00005')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00065', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00066', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00067', N'DCHT00006')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00068', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00069', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00070', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00071', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00072', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00073', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00074', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00075', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00076', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00077', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 10, N'HD00078', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 10, N'HD00079', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 10, N'HD00080', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 10, N'HD00081', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 6, N'HD00082', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (220000, 8, N'HD00083', N'S00007')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (150000, 7, N'HD00083', N'S00009')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (220000, 8, N'HD00084', N'S00007')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (150000, 8, N'HD00084', N'S00009')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00085', N'DCHT00006')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00085', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (220000, 2, N'HD00086', N'S00007')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00087', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (7000, 2, N'HD00088', N'DCHT00002')
GO
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 3, N'HD00088', N'DCHT00006')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (200000, 1, N'HD00088', N'S00005')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00089', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00090', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00091', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00092', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (6000, 2, N'HD00093', N'DCHT00007')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00094', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00095', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00098', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (63000, 1, N'HD00099', N'S00003')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (63000, 1, N'HD00100', N'S00003')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 37, N'HD00101', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 3, N'HD00102', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (160000, 1, N'HD00103', N'S00008')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00104', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 49, N'HD00105', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 49, N'HD00106', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 10, N'HD00107', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (220000, 3, N'HD00108', N'S00007')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00109', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00110', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (100000, 1, N'HD00111', N'S00002')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (100000, 1, N'HD00112', N'S00002')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (5000, 5, N'HD00113', N'DCHT00003')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 5, N'HD00113', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (720000, 2, N'HD00114', N'DCHT00009')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (200000, 4, N'HD00114', N'S00005')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00115', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 2, N'HD00116', N'DCHT00006')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (160000, 2, N'HD00116', N'S00008')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00117', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (70000, 1, N'HD00118', N'S00001')
INSERT [dbo].[ChiTietHoaDon] ([donGia], [soLuong], [maHoaDon], [maSanPham]) VALUES (4000, 1, N'HD00119', N'DCHT00001')
GO
INSERT [dbo].[ChiTietHoaDonCho] ([donGia], [soLuong], [maHoaDonCho], [maSanPham]) VALUES (70000, 2, N'HDC00001', N'S00001')
INSERT [dbo].[ChiTietHoaDonCho] ([donGia], [soLuong], [maHoaDonCho], [maSanPham]) VALUES (627000, 1, N'HDC00002', N'DCHT00012')
INSERT [dbo].[ChiTietHoaDonCho] ([donGia], [soLuong], [maHoaDonCho], [maSanPham]) VALUES (150000, 1, N'HDC00002', N'S00009')
GO
INSERT [dbo].[ChiTietPhieuDatHang] ([donGia], [soLuong], [maPhieuDatHang], [maSanPham]) VALUES (70000, 2, N'PD00001', N'S00001')
INSERT [dbo].[ChiTietPhieuDatHang] ([donGia], [soLuong], [maPhieuDatHang], [maSanPham]) VALUES (70000, 2, N'PD00002', N'S00001')
INSERT [dbo].[ChiTietPhieuDatHang] ([donGia], [soLuong], [maPhieuDatHang], [maSanPham]) VALUES (70000, 2, N'PD00003', N'S00001')
INSERT [dbo].[ChiTietPhieuDatHang] ([donGia], [soLuong], [maPhieuDatHang], [maSanPham]) VALUES (70000, 2, N'PD00004', N'S00001')
GO
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00001', N'NCC0001')
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00002', N'NCC0004')
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00003', N'NCC0001')
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00004', N'NCC0002')
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00005', N'NCC0002')
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00006', N'NCC0001')
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00007', N'NCC0002')
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00008', N'NCC0002')
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00009', N'NCC0001')
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00010', N'NCC0001')
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00011', N'NCC0002')
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00012', N'NCC0001')
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00013', N'NCC0002')
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00014', N'NCC0001')
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00015', N'NCC0004')
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00016', N'NCC0001')
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00017', N'NCC0002')
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00018', N'NCC0002')
INSERT [dbo].[DungCuHocTap] ([mucTieuSuDung], [maSanPham], [maNhaCungCap]) VALUES (NULL, N'DCHT00019', N'NCC0002')
GO
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00001', CAST(N'2023-12-12' AS Date), 140000, N'KH00001', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00002', CAST(N'2023-12-12' AS Date), 134000, N'KH00002', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00003', CAST(N'2023-12-12' AS Date), 40000, N'KH00004', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00004', CAST(N'2023-12-12' AS Date), 320000, N'KH00005', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00005', CAST(N'2023-12-12' AS Date), 63000, N'KH00006', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00006', CAST(N'2023-12-12' AS Date), 300000, N'KH00007', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00007', CAST(N'2023-12-12' AS Date), 160000, N'KH00008', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00008', CAST(N'2023-12-11' AS Date), 160000, N'KH00009', N'NV0002')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00009', CAST(N'2023-12-12' AS Date), 84000, N'KH00010', N'NV0002')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00010', CAST(N'2023-12-12' AS Date), 126000, N'KH00011', N'NV0002')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00011', CAST(N'2023-12-12' AS Date), 440000, N'KH00013', N'NV0002')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00012', CAST(N'2023-12-12' AS Date), 70000, N'KH00014', N'NV0002')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00013', CAST(N'2023-12-12' AS Date), 1254000, N'KH00015', N'NV0002')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00014', CAST(N'2023-12-12' AS Date), 390000, N'KH00016', N'NV0003')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00015', CAST(N'2023-12-12' AS Date), 12000, N'KH00017', N'NV0003')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00016', CAST(N'2023-12-12' AS Date), 140000, N'KH00019', N'NV0003')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00017', CAST(N'2023-12-12' AS Date), 1580000, N'KH00020', N'NV0003')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00018', CAST(N'2023-12-12' AS Date), 210000, N'KH00021', N'NV0003')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00019', CAST(N'2023-12-12' AS Date), 140000, N'KH00021', N'NV0004')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00020', CAST(N'2023-12-12' AS Date), 140000, N'KH00012', N'NV0004')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00021', CAST(N'2023-12-12' AS Date), 70000, N'KH00001', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00022', CAST(N'2023-12-12' AS Date), 140000, N'KH00001', N'NV0004')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00023', CAST(N'2023-12-12' AS Date), 770000, N'KH00001', N'NV0004')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00024', CAST(N'2023-12-12' AS Date), 500000, N'KH00001', N'NV0005')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00025', CAST(N'2023-12-12' AS Date), 500000, N'KH00001', N'NV0005')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00026', CAST(N'2023-12-11' AS Date), 2300000, N'KH00001', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00027', CAST(N'2023-12-12' AS Date), 7000, N'KH00001', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00028', CAST(N'2023-12-10' AS Date), 5500000, N'KH00002', N'NV0002')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00029', CAST(N'2023-12-09' AS Date), 6270000, N'KH00003', N'NV0003')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00030', CAST(N'2023-12-12' AS Date), 7000, N'KH00001', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00031', CAST(N'2023-12-12' AS Date), 14000, N'KH00001', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00032', CAST(N'2023-12-12' AS Date), 140000, N'KH00015', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00033', CAST(N'2023-12-08' AS Date), 2300000, N'KH00004', N'NV0004')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00034', CAST(N'2023-12-07' AS Date), 2700000, N'KH00005', N'NV0005')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00035', CAST(N'2023-12-12' AS Date), 70000, N'KH00018', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00036', CAST(N'2023-12-12' AS Date), 70000, N'KH00001', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00037', CAST(N'2023-12-12' AS Date), 140000, N'KH00016', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00038', CAST(N'2023-12-13' AS Date), 140000, N'KH00014', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00039', CAST(N'2023-12-13' AS Date), 455000, N'KH00012', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00040', CAST(N'2023-12-13' AS Date), 200000, N'KH00012', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00041', CAST(N'2024-04-17' AS Date), 40000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00042', CAST(N'2024-04-17' AS Date), 70000, N'KH00022', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00043', CAST(N'2024-04-17' AS Date), 300000, N'KH00013', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00044', CAST(N'2024-04-17' AS Date), 220000, N'KH00013', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00045', CAST(N'2024-04-19' AS Date), 70000, N'KH00019', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00046', CAST(N'2024-04-19' AS Date), 70000, N'KH00019', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00047', CAST(N'2024-04-19' AS Date), 140000, N'KH00019', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00048', CAST(N'2024-04-19' AS Date), 10000, N'KH00019', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00049', CAST(N'2024-04-19' AS Date), 140000, N'KH00019', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00050', CAST(N'2024-04-19' AS Date), 140000, N'KH00019', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00051', CAST(N'2024-04-19' AS Date), 14000, N'KH00017', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00052', CAST(N'2024-04-19' AS Date), 7000, N'KH00021', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00053', CAST(N'2024-04-19' AS Date), 70000, N'KH00021', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00054', CAST(N'2024-04-20' AS Date), 70000, N'KH00012', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00055', CAST(N'2024-04-20' AS Date), 70000, N'KH00012', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00056', CAST(N'2024-04-20' AS Date), 70000, N'KH00012', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00057', CAST(N'2024-04-20' AS Date), 70000, N'KH00010', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00058', CAST(N'2024-04-20' AS Date), 70000, N'KH00010', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00059', CAST(N'2024-04-20' AS Date), 70000, N'KH00010', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00060', CAST(N'2024-04-20' AS Date), 82000, N'KH00010', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00061', CAST(N'2024-04-20' AS Date), 70000, N'KH00015', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00062', CAST(N'2024-04-20' AS Date), 140000, N'KH00016', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00063', CAST(N'2024-04-20' AS Date), 70000, N'KH00010', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00064', CAST(N'2024-04-20' AS Date), 214000, N'KH00015', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00065', CAST(N'2024-04-20' AS Date), 140000, N'KH00010', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00066', CAST(N'2024-04-20' AS Date), 140000, N'KH00009', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00067', CAST(N'2024-04-20' AS Date), 140000, N'KH00009', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00068', CAST(N'2024-04-20' AS Date), 140000, N'KH00020', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00069', CAST(N'2024-04-20' AS Date), 140000, N'KH00020', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00070', CAST(N'2024-04-20' AS Date), 140000, N'KH00020', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00071', CAST(N'2024-04-20' AS Date), 140000, NULL, N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00072', CAST(N'2024-04-21' AS Date), 140000, NULL, N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00073', CAST(N'2024-04-21' AS Date), 140000, NULL, N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00074', CAST(N'2024-04-21' AS Date), 140000, NULL, N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00075', CAST(N'2024-04-21' AS Date), 140000, NULL, N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00076', CAST(N'2024-04-21' AS Date), 140000, NULL, N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00077', CAST(N'2024-04-21' AS Date), 70000, NULL, N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00078', CAST(N'2024-04-21' AS Date), 700000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00079', CAST(N'2024-04-21' AS Date), 700000, NULL, N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00080', CAST(N'2024-04-21' AS Date), 700000, NULL, N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00081', CAST(N'2024-04-21' AS Date), 700000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00082', CAST(N'2024-04-21' AS Date), 420000, NULL, N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00083', CAST(N'2024-04-21' AS Date), 2810000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00084', CAST(N'2024-04-21' AS Date), 2960000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00085', CAST(N'2024-04-20' AS Date), 140000, N'KH00020', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00086', CAST(N'2024-04-20' AS Date), 440000, N'KH00020', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00087', CAST(N'2024-04-20' AS Date), 140000, N'KH00020', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00088', CAST(N'2024-04-20' AS Date), 424000, N'KH00015', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00089', CAST(N'2024-04-21' AS Date), 140000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00090', CAST(N'2024-04-21' AS Date), 140000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00091', CAST(N'2024-04-21' AS Date), 140000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00092', CAST(N'2024-04-21' AS Date), 140000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00093', CAST(N'2024-04-21' AS Date), 12000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00094', CAST(N'2024-04-21' AS Date), 140000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00095', CAST(N'2024-04-23' AS Date), 140000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00096', CAST(N'2024-04-23' AS Date), 140000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00097', CAST(N'2024-04-23' AS Date), 70000, NULL, N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00098', CAST(N'2024-04-23' AS Date), 70000, NULL, N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00099', CAST(N'2024-04-23' AS Date), 63000, N'KH00006', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00100', CAST(N'2024-04-23' AS Date), 63000, N'KH00006', N'NV0001')
GO
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00101', CAST(N'2024-04-23' AS Date), 2590000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00102', CAST(N'2024-04-23' AS Date), 210000, NULL, N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00103', CAST(N'2024-04-23' AS Date), 160000, N'KH00006', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00104', CAST(N'2024-04-23' AS Date), 140000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00105', CAST(N'2024-04-23' AS Date), 3430000, NULL, N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00106', CAST(N'2024-04-23' AS Date), 3430000, N'KH00006', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00107', CAST(N'2024-04-23' AS Date), 700000, NULL, N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00108', CAST(N'2024-04-23' AS Date), 660000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00109', CAST(N'2024-04-23' AS Date), 140000, N'KH00010', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00110', CAST(N'2024-04-23' AS Date), 140000, NULL, N'NV0003')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00111', CAST(N'2024-04-23' AS Date), 100000, NULL, N'NV0003')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00112', CAST(N'2024-04-23' AS Date), 100000, NULL, N'NV0003')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00113', CAST(N'2024-04-23' AS Date), 375000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00114', CAST(N'2024-04-23' AS Date), 2240000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00115', CAST(N'2024-04-23' AS Date), 140000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00116', CAST(N'2024-04-23' AS Date), 460000, N'KH00023', N'NV0001')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00117', CAST(N'2024-04-23' AS Date), 70000, NULL, N'NV0003')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00118', CAST(N'2024-04-23' AS Date), 70000, NULL, N'NV0003')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HD00119', CAST(N'2024-07-25' AS Date), 4000, NULL, N'NV0001')
GO
INSERT [dbo].[HoaDonCho] ([maHoaDonCho], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HDC00001', CAST(N'2024-07-27' AS Date), 140000, N'KH00009', N'NV0001')
INSERT [dbo].[HoaDonCho] ([maHoaDonCho], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'HDC00002', CAST(N'2024-07-27' AS Date), 777000, N'KH00016', N'NV0001')
GO
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00001', N'Thành phố Vĩnh Long, Tỉnh Vĩnh Long.', N'Nam', N'0123456789', N'Trịnh Minh Kha')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00002', N'Huyện Giồng Trôm, Tỉnh Bến Tre.', N'Nam', N'0355208069', N'Võ Văn Bạch')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00003', N'Thị xã La Gi, Tỉnh Bình Thuận.', N'Nam', N'0373498729', N'Lê Hoàng Bảo')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00004', N'Quận 12, Thành phố Hồ Chí Minh.', N'Nam', N'0774025712', N'Trương Chí Bảo')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00005', N'Huyện Tây Sơn, Tỉnh Bình Định.', N'Nam', N'0987837712', N'Nguyễn Trọng Đại')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00006', N'Thành phố Châu Đốc, Tỉnh An Giang.', N'Nam', N'0834886058', N'Phạm Quốc Đại')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00007', N'Quận Gò Vấp, Thành phố Hồ Chí Minh.', N'Nam', N'0935531991', N'Phi Anh Đạt')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00008', N'Quận 1, Thành phố Hồ Chí Minh.', N'Nam', N'0703198828', N'Lê Trí Đức')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00009', N'Quận Tân Phú, Thành phố Hồ Chí Minh.', N'Nam', N'0369160539', N'Vũ Nguyễn Minh Đức')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00010', N'Thành phố Hưng Yên, Tỉnh Hưng Yên.', N'Nam', N'0352160178', N'Bùi Phương Duy')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00011', N'Huyện Cẩm Mỹ, Tỉnh Đồng Nai.', N'Nam', N'0343806292', N'Nguyễn Trường Huy')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00012', N'Quận 6, Thành phố Hồ Chí Minh.', N'Nam', N'0364972537', N'Trần Ngô Bảo')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00013', N'Huyện Quế Sơn, Tỉnh Quảng Nam.', N'Nam', N'0374490438', N'Đinh Văn Khanh')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00014', N'Quận 3, Thành phố Hồ Chí Minh.', N'Nam', N'0523323213', N'Đinh Quốc Khánh')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00015', N'Thành phố Nha Trang, Tỉnh Khánh Hòa.', N'Nam', N'0935912495', N'Võ Phạm Đăng Khoa')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00016', N'Thị xã Dĩ An, Tỉnh Bình Dương.', N'Nam', N'0786597684', N'Kiều Nhật Lệ')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00017', N'Huyện Chợ Gạo, Tỉnh Tiền Giang.', N'Nam', N'0834913675', N'Nguyễn Thành Long')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00018', N'Thành phố Vũng Tàu, Tỉnh Bà Rịa - Vũng Tàu.', N'Nam', N'0947767934', N'Phan Khôi Nguyên')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00019', N'Quận 12, Thành phố Hồ Chí Minh.', N'Nữ', N'0979294182', N'Đinh Thị Tuyết Nhi')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00020', N'Huyện Cai lậy, Tỉnh Tiền Giang.', N'Nam', N'0343989667', N'Hồ Trường Minh Phú')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00021', N'Huyện Cai lậy, Tỉnh Tiền Giang.', N'Nam', N'0365069728', N'Phan Đường Bảo Phúc')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00022', N'Huyện Hóc Môn, Thành phố Hồ Chí Minh.', N'Nữ', N'0367005956', N'Đinh Thị Ngọc Thanh')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00023', N'Bình Tân', N'Nam', N'0934004524', N'Phạm Văn Thành')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00024', N'Huyện Quế Sơn, Tỉnh Quảng Nam.', N'Nam', N'0374490438', N'Đinh Văn Khanh')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00025', N'Quận 1, Thành phố Hồ Chí Minh.', N'Nam', N'0703198828', N'Lê Trí Đức')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00026', N'Thành phố Nha Trang, Tỉnh Khánh Hòa.', N'Nam', N'0935912495', N'Võ Phạm Đăng Khoa')
INSERT [dbo].[KhachHang] ([maKhachHang], [diaChi], [gioiTinh], [soDienThoai], [tenKhachHang]) VALUES (N'KH00027', N'Thành phố Nha Traaaaaaaang, Tỉnh Khánh Hòa.', N'Nam', N'0935912495', N'Võ Phạm Đăng Khoa')
GO
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [diaChi], [email], [soDienThoai], [tenNhaCungCap]) VALUES (N'NCC0001', N'Tầng 10, Sofic Tower, Số 10 Đường Mai Chí Thọ, Phường Thủ Thiêm, Thành Phố Thủ Đức, Thành Phố Hồ Chí Minh, Việt Nam', N'salesonline@thienlongvn.com

', N'1900866819', N'Thiên Long')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [diaChi], [email], [soDienThoai], [tenNhaCungCap]) VALUES (N'NCC0002', N'220/9 Phan Văn Hân, Phường 17, Quận Bình Thạnh, TPHCM', N'vantaiquocanh@gmail.com', N'0903692603', N'Marvy Uchida')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [diaChi], [email], [soDienThoai], [tenNhaCungCap]) VALUES (N'NCC0003', N'33-35 đường D4, khu Đô thị mới Him Lam, Phường Tân Hưng, Quận 7, TP. Hồ Chí Minh', N'vta@gmail.com', N'0309132354', N'Việt Tinh Anh')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [diaChi], [email], [soDienThoai], [tenNhaCungCap]) VALUES (N'NCC0004', N'115/25/1 đường Lê Văn Sỹ, phường 13, quận Phú Nhuận, Tp. Hồ Chí Minh', N'hotro@laq.vn', N'0239314625', N'LAQ')
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [cCCD], [chucVu], [diaChi], [email], [gioiTinh], [hinhAnh], [ngaySinh], [ngayVaoLam], [soDienThoai], [tenNhanVien], [maCa]) VALUES (N'NV0001', N'206381313', N'Quản lý', N'Gò Xoài', N'phamtrung21112003@gmail.com', N'Nam', N'/image/NhanVien/PhamVanThanh.png', CAST(N'2003-01-01' AS Date), CAST(N'2023-01-01' AS Date), N'0934004524', N'Phạm Văn Thành', N'C01')
INSERT [dbo].[NhanVien] ([maNhanVien], [cCCD], [chucVu], [diaChi], [email], [gioiTinh], [hinhAnh], [ngaySinh], [ngayVaoLam], [soDienThoai], [tenNhanVien], [maCa]) VALUES (N'NV0002', N'077203005398', N'Bán hàng', N'Bùi Đình Túy', N'phamtrung21112003@gmail.com', N'Nam', N'/image/NhanVien/TranThanhTam.png', CAST(N'2003-01-01' AS Date), CAST(N'2023-10-29' AS Date), N'0934004524', N'Trần Thanh Tâm', N'C01')
INSERT [dbo].[NhanVien] ([maNhanVien], [cCCD], [chucVu], [diaChi], [email], [gioiTinh], [hinhAnh], [ngaySinh], [ngayVaoLam], [soDienThoai], [tenNhanVien], [maCa]) VALUES (N'NV0003', N'072030062412', N'Bán hàng', N'Lê Lai', N'phamtrung21112003@gmail.com', N'Nam', N'/image/NhanVien/MaiLuuHuuVinh.png', CAST(N'2003-01-01' AS Date), CAST(N'2023-10-29' AS Date), N'0934004524', N'Mai Lưu Hữu Vinh', N'C01')
INSERT [dbo].[NhanVien] ([maNhanVien], [cCCD], [chucVu], [diaChi], [email], [gioiTinh], [hinhAnh], [ngaySinh], [ngayVaoLam], [soDienThoai], [tenNhanVien], [maCa]) VALUES (N'NV0004', N'347582572375', N'Bán hàng', N'Hà Nội', N'bachtran246@gmail.com', N'Nam', N'/image/NhanVien/DamNgocSon.png', CAST(N'2003-01-01' AS Date), CAST(N'2023-11-12' AS Date), N'0823715461', N'Đàm Ngọc Sơn', N'C01')
INSERT [dbo].[NhanVien] ([maNhanVien], [cCCD], [chucVu], [diaChi], [email], [gioiTinh], [hinhAnh], [ngaySinh], [ngayVaoLam], [soDienThoai], [tenNhanVien], [maCa]) VALUES (N'NV0005', N'372352737542', N'Bán hàng', N'Hà Nội', N'anhNguyen246@gmail.com', N'Nữ', N'/image/NhanVien/NguyenNgocAnh.png', CAST(N'2003-01-01' AS Date), CAST(N'2023-12-12' AS Date), N'0982662346', N'Nguyễn Ngọc Anh', N'C01')
INSERT [dbo].[NhanVien] ([maNhanVien], [cCCD], [chucVu], [diaChi], [email], [gioiTinh], [hinhAnh], [ngaySinh], [ngayVaoLam], [soDienThoai], [tenNhanVien], [maCa]) VALUES (N'NV0006', N'726526346332', N'Bán hàng', N'Hà Nội', N'taiNguyen@gmail.com', N'Nam', N'/image/NhanVien/NguyenThanhTai.png', CAST(N'2003-01-01' AS Date), CAST(N'2023-12-12' AS Date), N'0876782366', N'Nguyễn Thanh Tài', N'C01')
INSERT [dbo].[NhanVien] ([maNhanVien], [cCCD], [chucVu], [diaChi], [email], [gioiTinh], [hinhAnh], [ngaySinh], [ngayVaoLam], [soDienThoai], [tenNhanVien], [maCa]) VALUES (N'NV0007', N'626417471284', N'Bán hàng', N'Đà Nẵng', N'tamPhan@gmail.com', N'Nữ', N'/image/NhanVien/PhanMyTam.png', CAST(N'2003-01-01' AS Date), CAST(N'2023-12-12' AS Date), N'0927652634', N'Phan Mỹ Tâm', N'C01')
INSERT [dbo].[NhanVien] ([maNhanVien], [cCCD], [chucVu], [diaChi], [email], [gioiTinh], [hinhAnh], [ngaySinh], [ngayVaoLam], [soDienThoai], [tenNhanVien], [maCa]) VALUES (N'NV0008', N'372352737542', N'Quản lý', N'Hà Nộii', N'anhNguyen246@gmail.com', N'Nữ', N'/image/NhanVien/NguyenNgocAnh.png', CAST(N'2003-01-18' AS Date), CAST(N'2024-04-21' AS Date), N'0982662346', N'Nguyễn Ngọc Anh', N'C02')
GO
INSERT [dbo].[NhaXuatBan] ([maNhaXuatBan], [diaChi], [email], [soDienThoai], [tenNhaXuatBan]) VALUES (N'NXB0001', N'161B Lý Chính Thắng, Võ Thị Sáu, Quận 3, Thành phố Hồ Chí Minh', N'chinhanhdongnambo@nxbtre.com.vn', N'0273924198', N'Trẻ')
INSERT [dbo].[NhaXuatBan] ([maNhaXuatBan], [diaChi], [email], [soDienThoai], [tenNhaXuatBan]) VALUES (N'NXB0002', N'Số 55 Quang Trung, Nguyễn Du, Hai Bà Trưng, Hà Nội', N'cskh_online@nxbkimdong.com.vn', N'0283931628', N'Kim Đồng')
INSERT [dbo].[NhaXuatBan] ([maNhaXuatBan], [diaChi], [email], [soDienThoai], [tenNhaXuatBan]) VALUES (N'NXB0003', N'SỐ 65 NGUYỄN DU, QUẬN HAI BÀ TRƯNG, HÀ NỘI', N'nxbhoinhavan65@gmail.com', N'0438222135', N'Hội Nhà Văn')
INSERT [dbo].[NhaXuatBan] ([maNhaXuatBan], [diaChi], [email], [soDienThoai], [tenNhaXuatBan]) VALUES (N'NXB0004', N'ngõ 19, phố Duy Tân, phường Dịch Vọng Hậu, quận Cầu Giấy, Hà Nội, Việt Nam.', N'lienhe@nxbtrithuc.com.vn', N'0838323839', N'Tri Thức')
INSERT [dbo].[NhaXuatBan] ([maNhaXuatBan], [diaChi], [email], [soDienThoai], [tenNhaXuatBan]) VALUES (N'NXB0005', N'62 Nguyễn Thị Minh Khai, phường Đa Kao, quận 1, TPHCM', N'tonghop@nxbhcm.com.vn', N'0838256804', N'Tổng Hợp TPHCM')
INSERT [dbo].[NhaXuatBan] ([maNhaXuatBan], [diaChi], [email], [soDienThoai], [tenNhaXuatBan]) VALUES (N'NXB0006', N'Công ty cổ phần Vận tải biển và Thương mại Phương Đông, số 278 Tôn Đức Thắng, Hàng Bột, Đống Đa, Hà Nội.', N'nxbdantri@gmail.com', N'0466860751', N'Dân Trí')
INSERT [dbo].[NhaXuatBan] ([maNhaXuatBan], [diaChi], [email], [soDienThoai], [tenNhaXuatBan]) VALUES (N'NXB0007', N'5270 N Park PL NE Ste 114 Cedar Rapids, IA, 52402 ', N'orders@arrowbookstore.com', N'3193957833', N'Arrow Books')
INSERT [dbo].[NhaXuatBan] ([maNhaXuatBan], [diaChi], [email], [soDienThoai], [tenNhaXuatBan]) VALUES (N'NXB0008', N'46 Trần Hưng Đạo, Hoàn Kiếm, Hanoi, Vietnam', N'thegioi@thegioipublishers.vn', N'0438253841', N'Thế Giới')
GO
INSERT [dbo].[PhieuDatHang] ([maPhieuDatHang], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'PD00001', CAST(N'2024-04-21' AS Date), 140000, N'KH00023', N'NV0001')
INSERT [dbo].[PhieuDatHang] ([maPhieuDatHang], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'PD00002', CAST(N'2024-04-21' AS Date), 140000, N'KH00023', N'NV0001')
INSERT [dbo].[PhieuDatHang] ([maPhieuDatHang], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'PD00003', CAST(N'2024-04-21' AS Date), 140000, N'KH00023', N'NV0001')
INSERT [dbo].[PhieuDatHang] ([maPhieuDatHang], [ngayLap], [thanhTien], [maKhachHang], [maNhanVien]) VALUES (N'PD00004', CAST(N'2024-04-21' AS Date), 140000, N'KH00023', N'NV0001')
GO
INSERT [dbo].[Sach] ([namXuatBan], [soTrang], [tacGia], [maSanPham], [maNhaXuatBan], [maTheLoaiSach]) VALUES (2024, 200, N'Tony Buổi Sáng', N'S00001', N'NXB0001', N'TL0002')
INSERT [dbo].[Sach] ([namXuatBan], [soTrang], [tacGia], [maSanPham], [maNhaXuatBan], [maTheLoaiSach]) VALUES (2023, 500, N'Dale Carnegie', N'S00002', N'NXB0005', N'TL0002')
INSERT [dbo].[Sach] ([namXuatBan], [soTrang], [tacGia], [maSanPham], [maNhaXuatBan], [maTheLoaiSach]) VALUES (2020, 227, N'Paulo Coelho', N'S00003', N'NXB0003', N'TL0003')
INSERT [dbo].[Sach] ([namXuatBan], [soTrang], [tacGia], [maSanPham], [maNhaXuatBan], [maTheLoaiSach]) VALUES (1997, 366, N'J. K. Rowling', N'S00004', N'NXB0004', N'TL0003')
INSERT [dbo].[Sach] ([namXuatBan], [soTrang], [tacGia], [maSanPham], [maNhaXuatBan], [maTheLoaiSach]) VALUES (2011, 554, N' Nguyễn Thủy Chung', N'S00005', N'NXB0004', N'TL0007')
INSERT [dbo].[Sach] ([namXuatBan], [soTrang], [tacGia], [maSanPham], [maNhaXuatBan], [maTheLoaiSach]) VALUES (2023, 596, N'Robert C. Martin', N'S00006', N'NXB0006', N'TL0004')
INSERT [dbo].[Sach] ([namXuatBan], [soTrang], [tacGia], [maSanPham], [maNhaXuatBan], [maTheLoaiSach]) VALUES (1951, 160, N'J.D. Salinger', N'S00007', N'NXB0004', N'TL0005')
INSERT [dbo].[Sach] ([namXuatBan], [soTrang], [tacGia], [maSanPham], [maNhaXuatBan], [maTheLoaiSach]) VALUES (1960, 180, N'Harper Lee', N'S00008', N'NXB0007', N'TL0005')
INSERT [dbo].[Sach] ([namXuatBan], [soTrang], [tacGia], [maSanPham], [maNhaXuatBan], [maTheLoaiSach]) VALUES (1925, 190, N'F. Scott Fitzgerald', N'S00009', N'NXB0008', N'TL0005')
INSERT [dbo].[Sach] ([namXuatBan], [soTrang], [tacGia], [maSanPham], [maNhaXuatBan], [maTheLoaiSach]) VALUES (2020, 200, N'Tô Hoài', N'S00010', N'NXB0002', N'TL0006')
INSERT [dbo].[Sach] ([namXuatBan], [soTrang], [tacGia], [maSanPham], [maNhaXuatBan], [maTheLoaiSach]) VALUES (1960, 180, N'Harper Lee', N'S00011', N'NXB0007', N'TL0005')
INSERT [dbo].[Sach] ([namXuatBan], [soTrang], [tacGia], [maSanPham], [maNhaXuatBan], [maTheLoaiSach]) VALUES (1951, 162, N'J.D. Salinger', N'S00012', N'NXB0004', N'TL0005')
INSERT [dbo].[Sach] ([namXuatBan], [soTrang], [tacGia], [maSanPham], [maNhaXuatBan], [maTheLoaiSach]) VALUES (1951, 160, N'J.D. Salinger', N'S00013', N'NXB0004', N'TL0005')
INSERT [dbo].[Sach] ([namXuatBan], [soTrang], [tacGia], [maSanPham], [maNhaXuatBan], [maTheLoaiSach]) VALUES (1951, 162, N'J.D. Salinger', N'S00014', N'NXB0004', N'TL0005')
GO
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00001', 4000, 2000, N'/image/DungCuHocTap/butChi.png', 3, N'Bút chì 2B', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00002', 7000, 5000, N'/image/DungCuHocTap/sotay.jpg', 41, N'Vở', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00003', 5000, 3000, N'/image/DungCuHocTap/thuocdai.png', 11, N'Thước kẻ', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00004', 5000, 3000, N'/image/DungCuHocTap/sghichu.jpg', 18, N'Sách ghi chú', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00005', 7000, 5000, N'/image/DungCuHocTap/butmau.jpg', 14, N'Bút màu', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00006', 70000, 60000, N'/image/DungCuHocTap/banhden.jpg', 7, N'Bảng đen', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00007', 6000, 3000, N'/image/DungCuHocTap/thuocDay.jpg', 14, N'Thước dây', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00008', 7000, 3000, N'/image/DungCuHocTap/kẹp giấy.jpg', 16, N'Kẹp giấy', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00009', 720000, 550000, N'/image/DungCuHocTap/fx580.jpg', 15, N'Máy tính bỏ túi Casio 580', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00010', 5000, 2500, N'/image/DungCuHocTap/Bút mực 0.5 mm - Mực xanh.jpg', 18, N'Bút mực 0.5 mm - Mực xanh', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00011', 250000, 190000, N'/image/DungCuHocTap/caphs.jpg', 17, N'Cặp xách học sinh', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00012', 627000, 520000, N'/image/DungCuHocTap/maytinh570.jpg', 16, N'Máy tính cá nhân Casio fx-570VN PLUS NEW', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00013', 8000, 3000, N'/image/DungCuHocTap/giaymaythucong.jpg', 20, N'Giấy màu thủ công', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00014', 25000, 15000, N'/image/DungCuHocTap/sotay.jpg', 20, N'Sổ Tay', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00015', 28000, 20000, N'/image/DungCuHocTap/butlongcuu.jpg', 18, N'Bút Lông Cừu', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00016', 14000, 10000, N'/image/DungCuHocTap/thuocdai.png', 20, N'Thước Dài', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00017', 20000, 15000, N'/image/DungCuHocTap/keocatgiay.jpg', 27, N'Kéo Cắt Giấy', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00018', 20000, 15000, N'/image/DungCuHocTap/keocatgiay.jpg', 23, N'Kéo Cắt Giấy', 0, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'DCHT00019', 20000, 15000, N'/image/DungCuHocTap/keocatgiay.jpg', 23, N'Kéo Cắt Giấy', 0, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'S00001', 70000, 50000, N'/image/Sach/trenduongbang.jpg', 21, N'Trên Đường Băng', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'S00002', 100000, 80000, N'/image/Sach/dacnhantam.jpg', 19, N'Đắc Nhân Tâm', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'S00003', 63000, 50000, N'/image/Sach/nhagiakim.jpg', 10, N'Nhà Giả Kim (Tái Bản 2020)', 1, N'Nước Ngoài')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'S00004', 250000, 230000, N'/image/Sach/rybotter.jpg', 34, N'Harry Potter', 1, N'Nước Ngoài')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'S00005', 200000, 170000, N'/image/Sach/luocsuloainguoi.jpg', 27, N'Lược sử loài người', 1, N'Nước Ngoài')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'S00006', 310000, 270000, N'/image/Sach/cleancode.jpg', 26, N'Clean Code', 1, N'Nước Ngoài')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'S00007', 220000, 170000, N'/image/Sach/catcher in the rye.png', 2, N'The Catcher in the Rye', 1, N'Hoa Kỳ')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'S00008', 160000, 100000, N'/image/Sach/to kill a Mockingbird.png', 29, N'To Kill a Mockingbird', 1, N'Nước Ngoài')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'S00009', 150000, 100000, N'/image/Sach/thr great gatsby.png', 20, N'The Great Gatsby', 1, N'Nước Ngoài')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'S00010', 40000, 30000, N'/image/Sach/demen.jpg', 36, N'Dế Mèn Phiêu Lưu Ký', 1, N'Việt Nam')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'S00011', 160000, 100000, N'/image/Sach/to kill a Mockingbird.png', 36, N'To Kill a Mockingbird', 1, N'Nước Ngoài')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'S00012', 220000, 170000, N'/image/Sach/catcher in the rye.png', 23, N'The Catcher in the Rye', 1, N'Hoa Kỳ')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'S00013', 220000, 170000, N'/image/Sach/catcher in the rye.png', 23, N'The Catcher in the Rye', 0, N'Hoa Kỳ')
INSERT [dbo].[SanPham] ([maSanPham], [giaBan], [giaNhap], [hinhAnh], [soLuongTon], [tenSanPham], [trangThai], [xuatXu]) VALUES (N'S00014', 220000, 170000, N'/image/Sach/catcher in the rye.png', 23, N'The Catcher in the Rye', 0, N'Hoa Kỳ')
GO
INSERT [dbo].[TaiKhoan] ([matKhau], [taiKhoan]) VALUES (N'NV0001', N'NV0001')
INSERT [dbo].[TaiKhoan] ([matKhau], [taiKhoan]) VALUES (N'NV0002', N'NV0002')
INSERT [dbo].[TaiKhoan] ([matKhau], [taiKhoan]) VALUES (N'NV0003', N'NV0003')
INSERT [dbo].[TaiKhoan] ([matKhau], [taiKhoan]) VALUES (N'NV0004', N'NV0004')
INSERT [dbo].[TaiKhoan] ([matKhau], [taiKhoan]) VALUES (N'NV0005', N'NV0005')
INSERT [dbo].[TaiKhoan] ([matKhau], [taiKhoan]) VALUES (N'NV0006', N'NV0006')
INSERT [dbo].[TaiKhoan] ([matKhau], [taiKhoan]) VALUES (N'NV0007', N'NV0007')
INSERT [dbo].[TaiKhoan] ([matKhau], [taiKhoan]) VALUES (N'0982662346', N'NV0008')
GO
INSERT [dbo].[TheLoaiSach] ([maTheLoaiSach], [tenTheLoaiSach]) VALUES (N'TL0002', N'Phát triển bản thân')
INSERT [dbo].[TheLoaiSach] ([maTheLoaiSach], [tenTheLoaiSach]) VALUES (N'TL0003', N'Phiêu lưu')
INSERT [dbo].[TheLoaiSach] ([maTheLoaiSach], [tenTheLoaiSach]) VALUES (N'TL0004', N'Lập trình')
INSERT [dbo].[TheLoaiSach] ([maTheLoaiSach], [tenTheLoaiSach]) VALUES (N'TL0005', N'Tiểu thuyết')
INSERT [dbo].[TheLoaiSach] ([maTheLoaiSach], [tenTheLoaiSach]) VALUES (N'TL0006', N'Thiếu nhi')
INSERT [dbo].[TheLoaiSach] ([maTheLoaiSach], [tenTheLoaiSach]) VALUES (N'TL0007', N'Lịch sử')
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK48lko1mwj5apm7o0w68jp3ugw] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK48lko1mwj5apm7o0w68jp3ugw]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FKjrhk50rw9gnc8yk1epve0uc7s] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FKjrhk50rw9gnc8yk1epve0uc7s]
GO
ALTER TABLE [dbo].[ChiTietHoaDonCho]  WITH CHECK ADD  CONSTRAINT [FK3q2j7gd02nrj073q6otsktrco] FOREIGN KEY([maHoaDonCho])
REFERENCES [dbo].[HoaDonCho] ([maHoaDonCho])
GO
ALTER TABLE [dbo].[ChiTietHoaDonCho] CHECK CONSTRAINT [FK3q2j7gd02nrj073q6otsktrco]
GO
ALTER TABLE [dbo].[ChiTietHoaDonCho]  WITH CHECK ADD  CONSTRAINT [FKnqc8y94t938ti6cfu1ju7mojl] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDonCho] CHECK CONSTRAINT [FKnqc8y94t938ti6cfu1ju7mojl]
GO
ALTER TABLE [dbo].[ChiTietPhieuDatHang]  WITH CHECK ADD  CONSTRAINT [FK4419u1mocbf204ncsmhk7qo03] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietPhieuDatHang] CHECK CONSTRAINT [FK4419u1mocbf204ncsmhk7qo03]
GO
ALTER TABLE [dbo].[ChiTietPhieuDatHang]  WITH CHECK ADD  CONSTRAINT [FKinou52k4duwbwlkiqbe2p3sm3] FOREIGN KEY([maPhieuDatHang])
REFERENCES [dbo].[PhieuDatHang] ([maPhieuDatHang])
GO
ALTER TABLE [dbo].[ChiTietPhieuDatHang] CHECK CONSTRAINT [FKinou52k4duwbwlkiqbe2p3sm3]
GO
ALTER TABLE [dbo].[DungCuHocTap]  WITH CHECK ADD  CONSTRAINT [FK7mkn02cg8a4b9ftcin00at0o0] FOREIGN KEY([maNhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([maNhaCungCap])
GO
ALTER TABLE [dbo].[DungCuHocTap] CHECK CONSTRAINT [FK7mkn02cg8a4b9ftcin00at0o0]
GO
ALTER TABLE [dbo].[DungCuHocTap]  WITH CHECK ADD  CONSTRAINT [FKpug3d2tr792bd6r52csvu4ar7] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[DungCuHocTap] CHECK CONSTRAINT [FKpug3d2tr792bd6r52csvu4ar7]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK9d827nxw1jb7c2n7k6lma13fo] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK9d827nxw1jb7c2n7k6lma13fo]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FKlr1g5d8b2338kpln7dlergfjg] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FKlr1g5d8b2338kpln7dlergfjg]
GO
ALTER TABLE [dbo].[HoaDonCho]  WITH CHECK ADD  CONSTRAINT [FKcc2ljm4ldpx2r02keaqkwgox6] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[HoaDonCho] CHECK CONSTRAINT [FKcc2ljm4ldpx2r02keaqkwgox6]
GO
ALTER TABLE [dbo].[HoaDonCho]  WITH CHECK ADD  CONSTRAINT [FKh7sn8exd50imeqv8w891r1pxw] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[HoaDonCho] CHECK CONSTRAINT [FKh7sn8exd50imeqv8w891r1pxw]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FKetl54hg7830bmf3h65d77a0kb] FOREIGN KEY([maCa])
REFERENCES [dbo].[Ca] ([maCa])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FKetl54hg7830bmf3h65d77a0kb]
GO
ALTER TABLE [dbo].[PhieuDatHang]  WITH CHECK ADD  CONSTRAINT [FK75yhrqce254k4tvuy76cvcdu5] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[PhieuDatHang] CHECK CONSTRAINT [FK75yhrqce254k4tvuy76cvcdu5]
GO
ALTER TABLE [dbo].[PhieuDatHang]  WITH CHECK ADD  CONSTRAINT [FKpapwsn75991pvju9srvcfmbp4] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[PhieuDatHang] CHECK CONSTRAINT [FKpapwsn75991pvju9srvcfmbp4]
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD  CONSTRAINT [FKmo8l27iahc73r4eahnhin1okm] FOREIGN KEY([maTheLoaiSach])
REFERENCES [dbo].[TheLoaiSach] ([maTheLoaiSach])
GO
ALTER TABLE [dbo].[Sach] CHECK CONSTRAINT [FKmo8l27iahc73r4eahnhin1okm]
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD  CONSTRAINT [FKos8qxumlj493069p193mmk4f2] FOREIGN KEY([maNhaXuatBan])
REFERENCES [dbo].[NhaXuatBan] ([maNhaXuatBan])
GO
ALTER TABLE [dbo].[Sach] CHECK CONSTRAINT [FKos8qxumlj493069p193mmk4f2]
GO
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD  CONSTRAINT [FKswtjkixe9c73kepggqlsogf6e] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[Sach] CHECK CONSTRAINT [FKswtjkixe9c73kepggqlsogf6e]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK5g2vbl1n39c6kg1ti4yvhuule] FOREIGN KEY([taiKhoan])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK5g2vbl1n39c6kg1ti4yvhuule]
GO
USE [master]
GO
ALTER DATABASE [Book] SET  READ_WRITE 
GO
