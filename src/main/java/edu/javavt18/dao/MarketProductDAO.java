package edu.javavt18.dao;

import edu.javavt18.model.MarketProduct;

import java.util.List;

public interface MarketProductDAO {

    void saveOrUpdate(MarketProduct item);

    void delete(int itemId);

    MarketProduct get(int itemId);

    List<MarketProduct> list();

}