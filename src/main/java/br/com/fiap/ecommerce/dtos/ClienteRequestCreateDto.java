package br.com.fiap.ecommerce.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteRequestCreateDto {
    private String nome;
    private String cep;

}


