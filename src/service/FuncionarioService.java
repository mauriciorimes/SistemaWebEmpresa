package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;


import modelo.Funcionario;

@Stateless
public class FuncionarioService extends GenericService<Funcionario> {
	
	public FuncionarioService() {
		super(Funcionario.class);
	}
	
	public List<Funcionario> filtrarFuncionarioPorNome() {
		
		final CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();	
    	final CriteriaQuery<Funcionario> criteriaQuery = criteriaBuilder.createQuery(Funcionario.class);
	
    	final Root<Funcionario> rootFilial = criteriaQuery.from(Funcionario.class);
    	
    	final Expression<String> expNome = rootFilial.get("nome");    	
    	
    	criteriaQuery.orderBy(criteriaBuilder.asc(expNome));    	

    	List<Funcionario> resultado = getEntityManager().createQuery(criteriaQuery).getResultList();
    	return resultado;
    	
	}
	
	
	public List<Funcionario> filtrarFilialPelaLista(Long idFilialAtual) {
		
		final CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();	
    	final CriteriaQuery<Funcionario> criteriaQuery = criteriaBuilder.createQuery(Funcionario.class);
	
    	final Root<Funcionario> rootFilial = criteriaQuery.from(Funcionario.class);
    	
    	rootFilial.get("filial").get("id");
    	  	
    	criteriaQuery.select(rootFilial).where(criteriaBuilder.equal(rootFilial.get("filial").get("id"), idFilialAtual)); 
    	
    	final Expression<String> expNome = rootFilial.get("nome");
    	criteriaQuery.orderBy(criteriaBuilder.asc(expNome));
    	
    	List<Funcionario> resultado = getEntityManager().createQuery(criteriaQuery).getResultList();
    	return resultado;
    	
	}		

}