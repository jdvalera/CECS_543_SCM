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
 * Description: This class is used to contain all the content for the 
 *              manifest file. It is used to collect all data to pass
 *              to the Manifest class.
 */
import java.io.File;
import java.util.ArrayList;

/*
 * Class responsible for storing all fields of the Manifest class
 * Has 2 constructors and getters and setters for all instance variables
 */
public class ManifestFields {
	
	private String projectName = "Vix-1";
	private String creationTime = "";
	private String userCmd = "";
	private String srcPath = "";
	private String targetPath = "";
	private String fileName = "";
	private ArrayList<Artifact> artifacts;
	private ArrayList<String> directories;
	private File directory;
	
	/*
	 * Default constructor with default values.
	 */
	public ManifestFields() {

		this.projectName = "Vix-1";
		this.creationTime = "";
		this.userCmd = "";
		this.srcPath = "";
		this.targetPath = "";
		this.fileName = "";
		this.artifacts = new ArrayList<Artifact>();
		this.directories = new ArrayList<String>();
		this.directory = null;
		
	}
	
	/*
	 * Constructor with all values being provided. 
	 */
	public  ManifestFields(String cT, String uC, String sP, String tP,
			String fN, ArrayList<Artifact> af, ArrayList<String> dirs,File dir) {
		
		this.creationTime = cT;
		this.userCmd = uC;
		this.srcPath = sP;
		this.targetPath = tP;
		this.fileName = fN;
		this.artifacts = af;
		this.directories = dirs;
		this.directory = dir;
		
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getUserCmd() {
		return userCmd;
	}

	public void setUserCmd(String userCmd) {
		this.userCmd = userCmd;
	}

	public String getSrcPath() {
		return srcPath;
	}

	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}

	public String getTargetPath() {
		return targetPath;
	}

	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ArrayList<Artifact> getArtifacts() {
		return artifacts;
	}
	
	public ArrayList<String> getDirectories() {
		return directories;
	}

	public void setArtifacts(ArrayList<Artifact> artifacts) {
		this.artifacts = artifacts;
	}
	
	public void addArtifact(Artifact artifact) {
		this.artifacts.add(artifact);
	}
	
	public void addDirectory(String directory) {
		this.directories.add(directory);
	}

	public File getDirectory() {
		return directory;
	}

	public void setDirectory(File directory) {
		this.directory = directory;
	}
}
