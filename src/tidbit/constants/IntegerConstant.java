package tidbit.constants;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author Gavin
 */
public class IntegerConstant extends Constant
{
	private final int value;

	public IntegerConstant(int value)
	{
		super(3);

		this.value = value;
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException
	{
		out.writeInt(value);
	}

	@Override
	public void register(ConstantTable table)
	{
		// do nothing
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 79 * hash + this.value;
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
		final IntegerConstant other = (IntegerConstant) obj;
		if (this.value != other.value) {
			return false;
		}
		return true;
	}

}
