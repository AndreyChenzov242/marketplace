package edu.javavt18.service;

import edu.javavt18.model.MarketProduct;
import java.util.List;

public interface MarketProductService {
    void saveOrUpdate(MarketProduct item);

    void delete(int itemId);

    MarketProduct get(int itemId);

    List<MarketProduct> list();
}