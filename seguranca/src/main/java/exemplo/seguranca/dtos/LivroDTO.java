package exemplo.seguranca.dtos;

import java.util.Optional;

import exemplo.seguranca.entidades.Livro;
import exemplo.seguranca.entidades.Usuario;
import jakarta.persistence.ManyToOne;

public record LivroDTO(String id, String titulo, String status) {
	public LivroDTO(Livro livro) {
		this(livro.getId(), livro.getTitulo(), livro.getStatus());
	}
}