package pjAula2;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class frmCadastro extends JFrame {
	JButton btCadastrar;
	public frmCadastro() {
		setSize(200, 200);
		setLayout(new FlowLayout());
		
		btCadastrar = new JButton("Cadastrar");
		
		add(btCadastrar);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new frmCadastro();
	}
}
