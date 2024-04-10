package exemplo.seguranca.dtos;

import exemplo.seguranca.entidades.Emprestimo;
import exemplo.seguranca.entidades.Livro;
import exemplo.seguranca.entidades.Usuario;

public record EmprestimoDTO(Livro livro, Usuario usuario, String status) {
	
	public EmprestimoDTO(Emprestimo emp) {
		// TODO Auto-generated constructor stub
		this(emp.getLivro(),emp.getUsuario(), emp.getStatus());
	}
}