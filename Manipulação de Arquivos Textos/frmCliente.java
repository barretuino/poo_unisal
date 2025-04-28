import java.io.*;
import java.io.File.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class frmCliente extends JFrame implements ActionListener {

	JLabel lbNome,lbCNPJ,lbTelefone,lbStatus;
	
	JTextField txtNome;	
	JFormattedTextField txtCNPJ;
	JFormattedTextField txtTelefone;	
	
	MaskFormatter mascaraCNPJ;
	MaskFormatter mascaraTelefone;
	
	JComboBox cbxStatus;
	
	String status [] = {"Ativo","Inativo"}; 
	
	File arquivo = new File("Clientes.txt");
	
	JButton btCadastrar, btLimpar, btSair, btConsultar;
	JPanel p1,p2;
	BorderLayout bLayout;
	GridLayout grid1, grid2;
	
	public frmCliente(){
		setTitle("Cadastro de Clientes");
		setLayout(bLayout = new BorderLayout());
		setSize(400,300);
		setLocation(50,50);
		
		grid1 = new GridLayout(4,2);
		grid2 = new GridLayout(1,3);

		p1 = new JPanel();
		p2 = new JPanel();
		
		lbNome = new JLabel ("    Razão Social: ");
		lbCNPJ = new JLabel ("    CNPJ: ");
		lbTelefone = new JLabel ("    Telefone: ");
		lbStatus = new JLabel ("    Status: ");

		txtNome = new JTextField(20);

		try{
			mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
			mascaraTelefone = new MaskFormatter("(##)####-####");

		}
		catch(ParseException excp){}
		
		txtCNPJ = new JFormattedTextField(mascaraCNPJ);
		txtTelefone = new JFormattedTextField(mascaraTelefone);
		
		cbxStatus = new JComboBox(status);
	
		
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.setMnemonic('C');
		btCadastrar.setToolTipText("Cadastrar Cliente");
		btCadastrar.addActionListener(this);

		btLimpar = new JButton("Limpar");
		btLimpar.setMnemonic('L');
		btLimpar.setToolTipText("Limpar");
		btLimpar.addActionListener(this);

		btSair = new JButton("Sair");
		btSair.setMnemonic('S');
		btSair.setToolTipText("Sair do Cadastro de Cliente");
		btSair.addActionListener(this);

		btConsultar = new JButton("Consultar");
		btConsultar.setMnemonic('t');
		btConsultar.setToolTipText("Consultar o Cadastro de Cliente");
		btConsultar.addActionListener(this);

		p1.setLayout(grid1);
		p1.add(lbNome);		
		p1.add(txtNome);
		p1.add(lbCNPJ);		
		p1.add(txtCNPJ);
		p1.add(lbTelefone);
		p1.add(txtTelefone);
		p1.add(lbStatus);
		p1.add(cbxStatus);
		add(p1,BorderLayout.NORTH);

		p2.setLayout(grid2);
		p2.add(btCadastrar);
		p2.add(btLimpar);
		p2.add(btConsultar);
		p2.add(btSair);

		add(p2,BorderLayout.SOUTH);

		setResizable(false);
	}

	public void actionPerformed (ActionEvent evento){
		if (evento.getSource()== btCadastrar){
			try{				
				//Se o arquivo não existir, cria.
				if(!arquivo.exists()){
					OutputStream f0 = new FileOutputStream("Clientes.txt");	
				}	
				
				PrintWriter out = new PrintWriter( new FileWriter(arquivo, true));
				out.print(txtNome.getText());
				out.print(" | ");
				out.print(txtCNPJ.getText());
				out.print(" | ");
				out.print(txtTelefone.getText());
				out.print(" | ");
				out.println(status[cbxStatus.getSelectedIndex()]);
				out.close();
				
				JOptionPane.showMessageDialog(null, "Inclusão Realizada com Sucesso!" ,"Inclusão no Arquivo Texto",JOptionPane.INFORMATION_MESSAGE);
				setLimpar();
				
			}catch (IOException erro){
				JOptionPane.showMessageDialog(null, "Erro na manipulacao do Arquivo Texto." + erro,"Erro no Arquivo Texto",JOptionPane.ERROR_MESSAGE);				
			}		    
		}
		if (evento.getSource()== btLimpar){
			setLimpar();
		}
		if (evento.getSource()== btConsultar){
			frmConsulta consulta = new frmConsulta(arquivo);			
		}
		if (evento.getSource()== btSair){
			System.out.println("Formulário Fechado com Sucesso!");		
			System.exit(0);
		}
	}

	public void setLimpar(){
		txtNome.setText("");
		txtCNPJ.setText("");
		txtTelefone.setText("");
		cbxStatus.setSelectedIndex(0);
		txtNome.requestFocus();
	}
	
	public static void main(String args[]){
		frmCliente formulario = new frmCliente();
		formulario.setDefaultCloseOperation(EXIT_ON_CLOSE);
		formulario.setVisible(true);
	}	
}