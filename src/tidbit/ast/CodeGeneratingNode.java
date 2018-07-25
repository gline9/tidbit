package tidbit.ast;

import java.util.List;
import tidbit.instruction.Instruction;

/**
 *
 * @author Gavin
 */
public abstract class CodeGeneratingNode
{

	public abstract List<Instruction> getInstructions();

	public abstract int getMaxStackDepth();
	
}
