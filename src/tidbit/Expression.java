
import java.util.function.Function;


/**
 *
 * @author Gavin
 */
public interface Expression extends Function<Integer, Integer>
{
	public static Expression add(int value)
	{
		return i -> i + value;
	}

	public static Expression mul(int value)
	{
		return i -> i * value;
	}
	
}
