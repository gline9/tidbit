package tidbit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import tidbit.ast.ParseException;
import tidbit.ast.Root;
import tidbit.ast.TidBit;

/**
 *
 * @author Gavin
 */
public class Main
{
	public static void main(String[] args) throws ParseException, IOException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Root root;
        if (args.length == 0)
        {
			root = TidBit.parse(System.in);
        }
        else
        {
			root = TidBit.parse(new FileInputStream(new File(args[0])));
        }

		String className = "Tid$Start";

		System.out.println("\n***** Program Running *****");

		Class<?> clazz = new RootClassLoader().loadRootClass(root, className);
		clazz.getMethod("main", String[].class).invoke(null, (Object)new String[]{});
	}
}
