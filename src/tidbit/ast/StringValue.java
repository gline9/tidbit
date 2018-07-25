package tidbit.ast;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.text.StringEscapeUtils;
import tidbit.constants.Constant;
import tidbit.constants.StringConstant;
import tidbit.constants.Type;
import tidbit.instruction.Instruction;
import tidbit.instruction.LoadConstant;

/**
 *
 * @author Gavin
 */
public class StringValue extends Value
{
	private final String value;

	public StringValue(String value)
	{
		this.value = StringEscapeUtils.unescapeJava(value);
	}

	private Constant getConstant()
	{
		return new StringConstant(value);
	}

	@Override
	public List<Instruction> addToTopOfStack()
	{
		return Arrays.asList(
			new LoadConstant(getConstant()));
	}

	@Override
	public int stackDepth() {
		return 1;
	}

	@Override
	public Type getType()
	{
		return Type.ofClass(String.class);
	}

}
