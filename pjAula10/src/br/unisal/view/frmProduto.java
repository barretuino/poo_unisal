package br.unisal.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unisal.model.Produto;
import br.unisal.model.Situacao;
import br.unisal.model.UnidadeMedida;
import br.unisal.service.ProdutoService;

public class frmProduto extends JFrame implements ActionListener{
	
	//1 Passo Declarar os objetos
	JLabel lbCodigo, lbDescricao, lbUnidadeMedida, 
		   lbLargura, lbComprimento, lbSituacao,
		   lbLocalizacao;
	JTextField txtCodigo, txtDescricao, txtLargura,
			   txtComprimento, txtLocalizacao;
	JComboBox cbxUnidadeMedida, cbxSituacao;
	JPanel pnCampos, pnBotoes;
	JButton btnInclui, btnExclui, btnAltera, btnPesquisa;
	List<Produto> bdProduto = new ArrayList<Produto>();

	public frmProduto() {
		super("Cadastro de Produto");
		setSize(400, 250);
		setLayout(new BorderLayout());
		
		//2 Passo Construir os objetos
		lbCodigo = new JLabel("Código");
		lbDescricao = new JLabel("Descrição");
		lbUnidadeMedida  = new JLabel("Un. Medida");
		lbLargura = new JLabel("Largura");
		lbComprimento = new JLabel("Comprimento");
		lbSituacao = new JLabel("Situação");
		lbLocalizacao = new JLabel("Localização");
		
		txtCodigo = new JTextField();
		txtDescricao = new JTextField();
		txtLargura = new JTextField();
		txtComprimento = new JTextField();
		txtLocalizacao = new JTextField();
		cbxSituacao = new JComboBox<Situacao>(Situacao.values());
		cbxUnidadeMedida = new JComboBox<UnidadeMedida>
											(UnidadeMedida.values());
		
		btnInclui = new JButton("Incluir");
		btnAltera = new JButton("Alterar");
		btnExclui = new JButton("Excluir");
		btnPesquisa = new JButton("Pesquisar");
		
		pnCampos = new JPanel(new GridLayout(7,2));
		pnBotoes = new JPanel(new GridLayout(1,4));
		
		//3 Adicao dos objetos
		pnCampos.add(lbCodigo);
		pnCampos.add(txtCodigo);
		pnCampos.add(lbDescricao);
		pnCampos.add(txtDescricao);
		pnCampos.add(lbUnidadeMedida);
		pnCampos.add(cbxUnidadeMedida);
		pnCampos.add(lbLargura);
		pnCampos.add(txtLargura);
		pnCampos.add(lbComprimento);
		pnCampos.add(txtComprimento);
		pnCampos.add(lbSituacao);
		pnCampos.add(cbxSituacao);
		pnCampos.add(lbLocalizacao);
		pnCampos.add(txtLocalizacao);
		
		add(pnCampos, BorderLayout.CENTER);
		
		pnBotoes.add(btnInclui);
		pnBotoes.add(btnAltera);
		pnBotoes.add(btnExclui);
		pnBotoes.add(btnPesquisa);
		
		add(pnBotoes, BorderLayout.SOUTH);
		
		//4 Passo incluir os elemento no Listener de Ações
		btnInclui.addActionListener(this);
		btnAltera.addActionListener(this);
		btnExclui.addActionListener(this);
		btnPesquisa.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		ProdutoService service = new ProdutoService();
		if(e.getSource() == btnInclui) {
			Produto instancia = service.instanciarProduto(
					txtCodigo, txtDescricao,
					txtComprimento, txtLargura, txtLocalizacao,
					cbxSituacao, cbxUnidadeMedida);
		}
		//TODO: Desenvolver
	}
	
	public static void main(String args[]) {
		frmProduto frm = new frmProduto();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
