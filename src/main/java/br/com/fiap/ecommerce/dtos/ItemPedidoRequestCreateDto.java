package br.com.fiap.ecommerce.dtos;

import java.math.BigDecimal;

public class ItemPedidoRequestCreateDto {
    private Long idPedido;
    private Long idProduto;
    private BigDecimal quantidade;
    public Long getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }
    public Long getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }
    public BigDecimal getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

}


