package tech.noetzold.ecommerce.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.noetzold.ecommerce.modelos.Papel;

public interface PapelRepositorio extends JpaRepository<Papel, Long> {

}
