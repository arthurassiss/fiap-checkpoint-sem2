package br.com.fiap.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.ecommerce.dtos.ClienteRequestCreateDto;
import br.com.fiap.ecommerce.dtos.ClienteRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.ClienteResponseDto;
import br.com.fiap.ecommerce.mapper.ClienteMapper;
import br.com.fiap.ecommerce.model.Cliente;
import br.com.fiap.ecommerce.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> list() {
        List<ClienteResponseDto> dtos = clienteService.list()
            .stream()
            .map(ClienteMapper::toDto)
            .toList();
        
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDto> create(@RequestBody ClienteRequestCreateDto dto) {
        Cliente cliente = ClienteMapper.toModel(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ClienteMapper.toDto(clienteService.save(cliente)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ClienteResponseDto> update(@PathVariable Long id, @RequestBody ClienteRequestUpdateDto dto) {
        if (!clienteService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }
        Cliente cliente = ClienteMapper.toModel(dto, id);
        return ResponseEntity.ok().body(ClienteMapper.toDto(clienteService.save(cliente)));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (!clienteService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }
        clienteService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(clienteService.findById(id)
                        .map(ClienteMapper::toDto)
                        .orElseThrow(() -> new RuntimeException("Id inexistente")));
    }
}

