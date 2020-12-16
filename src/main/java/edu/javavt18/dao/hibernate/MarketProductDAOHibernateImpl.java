package edu.javavt18.dao.hibernate;

import edu.javavt18.dao.MarketProductDAO;
import edu.javavt18.model.MarketProduct;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MarketProductDAOHibernateImpl implements MarketProductDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void saveOrUpdate(MarketProduct item) {
        if (item.getIdProduct() > 0) {
            getCurrentSession().merge(item);
        } else {
            getCurrentSession().save(item);
        }

    }

    public void delete(int itemId) {
        MarketProduct marketProduct = get(itemId);
        if (marketProduct != null)
            getCurrentSession().delete(marketProduct);
    }

    public MarketProduct get(int itemId) {
        MarketProduct marketProduct = (MarketProduct) getCurrentSession().get(MarketProduct.class, itemId);

        return marketProduct;
    }

    public List<MarketProduct> list() {
        Criteria criteria = getCurrentSession().createCriteria(MarketProduct.class);

        return criteria.list();
    }
}