package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaJPQLAvancada {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = manager.find(Conta.class, 2);

		// Double resultado = new
		// MovimentacaoDAO(manager).mediaDaContaPeloTipo(conta,
		// TipoMovimentacao.SAIDA);
		Double resultado = new MovimentacaoDAO(manager).mediaDaContaPeloTipoNamedQuery(conta, TipoMovimentacao.SAIDA);

		System.out.println("Média movimentada..: R$ " + resultado);

	}

}
