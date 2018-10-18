package au.edu.sydney;


import com.baidu.ai.aip.utils.HttpUtil;
import com.baidu.ai.aip.utils.Base64Util;
import com.baidu.ai.aip.utils.FileUtil;
import com.baidu.ai.aip.utils.GsonUtils;

import java.util.*;

/**
 * 人脸搜索
 */
public class FaceSearch {

	/**
	 * 重要提示代码中所需工具类 FileUtil,Base64Util,HttpUtil,GsonUtils请从
	 * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
	 * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
	 * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
	 * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3 下载
	 */
	public static Boolean search(String face) {
		// 请求url
		System.out.println("get into face search.");
		boolean a = false;
		String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
		try {
			/*
			 * byte[] bytes1 = FileUtil.readFileByBytes("D://download.jpg");
			 * String image1 = Base64Util.encode(bytes1);
			 */
			System.out.println(face);
			Map<String, Object> map = new HashMap<>();
			map.put("image", face);
			map.put("liveness_control", "LOW");
			map.put("group_id_list", "group_902");
			map.put("image_type", "FACE_TOKEN");
			map.put("quality_control", "LOW");

			String param = GsonUtils.toJson(map);

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间，
			// 客户端可自行缓存，过期后重新获取。
			String accessToken = "24.ac1d816795c040131e0736934b5991f6.2592000.1541559242.282335-11758176";
			// String accessToken =
			// "24.936901e94eee6271964498fe78f714e0.2592000.1538380298.282335-11758176";
			String result = HttpUtil.post(url, accessToken, "application/json", param);
			System.out.println(result);
			if (result.contains("match user is not found")) {
				a = true;
				return a;
			}
			String[] seperate1 = result.split("score");
			String[] seperate2 = seperate1[1].split(":");
			String[] seperate3 = seperate2[1].split("}");
			Double score = Double.parseDouble(seperate3[0]);
			System.out.println(score);
			if (score < 75) {
				return a = true;
			} else {
				return a = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	public static String LoginSearch(String face) {
		// 请求url
		String a = "default";
		String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
		try {
			/*
			 * byte[] bytes1 = FileUtil.readFileByBytes("D://download.jpg");
			 * String image1 = Base64Util.encode(bytes1);
			 */
			System.out.println(face);
			Map<String, Object> map = new HashMap<>();
			map.put("image", face);
			map.put("liveness_control", "LOW");
			map.put("group_id_list", "group_902");
			map.put("image_type", "FACE_TOKEN");
			map.put("quality_control", "LOW");

			String param = GsonUtils.toJson(map);

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间，
			// 客户端可自行缓存，过期后重新获取。
			// String accessToken =
			// "24.936901e94eee6271964498fe78f714e0.2592000.1538380298.282335-11758176";
			String accessToken = "24.ac1d816795c040131e0736934b5991f6.2592000.1541559242.282335-11758176";
			String result = HttpUtil.post(url, accessToken, "application/json", param);
			System.out.println(result);
			if (result.contains("match user is not found")) {
				a = "Not Found";
				return a;
			}
			String[] sep1 = result.split("error_msg");
			String[] sep2 = sep1[1].split(":");
			String[] sep3 = sep2[1].split(",");
			a = sep3[0].substring(1, sep3[0].length() - 1);
			if (a.equals("SUCCESS")) {
				String[] seperate1 = result.split("score");
				String[] seperate2 = seperate1[1].split(":");
				String[] seperate3 = seperate2[1].split("}");
				Double score = Double.parseDouble(seperate3[0]);
				System.out.println(score);
				if (score > 75) {
					return a = "yes";
				} else if (score < 75) {
					return a = "no";
				}
			} else {
				return a;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	public static String RegisterSearch(String face) {
		// 请求url
		String a = "default";
		String b = "default";
		String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
		try {
			/*
			 * byte[] bytes1 = FileUtil.readFileByBytes("D://download.jpg");
			 * String image1 = Base64Util.encode(bytes1);
			 */
			System.out.println(face);
			Map<String, Object> map = new HashMap<>();
			map.put("image", face);
			map.put("liveness_control", "LOW");
			map.put("group_id_list", "group_902");
			map.put("image_type", "FACE_TOKEN");
			map.put("quality_control", "LOW");

			String param = GsonUtils.toJson(map);

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间，
			// 客户端可自行缓存，过期后重新获取。
			// String accessToken =
			// "24.936901e94eee6271964498fe78f714e0.2592000.1538380298.282335-11758176";
			String accessToken = "24.ac1d816795c040131e0736934b5991f6.2592000.1541559242.282335-11758176";
			String result = HttpUtil.post(url, accessToken, "application/json", param);
			System.out.println(result);
			if (result.contains("match user is not found")) {
				a = "Not Found";
				return a;
			}
			String[] sep1 = result.split("error_msg");
			String[] sep2 = sep1[1].split(":");
			String[] sep3 = sep2[1].split(",");
			a = sep3[0].substring(1, sep3[0].length() - 1);
			if (a.equals("SUCCESS")) {
				String[] seperate1 = result.split("score");
				String[] seperate2 = seperate1[1].split(":");
				String[] seperate3 = seperate2[1].split("}");
				Double score = Double.parseDouble(seperate3[0]);
				System.out.println(score);
				/*
				 * if (score>80) {return b="yes"; } else if (score<80){ return b
				 * = "no"; }
				 */
			} else {
				return a;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	public static String ResultSearch(String face) {
		// 请求url
		String a = "default";
		String b = "default";
		String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
		try {
			/*
			 * byte[] bytes1 = FileUtil.readFileByBytes("D://download.jpg");
			 * String image1 = Base64Util.encode(bytes1);
			 */
			System.out.println(face);
			Map<String, Object> map = new HashMap<>();
			map.put("image", face);
			map.put("liveness_control", "LOW");
			map.put("group_id_list", "group_902");
			map.put("image_type", "FACE_TOKEN");
			map.put("quality_control", "LOW");

			String param = GsonUtils.toJson(map);

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间，
			// 客户端可自行缓存，过期后重新获取。
			// String accessToken =
			// "24.936901e94eee6271964498fe78f714e0.2592000.1538380298.282335-11758176";
			String accessToken = "24.ac1d816795c040131e0736934b5991f6.2592000.1541559242.282335-11758176";
			String result = HttpUtil.post(url, accessToken, "application/json", param);
			System.out.println(result);
			if (result.contains("match user is not found")) {
				a = "Not Found";
				return a;
			}
			String[] sep1 = result.split("error_msg");
			String[] sep2 = sep1[1].split(":");
			String[] sep3 = sep2[1].split(",");
			a = sep3[0].substring(1, sep3[0].length() - 1);
			if (a.equals("SUCCESS")) {
				String[] seperate1 = result.split("score");
				String[] seperate2 = seperate1[1].split(":");
				String[] seperate3 = seperate2[1].split("}");
				Double score = Double.parseDouble(seperate3[0]);
				System.out.println(score);
				if (score > 75) {
					return b = "yes";
				} else if (score < 75) {
					return b = "no";
				}
			} else {
				return a;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	/*
	 * public static void main(String[] args) {
	 * FaceSearch.search("027d8308a2ec665acb1bdf63e513bcb9"); }
	 */
}