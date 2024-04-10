package exemplo.seguranca.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import exemplo.seguranca.dtos.EmprestimoDTO;
import exemplo.seguranca.entidades.Emprestimo;
import exemplo.seguranca.repositorios.EmprestimoRepository;

@Service
public class EmprestimoService {
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	public ResponseEntity fazerCheckOutLivro(EmprestimoDTO emprestimoDTO) {
		Emprestimo emprestimo = new Emprestimo (emprestimoDTO);
		emprestimo.setStatus(emprestimoDTO.status());
		emprestimo.setLivro(emprestimoDTO.livro());
		emprestimo.setUsuario(emprestimoDTO.usuario());
		emprestimoRepository.save(emprestimo);
		
		return ResponseEntity.ok(emprestimoDTO);
	}
	
	public ResponseEntity fazerCheckInLivro(String id, String status) {
		var emprestimo = emprestimoRepository.findById(id);
		System.out.print(id);
		if(emprestimo.isPresent()) {
			Emprestimo empresimoDevolvido = emprestimo.get();
			empresimoDevolvido.setStatus(status);
			emprestimoRepository.save(empresimoDevolvido);
			return ResponseEntity.ok(new EmprestimoDTO(empresimoDevolvido));
		}
		
		return ResponseEntity.notFound().build();
	}

}
