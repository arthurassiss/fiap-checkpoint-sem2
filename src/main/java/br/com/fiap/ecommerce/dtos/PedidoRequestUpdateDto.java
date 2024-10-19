package br.com.fiap.ecommerce.dtos;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class PedidoRequestUpdateDto {
    private Long idCliente;
    private LocalDate dataPedido;
    private String status;
    private String formaPagamento;

}
