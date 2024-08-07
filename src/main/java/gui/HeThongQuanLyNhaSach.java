package gui;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import dao.*;
import entity.NhanVien;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HeThongQuanLyNhaSach extends JFrame {

	private static final long serialVersionUID = 1L;
	private CardLayout cl_pMain;
	private JPanel pMain;
	private JPanel contentPane;
	private JLabel lblNhanVien;
	private JLabel lblTrangChu;
	private JLabel lblKhachHang;
	private JLabel lblHoaDon;
	private JLabel lblSach;
	private JLabel lblHoSo;
	private JLabel lblDangXuat;
	private JLabel lblDungCuHocTap;
	private JLabel lblIconTrangChu;
	private JLabel lblIconNhanVien;
	private JLabel lblIconKhachHang;
	private JLabel lblIconSach;
	private JLabel lblIconDCHT;
	private JLabel lblIconHoaDon;
	private JLabel lblIconHoSo;
	private JLabel lblIconDangXuat;
	private JLabel lblSubMenu1;
	private JLabel lblSubMenu2;
	private JLabel lblSubMenu3;
	private JLabel lblSubMenu4;
	private JSeparator sprDoc1;
	private JSeparator sprDoc2;
	private JSeparator sprDoc3;
	
	private DanhSachHoaDon_GUI danhSachHoaDon_GUI;
	private DanhSachDatHang_GUI danhSachDatHang_GUI;
	private ThongKe_GUI thongKe_GUI;
	private TrangChu_GUI trangChu_GUI;
	private NhanVien_GUI nhanVien_GUI;
	private KhachHang_GUI khachHang_GUI;
	private Sach_GUI sach_GUI_NhanVien;
	private DungCuHocTap_GUI dungCuHocTap_GUI_NhanVien;
	private HoaDon_GUI hoaDon_GUI_NhanVien;
	private HoSo_GUI hoSo_GUI_NhanVien;
	private DatHang_GUI datHang_GUI_NhanVien;
	private TheLoaiSach_GUI theLoaiSach_GUI_NhanVien;
	private NhaXuatBan_GUI nhaXuatBan_GUI_NhanVien;
	private NhaCungCap_GUI nhaCungCap_GUI_NhanVien;
	private DanhSachHoaDonCho_GUI danhSachHoaDonCho_GUI;
	
	private NhanVien_DAO nhanVien_DAO;
	private PhieuDatHang_DAO phieuDatHang_DAO;
	private KhachHang_DAO khachHang_DAO;
	private TheLoaiSach_DAO theLoaiSach_DAO;
	private NhaXuatBan_DAO nhaXuatBan_DAO;
	private NhaCungCap_DAO nhaCungCap_DAO;
	private HoaDon_DAO hoaDon_DAO;
	private HoaDonCho_DAO hoaDonCho_DAO;
	private Sach_DAO sach_DAO;
	private DungCuHocTap_DAO dungCuHocTap_DAO;
	
	public HeThongQuanLyNhaSach(NhanVien nhanVien) throws SQLException, RemoteException {
		// initialization variable DAO
		nhanVien_DAO = new NhanVien_DAO();
		phieuDatHang_DAO = new PhieuDatHang_DAO();
		khachHang_DAO = new KhachHang_DAO();
		theLoaiSach_DAO = new TheLoaiSach_DAO();
		nhaXuatBan_DAO = new NhaXuatBan_DAO();
		nhaCungCap_DAO = new NhaCungCap_DAO();
		hoaDon_DAO = new HoaDon_DAO();
		hoaDonCho_DAO = new HoaDonCho_DAO();
		sach_DAO = new Sach_DAO();
		dungCuHocTap_DAO = new DungCuHocTap_DAO();

		ExecutorService executor = Executors.newCachedThreadPool();

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(HeThongQuanLyNhaSach.class.getResource("/image/HeThong/favicon.jpg")));
		setForeground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(241, 245, 249));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(1560, 882);
		setResizable(false);
		setTitle("Trang Chủ");
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane.setLayout(null);

		// menu
		JPanel pMenu1 = new JPanel();
		pMenu1.setBackground(new Color(255, 255, 255));
		pMenu1.setBounds(0, 85, 200, 568);
		pMenu1.setLayout(null);

		getContentPane().add(pMenu1);

		lblNhanVien = new JLabel("Nhân Viên");
		lblNhanVien.setBorder(null);
		lblNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNhanVien.setBackground(new Color(24, 39, 60));
				lblNhanVien.setOpaque(true);
				lblIconNhanVien.setBackground(new Color(24, 39, 60));
				lblIconNhanVien.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNhanVien.setBackground(new Color(39, 63, 96));
				lblIconNhanVien.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (nhanVien.getChucVu().equals("Quản lý")) {
					cl_pMain.show(pMain, "NhanVien_GUI");
					lblSubMenu1.setText("Nhân Viên");
					lblSubMenu2.setText("Thống Kê");
					lblSubMenu3.setText("Đặt Hàng");
					lblSubMenu4.setText("Danh Sách Đặt Hàng");
					sprDoc1.setVisible(true);
					sprDoc2.setVisible(true);
					sprDoc3.setVisible(true);
					setTitle("Nhân Viên");
				} else {
					cl_pMain.show(pMain, "ThongKe_GUI");
					lblSubMenu1.setText("Thống Kê");
					lblSubMenu2.setText("Đặt Hàng");
					lblSubMenu3.setText("Danh Sách Đặt Hàng");
					lblSubMenu4.setText("");
					sprDoc1.setVisible(true);
					sprDoc2.setVisible(true);
					sprDoc3.setVisible(false);
					setTitle("Thống Kê");
				}
			}
		});
		lblNhanVien.setForeground(new Color(255, 255, 255));
		lblNhanVien.setBackground(new Color(39, 63, 96));
		lblNhanVien.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhanVien.setBounds(62, 96, 138, 86);
		pMenu1.add(lblNhanVien);

		lblTrangChu = new JLabel("Trang Chủ");
		lblTrangChu.setHorizontalAlignment(SwingConstants.LEFT);
		lblTrangChu.setForeground(Color.WHITE);
		lblTrangChu.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblTrangChu.setBorder(null);
		lblTrangChu.setBackground(new Color(39, 63, 96));
		lblTrangChu.setBounds(62, 0, 138, 86);
		lblTrangChu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTrangChu.setBackground(new Color(24, 39, 60));
				lblTrangChu.setOpaque(true);
				lblIconTrangChu.setBackground(new Color(24, 39, 60));
				lblIconTrangChu.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblTrangChu.setBackground(new Color(39, 63, 96));
				lblIconTrangChu.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cl_pMain.show(pMain, "TrangChu_GUI");
				lblSubMenu1.setText("Trang Chủ");
				lblSubMenu2.setText("");
				lblSubMenu3.setText("");
				lblSubMenu4.setText("");
				sprDoc1.setVisible(false);
				sprDoc2.setVisible(false);
				sprDoc3.setVisible(false);
				setTitle("Trang Chủ");
			}
		});
		pMenu1.add(lblTrangChu);

		lblKhachHang = new JLabel("Khách Hàng");
		lblKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		lblKhachHang.setForeground(Color.WHITE);
		lblKhachHang.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblKhachHang.setBorder(null);
		lblKhachHang.setBackground(new Color(39, 63, 96));
		lblKhachHang.setBounds(62, 192, 138, 86);
		lblKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblKhachHang.setBackground(new Color(24, 39, 60));
				lblKhachHang.setOpaque(true);
				lblIconKhachHang.setBackground(new Color(24, 39, 60));
				lblIconKhachHang.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblKhachHang.setBackground(new Color(39, 63, 96));
				lblIconKhachHang.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cl_pMain.show(pMain, "KhachHang_GUI");
				lblSubMenu1.setText("Khách Hàng");
				lblSubMenu2.setText("");
				lblSubMenu3.setText("");
				lblSubMenu4.setText("");
				sprDoc1.setVisible(false);
				sprDoc2.setVisible(false);
				sprDoc3.setVisible(false);
				setTitle("Khách Hàng");
			}
		});
		pMenu1.add(lblKhachHang);

		lblHoaDon = new JLabel("Hóa Đơn");
		lblHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoaDon.setForeground(Color.WHITE);
		lblHoaDon.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblHoaDon.setBorder(null);
		lblHoaDon.setBackground(new Color(39, 63, 96));
		lblHoaDon.setBounds(62, 480, 138, 86);
		lblHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblHoaDon.setBackground(new Color(24, 39, 60));
				lblHoaDon.setOpaque(true);
				lblIconHoaDon.setBackground(new Color(24, 39, 60));
				lblIconHoaDon.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblHoaDon.setBackground(new Color(39, 63, 96));
				lblIconHoaDon.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cl_pMain.show(pMain, "HoaDon_GUI");
				lblSubMenu1.setText("Hóa Đơn");
				lblSubMenu2.setText("Danh Sách Hóa Đơn Chờ");
				lblSubMenu3.setText("Danh Sách Hóa Đơn");
				lblSubMenu4.setText("");
				sprDoc1.setVisible(true);
				sprDoc2.setVisible(true);
				sprDoc3.setVisible(false);
				setTitle("Hóa Đơn");
			}
		});
		pMenu1.add(lblHoaDon);

		lblSach = new JLabel("Sách");
		lblSach.setHorizontalAlignment(SwingConstants.LEFT);
		lblSach.setForeground(Color.WHITE);
		lblSach.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblSach.setBorder(null);
		lblSach.setBackground(new Color(39, 63, 96));
		lblSach.setBounds(62, 288, 138, 86);
		lblSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSach.setBackground(new Color(24, 39, 60));
				lblSach.setOpaque(true);
				lblIconSach.setBackground(new Color(24, 39, 60));
				lblIconSach.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSach.setBackground(new Color(39, 63, 96));
				lblIconSach.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cl_pMain.show(pMain, "Sach_GUI");
				lblSubMenu1.setText("Sách");
				lblSubMenu2.setText("Loại Sách");
				lblSubMenu3.setText("Nhà Xuất Bản");
				lblSubMenu4.setText("");
				sprDoc1.setVisible(true);
				sprDoc2.setVisible(true);
				sprDoc3.setVisible(false);
				setTitle("Sách");
			}
		});
		pMenu1.add(lblSach);

		lblDungCuHocTap = new JLabel("<html>Dụng Cụ<br>Học Tập</html>");
		lblDungCuHocTap.setToolTipText("Dụng cụ học tập");
		lblDungCuHocTap.setHorizontalAlignment(SwingConstants.LEFT);
		lblDungCuHocTap.setForeground(Color.WHITE);
		lblDungCuHocTap.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblDungCuHocTap.setBorder(null);
		lblDungCuHocTap.setBackground(new Color(39, 63, 96));
		lblDungCuHocTap.setBounds(62, 384, 138, 86);
		lblDungCuHocTap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDungCuHocTap.setBackground(new Color(24, 39, 60));
				lblDungCuHocTap.setOpaque(true);
				lblIconDCHT.setBackground(new Color(24, 39, 60));
				lblIconDCHT.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblDungCuHocTap.setBackground(new Color(39, 63, 96));
				lblIconDCHT.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cl_pMain.show(pMain, "DungCuHocTap_GUI");
				lblSubMenu1.setText("Dụng Cụ Học Tập");
				lblSubMenu2.setText("Nhà Cung Cấp");
				lblSubMenu3.setText("");
				lblSubMenu4.setText("");
				sprDoc1.setVisible(true);
				sprDoc2.setVisible(false);
				sprDoc3.setVisible(false);
				setTitle("Dụng Cụ Học Tập");
			}
		});
		pMenu1.add(lblDungCuHocTap);

		pMain = new JPanel();
		pMain.setBorder(null);
		pMain.setBackground(new Color(77, 77, 77));
		pMain.setBounds(220, 105, 1300, 720);
		getContentPane().add(pMain);
		cl_pMain = new CardLayout();
		pMain.setLayout(cl_pMain);

		danhSachHoaDon_GUI = new DanhSachHoaDon_GUI();
		trangChu_GUI = new TrangChu_GUI(nhanVien);
		thongKe_GUI = new ThongKe_GUI();
		nhanVien_GUI = new NhanVien_GUI(nhanVien);
		khachHang_GUI = new KhachHang_GUI();
		sach_GUI_NhanVien = new Sach_GUI(nhanVien);
		dungCuHocTap_GUI_NhanVien = new DungCuHocTap_GUI(nhanVien);
		hoSo_GUI_NhanVien = new HoSo_GUI(nhanVien);
		theLoaiSach_GUI_NhanVien = new TheLoaiSach_GUI(nhanVien);
		nhaXuatBan_GUI_NhanVien = new NhaXuatBan_GUI(nhanVien);
		nhaCungCap_GUI_NhanVien = new NhaCungCap_GUI(nhanVien);
		danhSachDatHang_GUI = new DanhSachDatHang_GUI(danhSachHoaDon_GUI, trangChu_GUI);
		datHang_GUI_NhanVien = new DatHang_GUI(nhanVien, danhSachDatHang_GUI);
		danhSachHoaDonCho_GUI = new DanhSachHoaDonCho_GUI(cl_pMain, pMain, sach_GUI_NhanVien, dungCuHocTap_GUI_NhanVien);
		hoaDon_GUI_NhanVien = new HoaDon_GUI(nhanVien, danhSachHoaDon_GUI, danhSachHoaDonCho_GUI, thongKe_GUI, trangChu_GUI);
		
		/**
		 * Thêm các giao diện vào CardLayout
		 * Lưu ý: Không được thay đổi thứ tự thêm các giao diện vào CardLayout bởi vì có sử dụng getComponent() để lấy giao diện con từ giao diện chính
		 */
		// main menu
		pMain.add(trangChu_GUI, "TrangChu_GUI");
		pMain.add(nhanVien_GUI, "NhanVien_GUI");
		pMain.add(khachHang_GUI, "KhachHang_GUI");
		pMain.add(sach_GUI_NhanVien, "Sach_GUI");
		pMain.add(dungCuHocTap_GUI_NhanVien, "DungCuHocTap_GUI");
		pMain.add(hoaDon_GUI_NhanVien, "HoaDon_GUI");
		pMain.add(hoSo_GUI_NhanVien, "HoSo_GUI");
		// sub menu
		pMain.add(thongKe_GUI, "ThongKe_GUI");
		pMain.add(datHang_GUI_NhanVien, "DatHang_GUI");
		pMain.add(danhSachDatHang_GUI, "DanhSachDatHang_GUI");
		pMain.add(theLoaiSach_GUI_NhanVien, "TheLoaiSach_GUI");
		pMain.add(nhaXuatBan_GUI_NhanVien, "NhaXuatBan_GUI");
		pMain.add(nhaCungCap_GUI_NhanVien, "NhaCungCap_GUI");
		pMain.add(danhSachHoaDon_GUI, "DanhSachHoaDon_GUI");
		pMain.add(danhSachHoaDonCho_GUI, "DanhSachHoaDonCho_GUI");
		// mac dinh hien thi giao dien trang chu dau tien
		cl_pMain.show(pMain, "TrangChu_GUI");

		JPanel pMenu2 = new JPanel();
		pMenu2.setBackground(new Color(255, 255, 255));
		pMenu2.setBounds(0, 673, 200, 172);
		contentPane.add(pMenu2);
		pMenu2.setLayout(null);

		lblDangXuat = new JLabel("Đăng Xuất");
		lblDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
		lblDangXuat.setForeground(Color.WHITE);
		lblDangXuat.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblDangXuat.setBorder(null);
		lblDangXuat.setBackground(new Color(39, 63, 96));
		lblDangXuat.setBounds(62, 86, 138, 86);
		lblDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDangXuat.setBackground(new Color(24, 39, 60));
				lblDangXuat.setOpaque(true);
				lblIconDangXuat.setBackground(new Color(24, 39, 60));
				lblIconDangXuat.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblDangXuat.setBackground(new Color(39, 63, 96));
				lblIconDangXuat.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Bạn có thực sự muốn thoát?", "Thoát?",
						JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					HeThongQuanLyNhaSach heThongQuanLyNhaSach;
					try {
						heThongQuanLyNhaSach = new HeThongQuanLyNhaSach();
						heThongQuanLyNhaSach.setVisible(true);
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					setVisible(false);
				}
			}
		});
		pMenu2.add(lblDangXuat);

		// set mau cho menu
		lblTrangChu.setOpaque(true);
		lblNhanVien.setOpaque(true);
		lblKhachHang.setOpaque(true);
		lblSach.setOpaque(true);
		lblDungCuHocTap.setOpaque(true);
		lblHoaDon.setOpaque(true);

		lblIconTrangChu = new JLabel("");
		lblIconTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconTrangChu.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/HeThong/home.png")));
		lblIconTrangChu.setBounds(0, 0, 64, 86);
		lblIconTrangChu.setOpaque(true);
		lblIconTrangChu.setBackground(new Color(39, 63, 96));
		lblIconTrangChu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTrangChu.setBackground(new Color(24, 39, 60));
				lblTrangChu.setOpaque(true);
				lblIconTrangChu.setBackground(new Color(24, 39, 60));
				lblIconTrangChu.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblTrangChu.setBackground(new Color(39, 63, 96));
				lblIconTrangChu.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cl_pMain.show(pMain, "TrangChu_GUI");
				lblSubMenu1.setText("Trang Chủ");
				lblSubMenu2.setText("");
				lblSubMenu3.setText("");
				lblSubMenu4.setText("");
				sprDoc1.setVisible(false);
				sprDoc2.setVisible(false);
				sprDoc3.setVisible(false);
				setTitle("Trang Chủ");
			}
		});
		pMenu1.add(lblIconTrangChu);

		lblIconNhanVien = new JLabel("");
		lblIconNhanVien.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/HeThong/staff.png")));
		lblIconNhanVien.setOpaque(true);
		lblIconNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconNhanVien.setBackground(new Color(39, 63, 96));
		lblIconNhanVien.setBounds(0, 96, 64, 86);
		lblIconNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNhanVien.setBackground(new Color(24, 39, 60));
				lblNhanVien.setOpaque(true);
				lblIconNhanVien.setBackground(new Color(24, 39, 60));
				lblIconNhanVien.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNhanVien.setBackground(new Color(39, 63, 96));
				lblIconNhanVien.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (nhanVien.getChucVu().equals("Quản lý")) {
					cl_pMain.show(pMain, "NhanVien_GUI");
					lblSubMenu1.setText("Nhân Viên");
					lblSubMenu2.setText("Thống Kê");
					lblSubMenu3.setText("Đặt Hàng");
					lblSubMenu4.setText("Danh Sách Đặt Hàng");
					sprDoc1.setVisible(true);
					sprDoc2.setVisible(true);
					sprDoc3.setVisible(true);
					setTitle("Nhân Viên");
				} else {
					cl_pMain.show(pMain, "ThongKe_GUI");
					lblSubMenu1.setText("Thống Kê");
					lblSubMenu2.setText("Đặt Hàng");
					lblSubMenu3.setText("Danh Sách Đặt Hàng");
					lblSubMenu4.setText("");
					sprDoc1.setVisible(true);
					sprDoc2.setVisible(true);
					sprDoc3.setVisible(false);
					setTitle("Thống Kê");
				}
			}
		});
		pMenu1.add(lblIconNhanVien);

		lblIconKhachHang = new JLabel("");
		lblIconKhachHang.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/HeThong/customer.png")));
		lblIconKhachHang.setOpaque(true);
		lblIconKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconKhachHang.setBackground(new Color(39, 63, 96));
		lblIconKhachHang.setBounds(0, 192, 64, 86);
		lblIconKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblKhachHang.setBackground(new Color(24, 39, 60));
				lblKhachHang.setOpaque(true);
				lblIconKhachHang.setBackground(new Color(24, 39, 60));
				lblIconKhachHang.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblKhachHang.setBackground(new Color(39, 63, 96));
				lblIconKhachHang.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cl_pMain.show(pMain, "KhachHang_GUI");
				lblSubMenu1.setText("Khách Hàng");
				lblSubMenu2.setText("");
				lblSubMenu3.setText("");
				lblSubMenu4.setText("");
				sprDoc1.setVisible(false);
				sprDoc2.setVisible(false);
				sprDoc3.setVisible(false);
				setTitle("Khách Hàng");
			}
		});
		pMenu1.add(lblIconKhachHang);

		lblIconSach = new JLabel("");
		lblIconSach.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/HeThong/book.png")));
		lblIconSach.setOpaque(true);
		lblIconSach.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconSach.setBackground(new Color(39, 63, 96));
		lblIconSach.setBounds(0, 288, 64, 86);
		lblIconSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSach.setBackground(new Color(24, 39, 60));
				lblSach.setOpaque(true);
				lblIconSach.setBackground(new Color(24, 39, 60));
				lblIconSach.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSach.setBackground(new Color(39, 63, 96));
				lblIconSach.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cl_pMain.show(pMain, "Sach_GUI");
				lblSubMenu1.setText("Sách");
				lblSubMenu2.setText("Loại Sách");
				lblSubMenu3.setText("Nhà Xuất Bản");
				lblSubMenu4.setText("");
				sprDoc1.setVisible(true);
				sprDoc2.setVisible(true);
				sprDoc3.setVisible(false);
				setTitle("Sách");
			}
		});
		pMenu1.add(lblIconSach);

		lblIconDCHT = new JLabel("");
		lblIconDCHT.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/HeThong/pen.png")));
		lblIconDCHT.setOpaque(true);
		lblIconDCHT.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDCHT.setBackground(new Color(39, 63, 96));
		lblIconDCHT.setBounds(0, 384, 64, 86);
		lblIconDCHT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDungCuHocTap.setBackground(new Color(24, 39, 60));
				lblDungCuHocTap.setOpaque(true);
				lblIconDCHT.setBackground(new Color(24, 39, 60));
				lblIconDCHT.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblDungCuHocTap.setBackground(new Color(39, 63, 96));
				lblIconDCHT.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cl_pMain.show(pMain, "DungCuHocTap_GUI");
				lblSubMenu1.setText("Dụng Cụ Học Tập");
				lblSubMenu2.setText("Nhà Cung Cấp");
				lblSubMenu3.setText("");
				lblSubMenu4.setText("");
				sprDoc1.setVisible(true);
				sprDoc2.setVisible(false);
				sprDoc3.setVisible(false);
				setTitle("Dụng Cụ Học Tập");
			}
		});
		pMenu1.add(lblIconDCHT);

		lblIconHoaDon = new JLabel("");
		lblIconHoaDon.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/HeThong/bill.png")));
		lblIconHoaDon.setOpaque(true);
		lblIconHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconHoaDon.setBackground(new Color(39, 63, 96));
		lblIconHoaDon.setBounds(0, 480, 64, 86);
		lblIconHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblHoaDon.setBackground(new Color(24, 39, 60));
				lblHoaDon.setOpaque(true);
				lblIconHoaDon.setBackground(new Color(24, 39, 60));
				lblIconHoaDon.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblHoaDon.setBackground(new Color(39, 63, 96));
				lblIconHoaDon.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cl_pMain.show(pMain, "HoaDon_GUI");
				lblSubMenu1.setText("Hóa Đơn");
				lblSubMenu2.setText("Danh Sách Hóa Đơn Chờ");
				lblSubMenu3.setText("Danh Sách Hóa Đơn");
				lblSubMenu4.setText("");
				sprDoc1.setVisible(true);
				sprDoc2.setVisible(true);
				sprDoc3.setVisible(false);
				setTitle("Hóa Đơn");
			}
		});
		pMenu1.add(lblIconHoaDon);

		lblDangXuat.setOpaque(true);
		lblHoSo = new JLabel("Hồ Sơ");
		lblHoSo.setBounds(62, 0, 138, 86);
		pMenu2.add(lblHoSo);
		lblHoSo.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoSo.setForeground(Color.WHITE);
		lblHoSo.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblHoSo.setBorder(null);
		lblHoSo.setBackground(new Color(39, 63, 96));
		lblHoSo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblHoSo.setBackground(new Color(24, 39, 60));
				lblHoSo.setOpaque(true);
				lblIconHoSo.setBackground(new Color(24, 39, 60));
				lblIconHoSo.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblHoSo.setBackground(new Color(39, 63, 96));
				lblIconHoSo.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cl_pMain.show(pMain, "HoSo_GUI");
				lblSubMenu1.setText("Hồ Sơ");
				lblSubMenu2.setText("");
				lblSubMenu3.setText("");
				lblSubMenu4.setText("");
				sprDoc1.setVisible(false);
				sprDoc2.setVisible(false);
				sprDoc3.setVisible(false);
				setTitle("Hồ Sơ");
			}
		});
		lblHoSo.setOpaque(true);

		lblIconHoSo = new JLabel("");
		lblIconHoSo.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/HeThong/user.png")));
		lblIconHoSo.setOpaque(true);
		lblIconHoSo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconHoSo.setBackground(new Color(39, 63, 96));
		lblIconHoSo.setBounds(0, 0, 64, 86);
		lblIconHoSo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblHoSo.setBackground(new Color(24, 39, 60));
				lblHoSo.setOpaque(true);
				lblIconHoSo.setBackground(new Color(24, 39, 60));
				lblIconHoSo.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblHoSo.setBackground(new Color(39, 63, 96));
				lblIconHoSo.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cl_pMain.show(pMain, "HoSo_GUI");
				lblSubMenu1.setText("Hồ Sơ");
				lblSubMenu2.setText("");
				lblSubMenu3.setText("");
				lblSubMenu4.setText("");
				sprDoc1.setVisible(false);
				sprDoc2.setVisible(false);
				sprDoc3.setVisible(false);
				setTitle("Hồ Sơ");
			}
		});
		pMenu2.add(lblIconHoSo);

		lblIconDangXuat = new JLabel("");
		lblIconDangXuat.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/HeThong/logout.png")));
		lblIconDangXuat.setOpaque(true);
		lblIconDangXuat.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDangXuat.setBackground(new Color(39, 63, 96));
		lblIconDangXuat.setBounds(0, 86, 64, 86);
		lblIconDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDangXuat.setBackground(new Color(24, 39, 60));
				lblDangXuat.setOpaque(true);
				lblIconDangXuat.setBackground(new Color(24, 39, 60));
				lblIconDangXuat.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblDangXuat.setBackground(new Color(39, 63, 96));
				lblIconDangXuat.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Bạn có thực sự muốn thoát?", "Thoát?",
						JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					HeThongQuanLyNhaSach heThongQuanLyNhaSach;
					try {
						heThongQuanLyNhaSach = new HeThongQuanLyNhaSach();
						heThongQuanLyNhaSach.setVisible(true);
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					setVisible(false);
				}
			}
		});
		pMenu2.add(lblIconDangXuat);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/HeThong/logo.png")));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogo.setBounds(58, 0, 93, 85);
		contentPane.add(lblLogo);

		Rectangle viTriMenuCon1 = new Rectangle(220, 15, 275, 55);
		Rectangle viTriMenuCon2 = new Rectangle(544, 15, 275, 55);
		Rectangle viTriMenuCon3 = new Rectangle(864, 15, 275, 55);
		Rectangle viTriMenuCon4 = new Rectangle(1180, 15, 275, 55);

		lblSubMenu1 = new JLabel();
		lblSubMenu1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSubMenu1.setBackground(new Color(39, 63, 96));
				lblSubMenu1.setForeground(new Color(255, 255, 255));
				lblSubMenu1.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSubMenu1.setBackground(new Color(241, 245, 249));
				lblSubMenu1.setForeground(new Color(0, 0, 0));
				lblSubMenu1.setOpaque(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblSubMenu1.getText().equals("Nhân Viên")) {
					cl_pMain.show(pMain, "NhanVien_GUI");
					setTitle("Nhân Viên");
				}

				else if (lblSubMenu1.getText().equals("Sách")) {
					cl_pMain.show(pMain, "Sach_GUI");
					setTitle("Sách");
				}

				else if (lblSubMenu1.getText().equals("Dụng Cụ Học Tập")) {
					cl_pMain.show(pMain, "DungCuHocTap_GUI");
					setTitle("Dụng Cụ Học Tập");
				}

				else if (lblSubMenu1.getText().equals("Hóa Đơn")) {
					cl_pMain.show(pMain, "HoaDon_GUI");
					setTitle("Hóa Đơn");
				}

				else if (lblSubMenu1.getText().equals("Thống Kê")) {
					cl_pMain.show(pMain, "ThongKe_GUI");
					setTitle("Thống Kê");
				}
			}
		});
		lblSubMenu1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubMenu1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubMenu1.setBounds(viTriMenuCon1.getBounds());
		lblSubMenu1.setVisible(true);
		lblSubMenu1.setText("Trang Chủ");
		contentPane.add(lblSubMenu1);

		sprDoc1 = new JSeparator();
		sprDoc1.setForeground(new Color(60, 60, 60));
		sprDoc1.setOrientation(SwingConstants.VERTICAL);
		sprDoc1.setBounds(520, 15, 2, 55);
		sprDoc1.setVisible(false);
		contentPane.add(sprDoc1);

		lblSubMenu2 = new JLabel();
		lblSubMenu2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (!lblSubMenu2.getText().equals("")) {
					lblSubMenu2.setBackground(new Color(39, 63, 96));
					lblSubMenu2.setForeground(new Color(255, 255, 255));
					lblSubMenu2.setOpaque(true);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!lblSubMenu2.getText().equals("")) {
					lblSubMenu2.setBackground(new Color(241, 245, 249));
					lblSubMenu2.setForeground(new Color(0, 0, 0));
					lblSubMenu2.setOpaque(true);
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblSubMenu2.getText().equals("Thống Kê")) {
					cl_pMain.show(pMain, "ThongKe_GUI");
					setTitle("Thống Kê");
				} else if (lblSubMenu2.getText().equals("Loại Sách")) {
					cl_pMain.show(pMain, "TheLoaiSach_GUI");
					setTitle("Loại Sách");
				} else if (lblSubMenu2.getText().equals("Nhà Cung Cấp")) {
					cl_pMain.show(pMain, "NhaCungCap_GUI");
					setTitle("Nhà Cung Cấp");
				} else if (lblSubMenu2.getText().equals("Danh Sách Hóa Đơn Chờ")) {
					cl_pMain.show(pMain, "DanhSachHoaDonCho_GUI");
					setTitle("Danh Sách Hóa Đơn Chờ");
				} else if (lblSubMenu2.getText().equals("Đặt Hàng")) {
					cl_pMain.show(pMain, "DatHang_GUI");
					setTitle("Đặt Hàng");
				}
			}
		});
		lblSubMenu2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubMenu2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubMenu2.setBounds(viTriMenuCon2.getBounds());
		contentPane.add(lblSubMenu2);

		sprDoc2 = new JSeparator();
		sprDoc2.setForeground(new Color(60, 60, 60));
		sprDoc2.setOrientation(SwingConstants.VERTICAL);
		sprDoc2.setBounds(842, 15, 2, 55);
		sprDoc2.setVisible(false);
		contentPane.add(sprDoc2);

		lblSubMenu3 = new JLabel();
		lblSubMenu3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (!lblSubMenu3.getText().equals("")) {
					lblSubMenu3.setBackground(new Color(39, 63, 96));
					lblSubMenu3.setForeground(new Color(255, 255, 255));
					lblSubMenu3.setOpaque(true);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!lblSubMenu3.getText().equals("")) {
					lblSubMenu3.setBackground(new Color(241, 245, 249));
					lblSubMenu3.setForeground(new Color(0, 0, 0));
					lblSubMenu3.setOpaque(true);
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblSubMenu3.getText().equals("Đặt Hàng")) {
					cl_pMain.show(pMain, "DatHang_GUI");
					setTitle("Đặt Hàng");
				}

				else if (lblSubMenu3.getText().equals("Nhà Xuất Bản")) {
					cl_pMain.show(pMain, "NhaXuatBan_GUI");
					setTitle("Nhà Xuất Bản");
				}

				else if (lblSubMenu3.getText().equals("Danh Sách Đặt Hàng")) {
					cl_pMain.show(pMain, "DanhSachDatHang_GUI");
					setTitle("Danh Sách Đặt Hàng");
				}
				
				else if (lblSubMenu3.getText().equals("Danh Sách Hóa Đơn")) {
					cl_pMain.show(pMain, "DanhSachHoaDon_GUI");
					setTitle("Danh Sách Hóa Đơn");
				}
			}
		});
		lblSubMenu3.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubMenu3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubMenu3.setBounds(viTriMenuCon3.getBounds());
		contentPane.add(lblSubMenu3);

		sprDoc3 = new JSeparator();
		sprDoc3.setForeground(new Color(60, 60, 60));
		sprDoc3.setOrientation(SwingConstants.VERTICAL);
		sprDoc3.setBounds(1159, 15, 2, 55);
		sprDoc3.setVisible(false);
		contentPane.add(sprDoc3);

		lblSubMenu4 = new JLabel();
		lblSubMenu4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (!lblSubMenu4.getText().equals("")) {
					lblSubMenu4.setBackground(new Color(39, 63, 96));
					lblSubMenu4.setForeground(new Color(255, 255, 255));
					lblSubMenu4.setOpaque(true);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!lblSubMenu4.getText().equals("")) {
					lblSubMenu4.setBackground(new Color(241, 245, 249));
					lblSubMenu4.setForeground(new Color(0, 0, 0));
					lblSubMenu4.setOpaque(true);
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblSubMenu4.getText().equals("Danh Sách Đặt Hàng")) {
					cl_pMain.show(pMain, "DanhSachDatHang_GUI");
					setTitle("Danh Sách Đặt Hàng");
				}
			}
		});
		lblSubMenu4.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubMenu4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubMenu4.setBounds(viTriMenuCon4.getBounds());
		contentPane.add(lblSubMenu4);

		JSeparator sprNgang = new JSeparator();
		sprNgang.setBounds(220, 85, 1300, 2);
		sprNgang.setForeground(new Color(60, 60, 60));
		contentPane.add(sprNgang);

		Runnable loadDataNhanVien = () -> {
			try {
				nhanVien_GUI.loadData(nhanVien_DAO.getAllNhanVien());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		};

		Runnable loadDataThongKe = () -> {
			try {
				thongKe_GUI.showAllChart();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		};

		Runnable loadDataDanhSachDatHang = () -> {
			try {
				danhSachDatHang_GUI.loadData(phieuDatHang_DAO.getAllPhieuDatHang());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		};

		Runnable loadDataKhachHang = () -> {
			try {
				khachHang_GUI.loadData(khachHang_DAO.getAllKhachHang());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		};

		Runnable loadDataSach_NhanVien = () -> {
			try {
				sach_GUI_NhanVien.loadData(sach_DAO.getAllSach());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		};

		Runnable loadDataTheLoaiSach = () -> {
			try {
				theLoaiSach_GUI_NhanVien.loadData(theLoaiSach_DAO.getAllTheLoaiSach());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		};

		Runnable loadDataNhaXuatBan_NhanVien = () -> {
			nhaXuatBan_GUI_NhanVien.loadData(nhaXuatBan_DAO.getAllNhaXuatBan());
		};

		Runnable loadDataDungCuHocTap_NhanVien = () -> {
			try {
				dungCuHocTap_GUI_NhanVien.loadData(dungCuHocTap_DAO.getAllDungCuHocTap());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		};

		Runnable loadDataNhaCungCap_NhanVien = () -> {
			nhaCungCap_GUI_NhanVien.loadData(nhaCungCap_DAO.getAllNhaCungCap());
		};

		Runnable loadDataHoaDon = () -> {
			try {
				danhSachHoaDon_GUI.loadData(hoaDon_DAO.getAllHoaDon());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		};
		
		Runnable loadDataHoaDonCho = () -> {
			try {
				danhSachHoaDonCho_GUI.loadData(hoaDonCho_DAO.getAllHoaDonCho());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		};

		executor.execute(loadDataNhanVien);
		executor.execute(loadDataThongKe);
		executor.execute(loadDataDanhSachDatHang);
		executor.execute(loadDataKhachHang);
		executor.execute(loadDataSach_NhanVien);
		executor.execute(loadDataTheLoaiSach);
		executor.execute(loadDataNhaXuatBan_NhanVien);
		executor.execute(loadDataDungCuHocTap_NhanVien);
		executor.execute(loadDataNhaCungCap_NhanVien);
		executor.execute(loadDataHoaDon);
		executor.execute(loadDataHoaDonCho);
		executor.shutdown();
	}

	public HeThongQuanLyNhaSach() throws RemoteException {
		// khai bao DAO
		nhaXuatBan_DAO = new NhaXuatBan_DAO();
		theLoaiSach_DAO = new TheLoaiSach_DAO();
		nhaCungCap_DAO = new NhaCungCap_DAO();
		sach_DAO = new Sach_DAO();
		dungCuHocTap_DAO = new DungCuHocTap_DAO();
		
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(HeThongQuanLyNhaSach.class.getResource("/image/HeThong/favicon.jpg")));
		setForeground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(241, 245, 249));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(1560, 882);
		setResizable(false);
		setTitle("Trang Chủ");
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane.setLayout(null);

		// menu
		JPanel pMenu1 = new JPanel();
		pMenu1.setBackground(new Color(255, 255, 255));
		pMenu1.setBounds(0, 85, 200, 183);
		pMenu1.setLayout(null);

		getContentPane().add(pMenu1);

		lblSach = new JLabel("Sách");
		lblSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSach.setBackground(new Color(24, 39, 60));
				lblSach.setOpaque(true);
				lblIconSach.setBackground(new Color(24, 39, 60));
				lblIconSach.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSach.setBackground(new Color(39, 63, 96));
				lblIconSach.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cl_pMain.show(pMain, "Sach_GUI");
				lblSubMenu1.setText("Sách");
				lblSubMenu2.setText("Loại Sách");
				lblSubMenu3.setText("Nhà Xuất Bản");
				sprDoc1.setVisible(true);
				sprDoc2.setVisible(true);
				setTitle("Sách");
			}
		});
		lblSach.setHorizontalAlignment(SwingConstants.LEFT);
		lblSach.setForeground(Color.WHITE);
		lblSach.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblSach.setBorder(null);
		lblSach.setBackground(new Color(39, 63, 96));
		lblSach.setBounds(62, 0, 138, 86);
		pMenu1.add(lblSach);

		lblDungCuHocTap = new JLabel("<html>Dụng Cụ<br>Học Tập</html>");
		lblDungCuHocTap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDungCuHocTap.setBackground(new Color(24, 39, 60));
				lblDungCuHocTap.setOpaque(true);
				lblIconDCHT.setBackground(new Color(24, 39, 60));
				lblIconDCHT.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblDungCuHocTap.setBackground(new Color(39, 63, 96));
				lblIconDCHT.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cl_pMain.show(pMain, "DungCuHocTap_GUI");
				lblSubMenu1.setText("Dụng Cụ Học Tập");
				lblSubMenu2.setText("Nhà Cung Cấp");
				lblSubMenu3.setText("");
				sprDoc1.setVisible(true);
				sprDoc2.setVisible(false);
				setTitle("Dụng Cụ Học Tập");
			}
		});
		lblDungCuHocTap.setToolTipText("Dụng cụ học tập");
		lblDungCuHocTap.setHorizontalAlignment(SwingConstants.LEFT);
		lblDungCuHocTap.setForeground(Color.WHITE);
		lblDungCuHocTap.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblDungCuHocTap.setBorder(null);
		lblDungCuHocTap.setBackground(new Color(39, 63, 96));
		lblDungCuHocTap.setBounds(62, 96, 138, 86);
		pMenu1.add(lblDungCuHocTap);

		pMain = new JPanel();
		pMain.setBorder(null);
		pMain.setBackground(new Color(77, 77, 77));
		pMain.setBounds(220, 105, 1300, 720);
		getContentPane().add(pMain);

		cl_pMain = new CardLayout();
		pMain.setLayout(cl_pMain);
		
		Sach_GUI sach_GUI = new Sach_GUI();
		DungCuHocTap_GUI dungCuHocTap_GUI = new DungCuHocTap_GUI();
		NhaXuatBan_GUI nhaXuatBan_GUI = new NhaXuatBan_GUI();
		TheLoaiSach_GUI theLoaiSach_GUI = new TheLoaiSach_GUI();
		NhaCungCap_GUI nhaCungCap_GUI = new NhaCungCap_GUI();
		
		// menu
		pMain.add(sach_GUI, "Sach_GUI");
		pMain.add(dungCuHocTap_GUI, "DungCuHocTap_GUI");
		// sub menu
		pMain.add(nhaXuatBan_GUI, "NhaXuatBan_GUI");
		pMain.add(theLoaiSach_GUI, "TheLoaiSach_GUI");
		pMain.add(nhaCungCap_GUI, "NhaCungCap_GUI");
		cl_pMain.show(pMain, "Sach_GUI");

		// set mau cho menu
		lblSach.setOpaque(true);
		lblDungCuHocTap.setOpaque(true);

		lblIconSach = new JLabel("");
		lblIconSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSach.setBackground(new Color(24, 39, 60));
				lblSach.setOpaque(true);
				lblIconSach.setBackground(new Color(24, 39, 60));
				lblIconSach.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSach.setBackground(new Color(39, 63, 96));
				lblIconSach.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cl_pMain.show(pMain, "Sach_GUI");
				lblSubMenu1.setText("Sách");
				lblSubMenu2.setText("Loại Sách");
				lblSubMenu3.setText("Nhà Xuất Bản");
				sprDoc1.setVisible(true);
				sprDoc2.setVisible(true);
				setTitle("Sách");
			}
		});
		lblIconSach.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/HeThong/book.png")));
		lblIconSach.setOpaque(true);
		lblIconSach.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconSach.setBackground(new Color(39, 63, 96));
		lblIconSach.setBounds(0, 0, 64, 86);
		pMenu1.add(lblIconSach);

		lblIconDCHT = new JLabel("");
		lblIconDCHT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDungCuHocTap.setBackground(new Color(24, 39, 60));
				lblDungCuHocTap.setOpaque(true);
				lblIconDCHT.setBackground(new Color(24, 39, 60));
				lblIconDCHT.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblDungCuHocTap.setBackground(new Color(39, 63, 96));
				lblIconDCHT.setBackground(new Color(39, 63, 96));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cl_pMain.show(pMain, "DungCuHocTap_GUI");
				lblSubMenu1.setText("Dụng Cụ Học Tập");
				lblSubMenu2.setText("Nhà Cung Cấp");
				lblSubMenu3.setText("");
				sprDoc1.setVisible(true);
				sprDoc2.setVisible(false);
				setTitle("Dụng Cụ Học Tập");
			}
		});
		lblIconDCHT.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/HeThong/pen.png")));
		lblIconDCHT.setOpaque(true);
		lblIconDCHT.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDCHT.setBackground(new Color(39, 63, 96));
		lblIconDCHT.setBounds(0, 96, 64, 86);
		pMenu1.add(lblIconDCHT);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(HeThongQuanLyNhaSach.class.getResource("/image/HeThong/logo.png")));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogo.setBounds(58, 0, 93, 85);
		contentPane.add(lblLogo);

		Rectangle viTriMenuCon1 = new Rectangle(220, 15, 275, 55);
		Rectangle viTriMenuCon2 = new Rectangle(544, 15, 275, 55);
		Rectangle viTriMenuCon3 = new Rectangle(864, 15, 275, 55);

		lblSubMenu1 = new JLabel();
		lblSubMenu1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSubMenu1.setBackground(new Color(39, 63, 96));
				lblSubMenu1.setForeground(new Color(255, 255, 255));
				lblSubMenu1.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSubMenu1.setBackground(new Color(241, 245, 249));
				lblSubMenu1.setForeground(new Color(0, 0, 0));
				lblSubMenu1.setOpaque(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblSubMenu1.getText().equals("Sách")) {
					cl_pMain.show(pMain, "Sach_GUI");
					setTitle("Sách");
				}

				else if (lblSubMenu1.getText().equals("Dụng Cụ Học Tập")) {
					cl_pMain.show(pMain, "DungCuHocTap_GUI");
					setTitle("Dụng Cụ Học Tập");
				}
			}
		});
		lblSubMenu1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubMenu1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubMenu1.setBounds(viTriMenuCon1.getBounds());
		lblSubMenu1.setVisible(true);
		lblSubMenu1.setText("Sách");
		contentPane.add(lblSubMenu1);

		sprDoc1 = new JSeparator();
		sprDoc1.setForeground(new Color(60, 60, 60));
		sprDoc1.setOrientation(SwingConstants.VERTICAL);
		sprDoc1.setBounds(520, 15, 2, 55);
		contentPane.add(sprDoc1);

		lblSubMenu2 = new JLabel();
		lblSubMenu2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (!lblSubMenu2.getText().equals("")) {
					lblSubMenu2.setBackground(new Color(39, 63, 96));
					lblSubMenu2.setForeground(new Color(255, 255, 255));
					lblSubMenu2.setOpaque(true);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!lblSubMenu2.getText().equals("")) {
					lblSubMenu2.setBackground(new Color(241, 245, 249));
					lblSubMenu2.setForeground(new Color(0, 0, 0));
					lblSubMenu2.setOpaque(true);
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblSubMenu2.getText().equals("Loại Sách")) {
					cl_pMain.show(pMain, "TheLoaiSach_GUI");
					setTitle("Loại Sách");
				}

				else if (lblSubMenu2.getText().equals("Nhà Cung Cấp")) {
					cl_pMain.show(pMain, "NhaCungCap_GUI");
					setTitle("Nhà Cung Cấp");
				}

			}
		});
		lblSubMenu2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubMenu2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubMenu2.setBounds(viTriMenuCon2.getBounds());
		lblSubMenu2.setText("Loại Sách");
		contentPane.add(lblSubMenu2);

		sprDoc2 = new JSeparator();
		sprDoc2.setForeground(new Color(60, 60, 60));
		sprDoc2.setOrientation(SwingConstants.VERTICAL);
		sprDoc2.setBounds(842, 15, 2, 55);
		contentPane.add(sprDoc2);

		lblSubMenu3 = new JLabel();
		lblSubMenu3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (!lblSubMenu3.getText().equals("")) {
					lblSubMenu3.setBackground(new Color(39, 63, 96));
					lblSubMenu3.setForeground(new Color(255, 255, 255));
					lblSubMenu3.setOpaque(true);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!lblSubMenu3.getText().equals("")) {
					lblSubMenu3.setBackground(new Color(241, 245, 249));
					lblSubMenu3.setForeground(new Color(0, 0, 0));
					lblSubMenu3.setOpaque(true);
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblSubMenu3.getText().equals("Nhà Xuất Bản")) {
					cl_pMain.show(pMain, "NhaXuatBan_GUI");
					setTitle("Nhà Xuất Bản");
				}
			}
		});
		lblSubMenu3.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubMenu3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubMenu3.setBounds(viTriMenuCon3.getBounds());
		lblSubMenu3.setText("Nhà Xuất Bản");
		contentPane.add(lblSubMenu3);

		JSeparator sprNgang = new JSeparator();
		sprNgang.setBounds(220, 85, 1300, 2);
		sprNgang.setForeground(new Color(60, 60, 60));
		contentPane.add(sprNgang);

		JButton btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnDangNhap.setBackground(new Color(73, 129, 158));
		btnDangNhap.setBounds(1348, 15, 172, 55);
		btnDangNhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DangNhap_GUI dangNhap_GUI;
				try {
					dangNhap_GUI = new DangNhap_GUI();
					dangNhap_GUI.setVisible(true);
				} catch (SQLException | RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnDangNhap);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		Runnable loadDataSach = () -> {
			try {
				sach_GUI.loadData_KhachHang(sach_DAO.getAllSach());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		};
		
		Runnable loadDataDungCuHocTap = () -> {
			try {
				dungCuHocTap_GUI.loadData_KhachHang(dungCuHocTap_DAO.getAllDungCuHocTap());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		};
		
		Runnable loadDataNhaXuatBan = () -> {
			nhaXuatBan_GUI.loadData(nhaXuatBan_DAO.getAllNhaXuatBan());
		};
		
		Runnable loadDataTheLoaiSach = () -> {
			try {
				theLoaiSach_GUI.loadData(theLoaiSach_DAO.getAllTheLoaiSach());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		};
		
		Runnable loadDataNhaCungCap = () -> {
			nhaCungCap_GUI.loadData(nhaCungCap_DAO.getAllNhaCungCap());
		};
		
		executor.execute(loadDataSach);
		executor.execute(loadDataDungCuHocTap);
		executor.execute(loadDataNhaXuatBan);
		executor.execute(loadDataTheLoaiSach);
		executor.execute(loadDataNhaCungCap);
		executor.shutdown();
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatMacLightLaf());
			HeThongQuanLyNhaSach heThongQuanLyNhaSach = new HeThongQuanLyNhaSach();
			heThongQuanLyNhaSach.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("Failed to initialize LaF");
		}
	}
}
