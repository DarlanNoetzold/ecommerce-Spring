package tech.noetzold.ecommerce.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.noetzold.ecommerce.modelos.ItensCompra;

public interface ItensCompraRepositorio extends JpaRepository<ItensCompra, Long> {

}
