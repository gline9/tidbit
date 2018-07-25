package tidbit.constants;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author Gavin
 */
public class NameAndTypeReferenceConstant extends Constant
{
	private final String name;
	private int nameIndex;
	private final String descriptor;
	private int descriptorIndex;

	public NameAndTypeReferenceConstant(String name, String descriptor)
	{
		super(12);

		this.name = name;
		this.descriptor = descriptor;
	}

	@Override
	public void register(ConstantTable table)
	{
		nameIndex = table.registerConstant(new UTF8Constant(name));
		descriptorIndex = table.registerConstant(new UTF8Constant(descriptor));
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException
	{
		out.writeShort(nameIndex);
		out.writeShort(descriptorIndex);
	}
	
}
