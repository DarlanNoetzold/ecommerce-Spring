package tech.noetzold.ecommerce.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.noetzold.ecommerce.modelos.EntradaItens;

public interface EntradaItensRepositorio extends JpaRepository<EntradaItens, Long> {

}
