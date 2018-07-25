package tidbit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tidbit.ast.Root;

/**
 *
 * @author Gavin
 */
public class RootClassLoader extends ClassLoader
{

	public Class loadRootClass(Root root, String className)
	{
		byte[] bytes = root.getClassBytes(className);
		try {
			FileOutputStream out = new FileOutputStream(new File(className + ".class"));
			out.write(bytes);
			out.flush();
			out.close();
		}
		catch (FileNotFoundException ex)
		{
			Logger.getLogger(RootClassLoader.class.getName()).log(Level.SEVERE, null, ex);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		return defineClass(className, bytes, 0, bytes.length);
	}
	
}
