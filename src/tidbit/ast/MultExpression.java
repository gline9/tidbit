package tidbit.ast;

import tidbit.instruction.IMul;

/**
 *
 * @author Gavin
 */
public class MultExpression extends MathExpression
{

	public MultExpression(Value left, Value right)
	{
		super(left, right, new IMul());
	}

}
