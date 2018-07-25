package tidbit.constants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Gavin
 */
public class Descriptor
{
	private final String compiled;

	private Descriptor(List<Type> args, Type returnType)
	{
		compiled = "(" + String.join(",", args.stream().map(Type::getName).collect(Collectors.toList())) + ")" + returnType.getName();
	}

	public String toString()
	{
		return compiled;
	}

	public static class Builder
	{
		private final List<Type> args = new ArrayList<>();

		private Type returnType = Type.ofVoid();

		public Builder withReturnType(Type type)
		{
			this.returnType = type;

			return this;
		}

		public Builder addArg(Type type)
		{
			this.args.add(type);

			return this;
		}

		public Descriptor build()
		{
			return new Descriptor(args, returnType);
		}
	}
	
}
