package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controler.QLSVControler;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class QLSV_View extends  JFrame{

	private JPanel contentPane;
	public QLSVModel qlsvModel;
	public JTextField txtMaSV;
	public JTable table;
	public JTextField txt_MSV;
	public JTextField txtHoTen;
	public JTextField txtNgaySinh;
	public JTextField txtDiem1;
	public JTextField txtDiem2;
	public JTextField txtDiem3;
	public ButtonGroup buttonGroup_gioiTinh;
	public JComboBox cbcQueQuan_1;
	public JRadioButton radiobtn_Nam;
	public JRadioButton radiobtn_Nu;
	private JComboBox cbcQueQuan;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSV_View frame = new QLSV_View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSV_View() {
		this.qlsvModel = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 698);

		ActionListener actionListener = new QLSVControler(this);


		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(actionListener);
		menuOpen.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuFile.add(menuOpen);

		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(actionListener);
		menuSave.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuFile.add(menuSave);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(actionListener);
		menuExit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuFile.add(menuExit);
		
		JMenuItem menuLuuLuon = new JMenuItem("Lưu Luôn");
		menuLuuLuon.addActionListener(actionListener);
		menuLuuLuon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		menuFile.add(menuLuuLuon);

		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(actionListener);
		menuAbout.setFont(new Font("Times New Roman", Font.BOLD, 20));
		menuBar.add(menuAbout);

		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.addActionListener(actionListener);
		menuAboutMe.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMaSinhVien = new JLabel("Mã SV");
		lblMaSinhVien.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblMaSinhVien.setBounds(284, 26, 109, 57);
		contentPane.add(lblMaSinhVien);

		JLabel lable_QueQuan = new JLabel("Quê Quán");
		lable_QueQuan.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lable_QueQuan.setBounds(10, 26, 109, 57);
		contentPane.add(lable_QueQuan);

		txtMaSV = new JTextField();
		txtMaSV.setBounds(388, 32, 130, 53);
		contentPane.add(txtMaSV);
		txtMaSV.setColumns(10);

		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(actionListener);
		btnTim.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnTim.setBounds(550, 30, 100, 52);
		contentPane.add(btnTim);

		cbcQueQuan = new JComboBox();
		ArrayList<Tinh> dsTinh = Tinh.getDSTinh();
		cbcQueQuan.addItem("");
		for(Tinh t : dsTinh)
		{
			cbcQueQuan.addItem(t.getTenTinh());
		}
		cbcQueQuan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cbcQueQuan.setBounds(129, 32, 130, 51);
		contentPane.add(cbcQueQuan);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(43, 96, 703, 2);
		contentPane.add(separator_1);

		JLabel lable_DSSV = new JLabel("Danh sách sinh viên");
		lable_DSSV.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lable_DSSV.setBounds(10, 99, 229, 57);
		contentPane.add(lable_DSSV);

		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Ma\u0303 SV", "Ho\u0323 T\u00EAn", "Qu\u00EA Qua\u0301n", "Nga\u0300y Sinh", "Gi\u01A1\u0301i Ti\u0301nh", "\u0110i\u00EAm 1", "\u0110i\u00EA\u0309m 2", "\u0110i\u00EA\u0309m 3"
				}
				));

		table.setRowHeight(30);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 152, 749, 154);
		contentPane.add(scrollPane);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(43, 327, 703, 2);
		contentPane.add(separator_1_1);

		JLabel lable_TTSV = new JLabel("Thông tin sinh viên");
		lable_TTSV.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lable_TTSV.setBounds(10, 327, 210, 53);
		contentPane.add(lable_TTSV);

		JLabel lbl_MaSinhVien = new JLabel("Mã SV");
		lbl_MaSinhVien.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbl_MaSinhVien.setBounds(10, 381, 71, 29);
		contentPane.add(lbl_MaSinhVien);

		txt_MSV = new JTextField();
		txt_MSV.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txt_MSV.setColumns(10);
		txt_MSV.setBounds(129, 382, 116, 33);
		contentPane.add(txt_MSV);

		JLabel lable_TenSV = new JLabel("Tên SV");
		lable_TenSV.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lable_TenSV.setBounds(10, 421, 75, 29);
		contentPane.add(lable_TenSV);

		txtHoTen = new JTextField();
		txtHoTen.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(129, 427, 116, 33);
		contentPane.add(txtHoTen);

		JLabel lable_QuaQuan = new JLabel("Quê Quán");
		lable_QuaQuan.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lable_QuaQuan.setBounds(10, 475, 104, 29);
		contentPane.add(lable_QuaQuan);

		cbcQueQuan_1 = new JComboBox();
		//ArrayList<Tinh> dsTinh = Tinh.getDSTinh();
		cbcQueQuan_1.addItem("");
		for(Tinh t : dsTinh)
		{
			cbcQueQuan_1.addItem(t.getTenTinh());
		}
		cbcQueQuan_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cbcQueQuan_1.setBounds(129, 471, 116, 34);
		contentPane.add(cbcQueQuan_1);

		JLabel lable_NgaySinh = new JLabel("Ngày Sinh");
		lable_NgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lable_NgaySinh.setBounds(10, 516, 103, 29);
		contentPane.add(lable_NgaySinh);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(129, 516, 116, 29);
		contentPane.add(txtNgaySinh);

		JLabel lable_GioiTinh = new JLabel("Giới Tính");
		lable_GioiTinh.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lable_GioiTinh.setBounds(307, 381, 138, 29);
		contentPane.add(lable_GioiTinh);

		radiobtn_Nam = new JRadioButton("Nam");
		radiobtn_Nam.setFont(new Font("Times New Roman", Font.BOLD, 13));
		radiobtn_Nam.setBounds(451, 384, 73, 30);
		contentPane.add(radiobtn_Nam);

		radiobtn_Nu = new JRadioButton("Nữ");
		radiobtn_Nu.setFont(new Font("Times New Roman", Font.BOLD, 13));
		radiobtn_Nu.setBounds(531, 381, 81, 30);
		contentPane.add(radiobtn_Nu);

		buttonGroup_gioiTinh = new ButtonGroup();
		buttonGroup_gioiTinh.add(radiobtn_Nam);
		buttonGroup_gioiTinh.add(radiobtn_Nu);

		JLabel lable_diem1 = new JLabel("Điêm 1");
		lable_diem1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lable_diem1.setBounds(307, 421, 138, 29);
		contentPane.add(lable_diem1);

		JLabel lable_diem2 = new JLabel("Điểm 2");
		lable_diem2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lable_diem2.setBounds(307, 471, 138, 29);
		contentPane.add(lable_diem2);

		JLabel lable_diem3 = new JLabel("Điểm 3");
		lable_diem3.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lable_diem3.setBounds(307, 516, 138, 29);
		contentPane.add(lable_diem3);

		txtDiem1 = new JTextField();
		txtDiem1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtDiem1.setColumns(10);
		txtDiem1.setBounds(451, 424, 116, 29);
		contentPane.add(txtDiem1);

		txtDiem2 = new JTextField();
		txtDiem2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtDiem2.setColumns(10);
		txtDiem2.setBounds(451, 471, 116, 29);
		contentPane.add(txtDiem2);

		txtDiem3 = new JTextField();
		txtDiem3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtDiem3.setColumns(10);
		txtDiem3.setBounds(451, 519, 116, 29);
		contentPane.add(txtDiem3);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(actionListener);
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnThem.setBounds(32, 570, 100, 52);
		contentPane.add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(actionListener);
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnXoa.setBounds(153, 570, 100, 52);
		contentPane.add(btnXoa);

		JButton btnCapNhat = new JButton("Cập Nhật");
		/*btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});*/
		btnCapNhat.addActionListener(actionListener);
		btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnCapNhat.setBounds(277, 570, 116, 52);
		contentPane.add(btnCapNhat);

		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(actionListener);
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnLuu.setBounds(426, 570, 100, 52);
		contentPane.add(btnLuu);

		JButton btnHuy = new JButton("Hủy Bỏ");
		/*btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});*/
		btnHuy.addActionListener(actionListener);
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnHuy.setBounds(562, 570, 100, 52);
		contentPane.add(btnHuy);

		JButton btnHuyTim = new JButton("Hủy Tìm");
		/*btnHuyTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});*/
		btnHuyTim.addActionListener(actionListener);
		btnHuyTim.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnHuyTim.setBounds(660, 30, 108, 52);
		contentPane.add(btnHuyTim);

		this.setVisible(true);
	}

	public void xoaForm() {
		txt_MSV.setText("");
		txtHoTen.setText("");
		txtNgaySinh.setText("");
		cbcQueQuan_1.setSelectedIndex(0);
		txtDiem1.setText("");
		txtDiem2.setText("");
		txtDiem3.setText("");
		buttonGroup_gioiTinh.clearSelection();
	}

	public void thuchienThem() {
		int maSV = Integer.parseInt(txt_MSV.getText());
		String hoTen =txtHoTen.getText();
		int queQuan = cbcQueQuan_1.getSelectedIndex()-1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		String ngaySinh = txtNgaySinh.getText();

		boolean gioiTinh = true;
		if(radiobtn_Nam.isSelected())
		{
			gioiTinh= true;
		}
		else if(radiobtn_Nu.isSelected())
		{
			gioiTinh= false;
		}

		Float diemMon1 = Float.parseFloat(txtDiem1.getText());
		Float diemMon2 = Float.parseFloat(txtDiem2.getText());
		Float diemMon3 = Float.parseFloat(txtDiem3.getText());

		ThiSinh ts = new ThiSinh(maSV, hoTen, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);

		this.themHoacCapNhatSinhVien(ts);


	}

	private void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();

		model_table.addRow(new Object[] { 
				ts.getMaThiSinh()+"", 
				ts.getTenThiSinh(), 
				ts.getQueQuan().getTenTinh(),
				ts.getNgaySinh(),

				(ts.isGioiTinh() ? "Nam" : "Nữ"), 
				ts.getDiemMon1()+"", 
				ts.getDiemMon2()+"",
				ts.getDiemMon3()+"", 
		});

	}
	public void themHoacCapNhatSinhVien(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();

		if(!this.qlsvModel.kiemTraTonTai(ts))
		{
			this.qlsvModel.insert(ts);
			this.themThiSinhVaoTable(ts);
		}
		else
		{
			this.qlsvModel.update(ts);
			int soLuongDong = model_table.getRowCount();
			for(int i=0 ; i<soLuongDong; i++)
			{
				String id = model_table.getValueAt(i, 0)+"";
				if(id.equals(ts.getMaThiSinh()+""))
				{
					model_table.setValueAt(ts.getMaThiSinh()+"", i, 0);
					model_table.setValueAt(ts.getTenThiSinh()+"", i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh()+"", i, 2);
					model_table.setValueAt(ts.getNgaySinh()+"", i, 3);
					model_table.setValueAt(ts.isGioiTinh() ? "Nam" : "Nữ"+"", i, 4);
					model_table.setValueAt(ts.getDiemMon1()+"", i, 5);
					model_table.setValueAt(ts.getDiemMon2()+"", i, 6);
					model_table.setValueAt(ts.getDiemMon3()+"", i, 7);

				}
			}
		}
	}

	//Lấy ra  thông tin thí sinh đang chọn
	public ThiSinh getThiSinhDangChon()
	{
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		int maThiSinh = Integer.parseInt(model_table.getValueAt(i_row, 0)+"");
		String tenThiSinh = model_table.getValueAt(i_row, 1)+"";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2)+"");
		String ngaySinh = model_table.getValueAt(i_row, 3)+"";
		String testGioiTinh = model_table.getValueAt(i_row, 4)+"";
		boolean gioiTinh = testGioiTinh.equals("Nam");
		float diemMon1 = Float.parseFloat(model_table.getValueAt(i_row, 5)+"");
		float diemMon2 = Float.parseFloat(model_table.getValueAt(i_row, 6)+"");
		float diemMon3 = Float.parseFloat(model_table.getValueAt(i_row, 7)+"");

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);

		return ts;

	}

	public void hienThiThongTinSinhVienDaChon() {
		ThiSinh ts = getThiSinhDangChon();

		this.txt_MSV.setText(ts.getMaThiSinh()+"");
		this.txtHoTen.setText(ts.getTenThiSinh()+"");
		this.cbcQueQuan_1.setSelectedItem(ts.getQueQuan().getTenTinh());
		this.txtNgaySinh.setText(ts.getNgaySinh()+"");
		if(ts.isGioiTinh())
		{
			radiobtn_Nam.setSelected(true);
		}
		else
		{
			radiobtn_Nu.setSelected(false);
		}
		//this.txt.setText(maThiSinh+"");
		this.txtDiem1.setText(ts.getDiemMon1()+"");
		this.txtDiem2.setText(ts.getDiemMon2()+"");
		this.txtDiem3.setText(ts.getDiemMon3()+"");

	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa dòng đã chọn");
		if(luaChon==JOptionPane.YES_OPTION)
		{
			ThiSinh ts = getThiSinhDangChon();
			this.qlsvModel.delete(ts);
			model_table.removeRow(i_row);
		}

	}

	public void thucHienTim() {
		// Goi ham huy tim kiem
		this.thucHienHuyTim();

		// Thuc hien tim kiem
		int queQuan = cbcQueQuan.getSelectedIndex() -1;
		String maThiSinhTimKiem = txtMaSV.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();

		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
		if (queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhById(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 2) + "";
				String id = model_table.getValueAt(i, 0) + "";
				if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if (maThiSinhTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (!id.equals(maThiSinhTimKiem)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer idCanXoa : idCuaThiSinhCanXoa) {
			System.out.println(idCanXoa);
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				System.out.println("idTrongTable: " + idTrongTable);
				if (idTrongTable.equals(idCanXoa.toString())) {
					System.out.println("Đã xóa: " + i);
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void thucHienHuyTim() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (ThiSinh ts : this.qlsvModel.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý sinh viên ");
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát khỏi phần mềm", "Exit", JOptionPane.YES_NO_OPTION);
		if(luaChon == JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
		
		
	}
	private void saveFile(String path) {
		try {
			this.qlsvModel.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(ThiSinh ts : this.qlsvModel.getDsThiSinh())
			{
				oos.writeObject(ts);
			}
			oos.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void thucHienSaveFile() {
		if(this.qlsvModel.getTenFile().length()>0)
		{
			saveFile(this.qlsvModel.getTenFile());
		}
		else
		{
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}

	private void openFile(File file) {
		ArrayList<ThiSinh> dsTS = new ArrayList<ThiSinh>();
		try {
			this.qlsvModel.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh ts = null;
			while((ts = (ThiSinh) ois.readObject())!= null)
			{
				dsTS.add(ts);
			}
			ois.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		this.qlsvModel.setDsThiSinh(dsTS);
	}

	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION)
		{
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienHuyTim();
		}
	}

	public void thucHienLuu() {
		int maSV = Integer.parseInt(txt_MSV.getText());
		String hoTen =txtHoTen.getText();
		int queQuan = cbcQueQuan_1.getSelectedIndex()-1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		String ngaySinh = txtNgaySinh.getText();

		boolean gioiTinh = true;
		if(radiobtn_Nam.isSelected())
		{
			gioiTinh= true;
		}
		else if(radiobtn_Nu.isSelected())
		{
			gioiTinh= false;
		}

		Float diemMon1 = Float.parseFloat(txtDiem1.getText());
		Float diemMon2 = Float.parseFloat(txtDiem2.getText());
		Float diemMon3 = Float.parseFloat(txtDiem3.getText());

		ThiSinh ts = new ThiSinh(maSV, hoTen, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		try {
			FileOutputStream fos = new FileOutputStream("ds_SV.pat",true);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			
			String line = ts.toString();
			
			bw.write(line);
			bw.newLine();
			
			bw.close();
			osw.close();
			fos.close();
			JOptionPane.showMessageDialog(this, "Lưu file thành công");
		}catch(Exception ex)
		
		{
			ex.printStackTrace();
		}
	}

	


}
