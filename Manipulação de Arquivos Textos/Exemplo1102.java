package exemplo;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import java.io.*; 

class Exemplo1102 extends JFrame implements ActionListener 
{ 
	JLabel L1,L2; 
	JButton B1,B2,B3; 
	JTextField T1; 
	TextArea TA1; 
	JPanel P1; 
	FileDialog Fabrir,Fsalvar; 

	public static void main(String[] args) 
	{ 
		JFrame Janela = new Exemplo1102(); 
		WindowListener x = new WindowAdapter() 
		{ 
			public void windowClosing(WindowEvent e) 
			{ 
				System.exit(0); 
			} 
		}; 
		Janela.addWindowListener(x); 
		Janela.show(); 
	} 

	Exemplo1102() 
	{ 
		setTitle("Manipulação de arquivo Texto"); 
		setSize (500,300); 
		setResizable(false); 
		getContentPane().setBackground (new Color (150,150,150)); 
		getContentPane().setLayout (new FlowLayout()); 
		L1 = new JLabel("Texto a ser editado:"); 
		L1.setForeground(Color.black); 
		L2 = new JLabel("Status:"); 
		L2.setForeground(Color.black); 
		B1 = new JButton("Gravar"); 
		B2 = new JButton("Abrir"); 
		B3 = new JButton("Limpar"); 
		B1.addActionListener(this); 
		B2.addActionListener(this); 
		B3.addActionListener(this); 
		T1 = new JTextField(35); 
		T1.setForeground(Color.red); 
		T1.setEditable(false); 
		P1 = new JPanel(); 
		P1.setLayout (new FlowLayout()); 
		P1.add(L2); P1.add(T1); 
		TA1 = new TextArea(8,60); 
		Fabrir = new FileDialog(this,"Abrir arquivo",FileDialog.LOAD); 
		Fsalvar = new FileDialog(this,"Salvar arquivo",FileDialog.SAVE); 
		getContentPane().add(L1); 
		getContentPane().add(TA1); 
		getContentPane().add(B1); 
		getContentPane().add(B2); 
		getContentPane().add(B3); 
		getContentPane().add(P1); 
	} 

	public void actionPerformed(ActionEvent e) 
	{ 
		String nome_do_arquivo; 
		if (e.getSource() == B3) //limpar 
		{ 
			TA1.setText(""); 
			T1.setText(""); 
		} 
		if (e.getSource() == B1) //gravar 
		{ 
			try 
			{ 
				Fsalvar.show(); 
				if (Fsalvar.getFile()==null) return; 
				nome_do_arquivo = Fsalvar.getDirectory()+Fsalvar.getFile(); 
				FileWriter out = new FileWriter(nome_do_arquivo); 
				out.write(TA1.getText()); 
				out.close(); 
				T1.setText("Arquivo gravado com sucesso !"); 
			} 
			catch(java.io.IOException exc) 
			{ 
				T1.setText("Erro ao gravar no arquivo !"); 
			} 
		} 
		if (e.getSource() == B2) //ler 
		{ 
			try 
			{ 
				Fabrir.show(); 
				if (Fabrir.getFile()==null) return; 
				nome_do_arquivo = Fabrir.getDirectory()+Fabrir.getFile(); 
				FileReader in = new FileReader(nome_do_arquivo); 
				String S=""; 
				int i = in.read(); 
				while (i!=-1) 
				{ 
					S = S +(char)i; 
					i = in.read(); 
				} 
				TA1.setText(S); 
				in.close(); 
				T1.setText("Arquivo aberto com sucesso !"); 
			} 
			catch(java.io.IOException exc) 
			{ 
				T1.setText("Erro ao abrir o arquivo !"); 
			}

		} 
	} 
} 