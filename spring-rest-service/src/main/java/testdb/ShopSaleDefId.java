// default package
// Generated 2016-5-8 10:48:16 by Hibernate Tools 4.3.1.Final
package testdb;
/**
 * ShopSaleDefId generated by hbm2java
 */
public class ShopSaleDefId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8367274487224728288L;
	private Integer ShopId;
	private Integer ShopSaleId;
	private Integer ShopSaleInstId;

	public ShopSaleDefId() {
	}

	public ShopSaleDefId(Integer ShopId, Integer ShopSaleId, Integer ShopSaleInstId) {
		this.ShopId = ShopId;
		this.ShopSaleId = ShopSaleId;
		this.ShopSaleInstId = ShopSaleInstId;
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

	public Integer getShopSaleInstId() {
		return this.ShopSaleInstId;
	}

	public void setShopSaleInstId(Integer ShopSaleInstId) {
		this.ShopSaleInstId = ShopSaleInstId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ShopSaleDefId))
			return false;
		ShopSaleDefId castOther = (ShopSaleDefId) other;

		return ((this.getShopId() == castOther.getShopId()) || (this.getShopId() != null
				&& castOther.getShopId() != null && this.getShopId().equals(castOther.getShopId())))
				&& ((this.getShopSaleId() == castOther.getShopSaleId()) || (this.getShopSaleId() != null
						&& castOther.getShopSaleId() != null && this.getShopSaleId().equals(castOther.getShopSaleId())))
				&& ((this.getShopSaleInstId() == castOther.getShopSaleInstId())
						|| (this.getShopSaleInstId() != null && castOther.getShopSaleInstId() != null
								&& this.getShopSaleInstId().equals(castOther.getShopSaleInstId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getShopId() == null ? 0 : this.getShopId().hashCode());
		result = 37 * result + (getShopSaleId() == null ? 0 : this.getShopSaleId().hashCode());
		result = 37 * result + (getShopSaleInstId() == null ? 0 : this.getShopSaleInstId().hashCode());
		return result;
	}
	@Override
	public String toString(){
		return new StringBuffer().append("{ShopId="+ShopId.toString()+"},")
				.append("{ShopSaleId="+ShopSaleId.toString()+"},")
				.append("{ShopSaleInstId="+ShopSaleInstId.toString()+"},").toString();
	}
}
