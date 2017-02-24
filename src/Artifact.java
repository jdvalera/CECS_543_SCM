
public class Artifact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Artifact a = new Artifact();
		
		System.out.println(a.createAID("HELLO WORLD"));
	}
	
	public String createAID(String content) {
		
		int total = 0;
		int length = content.length();
		
		for(int i = 0; i<length; i++ ) {
			
			byte ascii = (byte) content.charAt(i);
			
			if(i%4 == 0) {
				total += ascii*1;
			} else if (i%4 == 1) {
				total += ascii*3;
			} else if (i%4 == 2) {
				total += ascii*11;
			} else if (i%4 == 3) {
				total += ascii*17;
			}
		}
		
		String output = "" + total + "." + length;
		
		return output;
	}

}
