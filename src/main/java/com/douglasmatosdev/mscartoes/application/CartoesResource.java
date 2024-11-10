package com.douglasmatosdev.mscartoes.application;

import com.douglasmatosdev.mscartoes.application.representation.CartaoSaveRequest;
import com.douglasmatosdev.mscartoes.domain.Cartao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class CartoesResource {

    private final CartaoService cartaoService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastra(@RequestBody CartaoSaveRequest request) {
        Cartao cartao = request.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAteh(@RequestParam("renda") Long renda){
        List<Cartao> list = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }

//    @GetMapping(params = "cpf")
//    public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(
//            @RequestParam("cpf") String cpf){
//        List<ClienteCartao> lista = clienteCartaoService.listCartoesByCpf(cpf);
//        List<CartoesPorClienteResponse> resultList = lista.stream()
//                .map(CartoesPorClienteResponse::fromModel)
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(resultList);
//    }
}