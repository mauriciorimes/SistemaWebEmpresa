package controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.Endereco;
import modelo.Filial;
import service.FilialService;

@ViewScoped
@ManagedBean
public class FilialBean {
	
	@EJB
	private FilialService filialService;	
	private Filial filial = new Filial();	
	private List<Filial> listaDeFilial = new ArrayList<Filial>();
	private Endereco endereco = new Endereco();	
	private String textoDoFiltro;	

	@PostConstruct
	protected void inicializar() {		
		filtarFilial();		
	}
	
	public void filtarFilial() {
		listaDeFilial = filialService.filtrarFilialPorNome(textoDoFiltro);
	}	
	
	public void gravarFilial() {
		
		filial.setEndereco(endereco);
		
		if (filial.getId() == null) {
			filialService.create(filial);
		} else {
			filialService.merge(filial);			
		}		 		
		
		filial = new Filial();
		endereco = new Endereco();		
		filtarFilial();
		
	}
	
	public void editarFilial(Filial filialAtual) {
		
		filial = filialAtual;
		endereco = filialAtual.getEndereco();
		
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public List<Filial> getListaDeFilial() {
		return listaDeFilial;
	}

	public void setListaDeFilial(List<Filial> listaDeFilial) {
		this.listaDeFilial = listaDeFilial;
	}
	
	public String getTextoDoFiltro() {
		return textoDoFiltro;
	}

	public void setTextoDoFiltro(String textoDoFiltro) {
		this.textoDoFiltro = textoDoFiltro;
	}	
	
}
