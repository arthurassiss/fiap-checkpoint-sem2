package br.com.fiap.ecommerce.dtos;

public class ClienteRequestCreateDto {
    private String nome;
    private String cep;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

}


