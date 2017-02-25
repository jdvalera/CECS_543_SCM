import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Artifact {
	
	String artifactID;
	File sourceFile;
	File destination;
	File leafFolder;
	String extension;
	
	public Artifact(File src, File dest) {
		sourceFile = src;
		setID();
		destination = dest;
		createLeafFolder();
		insertArtifact();
	}
	
	public boolean createLeafFolder() {
		leafFolder = new File(destination.getName() + File.separator + sourceFile.getName());
		return leafFolder.mkdir();
	}
	
	public void insertArtifact() {
		try {
			InputStream in = new FileInputStream(sourceFile);
			File newFile = new File(leafFolder.getPath(), artifactID + "." + extension);
			OutputStream out = new FileOutputStream(newFile);
			
			byte[] buffer = new byte[1024];
			
			int length;
			
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setID() {
		
		int total = 0;
		int length = (int) sourceFile.length();
		extension = getFileExtension(sourceFile);
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
		
		 artifactID =  "" + total + "." + length + "." + extension;
		
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
		File test = new File("./", "text.txt");
		File dest = new File ("./testing");
		Artifact a = new Artifact(test, dest);
		
		//File directory = new File("./");
		//System.out.println(directory.getAbsolutePath());

		System.out.println(a.getID());
		System.out.println(a.leafFolder.getPath());
		
		//System.out.println(a.createID("HELLO WORLD"));
	}


}
