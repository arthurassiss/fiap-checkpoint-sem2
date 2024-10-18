package br.com.fiap.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.ecommerce.dtos.ItemPedidoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.ItemPedidoResponseDto;
import br.com.fiap.ecommerce.mapper.ItemPedidoMapper;
import br.com.fiap.ecommerce.model.ItemPedido;
import br.com.fiap.ecommerce.service.ItemPedidoService;

@RestController
@RequestMapping("/item-pedidos")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public ResponseEntity<List<ItemPedidoResponseDto>> list() {
        List<ItemPedidoResponseDto> dtos = itemPedidoService.list()
            .stream()
            .map(ItemPedidoMapper::toDto)
            .toList();
        
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<ItemPedidoResponseDto> create(@RequestBody ItemPedidoRequestCreateDto dto) {
        ItemPedido itemPedido = ItemPedidoMapper.toModel(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ItemPedidoMapper.toDto(itemPedidoService.save(itemPedido)));
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemPedidoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(itemPedidoService.findById(id)
                        .map(ItemPedidoMapper::toDto)
                        .orElseThrow(() -> new RuntimeException("Id inexistente")));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (!itemPedidoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }
        itemPedidoService.delete(id);
    }
}

