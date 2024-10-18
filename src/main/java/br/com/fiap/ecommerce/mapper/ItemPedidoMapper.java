package br.com.fiap.ecommerce.mapper;

import org.modelmapper.ModelMapper;

import br.com.fiap.ecommerce.dtos.ItemPedidoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.ItemPedidoResponseDto;
import br.com.fiap.ecommerce.model.ItemPedido;

public class ItemPedidoMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static ItemPedido toModel(ItemPedidoRequestCreateDto dto) {
        return modelMapper.map(dto, ItemPedido.class);
    }

    public static ItemPedidoResponseDto toDto(ItemPedido itemPedido) {
        return modelMapper.map(itemPedido, ItemPedidoResponseDto.class);
    }
}
