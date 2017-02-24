import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Artifact {
	
	String artifactID;
	File sourceFile;
	
	public Artifact(File f) {
		sourceFile = f;
		setID();
	}
	
	public void setID() {
		
		int total = 0;
		int length = (int) sourceFile.length();
		String ext = getFileExtension(sourceFile);
		try {
			InputStream input = new FileInputStream(sourceFile);
			int data = input.read();
			int i = 0;

			while(data != -1) {
				if(i%4 == 0) {
					total += data*1;
				} else if (i%4 == 1) {
					total += data*3;
				} else if (i%4 == 2) {
					total += data*11;
				} else if (i%4 == 3) {
					total += data*17;
				}
				data = input.read();
				i++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 artifactID =  "" + total + "." + length + "." + ext;
		
	}
	
	public String getID() {
		return artifactID;
	}
	
	public String getFileExtension(File file) {
	    String name = file.getName();
	    try {
	        return name.substring(name.lastIndexOf(".") + 1);
	    } catch (Exception e) {
	        return "";
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File test = new File("E:\\Users\\John\\Desktop\\Dropbox\\CECS 543\\Project", "text.txt");
		Artifact a = new Artifact(test);
		
		
		System.out.println(a.getID());
		
		//System.out.println(a.createID("HELLO WORLD"));
	}


}
