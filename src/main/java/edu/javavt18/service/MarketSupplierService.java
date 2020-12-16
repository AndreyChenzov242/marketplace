package edu.javavt18.service;

import edu.javavt18.model.MarketSupplier;
import java.util.List;

public interface MarketSupplierService {

    void saveOrUpdate(MarketSupplier item);

    void delete(int itemId);

    MarketSupplier get(int itemId);

    List<MarketSupplier> list();
}