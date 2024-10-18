package br.com.fiap.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.ecommerce.model.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
