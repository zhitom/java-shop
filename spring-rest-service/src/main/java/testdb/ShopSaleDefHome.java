// default package
// Generated 2016-5-8 10:48:16 by Hibernate Tools 4.3.1.Final
package testdb;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import shop.WebServiceData;

/**
 * Home object for domain model class ShopSaleDef.
 * @see .ShopSaleDef
 * @author Hibernate Tools
 */
public class ShopSaleDefHome {

	private static final Log log = LogFactory.getLog(ShopSaleDefHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			//return (SessionFactory) new InitialContext().lookup("SessionFactory");
			//SessionFactory sf= .buildSessionFactory(serviceRegistry)buildSessionFactory();
			
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
	public void persist(ShopSaleDef transientInstance) {
		log.debug("persisting ShopSaleDef instance");
		try {
			getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ShopSaleDef instance) {
		log.debug("attaching dirty ShopSaleDef instance");
		try {
			//getCurrentSession().saveOrUpdate(instance);
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(ShopSaleDef instance) {
		log.debug("attaching clean ShopSaleDef instance");
		try {
			//getCurrentSession().lock(instance, LockMode.NONE);
			getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ShopSaleDef persistentInstance) {
		log.debug("deleting ShopSaleDef instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShopSaleDef merge(ShopSaleDef detachedInstance) {
		log.debug("merging ShopSaleDef instance");
		try {
			ShopSaleDef result = (ShopSaleDef) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ShopSaleDef findById(WebServiceData webServiceData) {
		log.debug("getting ShopSaleDef instance with id: " + webServiceData);
		Transaction tx=null;
		try {
			tx = getCurrentSession().beginTransaction();
			//ShopSaleDef instance = (ShopSaleDef) sessionFactory.getCurrentSession().get("ShopSaleDef", webServiceData);
			@SuppressWarnings("unchecked")
			List results = getCurrentSession().createCriteria(ShopSaleDef.class)
					.add(Restrictions.eq("id.ShopId", webServiceData.getShopId()))
					.add(Restrictions.eq("id.ShopSaleId", webServiceData.getShopSaleId()))
					.add(Restrictions.eq("id.ShopSaleInstId", webServiceData.getShopSaleInstId())).list();
			tx.commit();
			if (results.size() == 0) {
				log.debug("get successful, no instance found");
				return null;
			} else {
				log.debug("get successful, instance found");
				long nowSecs=new Date().getTime();
				if(((ShopSaleDef)(results.get(0))).getBeginTime().getTime()<=nowSecs && 
						nowSecs < ((ShopSaleDef)(results.get(0))).getEndTime().getTime() ){
					long beginTime=((ShopSaleDef)(results.get(0))).getBeginTime().getTime(),
							endTime=((ShopSaleDef)(results.get(0))).getEndTime().getTime();
					log.debug("expire data found:beginTime="+new Long(beginTime).toString()+
							",nowTime="+new Long(nowSecs).toString()+
							",endTime="+new Long(endTime).toString());
					return null;
				}
				return (ShopSaleDef)(results.get(0));
			}
		} catch (RuntimeException re) {
			if(tx != null&&tx.isActive())
				tx.rollback();
			log.error("get failed", re);
			throw re;
		}
	}
	public List all() {
		log.debug("getting ShopSaleDef ");
		Transaction tx=null;
		try {
			tx = getCurrentSession().beginTransaction();
			//ShopSaleDef instance = (ShopSaleDef) sessionFactory.getCurrentSession().get("ShopSaleDef", webServiceData);
			@SuppressWarnings("unchecked")
			List results = getCurrentSession().createCriteria(ShopSaleDef.class).add(Restrictions.isNotNull("id.ShopId")).list();
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

	public List findByExample(ShopSaleDef instance) {
		log.debug("finding ShopSaleDef instance by example");
		Transaction tx=null;
		try {
			tx = getCurrentSession().beginTransaction();
			@SuppressWarnings("unchecked")
			List results =  getCurrentSession().createCriteria(ShopSaleDef.class)
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
