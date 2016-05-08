package shop;

import java.util.Date;

public class ShopMoneyCache {
	private Integer ShopId;
	private Integer ShopSaleId;
	private Integer ShopSaleInstId;
	private Integer UsedMoney;
	private Integer MaxMoney;
	private Date 	UpdateTime;
	
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
	
    public Integer getUsedMoney() {
		return this.UsedMoney;
	}

	public void setUsedMoney(Integer UsedMoney) {
		this.UsedMoney = UsedMoney;
	}
	
	public Integer getMaxMoney() {
		return this.MaxMoney;
	}

	public void setMaxMoney(Integer MaxMoney) {
		this.MaxMoney = MaxMoney;
	}
	
	public Date getUpdateTime() {
		return this.UpdateTime;
	}

	public void setUpdateTime(Date UpdateTime) {
		this.UpdateTime = UpdateTime;
	}

	public long getSecondsByNow(){
		return (new Date().getTime() - UpdateTime.getTime())/1000;
	}

	public Integer getShopSaleInstId() {
		return ShopSaleInstId;
	}

	public void setShopSaleInstId(Integer shopSaleInstId) {
		ShopSaleInstId = shopSaleInstId;
	}

}
