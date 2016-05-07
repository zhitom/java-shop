package shop;

public class Greeting {

    private final long UserId;
    private final long ShopId;
    private final long ShopSaleId;
    

    public Greeting(long UserId, long ShopId, long ShopSaleId) {
        this.UserId = UserId;
        this.ShopId = ShopId;
        this.ShopSaleId = ShopSaleId;
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

    
}

