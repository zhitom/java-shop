package shop;

//import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopSaleController {

    //private static final String template = "Hello, %s!";
    //private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/apply")
    public ShopSaleError apply(@RequestParam(value="user_id", defaultValue="0") Integer userId,
    		@RequestParam(value="shop_id", defaultValue="0") Integer shopId,
    		@RequestParam(value="shop_sale_id", defaultValue="0") Integer shopSaleId,
    		@RequestParam(value="shop_sale_inst_id", defaultValue="0") Integer shopSaleInstId) {
    	//接入处理
    	if(userId<=0||shopId<=0||shopSaleId<=0||shopSaleInstId<=0)
    		return new ShopSaleError("UNKNOWN OPERATOR",new ShopSaleResponse(userId, shopId, shopSaleId,shopSaleInstId,WebServiceData.POLICY.ERROR,0,0)); 
    	ShopSaleResponse shopSaleResponse=new ShopSaleManager().execute(userId, shopId, shopSaleId,shopSaleInstId);
    	return new ShopSaleError(shopSaleResponse.getResultCode().toString(),shopSaleResponse);
    }
    
    @RequestMapping("/all")
    public String all() {
    	AllInfo allInfo=new AllInfo();
    	return allInfo.execute();
    }
    //error.path="/myerror";
    /*@RequestMapping("/myerror1")
    public ShopSaleError myerror(@RequestParam(value="user_id", defaultValue="0") Integer userId,
    		@RequestParam(value="shop_id", defaultValue="0") Integer shopId,
    		@RequestParam(value="shop_sale_id", defaultValue="0") Integer shopSaleId,
    		@RequestParam(value="shop_sale_inst_id", defaultValue="0") Integer shopSaleInstId) {
        return new ShopSaleError("UNKNOWN OPERATOR",new Greeting(userId, shopId, shopSaleId,shopSaleInstId,WebServiceConstData.POLICY.ERROR));
    }*/
    
}



