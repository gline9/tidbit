package tidbit.instruction;

import java.io.DataOutputStream;
import java.io.IOException;
import tidbit.constants.ConstantTable;
import tidbit.constants.MethodReferenceConstant;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class InvokeVirtual extends Instruction
{
	private final MethodReferenceConstant method;
	private int methodIndex;

	public InvokeVirtual(MethodReferenceConstant method)
	{
		super(0xb6);

		this.method = method;
	}

	@Override
	protected int additionalSize()
	{
		return 2;
	}

	@Override
	public void registerConstants(ConstantTable table)
	{
		methodIndex = table.registerConstant(method);
	}

	@Override
	protected void writeInstruction(DataOutputStream out) throws IOException
	{
		out.writeShort(methodIndex);
	}

	@Override
	public void registerVariables(VariableTable table) {
		// do nothing
	}
	
}
