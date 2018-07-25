package tidbit.constants;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

/**
 *
 * @author Gavin
 */
public class UTF8Constant extends Constant
{
	private final String value;

	public UTF8Constant(String value)
	{
		super(1);
		this.value = value;
	}

	@Override
	public void register(ConstantTable table)
	{
		// do nothing
	}

	@Override
	public void writeData(DataOutputStream out) throws IOException
	{
		out.writeUTF(value);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 13 * hash + Objects.hashCode(this.value);
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
		final UTF8Constant other = (UTF8Constant) obj;
		if (!Objects.equals(this.value, other.value)) {
			return false;
		}
		return true;
	}

	
	
}
