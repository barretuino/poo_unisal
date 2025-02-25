package pjAula3;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frmCadastro extends JFrame{
	
	//1 Passo - Declarar
	JButton btCadastrar, btPesquisar;
	JTextField txtCodigo, txtNome, txtValor;
	JLabel lbCodigo, lbNome, lbValor;
	JCheckBox ckAtivo;
	
	public frmCadastro() {
		setTitle("Formulário de Cadastro");
		setSize(300, 300);
		setLayout(new FlowLayout());
		
		//2 Passo - Construir
		btCadastrar = new JButton("Cadastrar");
		btPesquisar = new JButton("Pesquisar");
		txtCodigo = new JTextField(20);
		txtNome = new JTextField("Digite aqui", 20);
		txtValor = new JTextField(20);
		lbCodigo = new JLabel("Código");
		lbNome = new JLabel("Nome");
		lbValor = new JLabel("Valor");
		ckAtivo = new JCheckBox("Equipamento Ativo");
		
		btCadastrar.setMnemonic('C');
		btPesquisar.setMnemonic('P');
		btCadastrar.setToolTipText("Cadastrar Equipamento");
		
		//3 Passo - Adiciona
		add(lbCodigo);
		add(txtCodigo);
		add(lbNome);
		add(txtNome);
		add(lbValor);
		add(txtValor);
		add(ckAtivo);
		add(btCadastrar);
		add(btPesquisar);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		frmCadastro frm = new frmCadastro();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
