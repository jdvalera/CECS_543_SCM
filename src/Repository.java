import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/*
 * Class that represents the project tree created.
 */

/*
 * Constructor that takes in cmd line args and creates the repository
 */
public class Repository {
	
	String path;	
	private ManifestFields mF;
	
	public Repository(String[] args) {
		
		if(args[0].equals("check-in")) {
			checkIn(args[1],args[2]);
		} 
		else if (args[0].equals("check-out")) {
			if(args.length > 2)
			  checkOut(args[1], args[2], args[3]);
		} else
		{
		System.out.println("Creating Repository...");
		
		mF = new ManifestFields();
		String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm")
				.format(new java.util.Date());
		
		String mTime = new SimpleDateFormat("MM-dd-yyyy-HH-mm")
				.format(new java.util.Date());
		
		mF.setCreationTime(timeStamp);
		mF.setUserCmd("java Repository " + args[0] + " " + args[1]);
		mF.setSrcPath(args[0]);
		mF.setTargetPath(args[1]);
		mF.setFileName("Manifest-" + mTime + ".txt");
		mF.setDirectory(new File(args[1] + File.separator + "activity"));
		
		path = args[1];
		copyDirectory(new File(args[0]), new File (args[1]), mF);
		Manifest m = new Manifest(mF);
		System.out.println("Repository Created!");
		}
	}
	
	/*
	 * Method for updating the repository.
	 * Each check-in has its own manifest.
	 */
	public void checkIn(String src, String dest) {
		System.out.println("Checking in...");
		
		ManifestFields mFs = new ManifestFields();
		String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm")
				.format(new java.util.Date());
		
		String mTime = new SimpleDateFormat("MM-dd-yyyy-HH-mm")
				.format(new java.util.Date());
		
		mFs.setCreationTime(timeStamp);
		mFs.setUserCmd("java Repository check-in " + src + " " + dest);
		mFs.setSrcPath(src);
		mFs.setTargetPath(dest);
		mFs.setFileName("Manifest-" + mTime + ".txt");
		mFs.setDirectory(new File(dest + File.separator + "activity"));
		
		path = src;
		copyDirectory(new File(src), new File (dest), mFs);
		Manifest m = new Manifest(mFs);
		System.out.println("Check-in Complete!");
	}
	
	/*
	 * Method for checking out a specific manifest configuration
	 * Each check-out has its own manifest
	 */
	public void checkOut(String src, String dest, String mDate) {
		List<String> lines;
		
		String mName = dest.replaceAll("/+$", "") + File.separator + "activity" + File.separator
				+ "Manifest-" + mDate + ".txt";
		
		lines = readFile(mName);
		
		System.out.println(mName);
		for(String line : lines) {
			System.out.println(line);
		}
		
	}
	
	/*
	 * Method that copies source directory to destination directory
	 */
	public void copyDirectory(File src, File dest, ManifestFields mF) {
		
		if(src.isDirectory()) {
			
			if(!dest.exists()) {
				dest.mkdir();
				System.out.println("Directory copied from " 
						+ src + " to " + dest);
			}
			
			mF.addDirectory(dest.getAbsolutePath());
			// List files in directory
			String files[] = src.list();
			
			for (String file:files) {
				
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				
				copyDirectory(srcFile, destFile, mF);
			}
		} else {

			Artifact artifact = new Artifact(src, dest);
			if(!artifact.exists()) {
				System.out.println("File copied from " + 
				artifact.getSourceFile().getPath() + " to " +
				artifact.getFile().getPath());
			}
			
			mF.addArtifact(artifact);
		}
		
	}
	
	public static List<String> readFile(String filename) {
		
	  List<String> records = new ArrayList<String>();
	  try {
	    BufferedReader reader = new BufferedReader(new FileReader(filename));
	    String line;
	    while ((line = reader.readLine()) != null) {
	      records.add(line);
	    }
	    reader.close();
	    return records;
	  }
	  catch (Exception e) {
	    System.err.format("Exception occurred trying to read '%s'.", filename);
	    e.printStackTrace();
	    return null;
	  }
	}
	
	/*
	 * Sends the cmd line args to the constructor
	 */
	public static void main(String[] args) {
		
		if(args.length > 1) {
			Repository r = new Repository(args);
		}
	}

}
