import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestSuite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testRepository();
		//Repository r = new Repository();
		//r.create();
		testCheckOut();
	}
	
	public static void testCheckOut() {
		List<String> lines;
		List<String> Names;
		//File test = new File("E:\\Users\\John\\Desktop\\Dropbox\\CECS 543\\Project\\src\\..\\destTest\\A");
		//System.out.println(test.getAbsolutePath().replaceAll("\\\\", "/"));
		//new File("E:/Users/John/Desktop/Dropbox/CECS 543/Project/src/../destTest/A/C").mkdir();
		//String list[] = test.list();
		//for(String l : list) {
		//	System.out.println(l);
		//}
		
		String filename = "E:/Users/John/Desktop/Dropbox/CECS 543/Project/destTest/activity/Manifest-05-10-2017-20-22.txt";
		lines = readFile(filename);
		int count = 0;
		for(String line : lines) {
			if(count>5)
				System.out.println(line);
				System.out.println(line.split("\t").length);
			count++;
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
	
	public static List<String> readFile(String filename)
	{
	  List<String> records = new ArrayList<String>();
	  try
	  {
	    BufferedReader reader = new BufferedReader(new FileReader(filename));
	    String line;
	    while ((line = reader.readLine()) != null)
	    {
	      records.add(line);
	    }
	    reader.close();
	    return records;
	  }
	  catch (Exception e)
	  {
	    System.err.format("Exception occurred trying to read '%s'.", filename);
	    e.printStackTrace();
	    return null;
	  }
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
