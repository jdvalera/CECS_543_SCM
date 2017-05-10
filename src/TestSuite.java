import java.io.File;

public class TestSuite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testRepository();
		//Repository r = new Repository();
		//r.create();
		testCheckOut();
	}
	
	public static void testCheckOut() {
		File test = new File("E:\\Users\\John\\Desktop\\Dropbox\\CECS 543\\Project\\src\\..\\destTest\\A");
		System.out.println(test.getAbsolutePath().replaceAll("\\\\", "/"));
		//new File("E:/Users/John/Desktop/Dropbox/CECS 543/Project/src/../destTest/A/C").mkdir();
		String list[] = test.list();
		for(String l : list) {
			System.out.println(l);
		}
	}
	
	public static void testArtifact() {
		File test = new File("./", "text.txt");
		File dest = new File ("./testing");
		Artifact a = new Artifact(test, dest);
		
		//File directory = new File("./");
		//System.out.println(directory.getAbsolutePath());

		System.out.println(a.getArtifactID());
		System.out.println(a.getLeafFolder().getPath());
		
		//System.out.println(a.createID("HELLO WORLD"));
	}
	
	public static void testRepository() {
		File src = new File("./sourceTest");
		File dest = new File("./destTest");
		String[] s  = {src.getPath(), dest.getPath()};
		Repository rep = new Repository(s);
		
		//rep.copyDirectory(src, dest);
		//System.out.println(src.getAbsolutePath());
		//System.out.println(dest.getAbsolutePath());
	}

}
