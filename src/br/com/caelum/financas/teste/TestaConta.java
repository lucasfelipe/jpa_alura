package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaConta {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setId(1);
		conta.setTitular("Joao Ferreira");
		conta.setBanco("HSBC");
		conta.setNumero("123345");
		conta.setAgencia("321");

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();
		conta = manager.find(Conta.class, conta.getId());
		
		manager.remove(conta);
		manager.getTransaction().commit();
		manager.close();
	}

}
