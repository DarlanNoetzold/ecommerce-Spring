package tech.noetzold.ecommerce.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.noetzold.ecommerce.modelos.Funcionario;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {

}
