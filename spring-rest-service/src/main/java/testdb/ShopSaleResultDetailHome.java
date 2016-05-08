// default package
// Generated 2016-5-8 10:48:16 by Hibernate Tools 4.3.1.Final
package testdb;
import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

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
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ShopSaleResultDetail transientInstance) {
		log.debug("persisting ShopSaleResultDetail instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ShopSaleResultDetail instance) {
		log.debug("attaching dirty ShopSaleResultDetail instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
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
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ShopSaleResultDetail persistentInstance) {
		log.debug("deleting ShopSaleResultDetail instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShopSaleResultDetail merge(ShopSaleResultDetail detachedInstance) {
		log.debug("merging ShopSaleResultDetail instance");
		try {
			ShopSaleResultDetail result = (ShopSaleResultDetail) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ShopSaleResultDetail findById(ShopSaleResultDetailId id) {
		log.debug("getting ShopSaleResultDetail instance with id: " + id);
		try {
			ShopSaleResultDetail instance = (ShopSaleResultDetail) sessionFactory.getCurrentSession()
					.get("ShopSaleResultDetail", id);
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

	public List findByExample(ShopSaleResultDetail instance) {
		log.debug("finding ShopSaleResultDetail instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("ShopSaleResultDetail")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
