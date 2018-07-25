package tidbit.instruction;

import java.io.DataOutputStream;
import java.io.IOException;
import tidbit.constants.Constant;
import tidbit.constants.ConstantTable;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class LoadConstant extends Instruction
{
	private final Constant constant;
	private int constantIndex;

	public LoadConstant(Constant constant)
	{
		super(0x12);

		this.constant = constant;
	}

	@Override
	protected int additionalSize()
	{
		return 1;
	}

	@Override
	public void registerConstants(ConstantTable table)
	{
		constantIndex = table.registerConstant(constant);
	}

	@Override
	protected void writeInstruction(DataOutputStream out) throws IOException
	{
		out.writeByte(constantIndex);
	}

	@Override
	public void registerVariables(VariableTable table)
	{
		// do nothing
	}
	
}
