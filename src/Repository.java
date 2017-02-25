import java.io.File;

public class Repository {
	
	public static void create() {
		System.out.println("Created Repository");
		
	}
	
	public void copyDirectory(File src, File dest) {
		
		if(src.isDirectory()) {
			
			if(!dest.exists()) {
				dest.mkdir();
				System.out.println("Directory copied from " 
						+ src + " to " + dest);
			}
			
			// List files in directory
			String files[] = src.list();
			
			for (String file:files) {
				
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				
				copyDirectory(srcFile, destFile);
			}
		} else {

			Artifact artifact = new Artifact(src, dest);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
