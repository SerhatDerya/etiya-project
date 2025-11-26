package com.etiya.basketservice.service.concretes;

import com.etiya.basketservice.client.BillingAccountServiceClient;
import com.etiya.basketservice.client.CatalogServiceClient;
import com.etiya.basketservice.domain.Basket;
import com.etiya.basketservice.domain.BasketItem;
import com.etiya.basketservice.repository.BasketRepository;
import com.etiya.basketservice.service.abstracts.BasketService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final BillingAccountServiceClient billingAccountServiceClient;
    private final CatalogServiceClient  catalogServiceClient;

    public BasketServiceImpl(BasketRepository basketRepository, BillingAccountServiceClient billingAccountServiceClient, CatalogServiceClient catalogServiceClient) {
        this.basketRepository = basketRepository;
        this.billingAccountServiceClient = billingAccountServiceClient;
        this.catalogServiceClient = catalogServiceClient;
    }



    @Override
    public void add(UUID billingAccountId, UUID productId) {
        var billingAccount = billingAccountServiceClient.getById(billingAccountId);
        var product = catalogServiceClient.getProductById(productId);
        var basket = basketRepository.getBasketByBillingAccountId(billingAccount.getId());

        if(basket==null){
            basket = new Basket();
            basket.setBillingAccountId(billingAccount.getId());
        }

        BasketItem basketItem = new BasketItem();
        basketItem.setProductId(product.getId());
        basketItem.setProductName(product.getName());
        basketItem.setPrice(product.getPrice());
        basket.setBillingAccountId(billingAccount.getId());
        basket.setTotalPrice(basket.getTotalPrice()+basketItem.getPrice());
        basket.getBasketItems().add(basketItem);
        basketRepository.add(basket);
    }

    @Override
    public Map<String, Basket> getAll() {
        return basketRepository.getAll();
    }
}
