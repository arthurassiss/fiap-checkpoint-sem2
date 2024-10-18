package br.com.fiap.ecommerce.mapper;

import org.modelmapper.ModelMapper;

import br.com.fiap.ecommerce.dtos.ClienteRequestCreateDto;
import br.com.fiap.ecommerce.dtos.ClienteRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.ClienteResponseDto;
import br.com.fiap.ecommerce.model.Cliente;

public class ClienteMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static Cliente toModel(ClienteRequestCreateDto dto) {
        return modelMapper.map(dto, Cliente.class);
    }

    public static Cliente toModel(ClienteRequestUpdateDto dto, Long id) {
        Cliente cliente = modelMapper.map(dto, Cliente.class);
        cliente.setId(id);
        return cliente;
    }

    public static ClienteResponseDto toDto(Cliente cliente) {
        return modelMapper.map(cliente, ClienteResponseDto.class);
    }
}
