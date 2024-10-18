package br.com.fiap.ecommerce.dtos;

import java.math.BigDecimal;

public class ItemPedidoResponseDto {
    private Long id;
    private Long idPedido;
    private Long idProduto;
    private BigDecimal quantidade;
    private BigDecimal valorTotal;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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
    public BigDecimal getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

}