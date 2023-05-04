package controller;
import java.io.IOException;
public interface ISteamController {
	
	public void readFile(String ano, String mes, double media) throws IOException;
	
	public void readFile2(String ano, String mes, String path, String file) throws IOException;

}
