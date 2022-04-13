package controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import modelo.Endereco;
import modelo.Filial;
import modelo.Funcionario;
import service.FilialService;
import service.FuncionarioService;

@ViewScoped
@ManagedBean
public class FuncionarioBean {
	
	@EJB
	FuncionarioService funcionarioService;
	@EJB
	FilialService filialService = new FilialService();		
	private Funcionario funcionario = new Funcionario();
	private List<Funcionario> listaDeFuncionario = new ArrayList<Funcionario>();
	private List<Filial> filiais = new ArrayList<Filial>();
	private Endereco endereco = new Endereco();		
	private Long idFilialAtual = 0L;	
	private Boolean botao = true;
	
	@PostConstruct
	protected void inicializar() {
		
		filtarFuncionario();
		filiais = filialService.listAll();
		
	}
	
	public void retomarLista() {
		inicializar();
	}
	
	public void filtarFuncionario() {
		listaDeFuncionario = funcionarioService.filtrarFuncionarioPorNome();		
	}
	
	public void gravarNovoFuncionario() {
		
		Filial f = filialService.obtemPorId(idFilialAtual);
		 
		 if(f == null || idFilialAtual == 0) {
			 FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage("Campo Filial Obrigatorio"));		      
		   }else {		
			   
		       funcionario.setFilial(f);
		       funcionario.setEndereco(endereco);		     
		      			   
			   funcionarioService.create(funcionario);			   
			   
			   funcionario = new Funcionario();
			   endereco = new Endereco();
			   
			   filtarFuncionario();
		   }
		   
	}
	
	public void editarFuncionarioCadastrado() {
		
		Filial f = filialService.obtemPorId(idFilialAtual);
		 
		 if(f == null || idFilialAtual == 0){
		      
		   }else{		     
		     funcionario.setEndereco(endereco);
		   }		   

		   if(funcionario.getFilial().getId() != idFilialAtual){
		      FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage("Após cadastrado não será permitido editar a filial."));
		      idFilialAtual = 0L;
		   }else {			   
		       funcionarioService.merge(funcionario);
		       botao = true;
		   }
		   
		   funcionario = new Funcionario();
		   endereco = new Endereco();

		  filtarFuncionario(); 
	
	}		
	
	public void editarFuncionario(Funcionario funcionarioAtual) {
		
		funcionario = funcionarioAtual;
		endereco = funcionarioAtual.getEndereco();
		idFilialAtual = funcionario.getFilial().getId();		
		botao = false;	
		
	}

	public void filtrarFiliais() {		
		listaDeFuncionario = funcionarioService.filtrarFilialPelaLista(idFilialAtual);		
	}	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getListaDeFuncionario() {
		return listaDeFuncionario;
	}

	public void setListaDeFuncionario(List<Funcionario> listaDeFuncionario) {
		this.listaDeFuncionario = listaDeFuncionario;
	}

	public Long getIdFilialAtual() {
		return idFilialAtual;
	}

	public void setIdFilialAtual(Long idFilialAtual) {
		this.idFilialAtual = idFilialAtual;
	}

	public List<Filial> getFiliais() {
		return filiais;
	}

	public void setFiliais(List<Filial> filiais) {
		this.filiais = filiais;
	}

	public Boolean getBotao() {
		return botao;
	}

	public void setBotao(Boolean botao) {
		this.botao = botao;
	}	
	
}
