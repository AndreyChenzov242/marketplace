package edu.javavt18.service;

import edu.javavt18.dao.MarketSupplierDAO;
import edu.javavt18.model.MarketSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Hibernate implementation for CarBrandService.
 */
@Service("marketSupplierHibernateService")
@Transactional(readOnly=false, value = "hibernateTransactionManager")
public class MarketSupplierHibernateServiceImpl implements MarketSupplierService {
    @Autowired
    @Qualifier("getMarketSupplierHibernateDAO")
    private MarketSupplierDAO marketSupplierDAO;

    /**
     * Saves CarBrand to the database by adding or updating it.
     * @param item to save in the database.
     */

    public void saveOrUpdate(MarketSupplier item) {
        marketSupplierDAO.saveOrUpdate(item);
    }

    /**
     * Deletes itemId from database.
     * @param itemId to delete in the database.
     */

    public void delete(int itemId) {
        marketSupplierDAO.delete(itemId);
    }

    /**
     * Get single CarBrand item by itemId from database.
     * @param itemId to get from the database.
     * @return CarBrand from the database.
     */

    public MarketSupplier get(int itemId) {
        return marketSupplierDAO.get(itemId);
    }

    /**
     * Selects all CarBrands from the database.
     * @return CarBrand list from the database.
     */

    public List<MarketSupplier> list() {
        return marketSupplierDAO.list();
    }
}