package gui;

public class Utils {

	public static String getFileExtension(String name) {
		
		int pointIndex = name.lastIndexOf(".");
		
		// not dot in the string
		if(pointIndex == -1) {
			return null;
		}
		
		// dot is last character
		if(pointIndex == name.length()-1) {
			return null;
		}
		
		return name.substring((pointIndex)+1, name.length());
	}
	
}
