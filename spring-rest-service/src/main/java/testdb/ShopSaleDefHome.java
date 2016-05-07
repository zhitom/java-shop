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
 * Home object for domain model class ShopSaleDef.
 * @see .ShopSaleDef
 * @author Hibernate Tools
 */
public class ShopSaleDefHome {

	private static final Log log = LogFactory.getLog(ShopSaleDefHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ShopSaleDef transientInstance) {
		log.debug("persisting ShopSaleDef instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ShopSaleDef instance) {
		log.debug("attaching dirty ShopSaleDef instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
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
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ShopSaleDef persistentInstance) {
		log.debug("deleting ShopSaleDef instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShopSaleDef merge(ShopSaleDef detachedInstance) {
		log.debug("merging ShopSaleDef instance");
		try {
			ShopSaleDef result = (ShopSaleDef) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ShopSaleDef findById(ShopSaleDefId id) {
		log.debug("getting ShopSaleDef instance with id: " + id);
		try {
			ShopSaleDef instance = (ShopSaleDef) sessionFactory.getCurrentSession().get("ShopSaleDef", id);
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

	public List findByExample(ShopSaleDef instance) {
		log.debug("finding ShopSaleDef instance by example");
		try {
			
			List results = sessionFactory.getCurrentSession().createCriteria("ShopSaleDef")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
