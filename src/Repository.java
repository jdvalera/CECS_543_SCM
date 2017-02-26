import java.io.File;
import java.text.SimpleDateFormat;

public class Repository {
	
	String path;
	
	/*
	String projectName = "Vix-1";
	String creationTime = "";
	String userCmd = "";
	String srcPath = "";
	String targetPath = "";
	String fileName = "";
	ArrayList<Artifact> artifacts;
	File directory;*/
	
	ManifestFields mF;
	
	public Repository(String[] args) {
		System.out.println("Creating Repository...");
		
		mF = new ManifestFields();
		String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm")
				.format(new java.util.Date());
		
		mF.setCreationTime(timeStamp);
		mF.setUserCmd("java Repository " + args[0] + " " + args[1]);
		mF.setSrcPath(args[0]);
		mF.setTargetPath(args[1]);
		mF.setFileName("Manifest-" + timeStamp + ".txt");
		mF.setDirectory(new File(args[1] + File.separator + "activity"));
		
		path = args[1];
		copyDirectory(new File(args[0]), new File (args[1]));
		Manifest m = new Manifest(path);
		System.out.println("Repository Created!");
	}
	
	public void create() {
		
		
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
			mF.addArtifact(artifact);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length > 1) {
			Repository r = new Repository(args);
		}
	}

}
