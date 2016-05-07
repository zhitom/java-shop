// default package
// Generated 2016-5-7 20:32:11 by Hibernate Tools 4.0.0.Final
package testdb;
import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

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
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ShopSaleResult transientInstance) {
		log.debug("persisting ShopSaleResult instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ShopSaleResult instance) {
		log.debug("attaching dirty ShopSaleResult instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
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
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ShopSaleResult persistentInstance) {
		log.debug("deleting ShopSaleResult instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShopSaleResult merge(ShopSaleResult detachedInstance) {
		log.debug("merging ShopSaleResult instance");
		try {
			ShopSaleResult result = (ShopSaleResult) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ShopSaleResult findById(ShopSaleResultId id) {
		log.debug("getting ShopSaleResult instance with id: " + id);
		try {
			ShopSaleResult instance = (ShopSaleResult) sessionFactory.getCurrentSession().get("ShopSaleResult", id);
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

	public List findByExample(ShopSaleResult instance) {
		log.debug("finding ShopSaleResult instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("ShopSaleResult")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
