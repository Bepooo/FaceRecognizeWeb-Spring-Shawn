package au.edu.sydney;

import java.io.File;

public class Local {
	public void renameFile(String file, String toFile) {
		 
        File toBeRenamed = new File(file);
        //���Ҫ���������ļ��Ƿ���ڣ��Ƿ����ļ�
        if (!toBeRenamed.exists() || toBeRenamed.isDirectory()) {
 
            System.out.println("File does not exist: " + file);
            return;
        }
 
        File newFile = new File(toFile);
 
        //�޸��ļ���
        if (toBeRenamed.renameTo(newFile)) {
            System.out.println("File has been renamed.");
        } else {
            System.out.println("Error renmaing file");
        }
 
    }

}
