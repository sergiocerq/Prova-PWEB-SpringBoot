package exemplo.seguranca.entidades;

import org.hibernate.annotations.ValueGenerationType;

import exemplo.seguranca.dtos.LivroDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "livros")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String titulo;
	private String status;
	
	public Livro() {
	}
	

	public Livro(String id, String titulo, String status) {
		this.id = id;
		this.titulo = titulo;
		this.status = status;
	}

	public Livro(LivroDTO livroDTO) {
		// TODO Auto-generated constructor stub
		this.id = livroDTO.id();
		this.titulo = livroDTO.titulo();
		this.status = livroDTO.status();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
