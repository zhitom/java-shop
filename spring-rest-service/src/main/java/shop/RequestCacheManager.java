package shop;

import java.util.Hashtable;
/**
 * 缓存数据在多线程场景下会不太准确,但不影响大局.不加锁可以提高性能
 * */
public class RequestCacheManager {
	private static class LazySingleton {    
	       private static final RequestCacheManager INSTANCE = new RequestCacheManager();    
	    }    
	
	 RequestCacheManager (){}    
	 public static final RequestCacheManager getInstance() {    
	    return LazySingleton.INSTANCE;    
	 }   
	 //因为多线程并发,所以需要使用Hashtable
	 private Hashtable<String,RequestCache> RequestCacheMap=new Hashtable<String,RequestCache>(); 
	 
	 public RequestCache find(String key){
		 return RequestCacheMap.get(key);
	 }
	 public void erase(String key){
		 RequestCacheMap.remove(key);
	 }
	 public void merge(String key,RequestCache requestCache ){
		 if(RequestCacheMap.replace(key, requestCache)==null)
			 RequestCacheMap.put(key,requestCache);
	 }
}
