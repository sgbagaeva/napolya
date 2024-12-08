package com.example.napolya.services;

import com.example.napolya.model.ProviderField;
import com.example.napolya.repositories.ProviderFieldRepository;
import org.springframework.stereotype.Service;

@Service
public class ProviderFieldService extends GenericService<ProviderField, Integer> {
    private final ProviderFieldRepository providerFieldRepository;

    public ProviderFieldService(ProviderFieldRepository providerFieldRepository) {
        super(providerFieldRepository);
        this.providerFieldRepository = providerFieldRepository;
    }
}

