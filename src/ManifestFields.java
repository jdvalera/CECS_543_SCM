import java.io.File;
import java.util.ArrayList;

public class ManifestFields {
	
	private String projectName = "Vix-1";
	private String creationTime = "";
	private String userCmd = "";
	private String srcPath = "";
	private String targetPath = "";
	private String fileName = "";
	private ArrayList<Artifact> artifacts;
	private File directory;
	
	public ManifestFields() {

		this.projectName = "Vix-1";
		this.creationTime = "";
		this.userCmd = "";
		this.srcPath = "";
		this.targetPath = "";
		this.fileName = "";
		this.artifacts = new ArrayList<Artifact>();
		this.directory = null;
		
	}
	
	public  ManifestFields(String cT, String uC, String sP, String tP,
			String fN, ArrayList<Artifact> af,File dir) {
		
		this.creationTime = cT;
		this.userCmd = uC;
		this.srcPath = sP;
		this.targetPath = tP;
		this.fileName = fN;
		this.artifacts = af;
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

	public void setArtifacts(ArrayList<Artifact> artifacts) {
		this.artifacts = artifacts;
	}
	
	public void addArtifact(Artifact artifact) {
		this.artifacts.add(artifact);
	}

	public File getDirectory() {
		return directory;
	}

	public void setDirectory(File directory) {
		this.directory = directory;
	}
}
