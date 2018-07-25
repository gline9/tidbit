package tidbit.ast;

import java.util.List;
import tidbit.constants.Type;
import tidbit.instruction.Instruction;
import tidbit.variables.VariableTable;

/**
 *
 * @author Gavin
 */
public abstract class Value
{

	public abstract List<Instruction> addToTopOfStack(VariableTable table);

	public abstract int stackDepth();

	public abstract Type getType(VariableTable table);
	
}
