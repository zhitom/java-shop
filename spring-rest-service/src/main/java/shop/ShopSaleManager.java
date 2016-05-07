package shop;



public class ShopSaleManager {
	private UserAAAChecker userAAAChecker=new UserAAAChecker();
	
	public Greeting execute(Integer userId,Integer shopId,Integer shopSaleId) {
		if(!userAAAChecker.check(userId))
			return new Greeting(-1,shopId,shopSaleId);
        return new Greeting(userId,shopId,shopSaleId);
    }
}
