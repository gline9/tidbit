package tidbit.ast;

import java.util.List;
import tidbit.instruction.Instruction;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public abstract class CodeGeneratingNode
{

	public abstract List<Instruction> getInstructions(VariableTable table);

	public abstract int getMaxStackDepth();
	
}
