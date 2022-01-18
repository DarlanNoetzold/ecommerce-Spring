package tech.noetzold.ecommerce.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.noetzold.ecommerce.modelos.Estado;

public interface EstadoRepositorio extends JpaRepository<Estado, Long> {

}
