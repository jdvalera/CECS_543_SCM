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
}
