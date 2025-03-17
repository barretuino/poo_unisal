package pjAula5;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * GUI - Interface Gráfica com Usuário
 */

public class frmCadastro extends JFrame implements ActionListener{
	//1 Passo - Declarar
	JButton btCadastrar, btAlterar, btExcluir, btPesquisar;
	JLabel lbCodigo, lbNome, lbEmail, lbTelefone;
	JTextField txtCodigo, txtNome, txtEmail, txtTelefone;
	JPanel pnCampos, pnBotoes;
	
	public frmCadastro() {
		super("Cadastro de Clientes");
		setSize(400, 200);
		setLayout(new BorderLayout());
		
		//2 Passo - Construir os componentes
		btCadastrar = new JButton("Cadastrar");
		btAlterar = new JButton("Alterar");
		btExcluir = new JButton("Excluir");
		btPesquisar = new JButton("Pesquisar");
		lbCodigo = new JLabel("Código");
		lbNome = new JLabel("Nome");
		lbTelefone = new JLabel("Telefone");
		lbEmail = new JLabel("E-mail");
		txtCodigo = new JTextField(20);
		txtNome = new JTextField(20);
		txtEmail = new JTextField(20);
		txtTelefone = new JTextField("Informe o telefone");
		pnCampos = new JPanel(new GridLayout(4,2));
		pnBotoes = new JPanel(new GridLayout(1,4,5,5));
		
		//3 Passo - Adicionar os componentes
		pnCampos.add(lbCodigo);
		pnCampos.add(txtCodigo);
		pnCampos.add(lbNome);
		pnCampos.add(txtNome);
		pnCampos.add(lbEmail);
		pnCampos.add(txtEmail);
		pnCampos.add(lbTelefone);
		pnCampos.add(txtTelefone);
		
		add(pnCampos, BorderLayout.CENTER);
		
		pnBotoes.add(btCadastrar);
		pnBotoes.add(btAlterar);
		pnBotoes.add(btExcluir);
		pnBotoes.add(btPesquisar);
		
		add(pnBotoes, BorderLayout.SOUTH);
		
		//4 Passo - Adicionar a lista de ações
		btCadastrar.addActionListener(this);
		btAlterar.addActionListener(this);
		btExcluir.addActionListener(this);
		btPesquisar.addActionListener(this);
		
		txtCodigo.addActionListener(this);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btCadastrar) {
			JOptionPane.showMessageDialog(null, 
					"Código " + txtCodigo.getText()
					+ " Nome " + txtNome.getText());
		}
		if(e.getSource() == btAlterar) {
			
		}
		if(e.getSource() == btExcluir) {
			
		}
		if(e.getSource() == btPesquisar) {
			
		}
		if(e.getSource() == txtCodigo) {
			txtNome.setText(txtCodigo.getText());
		}
	}	
	public static void main(String[] args) {
		frmCadastro frm = new frmCadastro();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}