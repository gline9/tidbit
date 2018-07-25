package tidbit.constants;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Optional;

/**
 *
 * @author Gavin
 */
public abstract class Constant
{
	private Optional<Integer> index = Optional.empty();
	private final int type;

	public Constant(int type)
	{
		this.type = type;
	}

	public void setIndex(int index)
	{
		this.index = Optional.of(index);
	}

	public Optional<Integer> getIndex()
	{
		return index;
	}

	public void write(DataOutputStream out) throws IOException
	{
		out.writeByte(type);

		writeData(out);
	}

	public abstract void writeData(DataOutputStream out) throws IOException;

	public abstract void register(ConstantTable table);
	
}
