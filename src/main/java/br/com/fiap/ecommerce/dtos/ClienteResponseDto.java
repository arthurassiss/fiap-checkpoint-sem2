package br.com.fiap.ecommerce.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ClienteResponseDto {
    private Long id;
    private String nome;
}