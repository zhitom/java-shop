package shop;

import java.sql.Date;

public class ShopMoneyCache {
	private Integer ShopId;
	private Integer ShopSaleId;
	private Integer UsedMoney;
	private Integer MaxMoney;
	private Date 	UpdateTime;
	
	private static class LazySingleton {    
	       private static final ShopMoneyCache INSTANCE = new ShopMoneyCache();    
	    }    
	
    private ShopMoneyCache (){}    
    public static final ShopMoneyCache getInstance() {    
       return LazySingleton.INSTANCE;    
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

}
