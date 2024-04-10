package exemplo.seguranca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exemplo.seguranca.dtos.LivroDTO;
import exemplo.seguranca.servicos.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;
	
	@GetMapping
	public List<LivroDTO> listarAllLivros( ){
		return livroService.getAllLivros();
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity listarLivroPorId(@PathVariable String nome) {
		return livroService.findByNome(nome);
	}
}
