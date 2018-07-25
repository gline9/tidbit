package tidbit.ast;

import tidbit.instruction.IRem;

/**
 *
 * @author Gavin
 */
public class ModExpression extends MathExpression
{
	
	public ModExpression(Value left, Value right)
	{
		super(left, right, new IRem());
	}
	
}
