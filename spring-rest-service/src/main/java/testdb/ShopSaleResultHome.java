// default package
// Generated 2016-5-8 10:48:16 by Hibernate Tools 4.3.1.Final
package testdb;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
//import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import shop.WebServiceData;



/**
 * Home object for domain model class ShopSaleResult.
 * @see .ShopSaleResult
 * @author Hibernate Tools
 */
public class ShopSaleResultHome {

	private static final Log log = LogFactory.getLog(ShopSaleResultHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			//return (SessionFactory) new InitialContext().lookup("SessionFactory");
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			SessionFactory sf = new Configuration(). configure("hibernate.cfg.xml").buildSessionFactory(serviceRegistry);
			 
			//@SuppressWarnings("unused")
			//Session session = sf.openSession();//先加入import org.hibernate.Session;
			return sf;
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}
	private Session getCurrentSession(){
		if(sessionFactory.isClosed()){
			log.debug("sessionFactory.isClosed()=true");
			return sessionFactory.openSession();
		}
		else{
			log.debug("sessionFactory.isClosed()=false");
			return sessionFactory.getCurrentSession();
		}
	}
	public void persist(ShopSaleResult transientInstance) {
		log.debug("persisting ShopSaleResult instance");
		try {
			getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ShopSaleResult instance) {
		log.debug("attaching dirty ShopSaleResult instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(ShopSaleResult instance) {
		log.debug("attaching clean ShopSaleResult instance");
		try {
			getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ShopSaleResult persistentInstance) {
		log.debug("deleting ShopSaleResult instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShopSaleResult merge(ShopSaleResult detachedInstance) {
		log.debug("merging ShopSaleResult instance");
		Transaction tx=null;
		try {
			tx = getCurrentSession().beginTransaction();
			ShopSaleResult result = (ShopSaleResult) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			tx.commit();
			return result;
		} catch (RuntimeException re) {
			if(tx != null&&tx.isActive())
				tx.rollback();
			log.error("merge failed", re);
			throw re;
		}
	}
	public void truncate() {
		log.debug("truncating ShopSaleResult instance");
		Transaction tx=null;
		try {
			tx = getCurrentSession().beginTransaction();
			getCurrentSession().createQuery("delete from test.shop_sale_result").executeUpdate();
			log.debug("truncating successful");
			tx.commit();
			
		} catch (RuntimeException re) {
			if(tx != null&&tx.isActive())
				tx.rollback();
			log.error("merge failed", re);
			throw re;
		}
	}
	public ShopSaleResult findById(ShopSaleResultId id) {
		log.debug("getting ShopSaleResult instance with id: " + id);
		try {
			ShopSaleResult instance = (ShopSaleResult) getCurrentSession().get("testdb.ShopSaleResult", id);
			if (instance == null) {
				log.info("get successful, no instance found");
			} else {
				log.info("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public ShopSaleResult findById(WebServiceData webServiceData,ShopSaleDefHome shopSaleDefHome) {
		log.debug("getting ShopSaleResult instance with id: " + webServiceData.toString());
		Transaction tx=null;
		try {
			tx = getCurrentSession().beginTransaction();
			//ShopSaleResult instance = (ShopSaleResult) getCurrentSession().get("ShopSaleResult", id);
			@SuppressWarnings("unchecked")
			List results = getCurrentSession().createCriteria(ShopSaleResult.class)
					.add(Restrictions.eq("id.ShopId", webServiceData.getShopId()))
					.add(Restrictions.eq("id.ShopSaleId", webServiceData.getShopSaleId()))
					.add(Restrictions.eq("id.ShopSaleInstId", webServiceData.getShopSaleInstId())).list();
			tx.commit();
			if (results.size() == 0) {
				log.debug("get successful, no instance found,insert it...");
				//没查询到就插入一条.
				ShopSaleDef shopSaleDef= shopSaleDefHome.findById(webServiceData);
				if(shopSaleDef != null){
					ShopSaleResult shopSaleResult=new ShopSaleResult();
					shopSaleResult.convert(shopSaleDef);
					return merge(shopSaleResult);
				}else{
					return null;
				}
			} else {
				log.debug("get successful, instance found");
			}
			return (ShopSaleResult)(results.get(0));
		} catch (RuntimeException re) {
			if(tx != null&&tx.isActive())
				tx.rollback();
			log.error("get failed", re);
			throw re;
		}
	}
	public List all() {
		log.debug("getting ShopSaleResult ");
		Transaction tx=null;
		try {
			tx = getCurrentSession().beginTransaction();
			//ShopSaleDef instance = (ShopSaleDef) getCurrentSession().get("ShopSaleResult", webServiceData);
			@SuppressWarnings("unchecked")
			List results = getCurrentSession().createCriteria(ShopSaleResult.class).add(Restrictions.isNotNull("id.ShopId")).list();
			tx.commit();
			if (results.size() == 0) {
				log.info("get successful, no instance found");
				return null;
			} else {
				log.info("get successful, instance found");
				return results;
			}
		} catch (RuntimeException re) {
			if(tx != null&&tx.isActive())
				tx.rollback();
			log.error("get failed", re);
			throw re;
		}
	}
	public List findByExample(ShopSaleResult instance) {
		log.debug("finding ShopSaleResult instance by example");
		Transaction tx=null;
		try {
			tx = getCurrentSession().beginTransaction();
			@SuppressWarnings("unchecked")
			List results = getCurrentSession().createCriteria(ShopSaleResult.class)
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			tx.commit();
			return results;
		} catch (RuntimeException re) {
			if(tx != null&&tx.isActive())
				tx.rollback();
			log.error("find by example failed", re);
			throw re;
		}
	}
}
