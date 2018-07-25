package tidbit.constants;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

/**
 *
 * @author Gavin
 */
public class StringConstant extends Constant
{
	private final String value;
	private int valueIndex;

	public StringConstant(String value)
	{
		super(8);

		this.value = value;
	}

	@Override
	public void register(ConstantTable table)
	{
		valueIndex = table.registerConstant(new UTF8Constant(value));
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException
	{
		out.writeShort(valueIndex);
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 89 * hash + Objects.hashCode(this.value);
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
		final StringConstant other = (StringConstant) obj;
		if (!Objects.equals(this.value, other.value)) {
			return false;
		}
		return true;
	}

}
