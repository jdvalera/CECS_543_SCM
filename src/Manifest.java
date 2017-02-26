import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Manifest {
	
	ManifestFields manifestFields;
	
	String projectName = "Vix-1";
	String creationTime = "";
	String userCmd = "";
	String srcPath = "";
	String targetPath = "";
	String fileName = "";
	ArrayList<Artifact> artifacts;
	File directory;
	
	
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
		
		if(!manifestFields.getDirectory().exists()) {
			manifestFields.getDirectory().mkdir();
		}
		createManifestFile();
	}
	
	public ArrayList<String> createManifestContent() {
		
		String[] s = {projectName, 
				manifestFields.getCreationTime(), manifestFields.getUserCmd(),
				new File(manifestFields.getSrcPath()).getAbsolutePath(),
				new File(manifestFields.getTargetPath()).getAbsolutePath()};
		
		ArrayList<String> content = new ArrayList<String>(Arrays.asList(s));
		
		for(Artifact a : manifestFields.artifacts) {
			String artifact;
			artifact = a.getArtifactID() + " " + a.getSourceFile().getName()
					+ " " + a.getFile().getPath();
			content.add(artifact);
		}
		
		
		return content;
	}
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
