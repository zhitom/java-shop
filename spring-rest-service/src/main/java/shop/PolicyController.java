package shop;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import shop.WebServiceData.POLICY;

/*
 * 用户重复发起请求的过滤,恶意请求的鉴别,快速返回上次返回的红包信息,申请成功(present_money>0)就更新缓存
 * */
public class PolicyController {
	private static final Log log = LogFactory.getLog(PolicyController.class);
	private RequestCacheManager cacheManager=RequestCacheManager.getInstance();
	private ShopMoneyCacheManager cacheMoneyManager=ShopMoneyCacheManager.getInstance();
	private RequestCache requestCache;
	private ShopMoneyCache shopMoneyCache;
	
	public POLICY policy(WebServiceData webServiceData) {
		//用户重复发起请求的过滤
		requestCache=cacheManager.find(webServiceData.getUserKey());
		if(requestCache != null){
			requestCache.setApplyCount(requestCache.getApplyCount()+1);//访问次数加1
			webServiceData.setRequestCache(requestCache);//用于打印
			//恶意请求的鉴别
			if(isBadApply(requestCache)){
				log.info("apply bad_repeat:userKey="+webServiceData.getUserKey()+
						",applyCount="+requestCache.getApplyCount().toString());
				return POLICY.BAD_APPLY_ERROR;//恶意点击
			}
			log.info("apply repeat:userId="+webServiceData.getUserKey());
			return POLICY.REPEAT;
		}
		
		//第一次获取并留存此次活动红包最大金额.如果max_money<=used_money,即可以立即返回’红包已经抢完’
		shopMoneyCache=cacheMoneyManager.find(webServiceData.getShopSaleInstKey());
		if(shopMoneyCache!=null){//已经存在
			if(shopMoneyCache.getUsedMoney()>=shopMoneyCache.getMaxMoney()){
				log.info("no money:shopSaleInstKey="+webServiceData.getShopSaleInstKey()+
						",usedMoney="+shopMoneyCache.getUsedMoney().toString()+
						",maxMoney="+shopMoneyCache.getMaxMoney());
				return POLICY.NORMAL_EMPTY;
			}
			//如果已经超时就删除
			if(shopMoneyCache.getSecondsByNow() >= WebServiceData.MAX_MONEY_CACHE_TIME)
				cacheMoneyManager.erase(webServiceData.getShopSaleInstKey());
		}else{

		}
		return POLICY.NORMAL;
	}
	public void updateCache(WebServiceData webServiceData){
		if(requestCache != null)
		{
			requestCache.setPresentMoney(webServiceData.getPresentMoney());
			requestCache.setPresentTime(new Date());
			cacheManager.merge(webServiceData.getUserKey(),requestCache);
		}else{
			requestCache=new RequestCache();
			requestCache.setUserId(webServiceData.getUserId());
			requestCache.setShopId(webServiceData.getShopId());
			requestCache.setShopSaleId(webServiceData.getShopSaleId());
			requestCache.setShopSaleInstId(webServiceData.getShopSaleInstId());
			requestCache.setPresentMoney(webServiceData.getPresentMoney());
			requestCache.setApplyCount(new Integer(1));
			requestCache.setPresentTime(new Date());
			cacheManager.merge(webServiceData.getUserKey(),requestCache);
		}
		if(shopMoneyCache != null)
		{
			shopMoneyCache.setUsedMoney(shopMoneyCache.getUsedMoney()+webServiceData.getPresentMoney());
			shopMoneyCache.setUpdateTime(new Date());
			cacheMoneyManager.merge(webServiceData.getShopSaleInstKey(),shopMoneyCache);
		}else{
			shopMoneyCache=new ShopMoneyCache();
			shopMoneyCache.setShopId(webServiceData.getShopId());
			shopMoneyCache.setShopSaleId(webServiceData.getShopSaleId());
			shopMoneyCache.setShopSaleInstId(webServiceData.getShopSaleInstId());
			shopMoneyCache.setMaxMoney(webServiceData.getMaxMoney());
			shopMoneyCache.setUsedMoney(webServiceData.getPresentMoney());
			shopMoneyCache.setUpdateTime(new Date());
			cacheMoneyManager.merge(webServiceData.getUserKey(),shopMoneyCache);
		}
	}
	private boolean isBadApply(RequestCache cache){
		
		return (cache.getApplyCount()/cache.getSecondsByNow()>WebServiceData.MAX_BAD_APPLY_SECONDS);
	}

	
}
