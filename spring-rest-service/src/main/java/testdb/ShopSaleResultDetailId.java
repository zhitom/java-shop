// default package
// Generated 2016-5-7 20:32:10 by Hibernate Tools 4.0.0.Final
package testdb;
/**
 * ShopSaleResultDetailId generated by hbm2java
 */
public class ShopSaleResultDetailId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3543517282163710276L;
	private Integer UserId;
	private Integer ShopId;
	private Integer ShopSaleId;

	public ShopSaleResultDetailId() {
	}

	public ShopSaleResultDetailId(Integer UserId, Integer ShopId, Integer ShopSaleId) {
		this.UserId = UserId;
		this.ShopId = ShopId;
		this.ShopSaleId = ShopSaleId;
	}

	public Integer getUserId() {
		return this.UserId;
	}

	public void setUserId(Integer UserId) {
		this.UserId = UserId;
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
		if (!(other instanceof ShopSaleResultDetailId))
			return false;
		ShopSaleResultDetailId castOther = (ShopSaleResultDetailId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(castOther.getUserId())))
				&& ((this.getShopId() == castOther.getShopId()) || (this.getShopId() != null
						&& castOther.getShopId() != null && this.getShopId().equals(castOther.getShopId())))
				&& ((this.getShopSaleId() == castOther.getShopSaleId())
						|| (this.getShopSaleId() != null && castOther.getShopSaleId() != null
								&& this.getShopSaleId().equals(castOther.getShopSaleId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result + (getShopId() == null ? 0 : this.getShopId().hashCode());
		result = 37 * result + (getShopSaleId() == null ? 0 : this.getShopSaleId().hashCode());
		return result;
	}

}
