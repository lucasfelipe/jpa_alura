package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaMovimentacaoConta {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		Movimentacao movimentacao = em.find(Movimentacao.class, 2);

		System.out.println("Titular da conta: " + movimentacao.getConta().getTitular());
		Conta conta = movimentacao.getConta();
		System.out.println(conta.getMovimentacoes().size());

		Query query = em.createQuery("select c from Conta c");
		List<Conta> contas = query.getResultList();

		for (Conta c : contas) {
			System.out.println(c.getMovimentacoes().size());
		}

	}

}
