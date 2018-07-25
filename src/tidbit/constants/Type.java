package tidbit.constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import tidbit.instruction.load.ALoad;
import tidbit.instruction.load.DLoad;
import tidbit.instruction.load.FLoad;
import tidbit.instruction.load.ILoad;
import tidbit.instruction.load.LLoad;
import tidbit.instruction.load.LoadInstruction;
import tidbit.instruction.store.AStore;
import tidbit.instruction.store.DStore;
import tidbit.instruction.store.FStore;
import tidbit.instruction.store.IStore;
import tidbit.instruction.store.LStore;
import tidbit.instruction.store.StoreInstruction;

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
		classMap.put(long.class, "J");
		classMap.put(short.class, "S");
		classMap.put(boolean.class, "Z");
	}

	private static final Map<String, Function<String, LoadInstruction>> loadMap = new HashMap<>();
	static
	{
		loadMap.put("B", ILoad::new);
		loadMap.put("C", ILoad::new);
		loadMap.put("D", DLoad::new);
		loadMap.put("F", FLoad::new);
		loadMap.put("I", ILoad::new);
		loadMap.put("J", LLoad::new);
		loadMap.put("S", ILoad::new);
		loadMap.put("Z", ILoad::new);
	}

	private static final Map<String, Function<String, StoreInstruction>> storeMap = new HashMap<>();
	static
	{
		storeMap.put("B", IStore::new);
		storeMap.put("C", IStore::new);
		storeMap.put("D", DStore::new);
		storeMap.put("F", FStore::new);
		storeMap.put("I", IStore::new);
		storeMap.put("J", LStore::new);
		storeMap.put("S", IStore::new);
		storeMap.put("Z", IStore::new);
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

	public LoadInstruction getLoadInstruction(String variableName)
	{
		if (loadMap.containsKey(name))
		{
			return loadMap.get(name).apply(variableName);
		}

		return new ALoad(variableName, this);
	}

	public StoreInstruction getStoreInstruction(String variableName)
	{
		if (storeMap.containsKey(name))
		{
			return storeMap.get(name).apply(variableName);
		}

		return new AStore(variableName, this);
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
