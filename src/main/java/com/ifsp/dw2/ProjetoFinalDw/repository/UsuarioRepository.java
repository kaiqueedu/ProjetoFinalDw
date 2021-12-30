package com.ifsp.dw2.ProjetoFinalDw.repository;

import com.ifsp.dw2.ProjetoFinalDw.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Optional<Usuario> findByEmail(String email);
	
}
