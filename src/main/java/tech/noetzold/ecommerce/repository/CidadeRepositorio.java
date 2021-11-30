package tech.noetzold.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.noetzold.ecommerce.model.Cidade;

public interface CidadeRepositorio extends JpaRepository<Cidade, Long> {

}
