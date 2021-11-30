package tech.noetzold.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.noetzold.ecommerce.model.Funcionario;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {

}
