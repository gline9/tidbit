package tidbit.instruction;

import java.io.DataOutputStream;
import java.io.IOException;
import tidbit.constants.ConstantTable;
import tidbit.constants.FieldReferenceConstant;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public class GetStatic extends Instruction
{
	private final FieldReferenceConstant field;
	private int fieldIndex;

	public GetStatic(FieldReferenceConstant field)
	{
		super(0xb2);

		this.field = field;
	}

	@Override
	public int additionalSize()
	{
		return 2;
	}

	@Override
	public void writeInstruction(DataOutputStream out) throws IOException
	{
		out.writeShort(fieldIndex);
	}

	@Override
	public void registerConstants(ConstantTable table)
	{
		fieldIndex = table.registerConstant(field);
	}

	@Override
	public void registerVariables(VariableTable table) {
		// do nothing
	}
	
}
