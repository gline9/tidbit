package tidbit.instruction;

import java.util.Optional;
import tidbit.frames.SameFrameExtended;
import tidbit.frames.StackFrame;

/**
 *
 * @author Gavin
 */
public class JumpPointInstruction extends PhantomInstruction
{

	private int jumpIndex;

	@Override
	public Optional<StackFrame> getStackFrame(int index, int frameOffset)
	{
		jumpIndex = index;

		return Optional.of(new SameFrameExtended(index - frameOffset));
	}

	public int getRelativeJump(Instruction instruction)
	{
		return jumpIndex - instruction.getLocation();
	}
	
}
