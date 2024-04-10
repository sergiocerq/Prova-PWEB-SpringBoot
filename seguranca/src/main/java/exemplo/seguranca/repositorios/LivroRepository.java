package exemplo.seguranca.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import exemplo.seguranca.entidades.Livro;

public interface LivroRepository extends JpaRepository<Livro, String>{

	Optional<Livro> findByTitulo(String nome);
	
}
