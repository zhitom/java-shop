/**
 * 
 */
package shop;

import java.util.Date;

/**
 * @author Shandy
 *
 */
public class RequestCache {
	private Integer UserId;
	private Integer ShopId;
	private Integer ShopSaleId;
	private Integer ShopSaleInstId;
	private Integer PresentMoney;
	private Date 	PresentTime;//仅第一次记录
	private Integer ApplyCount;
	
	public RequestCache(){
		ApplyCount=new Integer(1);
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
	
	public long getSecondsByNow(){
		return (new Date().getTime() - PresentTime.getTime())/1000;
	}

	public Integer getShopSaleInstId() {
		return ShopSaleInstId;
	}

	public void setShopSaleInstId(Integer shopSaleInstId) {
		ShopSaleInstId = shopSaleInstId;
	}
}
