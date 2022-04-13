package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import modelo.Filial;

@Stateless
public class FilialService extends GenericService<Filial> {
	
	public FilialService() {
		super(Filial.class);
	}
	
	public List<Filial> filtrarFilialPorNome(String texto) {
		
		final CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();	
    	final CriteriaQuery<Filial> criteriaQuery = criteriaBuilder.createQuery(Filial.class);
	
    	final Root<Filial> rootFilial = criteriaQuery.from(Filial.class);
    	
    	final Expression<String> expNome = rootFilial.get("nome");    	
    	
    	criteriaQuery.orderBy(criteriaBuilder.asc(expNome));    	

    	List<Filial> resultado = getEntityManager().createQuery(criteriaQuery).getResultList();
    	return resultado;
	}	

}
