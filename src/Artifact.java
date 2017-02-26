import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Artifact {
	
	String artifactID;
	File sourceFile;
	File destination;
	File leafFolder;
	String extension;
	File file;
	
	public Artifact(File src, File dest) {
		sourceFile = src;
		setID();
		destination = new File(dest.getParent());
		createLeafFolder();
		insertArtifact();
	}
	
	
	public boolean createLeafFolder() {
		leafFolder = new File(destination.getPath() + File.separator + sourceFile.getName());
		return leafFolder.mkdir();
	}
	
	public void insertArtifact() {
		try {
			InputStream in = new FileInputStream(sourceFile);
			file = new File(leafFolder.getPath(), artifactID + "." + extension);
			OutputStream out = new FileOutputStream(file);
			
			byte[] buffer = new byte[1024];
			
			int length;
			
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void setID() {
		
		int total = 0;
		int length = (int) sourceFile.length();
		extension = getFileExtension(sourceFile);
		try {
			InputStream input = new FileInputStream(sourceFile);
			int data = input.read();
			int i = 0;

			while(data != -1) {
				if(i%4 == 0) {
					total += data*1;
				} else if (i%4 == 1) {
					total += data*3;
				} else if (i%4 == 2) {
					total += data*11;
				} else if (i%4 == 3) {
					total += data*17;
				}
				data = input.read();
				i++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 artifactID =  "" + total + "." + length + "." + extension;
		
	}
	
	public String getFileExtension(File file) {
	    String name = file.getName();
	    try {
	        return name.substring(name.lastIndexOf(".") + 1);
	    } catch (Exception e) {
	        return "";
	    }
	}
	
	public String getArtifactID() {
		return artifactID;
	}


	public void setArtifactID(String artifactID) {
		this.artifactID = artifactID;
	}


	public File getSourceFile() {
		return sourceFile;
	}


	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}


	public File getDestination() {
		return destination;
	}


	public void setDestination(File destination) {
		this.destination = destination;
	}


	public File getLeafFolder() {
		return leafFolder;
	}


	public void setLeafFolder(File leafFolder) {
		this.leafFolder = leafFolder;
	}


	public String getExtension() {
		return extension;
	}


	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}


}
