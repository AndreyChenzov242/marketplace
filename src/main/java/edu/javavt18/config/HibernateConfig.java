package edu.javavt18.config;

import edu.javavt18.dao.MarketSupplierDAO;
import edu.javavt18.dao.MarketProductDAO;
import edu.javavt18.dao.hibernate.MarketProductDAOHibernateImpl;
import edu.javavt18.dao.hibernate.MarketSupplierDAOHibernateImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:application.properties"})
@ComponentScan({"edu.javavt18"})
public class HibernateConfig {

    @Autowired
    private DataSource dataSource;

    //Hibernate configuration
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan(new String[] { "edu.javavt18.model" });
        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }

    @Bean
    public MarketSupplierDAO getMarketSupplierHibernateDAO() {
        return new MarketSupplierDAOHibernateImpl();
    }
    @Bean
    public MarketProductDAO getMarketProductHibernateDAO() {
        return new MarketProductDAOHibernateImpl();
    }
}