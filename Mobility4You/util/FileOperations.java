package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FileOperations
{
	public static ArrayList<String> readFromFile(String path)
	{
		ArrayList<String> rows=new ArrayList<String>();

		try(BufferedReader br=Files.newBufferedReader(Paths.get(path)))	
		{
			rows=(ArrayList<String>) br.lines().collect(Collectors.toList());
		}
		catch(IOException e) {e.printStackTrace();}

		return rows;
	}
}
