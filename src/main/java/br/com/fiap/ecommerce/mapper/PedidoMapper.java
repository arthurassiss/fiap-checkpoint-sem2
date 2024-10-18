package br.com.fiap.ecommerce.mapper;

import org.modelmapper.ModelMapper;

import br.com.fiap.ecommerce.dtos.PedidoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.PedidoRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.PedidoResponseDto;
import br.com.fiap.ecommerce.model.Pedido;

public class PedidoMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static Pedido toModel(PedidoRequestCreateDto dto) {
        return modelMapper.map(dto, Pedido.class);
    }

    public static Pedido toModel(PedidoRequestUpdateDto dto, Long id) {
        Pedido pedido = modelMapper.map(dto, Pedido.class);
        pedido.setId(id);
        return pedido;
    }

    public static PedidoResponseDto toDto(Pedido pedido) {
        return modelMapper.map(pedido, PedidoResponseDto.class);
    }
}
