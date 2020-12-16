package edu.javavt18.dao.hibernate;

import edu.javavt18.dao.MarketSupplierDAO;
import edu.javavt18.model.MarketSupplier;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MarketSupplierDAOHibernateImpl implements MarketSupplierDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void saveOrUpdate(MarketSupplier item) {
        if (item.getIdSupplier() > 0) {
            //update
            getCurrentSession().merge(item);
        } else {
            //insert
            getCurrentSession().save(item);
        }

    }

    public void delete(int itemId) {
        MarketSupplier marketSupplier = get(itemId);
        if (marketSupplier != null)
            getCurrentSession().delete(marketSupplier);
    }

    public MarketSupplier get(int itemId) {
        MarketSupplier marketSupplier = (MarketSupplier) getCurrentSession().get(MarketSupplier.class, itemId);

        return marketSupplier;
    }

    public List<MarketSupplier> list() {
        Criteria criteria = getCurrentSession().createCriteria(MarketSupplier.class);

        return criteria.list();
    }
}