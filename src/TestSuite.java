import java.io.File;

public class TestSuite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File test = new File("./", "text.txt");
		File dest = new File ("./testing");
		Artifact a = new Artifact(test, dest);
		
		//File directory = new File("./");
		//System.out.println(directory.getAbsolutePath());

		System.out.println(a.getID());
		System.out.println(a.leafFolder.getPath());
		
		//System.out.println(a.createID("HELLO WORLD"));
	}

}
