package shop;



public class ShopSaleManager {
	private UserAAAChecker userAAAChecker=new UserAAAChecker();
	
	public Greeting execute(Integer userId,Integer shopId,Integer shopSaleId,Integer shopSaleInstId) {
		if(!userAAAChecker.check(userId))
			return new Greeting(-1,shopId,shopSaleId,shopSaleInstId);
        return new Greeting(userId,shopId,shopSaleId,shopSaleInstId);
    }
}
