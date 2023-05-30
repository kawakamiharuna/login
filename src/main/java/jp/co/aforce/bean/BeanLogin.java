package jp.co.aforce.bean;

public class BeanLogin {
	private String id;
	private String password;
	
	//ログイン時のId
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
//	ログイン時のパスワード
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
