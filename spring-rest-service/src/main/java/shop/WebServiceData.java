package shop;


public class WebServiceData {
	public enum POLICY
	{
		NORMAL,//正常
		NORMAL_EMPTY,//正常
	    REPEAT,//重复请求
	    BAD_APPLY_ERROR,//恶意请求
	    ILLEGALLY_USER,//非法用户
	    ERROR, //错误请求
	    NO_SHOP_SALE;//没有商户活动信息
	}
	public final static long MAX_BAD_APPLY_SECONDS=10;//一秒点击量超过该值就认为是恶意
	public final static long MAX_REQUEST_CACHE_TIME=120;//缓存2分钟,可以用于超时缓存清除.
	public final static long MAX_MONEY_CACHE_TIME=20;//可以用于超时缓存清除.
	
	private Integer UserId;
	private Integer ShopId;
	private Integer ShopSaleId;
	private Integer ShopSaleInstId;
	private Integer PresentMoney;//单个用户的红包
	private Integer MaxMoney;//当前的红包最大值
	
	private StringBuffer UserKey=new StringBuffer();
	private StringBuffer ShopSaleInstKey=new StringBuffer();
	private RequestCache requestCache;
	
	public WebServiceData(){
		PresentMoney=new Integer(0);
		MaxMoney=new Integer(0);
	}
	public String getUserKey() {
		return UserKey.toString();
	}
	public void setUserKey(Integer userId,Integer shopId,Integer shopSaleId,Integer shopSaleInstId) {
		setUserId(userId);
		setShopId(shopId);
		setShopSaleId(shopSaleId);
		setShopSaleInstId(shopSaleInstId);
		UserKey.setLength(0);
		UserKey.append(shopId.toString()+"-"+shopSaleId.toString()+"-"+shopSaleInstId.toString()+"-"+userId.toString());
	}
	public String getShopSaleInstKey() {
		return ShopSaleInstKey.toString();
	}
	public void setShopSaleInstKey(Integer shopId,Integer shopSaleId,Integer shopSaleInstId) {
		setShopId(shopId);
		setShopSaleId(shopSaleId);
		setShopSaleInstId(shopSaleInstId);
		ShopSaleInstKey.setLength(0);
		ShopSaleInstKey.append(shopId.toString()+"-"+shopSaleId.toString()+"-"+shopSaleInstId.toString());
	}
	public RequestCache getRequestCache() {
		return requestCache;
	}
	public void setRequestCache(RequestCache requestCache) {
		this.requestCache = requestCache;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public Integer getShopId() {
		return ShopId;
	}
	public void setShopId(Integer shopId) {
		ShopId = shopId;
	}
	public Integer getShopSaleId() {
		return ShopSaleId;
	}
	public void setShopSaleId(Integer shopSaleId) {
		ShopSaleId = shopSaleId;
	}
	public Integer getShopSaleInstId() {
		return ShopSaleInstId;
	}
	public void setShopSaleInstId(Integer shopSaleInstId) {
		ShopSaleInstId = shopSaleInstId;
	}
	public Integer getPresentMoney() {
		return PresentMoney;
	}
	public void setPresentMoney(Integer presentMoney) {
		PresentMoney = presentMoney;
	}
	public Integer getMaxMoney() {
		return MaxMoney;
	}
	public void setMaxMoney(Integer maxMoney) {
		MaxMoney = maxMoney;
	}
}
