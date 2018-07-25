package tidbit.attributes;

import java.io.DataOutputStream;
import java.io.IOException;
import tidbit.constants.ConstantTable;

/**
 *
 * @author Gavin
 */
public abstract class Attribute
{
	public abstract void registerConstants(ConstantTable table);

	public abstract void write(DataOutputStream out) throws IOException;
	
}
