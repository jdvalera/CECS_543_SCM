/*
 * Author: 
 * John Valera
 * Email: johnlemuelvalera@gmail.com
 * 
 * Co-authors:
 * Jun Ying
 * jun.ying@student.csulb.edu
 * 
 * Wei Wang
 * Email: weiwang19871216@gmail.com
 * 
 * Description: This class is used used to create the actual manifest files.
 *              It uses the ManifestFields class to extract the info it needs
 *              for each manifest file.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/*
 * Class responsible for creating the manifest file.
 */
public class Manifest {
	
	ManifestFields manifestFields;
	
	private String projectName = "Vix-1";
	private ArrayList<Artifact> artifacts;
	private ArrayList<String> directories;

	
	/*
	 * Constructor that creates a manifest file.
	 * Creates the 'activities' directory if it doesn't exist.
	 */
	public Manifest(ManifestFields mf) {
		this.manifestFields = mf;
		
		if(!manifestFields.getDirectory().exists()) {
			manifestFields.getDirectory().mkdir();
		}
		createManifestFile();
	}
	
	/*
	 * Method that populates a string array to make up the content
	 * of the manifest file.
	 */
	public ArrayList<String> createManifestContent() {
		
		String[] s = {projectName, 
				manifestFields.getCreationTime(), manifestFields.getUserCmd(),
				new File(manifestFields.getSrcPath()).getAbsolutePath().replaceAll("\\\\", "/"),
				new File(manifestFields.getTargetPath()).getAbsolutePath().replaceAll("\\\\", "/")};
		
		ArrayList<String> content = new ArrayList<String>(Arrays.asList(s));
		
		for(String d : manifestFields.getDirectories()) {
			String directory;
			File dir = new File(d);
			directory = dir.getName() + "\t" + dir.getAbsolutePath().replaceAll("\\\\", "/");
			content.add(directory);
		}

		for(Artifact a : manifestFields.getArtifacts()) {
			String artifact;
			artifact = a.getArtifactID() + "\t" + a.getSourceFile().getName()
					+ "\t" + a.getDestination().getAbsolutePath().replaceAll("\\\\", "/");
			content.add(artifact);
		}
		
		
		return content;
	}
	
	/*
	 * Method that gets the contents from a string array and
	 * creates the actual manifest file.
	 */
	public void createManifestFile() {
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(manifestFields.getDirectory().getPath()
					+ File.separator + manifestFields.getFileName());
			bw = new BufferedWriter(fw);
			ArrayList<String> content = createManifestContent();
			for(String s : content) {
				
				bw.write(s);
				bw.newLine();
			}	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
	}
	
	public ArrayList<Artifact> getArtifacts() {
		return artifacts;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
