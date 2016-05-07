/**
 * 
 */
package shop;

import java.sql.Date;


/**
 * @author Shandy
 *
 */
public class RequestCache {
	private Integer UserId;
	private Integer PresentMoney;
	private Date 	PresentTime;
	private Integer ApplyCount;
	private Integer ShopId;
	private Integer ShopSaleId;
	
	private static class LazySingleton {    
	       private static final RequestCache INSTANCE = new RequestCache();    
	    }    
	
    private RequestCache (){}    
    public static final RequestCache getInstance() {    
       return LazySingleton.INSTANCE;    
    }    
    
    public Integer getUserId() {
		return this.UserId;
	}

	public void setUserId(Integer UserId) {
		this.UserId = UserId;
	}
	
	public Integer getPresentMoney() {
		return this.PresentMoney;
	}

	public void setPresentMoney(Integer PresentMoney) {
		this.PresentMoney = PresentMoney;
	}
	
	public Date getPresentTime() {
		return this.PresentTime;
	}

	public void setPresentTime(Date PresentTime) {
		this.PresentTime = PresentTime;
	}
	
	public Integer getApplyCount() {
		return this.ApplyCount;
	}

	public void setApplyCount(Integer ApplyCount) {
		this.ApplyCount = ApplyCount;
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
	
}
