package tech.noetzold.ecommerce.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.noetzold.ecommerce.modelos.Permissao;

public interface PermissaoRepositorio extends JpaRepository<Permissao, Long> {

}
