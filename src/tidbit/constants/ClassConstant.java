package tidbit.constants;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

/**
 *
 * @author Gavin
 */
public class ClassConstant extends Constant
{
	private int classNameIndex;
	private final String className;

	public ClassConstant(String className)
	{
		super(7);

		this.className = className;
	}

	@Override
	public void register(ConstantTable table)
	{
		classNameIndex = table.registerConstant(new UTF8Constant(className));
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException
	{
		out.writeShort(classNameIndex);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 17 * hash + Objects.hashCode(this.className);
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
		final ClassConstant other = (ClassConstant) obj;
		if (!Objects.equals(this.className, other.className)) {
			return false;
		}
		return true;
	}

}
