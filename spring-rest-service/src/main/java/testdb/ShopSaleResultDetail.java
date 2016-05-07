// default package
// Generated 2016-5-7 20:32:10 by Hibernate Tools 4.0.0.Final
package testdb;
import java.util.Date;

/**
 * ShopSaleResultDetail generated by hbm2java
 */
public class ShopSaleResultDetail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2408530824864504942L;
	private ShopSaleResultDetailId id;
	private Integer presentMoney;
	private Date presentTime;
	private Date applyTime;

	public ShopSaleResultDetail() {
	}

	public ShopSaleResultDetail(ShopSaleResultDetailId id, Integer presentMoney, Date presentTime, Date applyTime) {
		this.id = id;
		this.presentMoney = presentMoney;
		this.presentTime = presentTime;
		this.applyTime = applyTime;
	}

	public ShopSaleResultDetailId getId() {
		return this.id;
	}

	public void setId(ShopSaleResultDetailId id) {
		this.id = id;
	}

	public Integer getPresentMoney() {
		return this.presentMoney;
	}

	public void setPresentMoney(Integer presentMoney) {
		this.presentMoney = presentMoney;
	}

	public Date getPresentTime() {
		return this.presentTime;
	}

	public void setPresentTime(Date presentTime) {
		this.presentTime = presentTime;
	}

	public Date getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

}