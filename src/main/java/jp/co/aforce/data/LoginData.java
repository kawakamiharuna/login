package jp.co.aforce.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LoginData {
	public Map<String, String> getDbInfo() throws FileNotFoundException {

		

		Properties dbInfo = new Properties();
		FileInputStream dbFileStream = new FileInputStream(bad);

		try {
			dbInfo.load(dbFileStream);
		} catch (IOException e) {
			System.out.println("登録データがありません");
			e.printStackTrace();
		}

		String dbName = dbInfo.getProperty("name");
		String dbId = dbInfo.getProperty("id");
		String dbPassword = dbInfo.getProperty("password");

		Map<String, String> getDbForm = new HashMap<>();

		getDbForm.put("name", dbName);
		getDbForm.put("id", dbId);
		getDbForm.put("password", dbPassword);

		return getDbForm;

	}
}
