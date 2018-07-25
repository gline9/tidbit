package tidbit.constants;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 *
 * @author Gavin
 */
public class ConstantTable
{
	private final LinkedHashMap<Constant, Constant> constants = new LinkedHashMap<>();

	public int registerConstant(Constant constant)
	{
		if (constants.containsKey(constant))
		{
			return getConstantIndex(constant);
		}
		constants.put(constant, constant);
		int index = constants.size();
		constant.setIndex(index);
		constant.register(this);
		return index;
	}

	public int getConstantIndex(Constant constant)
	{
		Constant found = constant;
		if (constants.containsKey(constant))
		{
			found = constants.get(constant);
		}
		return found.getIndex().orElseThrow(() -> new IllegalStateException("Tried to grab index of unlisted constant"));
	}

	public void writeConstantTable(DataOutputStream out) throws IOException
	{
		writeTableSize(out);

		for (Constant constant : constants.keySet())
		{
			constant.write(out);
		}
	}

	private void writeTableSize(DataOutputStream out) throws IOException
	{
		out.writeShort(constants.size() + 1);
	}
}
