package exemplo.seguranca.entidades;

import exemplo.seguranca.dtos.EmprestimoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "emprestimos")
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@OneToOne
	private Livro livro;
	@OneToOne
	private Usuario usuario;
	private String status;
	
	public Emprestimo(String id, Livro livro, Usuario usuario, String status) {
		this.id = id;
		this.livro = livro;
		this.usuario = usuario;
		this.status = status;
	}
	
	public Emprestimo() {
		
	}

	public Emprestimo(EmprestimoDTO emprestimoDTO) {
		// TODO Auto-generated constructor stub
		this.livro = emprestimoDTO.livro();
		this.usuario = emprestimoDTO.usuario();
	}
	
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
