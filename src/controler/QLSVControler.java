package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import model.ThiSinh;
import model.Tinh;
import view.QLSV_View;

public class QLSVControler implements ActionListener{

	private QLSV_View qlsv_View;


	public QLSVControler(QLSV_View qlsv_View) {
		super();
		this.qlsv_View = qlsv_View;
	}


	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		//JOptionPane.showMessageDialog(qlsv_View, "Bạn vừa nhân vào: "+src);
		if(src.equals("Thêm"))
		{
			this.qlsv_View.xoaForm();
			//this.qlsv_View.qlsvModel.setLuaChon("Thêm");
		}
		else if(src.equals("Lưu"))
		{
			try {
				this.qlsv_View.thuchienThem();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		else if(src.equals("Cập Nhật"))
		{
			this.qlsv_View.hienThiThongTinSinhVienDaChon();
		}
		else if(src.equals("Xóa"))
		{
			this.qlsv_View.thucHienXoa();
		}
		else if(src.equals("Hủy Bỏ"))
		{
			this.qlsv_View.xoaForm();
		}
		else if(src.equals("Tìm"))
		{
			this.qlsv_View.thucHienTim();
		}
		else if(src.equals("Hủy Tìm"))
		{
			this.qlsv_View.thucHienHuyTim();
		}
		else if(src.equals("About Me"))
		{
			this.qlsv_View.hienThiAbout();
		}
		else if(src.equals("Exit"))
		{
			this.qlsv_View.thoatKhoiChuongTrinh();
		}
		else if(src.equals("Save"))
		{
			this.qlsv_View.thucHienSaveFile();
		}
		else if(src.equals("Open"))
		{
			this.qlsv_View.thucHienOpenFile();
		}
		else if(src.equals("Lưu Luôn"))
		{
			this.qlsv_View.thucHienLuu();
		}


	}

}
