import java.io.File;
import java.text.SimpleDateFormat;

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
	 * Method that copies source directory to destination directory
	 */
	public void copyDirectory(File src, File dest, ManifestFields mF) {
		
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
				
				copyDirectory(srcFile, destFile, mF);
			}
		} else {

			Artifact artifact = new Artifact(src, dest);
			System.out.println("File copied from " + 
			artifact.getSourceFile().getPath() + " to " +
			artifact.getFile().getPath());
			
			mF.addArtifact(artifact);
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
