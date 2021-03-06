package shop;

import java.util.Hashtable;
/**
 * 缓存数据在多线程场景下会不太准确,但不影响大局.不加锁可以提高性能
 * */
public class ShopMoneyCacheManager {
	private static class LazySingleton {    
	   private static final ShopMoneyCacheManager INSTANCE = new ShopMoneyCacheManager();    
	}    
	
	private ShopMoneyCacheManager (){}    
	public static final ShopMoneyCacheManager getInstance() {    
	    return LazySingleton.INSTANCE;    
	}    
	
	//因为多线程并发,所以需要使用Hashtable
	private Hashtable<String,ShopMoneyCache> ShopMoneyCacheMap=new Hashtable<String,ShopMoneyCache>(); 
	
	public ShopMoneyCache find(String key){
		 return ShopMoneyCacheMap.get(key);
	 }
	 public void erase(String key){
		 ShopMoneyCacheMap.remove(key);
	 }
	 public void merge(String key,ShopMoneyCache shopMoneyCache ){
		 if(ShopMoneyCacheMap.replace(key, shopMoneyCache)==null)
			 ShopMoneyCacheMap.put(key,shopMoneyCache);
	 }
}
