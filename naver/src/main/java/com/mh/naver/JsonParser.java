package com.mh.naver;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParser {
	JSONParser jsonParser = new JSONParser();

	public UserVO changeJson(String string) throws Exception {

		HashMap<String, Object> map = new HashMap<String, Object>();
		JSONParser jsonParser = new JSONParser();
		UserVO vo = new UserVO();

		JSONObject jsonObject = (JSONObject) jsonParser.parse(string);

		jsonObject = (JSONObject) jsonObject.get("response");
//		map.put("userGender", jsonObject.get("gender"));
		map.put("userId", jsonObject.get("id"));
		map.put("userEmail", jsonObject.get("email"));
		
		//apiResult = {"resultcode":"00",
		//"message":"success","response":{"id":"29275747","email":"dron512@naver.com"}}
//		vo.setUserName(map.get("userName").toString());
		vo.setUserEmail(map.get("userEmail").toString()); // id -> vo.email 넣기
//		vo.setUserGender(map.get("userGender").toString()); // gender -> vo.gender 넣기
		vo.setUserNaver(map.get("userId").toString());// id -> vo.naver 넣기

		return vo;
	}
}






