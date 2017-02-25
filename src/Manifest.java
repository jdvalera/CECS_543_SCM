import java.io.File;
import java.util.ArrayList;

public class Manifest {
	
	String projectName = "Vix-1";
	String creationTime;
	String userCmd;
	String srcPath;
	String targetPath;
	ArrayList<Artifact> artifacts;
	
	public Manifest(String path) {
		File directory = new File(path + File.separator + "activity");
		if(!directory.exists()) {
			directory.mkdir();
		}
	}
	
	public void setTime(String t) {
		creationTime = t;
	}
	
	public void setCmd(String c) {
		userCmd = c;
	}
	
	public void setSrcPath(String sp) {
		srcPath = sp;
	}
	
	public void setTargetPath(String tp) {
		targetPath = tp;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
