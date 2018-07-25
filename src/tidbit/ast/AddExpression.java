package tidbit.ast;

import tidbit.instruction.IAdd;

/**
 *
 * @author Gavin
 */
public class AddExpression extends MathExpression
{

	public AddExpression(Value left, Value right)
	{
		super(left, right, new IAdd());
	}

}
