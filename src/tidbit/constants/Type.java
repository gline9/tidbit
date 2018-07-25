package tidbit.constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Gavin
 */
public class Type
{
	private static final Map<Class, String> classMap = new HashMap<>();
	static
	{
		classMap.put(byte.class, "B");
		classMap.put(char.class, "C");
		classMap.put(double.class, "D");
		classMap.put(float.class, "F");
		classMap.put(int.class, "I");
		classMap.put(long.class, "L");
		classMap.put(short.class, "S");
		classMap.put(boolean.class, "Z");
	}
	private final String name;

	private Type(String name)
	{
		this.name = name;
	}

	public static Type ofClass(Class clazz)
	{
		return new Type(getTypeName(clazz));
	}

	public static Type ofByte()
	{
		return new Type(getTypeName(byte.class));
	}

	public static Type ofChar()
	{
		return new Type(getTypeName(char.class));
	}

	public static Type ofDouble()
	{
		return new Type(getTypeName(double.class));
	}

	public static Type ofFloat()
	{
		return new Type(getTypeName(float.class));
	}

	public static Type ofInt()
	{
		return new Type(getTypeName(int.class));
	}

	public static Type ofLong()
	{
		return new Type(getTypeName(long.class));
	}

	public static Type ofShort()
	{
		return new Type(getTypeName(short.class));
	}

	public static Type ofBoolean()
	{
		return new Type(getTypeName(boolean.class));
	}

	public static Type ofVoid()
	{
		return new Type("V");
	}

	public static Type fromName(String name)
	{
		return new Type(nameToType(name));
	}

	private static String getTypeName(Class clazz)
	{
		if (classMap.containsKey(clazz))
		{
			return classMap.get(clazz);
		}

		if (clazz.isArray())
		{
			return "[" + getTypeName(clazz.getComponentType());
		}

		return nameToType(clazz.getCanonicalName());
	}

	private static String nameToType(String name)
	{
		return "L" + name.replaceAll("\\.", "/") + ";";
	}

	public String getName()
	{
		return name;
	}

	public Type asArray()
	{
		return new Type("[" + name);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Type other = (Type) obj;
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		return true;
	}

}
