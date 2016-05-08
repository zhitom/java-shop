package shop;

//鉴权认证,暂不实现
public class UserAAAChecker {
	public boolean check(Integer userId){
		if(userId!=0){
			//////////////////////////////////
			//AAA校验
			//////////////////////////////////
			
			return true;
		}
		else
			return false;
	}
}
