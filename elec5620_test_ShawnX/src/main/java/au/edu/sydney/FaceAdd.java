package au.edu.sydney;
import com.baidu.ai.aip.utils.HttpUtil;
import com.baidu.ai.aip.utils.GsonUtils;

import java.util.*;
public class FaceAdd {
public static void add(int id, String name, String face) {
	// 请求url
	System.out.println("get into add " + " " + id + " " + name + " " + face);
	String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
	try {
		Map<String, Object> map = new HashMap<>();
		map.put("image", face);
		map.put("group_id", "group_903");
		map.put("user_id", id);
		map.put("user_info", name);
		map.put("liveness_control", "NORMAL");
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
	} catch (Exception e) {
		e.printStackTrace();
	}

}
}