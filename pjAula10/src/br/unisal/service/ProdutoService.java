package br.unisal.service;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import br.unisal.model.Produto;
import br.unisal.model.Situacao;
import br.unisal.model.UnidadeMedida;

/**
 * Métodos ligados a camada de serviço
 * Regras e Validações
 */
public class ProdutoService {
	public boolean validarDadosLogisticos(Produto produto) 
													throws Exception {
		if(produto.getComprimento() <= 0 ) {
			throw new Exception("Comprimento de Produto inválido.");
		}
		if(produto.getLargura() <= 0) {
			throw new Exception("Largura de Produto inválida.");
		}
		
		return true;
	}

	public Produto instanciarProduto(JTextField txtCodigo, 
			JTextField txtDescricao, JTextField txtComprimento,
			JTextField txtLargura, JTextField txtLocalizacao, 
			JComboBox cbxSituacao, JComboBox cbxUnidadeMedida) {
		
		Produto produto = new Produto();
		produto.setCodigo(Integer.parseInt(txtCodigo.getText()));
		produto.setDescricao(txtDescricao.getText());
		produto.setLargura(Float.parseFloat(txtLargura.getText()));
		produto.setComprimento(Float.parseFloat(txtComprimento.getText()));
		produto.setLocalizacao(txtLocalizacao.getText());
		produto.setSituacao(Situacao.values()[
				cbxSituacao.getSelectedIndex()]);
		produto.setUn(UnidadeMedida.values()[
		        cbxUnidadeMedida.getSelectedIndex()]);
		
		return produto;
	}
}
