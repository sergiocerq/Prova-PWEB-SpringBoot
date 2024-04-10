package exemplo.seguranca.entidades;

import org.springframework.security.core.GrantedAuthority;

import exemplo.seguranca.dtos.RoleDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name = "roles")
public class Role implements GrantedAuthority {

	public Role(Long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String role;
	
	public Role(RoleDto roleDto) {
		this.id = roleDto.id();
		this.role = roleDto.role();
	}
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return role;
	}
	
	public String getRole() {
		return this.role;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	

}
