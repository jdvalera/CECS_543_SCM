import java.io.File;
import java.text.SimpleDateFormat;

public class Repository {
	
	public void create() {
		String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm")
				.format(new java.util.Date());
		System.out.println(timeStamp);
		
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
		Repository r = new Repository();
	}

}
