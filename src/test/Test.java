package test;

import javax.swing.UIManager;

import view.QLSV_View;

public class Test {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new QLSV_View();
		} catch (Exception e) {
			e.printStackTrace();
		}	}

}
