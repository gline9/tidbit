package tidbit.ast;

import java.util.List;
import tidbit.constants.Type;
import tidbit.instruction.Instruction;

/**
 *
 * @author Gavin
 */
public abstract class Value
{

	public abstract List<Instruction> addToTopOfStack();

	public abstract int stackDepth();

	public abstract Type getType();
	
}
