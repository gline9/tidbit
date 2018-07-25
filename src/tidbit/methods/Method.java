package tidbit.methods;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import tidbit.attributes.Attribute;
import tidbit.constants.ConstantTable;
import tidbit.constants.UTF8Constant;

/**
 *
 * @author Gavin
 */
public class Method
{
	private final String name;
	private int nameIndex;
	private final int accessor;
	private final String descriptor;
	private int descriptorIndex;
	private final List<Attribute> attributes;

	protected Method(String name, int accessor, String descriptor, List<Attribute> attributes)
	{
		this.name = name;
		this.accessor = accessor;
		this.descriptor = descriptor;
		this.attributes = attributes;

	}

	public void registerConstants(ConstantTable table)
	{
		this.nameIndex = table.registerConstant(new UTF8Constant(name));
		this.descriptorIndex = table.registerConstant(new UTF8Constant(descriptor));
		this.attributes.forEach(a -> a.registerConstants(table));
	}

	public void write(DataOutputStream out) throws IOException
	{
		out.writeShort(accessor);
		out.writeShort(nameIndex);
		out.writeShort(descriptorIndex);
		out.writeShort(attributes.size());

		for (Attribute attribute : attributes)
		{
			attribute.write(out);
		}
	}
}
