package tidbit.variables;

import java.util.Optional;
import tidbit.constants.Type;

/**
 *
 * @author Gavin
 */
public class Variable
{
	private final Type type;
	private Optional<Integer> index = Optional.empty();

	private Variable(Type type)
	{
		this.type = type;
	}

	public static Variable ofType(Type type)
	{
		return new Variable(type);
	}

	void setIndex(int index)
	{
		this.index = Optional.of(index);
	}

	public int getIndex()
	{
		return this.index.get();
	}

	public Type getType()
	{
		return type;
	}
	
}
