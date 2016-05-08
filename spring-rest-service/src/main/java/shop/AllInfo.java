package shop;

import java.util.List;

import testdb.ShopSaleDef;
import testdb.ShopSaleDefHome;
import testdb.ShopSaleResult;
import testdb.ShopSaleResultDetail;
import testdb.ShopSaleResultDetailHome;
import testdb.ShopSaleResultHome;

public class AllInfo {
	private ShopSaleDefHome 			shopSaleDefHome=new ShopSaleDefHome();
	private ShopSaleResultHome 			shopSaleResultHome=new ShopSaleResultHome();
	private ShopSaleResultDetailHome	shopSaleResultDetailHome=new ShopSaleResultDetailHome();
	
	private StringBuffer allShopSaleDefStr=new StringBuffer();
	private StringBuffer allShopSaleResult=new StringBuffer();
	private StringBuffer allShopSaleResultDetail=new StringBuffer();
	
	public String execute(){
		List dataList=shopSaleDefHome.all();
		allShopSaleDefStr.setLength(0);
		for(int i=0;dataList!=null&&i<dataList.size();i++)
			allShopSaleDefStr.append(((ShopSaleDef)dataList.get(i)).toString()+"<br>");

		dataList=shopSaleResultHome.all();
		allShopSaleResult.setLength(0);
		for(int i=0;dataList!=null&&i<dataList.size();i++)
			allShopSaleResult.append(((ShopSaleResult)dataList.get(i)).toString()+"<br>");
		
		dataList=shopSaleResultDetailHome.all();
		allShopSaleResultDetail.setLength(0);
		for(int i=0;dataList!=null&&i<dataList.size();i++)
			allShopSaleResultDetail.append(((ShopSaleResultDetail)dataList.get(i)).toString()+"<br>");
		return new StringBuffer().append("allShopSaleDefStr=<br>").append(allShopSaleDefStr+"<br>")
				.append("allShopSaleResult=<br>").append(allShopSaleResult+"<br>")
				.append("allShopSaleResultDetail=<br>").append(allShopSaleResultDetail+"<br>").toString();
				
	}
}
