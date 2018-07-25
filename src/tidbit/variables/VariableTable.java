package tidbit.variables;

import java.util.LinkedHashMap;
import java.util.Map;
import tidbit.constants.Type;

/**
 *
 * @author Gavin
 */
public class VariableTable
{
	private final int offset;
	private final Map<String, Variable> variableMap = new LinkedHashMap<>();

	public VariableTable(int offset)
	{
		this.offset = offset;
	}
	
	public Variable getVariable(String name, Type type)
	{
		Variable variable = variableMap.computeIfAbsent(name, n ->
		{
			Variable var = Variable.ofType(type);
			var.setIndex(variableMap.size() + offset);
			return var;
		});

		if (!variable.getType().equals(type))
		{
			throw new RuntimeException(String.format("Tried to assign type '%s' to variable '%s' of type '%s'", type.getName(), name, type.getName()));
		}

		return variable;
	}

	public int size()
	{
		return variableMap.size() + offset;
	}
}
