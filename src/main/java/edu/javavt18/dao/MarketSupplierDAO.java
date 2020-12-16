package edu.javavt18.dao;

import edu.javavt18.model.MarketSupplier;
import java.util.List;

public interface MarketSupplierDAO{

    void saveOrUpdate(MarketSupplier item);

    void delete(int itemId);

    MarketSupplier get(int itemId);

    List<MarketSupplier> list();

}