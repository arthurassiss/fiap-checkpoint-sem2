package br.com.fiap.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.ecommerce.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
