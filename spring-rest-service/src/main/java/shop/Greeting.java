package shop;

public class Greeting {

    private final long UserId;
    private final long ShopId;
    private final long ShopSaleId;
    private final long ShopSaleInstId;
    

    public Greeting(long UserId, long ShopId, long ShopSaleId,long ShopSaleInstId) {
        this.UserId = UserId;
        this.ShopId = ShopId;
        this.ShopSaleId = ShopSaleId;
        this.ShopSaleInstId = ShopSaleInstId;
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
}

