package tidbit.constants;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

/**
 *
 * @author Gavin
 */
public class MethodReferenceConstant extends Constant
{
	private final String className;
	private int classNameIndex;
	private final String name;
	private final String descriptor;
	private int nameTypeIndex;

	public MethodReferenceConstant(String className, String name, Descriptor descriptor)
	{
		super(10);

		this.className = className;
		this.name = name;
		this.descriptor = descriptor.toString();
	}

	@Override
	public void register(ConstantTable table)
	{
		classNameIndex = table.registerConstant(new ClassConstant(className));
		nameTypeIndex = table.registerConstant(new NameAndTypeReferenceConstant(name, descriptor));
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException
	{
		out.writeShort(classNameIndex);
		out.writeShort(nameTypeIndex);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 53 * hash + Objects.hashCode(this.className);
		hash = 53 * hash + Objects.hashCode(this.name);
		hash = 53 * hash + Objects.hashCode(this.descriptor);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final MethodReferenceConstant other = (MethodReferenceConstant) obj;
		if (!Objects.equals(this.className, other.className)) {
			return false;
		}
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		if (!Objects.equals(this.descriptor, other.descriptor)) {
			return false;
		}
		return true;
	}

}
