package shop;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import testdb.ShopSaleDefHome;
import testdb.ShopSaleResult;
import testdb.ShopSaleResultDetail;
import testdb.ShopSaleResultDetailHome;
import testdb.ShopSaleResultDetailId;
import testdb.ShopSaleResultHome;

public class ShopSaleManager {
	private static final Log log = LogFactory.getLog(ShopSaleManager.class);
	private UserAAAChecker userAAAChecker=new UserAAAChecker();
	private PolicyController policyController=new PolicyController();
	private WebServiceData webServiceData=new WebServiceData();
	private ShopSaleResultDetail shopSaleResultDetail=new ShopSaleResultDetail();
	
	private ShopSaleDefHome 			shopSaleDefHome=new ShopSaleDefHome();
	private ShopSaleResultHome 			shopSaleResultHome=new ShopSaleResultHome();
	private ShopSaleResultDetailHome	shopSaleResultDetailHome=new ShopSaleResultDetailHome();
	
	public ShopSaleResponse execute(Integer userId,Integer shopId,Integer shopSaleId,Integer shopSaleInstId) {
		//鉴权认证
		if(!userAAAChecker.check(userId)){
			log.info("Failed userAAAChecker.check():userId="+userId.toString());
			return new ShopSaleResponse(userId,shopId,shopSaleId,shopSaleInstId,WebServiceData.POLICY.ILLEGALLY_USER,0,shopSaleResultDetail.getSpentMSeconds());
		}
		//设置常用的key
		webServiceData.setUserKey(userId, shopId, shopSaleId, shopSaleInstId);
		webServiceData.setShopSaleInstKey(shopId, shopSaleId, shopSaleInstId);
		
		//策略控制
		WebServiceData.POLICY iPolicyRet=policyController.policy(webServiceData);
		if(iPolicyRet != WebServiceData.POLICY.NORMAL)
		{
			//上次红包的金额在RequestCache里边.
			return new ShopSaleResponse(userId,shopId,shopSaleId,shopSaleInstId,
					iPolicyRet,webServiceData.getRequestCache().getPresentMoney(),shopSaleResultDetail.getSpentMSeconds());
		}
		
		//资金扣减
		synchronized (shopSaleResultHome){
			ShopSaleResult shopSaleResult=shopSaleResultHome.findById(webServiceData, shopSaleDefHome);
			if(shopSaleResult==null){
				log.info("Failed userAAAChecker.check():userId="+userId.toString());
				return new ShopSaleResponse(userId,shopId,shopSaleId,shopSaleInstId,WebServiceData.POLICY.NO_SHOP_SALE,0,shopSaleResultDetail.getSpentMSeconds());
			}				
			webServiceData.setPresentMoney(shopSaleResult.getPresentMoney());//红包值
			webServiceData.setMaxMoney(shopSaleResult.getMaxMoney());//后续缓存使用.
			shopSaleResult.setUsedMoney(shopSaleResult.getUsedMoney()+webServiceData.getPresentMoney());
			shopSaleResult.setUpdateTime(new Date());
			shopSaleResultHome.merge(shopSaleResult);
		}
		
		//产生红包信息及更新缓存webServiceData.getPresentMoney()
		policyController.updateCache(webServiceData);
		
		//记录红包流水
		if(webServiceData.getPresentMoney()>0){
			shopSaleResultDetail.setId(new ShopSaleResultDetailId());
			shopSaleResultDetail.getId().setUserId(userId);
			shopSaleResultDetail.getId().setShopId(shopId);
			shopSaleResultDetail.getId().setShopSaleId(shopSaleId);
			shopSaleResultDetail.getId().setShopSaleInstId(shopSaleInstId);
			shopSaleResultDetail.setPresentMoney(webServiceData.getPresentMoney());
			shopSaleResultDetail.setPresentTime(new Date());
			shopSaleResultDetailHome.merge(shopSaleResultDetail);
		}
		//返回处理
		iPolicyRet = ((webServiceData.getPresentMoney()<=0)?WebServiceData.POLICY.NORMAL_EMPTY:WebServiceData.POLICY.NORMAL);
		return new ShopSaleResponse(userId,shopId,shopSaleId,shopSaleInstId,iPolicyRet,webServiceData.getPresentMoney(),shopSaleResultDetail.getSpentMSeconds());
    }
	public String getUserKey(Integer userId,Integer shopId,Integer shopSaleId,Integer shopSaleInstId){
		return shopId.toString()+"-"+shopSaleId.toString()+"-"+shopSaleInstId.toString()+"-"+userId.toString();
	}
	public String getShopSaleInst(Integer shopId,Integer shopSaleId,Integer shopSaleInstId){
		return shopId.toString()+"-"+shopSaleId.toString()+"-"+shopSaleInstId.toString();
	}
}
