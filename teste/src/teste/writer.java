package teste;

import java.io.FileWriter;
import java.io.IOException;

public class writer {	
	
    public static void main(String[] args) throws IOException
    {
        // String do arquivo
        String str = "Gravando num arquivo texto";
  
        // Arquivo onde será gravada a string 
        FileWriter arquivo=new FileWriter("output.txt");
  
        // read character wise from string and write 
        // into FileWriter 
        for (int i = 0; i < str.length(); i++)
        	arquivo.write(str.charAt(i));
  
        System.out.println("Writing successful");
        //close the file 
        arquivo.close();
    }

}
