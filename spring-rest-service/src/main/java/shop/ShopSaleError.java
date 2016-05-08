package shop;

public class ShopSaleError {
	
	private String Message;
	private ShopSaleResponse ResultObject;
	
	public ShopSaleError(String str,ShopSaleResponse obj) {
		setMessage(str);
		setResultObject(obj);
	}
	public String getMessage() {
		return this.Message;
	}
	public void setMessage(String errorMsg) {
		this.Message = errorMsg;
	}
	public Object getResultObject() {
		return this.ResultObject;
	}
	public void setResultObject(ShopSaleResponse errorObject) {
		this.ResultObject = errorObject;
	}
//	public String toString(){
//		StringBuffer stringBuffer=new StringBuffer();
//		stringBuffer.append(this.Message+"\n\n");
//		stringBuffer.append("user_id = "+ResultObject.getUserId()+WebServiceConstData.getInstance().getBaseInfoMap().get("user_id"));
//		stringBuffer.append("shop_id = "+ResultObject.getUserId()+WebServiceConstData.getInstance().getBaseInfoMap().get("shop_id"));
//		stringBuffer.append("shop_sale_id = "+ResultObject.getUserId()+WebServiceConstData.getInstance().getBaseInfoMap().get("shop_sale_id"));
//		stringBuffer.append("shop_sale_inst_id = "+ResultObject.getUserId()+WebServiceConstData.getInstance().getBaseInfoMap().get("shop_sale_inst_id"));
//		
//		return stringBuffer.toString();
//				
//	}
}
