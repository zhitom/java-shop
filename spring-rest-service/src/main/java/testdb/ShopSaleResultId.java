// default package
// Generated 2016-5-7 20:32:10 by Hibernate Tools 4.0.0.Final
package testdb;
/**
 * ShopSaleResultId generated by hbm2java
 */
public class ShopSaleResultId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3132687432328788509L;
	private Integer ShopId;
	private Integer ShopSaleId;

	public ShopSaleResultId() {
	}

	public ShopSaleResultId(Integer ShopId, Integer ShopSaleId) {
		this.ShopId = ShopId;
		this.ShopSaleId = ShopSaleId;
	}

	public Integer getShopId() {
		return this.ShopId;
	}

	public void setShopId(Integer ShopId) {
		this.ShopId = ShopId;
	}

	public Integer getShopSaleId() {
		return this.ShopSaleId;
	}

	public void setShopSaleId(Integer ShopSaleId) {
		this.ShopSaleId = ShopSaleId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ShopSaleResultId))
			return false;
		ShopSaleResultId castOther = (ShopSaleResultId) other;

		return ((this.getShopId() == castOther.getShopId()) || (this.getShopId() != null
				&& castOther.getShopId() != null && this.getShopId().equals(castOther.getShopId())))
				&& ((this.getShopSaleId() == castOther.getShopSaleId())
						|| (this.getShopSaleId() != null && castOther.getShopSaleId() != null
								&& this.getShopSaleId().equals(castOther.getShopSaleId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getShopId() == null ? 0 : this.getShopId().hashCode());
		result = 37 * result + (getShopSaleId() == null ? 0 : this.getShopSaleId().hashCode());
		return result;
	}

}
