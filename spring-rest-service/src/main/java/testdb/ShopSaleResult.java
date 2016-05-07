// default package
// Generated 2016-5-7 20:32:10 by Hibernate Tools 4.0.0.Final
package testdb;
import java.util.Date;

/**
 * ShopSaleResult generated by hbm2java
 */
public class ShopSaleResult implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7281616040579819000L;
	private ShopSaleResultId id;
	private Integer maxMoney;
	private Integer usedMoney;
	private Date updateTime;

	public ShopSaleResult() {
	}

	public ShopSaleResult(ShopSaleResultId id, Integer maxMoney, Integer usedMoney, Date updateTime) {
		this.id = id;
		this.maxMoney = maxMoney;
		this.usedMoney = usedMoney;
		this.updateTime = updateTime;
	}

	public ShopSaleResultId getId() {
		return this.id;
	}

	public void setId(ShopSaleResultId id) {
		this.id = id;
	}

	public Integer getMaxMoney() {
		return this.maxMoney;
	}

	public void setMaxMoney(Integer maxMoney) {
		this.maxMoney = maxMoney;
	}

	public Integer getUsedMoney() {
		return this.usedMoney;
	}

	public void setUsedMoney(Integer usedMoney) {
		this.usedMoney = usedMoney;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}