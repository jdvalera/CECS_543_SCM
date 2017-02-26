import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Manifest {
	
	String projectName = "Vix-1";
	String creationTime = "";
	String userCmd = "";
	String srcPath = "";
	String targetPath = "";
	String fileName = "";
	ArrayList<Artifact> artifacts;
	File directory;
	ManifestFields manifestFields;
	
	public Manifest(String path) {
		creationTime = new SimpleDateFormat("MM-dd-yyyy-HH-mm")
				.format(new java.util.Date());
		directory = new File(path + File.separator + "activity");
		if(!directory.exists()) {
			directory.mkdir();
		}
		fileName = "Manifest-" + creationTime + ".txt";
		createManifestFile();
	}
	
	public Manifest(ManifestFields mf) {
		this.manifestFields = mf;
	}
	
	public String[] createManifestContent() {
		
		String[] content = {projectName, creationTime, userCmd, srcPath, targetPath};
	
		
		return content;
	}
	
	public void createManifestFile() {
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(directory.getPath() + File.separator + fileName);
			bw = new BufferedWriter(fw);
			String[] content = createManifestContent();
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
