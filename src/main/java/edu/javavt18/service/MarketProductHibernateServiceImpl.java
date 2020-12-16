package edu.javavt18.service;

import edu.javavt18.dao.MarketProductDAO;
import edu.javavt18.model.MarketProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Hibernate implementation for  CarModelService.
 */

@Service("marketProductHibernateService")
@Transactional(readOnly=false, value = "hibernateTransactionManager")
public class MarketProductHibernateServiceImpl implements MarketProductService {
    @Autowired
    @Qualifier("getMarketProductHibernateDAO")
    private MarketProductDAO marketProductlDAO;

    /**
     * Saves CarModel to the database by adding or updating it.
     * @param item to save in the database.
     */

    public void saveOrUpdate(MarketProduct item) {
        marketProductlDAO.saveOrUpdate(item);
    }

    /**
     * Deletes itemId from database.
     * @param itemId to delete in the database.
     */

    public void delete(int itemId) {
        marketProductlDAO.delete(itemId);
    }

    /**
     * Get single CarModel item by itemId from database.
     * @param itemId to get from the database.
     * @return CarModel from the database.
     */

    public MarketProduct get(int itemId) {
        return marketProductlDAO.get(itemId);
    }

    /**
     * Selects all CarModels from the database.
     * @return CarModel list from the database.
     */

    public List<MarketProduct> list() {
        return marketProductlDAO.list();
    }
}