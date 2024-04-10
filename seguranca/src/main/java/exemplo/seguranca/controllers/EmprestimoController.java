package exemplo.seguranca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exemplo.seguranca.dtos.EmprestimoDTO;
import exemplo.seguranca.servicos.EmprestimoService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
	
	@Autowired
	private EmprestimoService emprestimoService;

	@PostMapping
	public ResponseEntity<EmprestimoDTO> check_out_livro(@RequestBody EmprestimoDTO emprestimoDTO) {
		System.out.println(emprestimoDTO.livro());
		return emprestimoService.fazerCheckOutLivro(emprestimoDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity check_in_livro(@PathVariable String id, @RequestBody String status) {
		return emprestimoService.fazerCheckInLivro(id, status);
	}
	

}
