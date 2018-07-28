package tidbit.instruction;

import java.io.DataOutputStream;
import java.io.IOException;
import tidbit.constants.ConstantTable;

/**
 *
 * @author Gavin
 */
public abstract class PhantomInstruction extends Instruction
{

	public PhantomInstruction()
	{
		super(0);
	}

	@Override
	public int size()
	{
		return 0;
	}

	@Override
	protected int additionalSize()
	{
		return 0;
	}

	@Override
	public void registerConstants(ConstantTable table)
	{
		// do nothing
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		// do nothing
	}

	@Override
	protected void writeInstruction(DataOutputStream out) throws IOException
	{
		// do nothing
	}
	
}
