package exemplo.seguranca.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import exemplo.seguranca.dtos.LivroDTO;
import exemplo.seguranca.entidades.Livro;
import exemplo.seguranca.repositorios.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	public List<LivroDTO> getAllLivros(){
		return livroRepository.findAll().stream().map(LivroDTO::new).toList();
	}
	
	public ResponseEntity <LivroDTO> salvar(LivroDTO livroDTO) {
		Livro livro = new Livro(livroDTO);
		livroRepository.save(livro);
		
		return ResponseEntity.ok().build();
	}
	
	public ResponseEntity<LivroDTO> findByNome(String nome) {
		var livro = livroRepository.findByTitulo(nome);
		if(livro.isPresent()) {
			Livro livroResponse = (Livro) livro.get();
			
			return ResponseEntity.ok(new LivroDTO(livroResponse));
		}
		
		return ResponseEntity.notFound().build();
	}

}