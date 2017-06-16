package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoCount {

	public static void main(String[] args) {

		EntityManager entityManager = new JPAUtil().getEntityManager();
		Conta conta = entityManager.find(Conta.class, 2);

		String jpql = "SELECT count(m) from Movimentacao m where m.conta = :pConta";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("pConta", conta);

		Long count = (Long) query.getSingleResult();

		System.out.println("Quantidade de Movimentacoes...: " + count);

	}

}
