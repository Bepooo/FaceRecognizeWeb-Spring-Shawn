package au.edu.sydney;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baidu.ai.aip.utils.GsonUtils;
import com.baidu.ai.aip.utils.HttpUtil;

import au.edu.sydney.domain.Person;

public class Local {
	public void renameFile(String file, String toFile) {
		 
        File toBeRenamed = new File(file);
        //检查要重命名的文件是否存在，是否是文件
        if (!toBeRenamed.exists() || toBeRenamed.isDirectory()) {
 
            System.out.println("File does not exist: " + file);
            return;
        }
 
        File newFile = new File(toFile);
 
        //修改文件名
        if (toBeRenamed.renameTo(newFile)) {
            System.out.println("File has been renamed.");
        } else {
            System.out.println("Error renmaing file");
        }
 
    }
	
	public static String getName(String face) {
		// 请求url
		String a = null;
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
			map.put("group_id_list", "group_903");
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
			String[] seperate1 = result.split("user_info");
			String[] seperate2 = seperate1[1].split(":");
			String[] seperate3 = seperate2[1].split(",");
			a = seperate3[0].substring(1, seperate3[0].length() - 1);
			System.out.println(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	public static  String getAdvice(Person p) {
		String advice;
		if (p.getAge()<30)
		{
			advice=(p.getFavor()+" T-shirt");
		}
		else {
			advice=(p.getFavor()+" Jacket");
		}
		return advice;
		// TODO Auto-generated method stub
		
		
	}


	public static void DeleteFile() {
		try
        { 
            Files.deleteIfExists(Paths.get("D:\\5620\\photo.png")); 
            Files.deleteIfExists(Paths.get("D:\\5620\\download")); 
        } 
        catch(NoSuchFileException e) 
        { 
            System.out.println("No such file/directory exists"); 
        } 
        catch(DirectoryNotEmptyException e) 
        { 
            System.out.println("Directory is not empty."); 
        } 
        catch(IOException e) 
        { 
            System.out.println("Invalid permissions."); 
        } 
		// TODO Auto-generated method stub
	}

}
