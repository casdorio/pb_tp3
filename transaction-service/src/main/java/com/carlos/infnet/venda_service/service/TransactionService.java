package com.carlos.infnet.venda_service.service;

import org.springframework.stereotype.Service;

import com.carlos.infnet.venda_service.model.Transaction;
import com.carlos.infnet.venda_service.repository.TransactionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public Transaction create(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

}
