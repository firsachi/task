package kievreclama.task.configurations;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import kievreclama.task.dao.impl.CompanyDaoImpl;
import kievreclama.task.model.FactoryDao;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	@Bean
	public ComboPooledDataSource dataSource(){
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("org.postgresql.Driver");
			dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/informer");
			dataSource.setUser("informer");
			dataSource.setPassword("1q2w3e4r");
			dataSource.setMaxPoolSize(30);
			dataSource.setMinPoolSize(2);
			dataSource.setMaxStatements(100);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[]{"kievreclama.task.entity"});
		Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
        properties.put("hibernate.enable_lazy_load_no_trans", true);
		sessionFactory.setHibernateProperties(properties);
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
	      HibernateTransactionManager txManager = new HibernateTransactionManager();
	      txManager.setSessionFactory(sessionFactory);
	      return txManager;
	   }

	@Bean 
	public FactoryDao factoryDao() {
		return FactoryDao.getInstance();
	}
	
	@Bean
	public CompanyDaoImpl companyDao(){
		return new CompanyDaoImpl();
	}

}
