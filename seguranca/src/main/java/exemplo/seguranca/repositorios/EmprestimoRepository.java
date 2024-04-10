package exemplo.seguranca.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import exemplo.seguranca.entidades.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, String>{

}
