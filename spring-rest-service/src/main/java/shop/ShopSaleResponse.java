package shop;

import shop.WebServiceData.POLICY;

public class ShopSaleResponse {

    private final long UserId;
    private final long ShopId;
    private final long ShopSaleId;
    private final long ShopSaleInstId;
    private final WebServiceData.POLICY  ResultCode;
    private final long PresentMoney;//红包金额
    private final long SpentMSecs;//花费的毫秒数

    public ShopSaleResponse(long UserId, long ShopId, long ShopSaleId,long ShopSaleInstId,WebServiceData.POLICY resultCode,long PresentMoney,long SpentMSecs) {
        this.UserId = UserId;
        this.ShopId = ShopId;
        this.ShopSaleId = ShopSaleId;
        this.ShopSaleInstId = ShopSaleInstId;
        this.ResultCode = resultCode;
        this.PresentMoney = PresentMoney;
        this.SpentMSecs = SpentMSecs;
    }
    
    public long getUserId() {
        return UserId;
    }
    
    public long getShopId() {
        return ShopId;
    }
    
    public long getShopSaleId() {
        return ShopSaleId;
    }

    public long getShopSaleInstId() {
        return ShopSaleInstId;
    }
    
    public POLICY getResultCode() {
        return ResultCode;
    }

	public long getPresentMoney() {
		return PresentMoney;
	}

	public long getSpentMSecs() {
		return SpentMSecs;
	}
}

