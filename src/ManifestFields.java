import java.io.File;
import java.util.ArrayList;

public class ManifestFields {
	
	String projectName = "Vix-1";
	String creationTime = "";
	String userCmd = "";
	String srcPath = "";
	String targetPath = "";
	String fileName = "";
	ArrayList<Artifact> artifacts;
	File directory;
	
	public ManifestFields() {

		projectName = "Vix-1";
		creationTime = "";
		userCmd = "";
		srcPath = "";
		targetPath = "";
		fileName = "";
		artifacts = new ArrayList<Artifact>();
		directory = null;
		
	}
	
	public  ManifestFields(String pN, String cT, String uC, String sP, String tP,
			String fN, ArrayList<Artifact> af,File dir) {
		
		projectName = pN;
		creationTime = cT;
		userCmd = uC;
		srcPath = sP;
		targetPath = tP;
		fileName = fN;
		artifacts = af;
		directory = dir;
		
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

	public void setArtifacts(ArrayList<Artifact> artifacts) {
		this.artifacts = artifacts;
	}

	public File getDirectory() {
		return directory;
	}

	public void setDirectory(File directory) {
		this.directory = directory;
	}
}
