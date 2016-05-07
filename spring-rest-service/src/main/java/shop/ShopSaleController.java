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
    public Greeting greeting(@RequestParam(value="user_id", defaultValue="0") Integer userId,
    		@RequestParam(value="shop_id", defaultValue="0") Integer shopId,
    		@RequestParam(value="shop_sale_id", defaultValue="0") Integer shopSaleId) {
        return new ShopSaleManager().execute(userId, shopId, shopSaleId);
    }
}



