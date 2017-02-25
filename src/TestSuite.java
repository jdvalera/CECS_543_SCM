import java.io.File;

public class TestSuite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testRepository();
	}
	
	public static void testArtifact() {
		File test = new File("./", "text.txt");
		File dest = new File ("./testing");
		Artifact a = new Artifact(test, dest);
		
		//File directory = new File("./");
		//System.out.println(directory.getAbsolutePath());

		System.out.println(a.getID());
		System.out.println(a.leafFolder.getPath());
		
		//System.out.println(a.createID("HELLO WORLD"));
	}
	
	public static void testRepository() {
		File src = new File("./sourceTest");
		File dest = new File("./destTest");
		
		Repository rep = new Repository();
		
		rep.copyDirectory(src, dest);
		System.out.println(src.getAbsolutePath());
		System.out.println(dest.getAbsolutePath());
	}

}
