package br.com.fiap.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.ecommerce.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
