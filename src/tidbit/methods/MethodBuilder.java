package tidbit.methods;

import java.util.ArrayList;
import java.util.List;
import tidbit.attributes.Attribute;
import tidbit.constants.ConstantTable;

/**
 *
 * @author Gavin
 */
public class MethodBuilder
{
	private String name;
	private List<MethodAccessor> accessors = new ArrayList<>();
	private String inputs;
	private String output;
	private List<Attribute> attributes = new ArrayList<>();

	public MethodBuilder withName(String name)
	{
		this.name = name;

		return this;
	}

	public MethodBuilder withAccess(MethodAccessor accessor)
	{
		accessors.add(accessor);

		return this;
	}

	public MethodBuilder withInputArguments(String... inputs)
	{
		this.inputs = String.join("", inputs);

		return this;
	}

	public MethodBuilder withOutputArgument(String output)
	{
		this.output = output;

		return this;
	}

	public MethodBuilder withAttribute(Attribute attribute)
	{
		this.attributes.add(attribute);

		return this;
	}

	public Method build()
	{
		int accessor = MethodAccessor.createFlag(accessors);
		String descriptor = "(" + inputs + ")" + output;

		return new Method(name, accessor, descriptor, attributes);
	}
	
}
