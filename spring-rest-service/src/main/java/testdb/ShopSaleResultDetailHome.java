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

/**
 * Home object for domain model class ShopSaleResultDetail.
 * @see .ShopSaleResultDetail
 * @author Hibernate Tools
 */
public class ShopSaleResultDetailHome {

	private static final Log log = LogFactory.getLog(ShopSaleResultDetailHome.class);

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
	public void persist(ShopSaleResultDetail transientInstance) {
		log.debug("persisting ShopSaleResultDetail instance");
		try {
			getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ShopSaleResultDetail instance) {
		log.debug("attaching dirty ShopSaleResultDetail instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(ShopSaleResultDetail instance) {
		log.debug("attaching clean ShopSaleResultDetail instance");
		try {
			getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ShopSaleResultDetail persistentInstance) {
		log.debug("deleting ShopSaleResultDetail instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public void truncate() {
		log.debug("truncating ShopSaleResultDetail instance");
		Transaction tx=null;
		try {
			tx = getCurrentSession().beginTransaction();
			getCurrentSession().createQuery("delete from test.shop_sale_result_detail").executeUpdate();
			log.debug("truncating successful");
			tx.commit();
			
		} catch (RuntimeException re) {
			if(tx != null&&tx.isActive())
				tx.rollback();
			log.error("merge failed", re);
			throw re;
		}
	}
	public ShopSaleResultDetail merge(ShopSaleResultDetail detachedInstance) {
		log.debug("merging ShopSaleResultDetail instance");
		Transaction tx=null;
		try {
			tx = getCurrentSession().beginTransaction();
			ShopSaleResultDetail result = (ShopSaleResultDetail) getCurrentSession()
					.merge(detachedInstance);
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

	public ShopSaleResultDetail findById(ShopSaleResultDetailId id) {
		log.debug("getting ShopSaleResultDetail instance with id: " + id);
		try {
			ShopSaleResultDetail instance = (ShopSaleResultDetail) getCurrentSession().get("testdb.ShopSaleResultDetail", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public List all() {
		log.debug("getting ShopSaleResultDetail ");
		Transaction tx=null;
		try {
			tx = getCurrentSession().beginTransaction();
			//ShopSaleDef instance = (ShopSaleDef) getCurrentSession().get("ShopSaleResultDetail", webServiceData);
			@SuppressWarnings("unchecked")
			List results = getCurrentSession().createCriteria(ShopSaleResultDetail.class).add(Restrictions.isNotNull("id.ShopId")).list();
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
	public List findByExample(ShopSaleResultDetail instance) {
		log.debug("finding ShopSaleResultDetail instance by example");
		Transaction tx=null;
		try {
			tx = getCurrentSession().beginTransaction();
			@SuppressWarnings("unchecked")
			List results = getCurrentSession().createCriteria(ShopSaleResultDetail.class)
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
