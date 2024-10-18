package br.com.fiap.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.ecommerce.dtos.PedidoRequestCreateDto;
import br.com.fiap.ecommerce.dtos.PedidoRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.PedidoResponseDto;
import br.com.fiap.ecommerce.mapper.PedidoMapper;
import br.com.fiap.ecommerce.model.Pedido;
import br.com.fiap.ecommerce.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoResponseDto>> list() {
        List<PedidoResponseDto> dtos = pedidoService.list()
            .stream()
            .map(PedidoMapper::toDto)
            .toList();
        
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDto> create(@RequestBody PedidoRequestCreateDto dto) {
        Pedido pedido = PedidoMapper.toModel(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(PedidoMapper.toDto(pedidoService.save(pedido)));
    }

    @PutMapping("{id}")
    public ResponseEntity<PedidoResponseDto> update(@PathVariable Long id, @RequestBody PedidoRequestUpdateDto dto) {
        if (!pedidoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }
        Pedido pedido = PedidoMapper.toModel(dto, id);
        return ResponseEntity.ok().body(PedidoMapper.toDto(pedidoService.save(pedido)));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (!pedidoService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }
        pedidoService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<PedidoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(pedidoService.findById(id)
                        .map(PedidoMapper::toDto)
                        .orElseThrow(() -> new RuntimeException("Id inexistente")));
    }
}
