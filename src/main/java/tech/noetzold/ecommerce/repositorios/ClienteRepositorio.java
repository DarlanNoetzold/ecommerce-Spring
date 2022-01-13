package tech.noetzold.ecommerce.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tech.noetzold.ecommerce.modelos.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

	@Query("from Cliente where email=?1")
	public List<Cliente> buscarClienteEmail(String email);
}
