package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaConsulta {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(2);

		Query query = em.createQuery("select m from Movimentacao m where m.conta=:pConta"
				+ " and m.tipo = :pTipo" + " order by m.valor desc");
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		List<Movimentacao> movimentacoes = query.getResultList();

		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("\nDescricao ..: " + movimentacao.getDescricao());
			System.out.println("Valor ......: R$ " + movimentacao.getValor());
		}

	}

}
