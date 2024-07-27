package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.ChiTietHoaDonCho_DAO;
import dao.HoaDonCho_DAO;
import dao.NhanVien_DAO;
import dao.SanPham_DAO;
import entity.ChiTietHoaDonCho;
import entity.HoaDonCho;

public class DanhSachHoaDonCho_GUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelDanhSachHoaDon;
	private JTable tableDanhSachHoaDon;
	private JTableHeader tableHeader;
	private DefaultTableModel modelChiTietHoaDon;
	private JTable tableChiTietHoaDon;
	private JTableHeader tableHeaderChiTietHoaDon;
	private JScrollPane scrChiTietHoaDon;
	
	private NhanVien_DAO nhanVien_DAO;
	private HoaDonCho_DAO hoaDonCho_DAO;
	private SanPham_DAO sanPham_DAO;
	private ChiTietHoaDonCho_DAO chiTietHoaDonCho_DAO;
	
	private Sach_GUI sach_GUI;
	private DungCuHocTap_GUI dungCuHocTap_GUI;

	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public DanhSachHoaDonCho_GUI(CardLayout cardLayout, JPanel pMain, Sach_GUI sach_GUI, DungCuHocTap_GUI dungCuHocTap_GUI) throws RemoteException {
		nhanVien_DAO = new NhanVien_DAO();
		sanPham_DAO = new SanPham_DAO();
		hoaDonCho_DAO = new HoaDonCho_DAO();
		chiTietHoaDonCho_DAO = new ChiTietHoaDonCho_DAO();
		
		this.sach_GUI = sach_GUI;
		this.dungCuHocTap_GUI = dungCuHocTap_GUI;
		
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 1299, 720);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblThongTinHoaDon = new JLabel("Thông Tin Hóa Đơn");
		lblThongTinHoaDon.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblThongTinHoaDon.setBounds(20, 20, 219, 40);
		panel.add(lblThongTinHoaDon);
		
		JScrollPane scrollPane;
		scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 70, 1218, 296);
		scrollPane.setToolTipText("Chọn vào sản phẩm cần hiển thị thông tin");
		scrollPane.setBorder(new LineBorder(new Color(80, 80, 80), 1, true));
		scrollPane.setBackground(new Color(80, 80, 80));
		panel.add(scrollPane);

		String cols[] = { "Mã Hóa Đơn", "Tên Khách Hàng", "Số Điện Thoại",
				 "Tên Nhân Viên" , "Ngày Lập" , "Thành Tiền (tạm thời)" };
		modelDanhSachHoaDon = new DefaultTableModel(cols, 0);
		tableDanhSachHoaDon = new JTable(modelDanhSachHoaDon);
		tableDanhSachHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableDanhSachHoaDon.setToolTipText("Chọn vào nhân viên cần hiển thị thông tin");
		tableDanhSachHoaDon.setRowHeight(30);
		tableDanhSachHoaDon.setDefaultEditor(Object.class, null);
		tableDanhSachHoaDon.setShowGrid(true); 
		tableDanhSachHoaDon.setShowHorizontalLines(true);
		tableDanhSachHoaDon.setBackground(new Color(255, 255, 255));
		tableDanhSachHoaDon.setSelectionBackground(new Color(141, 208, 229));
		tableDanhSachHoaDon.setSelectionForeground(new Color(0, 0, 0));
		tableDanhSachHoaDon.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tableDanhSachHoaDon.getSelectedRow();
				HoaDonCho hoaDonCho;
				try {
					hoaDonCho = hoaDonCho_DAO.getHoaDonChoTheoMa(modelDanhSachHoaDon.getValueAt(row, 0).toString());
					loadDataIntoTableChiTietHoaDonChoTheoMaHoaDonCho(hoaDonCho.getMaHoaDonCho());
				} catch (RemoteException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(tableDanhSachHoaDon);

		// header of table
		tableHeader = tableDanhSachHoaDon.getTableHeader();
		tableHeader.setBackground(new Color(73, 129, 158));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
		tableHeader.setReorderingAllowed(false);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tableDanhSachHoaDon.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableDanhSachHoaDon.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tableDanhSachHoaDon.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tableDanhSachHoaDon.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tableDanhSachHoaDon.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		tableDanhSachHoaDon.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);

		scrChiTietHoaDon = new JScrollPane();
		scrChiTietHoaDon.setBounds(40, 400, 1218, 250);
		scrChiTietHoaDon.setToolTipText("");
		scrChiTietHoaDon.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrChiTietHoaDon.setBackground(new Color(255, 255, 255));
		panel.add(scrChiTietHoaDon);

		String colsChiTietHoaDon[] = { "Mã Hóa Đơn", "Tên Sản Phẩm", "Số Lượng",
				"Đơn Giá" };
		modelChiTietHoaDon = new DefaultTableModel(colsChiTietHoaDon, 0);
		tableChiTietHoaDon = new JTable(modelChiTietHoaDon);
		tableChiTietHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableChiTietHoaDon.setToolTipText("Chọn vào hóa đơn cần hiển thị thông tin");
		tableChiTietHoaDon.setRowHeight(30);
		tableChiTietHoaDon.setDefaultEditor(Object.class, null);
		tableChiTietHoaDon.setShowGrid(true);
		tableChiTietHoaDon.setShowHorizontalLines(true);
		tableChiTietHoaDon.setBackground(new Color(255, 255, 255));
		tableChiTietHoaDon.setSelectionBackground(new Color(141, 208, 229));
		tableChiTietHoaDon.setSelectionForeground(new Color(0, 0, 0));
		tableChiTietHoaDon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableChiTietHoaDon.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		scrChiTietHoaDon.setViewportView(tableChiTietHoaDon);

		// header of table
		tableHeaderChiTietHoaDon = tableChiTietHoaDon.getTableHeader();
		tableHeaderChiTietHoaDon.setBackground(new Color(73, 129, 158));
		tableHeaderChiTietHoaDon.setForeground(Color.white);
		tableHeaderChiTietHoaDon.setFont(new Font("SansSerif", Font.BOLD, 14));
		tableHeaderChiTietHoaDon.setReorderingAllowed(false);
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tableChiTietHoaDon.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableChiTietHoaDon.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tableChiTietHoaDon.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tableChiTietHoaDon.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tableChiTietHoaDon.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setOpaque(true);
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnXoa.setBackground(new Color(73, 129, 158));
		btnXoa.setBounds(343, 665, 135, 40);
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = tableDanhSachHoaDon.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "Bạn phải chọn hóa đơn cần xóa");
				}
				else {
					int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa hóa đơn này không?",
							"Xác nhận", JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {
						String maHoaDon = modelDanhSachHoaDon.getValueAt(row, 0).toString();
						try {
							chiTietHoaDonCho_DAO.getAllChiTietHoaDonChoTheoMaHoaDonCho(maHoaDon).forEach(a -> {
								try {
									sanPham_DAO.banSanPham(a.getSanPham().getMaSanPham(), -a.getSoLuong());
									chiTietHoaDonCho_DAO.xoaChiTietHoaDonCho(a.getId());
								} catch (RemoteException e1) {
									e1.printStackTrace();
								}
							});
							hoaDonCho_DAO.xoaHoaDonCho(maHoaDon);
							modelChiTietHoaDon.setRowCount(0);
							refresh();
							updateThenRemove();
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		panel.add(btnXoa);
		
		JButton btnTiepTuc = new JButton("Tiếp Tục");
		btnTiepTuc.setOpaque(true);
		btnTiepTuc.setForeground(Color.WHITE);
		btnTiepTuc.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnTiepTuc.setBackground(new Color(73, 129, 158));
		btnTiepTuc.setBounds(821, 665, 135, 40);
		btnTiepTuc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int row = tableDanhSachHoaDon.getSelectedRow();
					String maHoaDonCho = modelDanhSachHoaDon.getValueAt(row, 0).toString();
					HoaDon_GUI hoaDon_GUI = (HoaDon_GUI) pMain.getComponent(5);
					hoaDon_GUI.getHoaDonTuHoaDonCho(maHoaDonCho);
					cardLayout.show(pMain, "HoaDon_GUI");
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnTiepTuc);
		
	}
	
	private void updateThenRemove() throws RemoteException {
		sach_GUI.refresh();
		dungCuHocTap_GUI.refresh();
	}
	
	public void loadData(List<HoaDonCho> hoaDonChos) throws RemoteException {
		modelDanhSachHoaDon.setRowCount(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for (HoaDonCho hoaDonCho : hoaDonChos) {
			Object[] objects = {hoaDonCho.getMaHoaDonCho(), 
					hoaDonCho.getKhachHang() != null ? hoaDonCho.getKhachHang().getTenKhachHang() : "",
							hoaDonCho.getKhachHang() != null ? hoaDonCho.getKhachHang().getSoDienThoai() : "",
								nhanVien_DAO.getNhanVienTheoMa(hoaDonCho.getNhanVien().getMaNhanVien()).getTenNhanVien(), 
								simpleDateFormat.format(hoaDonCho.getNgayLap()), 
								hoaDonCho.getThanhTien()};
			modelDanhSachHoaDon.addRow(objects);
		}
	}
	
	public void refresh() throws RemoteException {
		loadData(hoaDonCho_DAO.getAllHoaDonCho());
	}
	
	private void loadDataIntoTableChiTietHoaDonChoTheoMaHoaDonCho(String maHoaDonCho) throws RemoteException, SQLException {
		modelChiTietHoaDon.setRowCount(0);
		try {
			for (ChiTietHoaDonCho chiTietHoaDonCho : chiTietHoaDonCho_DAO.getAllChiTietHoaDonChoTheoMaHoaDonCho(maHoaDonCho)) {
				Object[] objects = {chiTietHoaDonCho.getHoaDonCho().getMaHoaDonCho(),
									sanPham_DAO.getSanPhamTheoMa(chiTietHoaDonCho.getSanPham().getMaSanPham()).getTenSanPham(),
									chiTietHoaDonCho.getSoLuong(),
									chiTietHoaDonCho.getDonGia()};
				modelChiTietHoaDon.addRow(objects);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }
	
}
