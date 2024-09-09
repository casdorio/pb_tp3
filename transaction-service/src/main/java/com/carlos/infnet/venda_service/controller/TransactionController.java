package com.carlos.infnet.venda_service.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.infnet.venda_service.model.Product;
import com.carlos.infnet.venda_service.model.Transaction;
import com.carlos.infnet.venda_service.service.ProductService;
import com.carlos.infnet.venda_service.service.TaxService;
import com.carlos.infnet.venda_service.service.TransactionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/transaction")
@Slf4j
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    private final TaxService taxService;
    //private final ProductService productService;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Transaction transaction) {
        log.info("Creating transaction: {}", transaction.getItems());
        //var teste = taxService.getTaxByItems(transaction.getItems());
        //calcular imposto todos os items da transacao enviado para o taxService e atualizar
        //transaction.setTotalTaxcost(transaction.getItems().stream().map(item -> taxService.getTaxByItems(item)).reduce(BigDecimal.ZERO, BigDecimal::add));
       // var totalTaxCost = transaction.getItems().stream().map(item -> taxService.getTaxByItems(item)).reduce(BigDecimal.ZERO, BigDecimal::add);

        
        Transaction saved = transactionService.create(transaction);
        return ResponseEntity.ok(saved);
    }
}
