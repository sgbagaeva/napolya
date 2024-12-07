package com.example.napolya.services;

import com.example.napolya.model.Provider;
import com.example.napolya.repositories.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProviderService extends GenericService<Provider, Integer> {
    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        super(providerRepository);
        this.providerRepository = providerRepository;
    }
    // Метод для поиска провайдера по имени
    public Optional<Provider> findByName(String name) {
        return providerRepository.findByName(name);
    }
}
