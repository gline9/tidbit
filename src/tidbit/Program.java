package tidbit;

import java.io.ByteArrayOutputStream;
import tidbit.constants.ClassConstant;
import tidbit.constants.ConstantTable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import tidbit.methods.Method;

/**
 *
 * @author Gavin
 */
public class Program
{
	public static ConstantTable table = new ConstantTable();

	private static final int MAGIC = 0xCAFEBABE;
	private static final int MAJOR = 52;
	private static final int MINOR = 0;

	private final String className;
	private final String superClassName;
	private final List<Method> methods;

	public Program(String className, String superClassName, List<Method> methods)
	{
		this.className = className;
		this.superClassName = superClassName;
		this.methods = methods;
	}

	public byte[] getBytes() throws IOException
	{
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		try(DataOutputStream out = new DataOutputStream(bytes))
		{
			ConstantTable table = new ConstantTable();

			int classNameIndex = table.registerConstant(new ClassConstant(className));
			int superClassNameIndex = table.registerConstant(new ClassConstant(superClassName));
			this.methods.forEach(method -> method.registerConstants(table));


			out.writeInt(MAGIC);
			out.writeShort(MINOR);
			out.writeShort(MAJOR);
			table.writeConstantTable(out);
			out.writeShort(0x0001 | 0x0020 | 0x1000); // public class
			out.writeShort(classNameIndex);
			out.writeShort(superClassNameIndex);
			out.writeShort(0); // num interfaces
			out.writeShort(0); // num fields
			out.writeShort(this.methods.size()); // num methods

			for (Method method : this.methods)
			{
				method.write(out);
			}

			out.writeShort(0); // num attributes
			out.flush();
		}

		return bytes.toByteArray();
	}

}
