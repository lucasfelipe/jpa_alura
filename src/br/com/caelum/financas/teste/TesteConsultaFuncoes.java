package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncoes {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(2);

		String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :pConta and m.tipo = :pTipo";

		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		BigDecimal resultado = (BigDecimal) query.getSingleResult();

		System.out.println("Total movimentado ..: R$ " + resultado);
	}

}
