package tidbit.constants;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

/**
 *
 * @author Gavin
 */
public class FieldReferenceConstant extends Constant
{
	private final String className;
	private int classNameIndex;
	private final String name;
	private final String type;
	private int nameTypeIndex;

	public FieldReferenceConstant(String className, String name, Type type)
	{
		super(9);

		this.className = className;
		this.name = name;
		this.type = type.getName();
	}

	@Override
	public void register(ConstantTable table)
	{
		classNameIndex = table.registerConstant(new ClassConstant(className));
		nameTypeIndex = table.registerConstant(new NameAndTypeReferenceConstant(name, type));
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException
	{
		out.writeShort(classNameIndex);
		out.writeShort(nameTypeIndex);
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 31 * hash + Objects.hashCode(this.className);
		hash = 31 * hash + Objects.hashCode(this.name);
		hash = 31 * hash + Objects.hashCode(this.type);
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
		final FieldReferenceConstant other = (FieldReferenceConstant) obj;
		if (!Objects.equals(this.className, other.className)) {
			return false;
		}
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		if (!Objects.equals(this.type, other.type)) {
			return false;
		}
		return true;
	}

}
