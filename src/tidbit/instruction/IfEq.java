package tidbit.instruction;

import java.io.DataOutputStream;
import java.io.IOException;
import tidbit.constants.ConstantTable;

/**
 *
 * @author Gavin
 */
public class IfEq extends Instruction
{
	private final JumpPointInstruction jumpPoint;

	public IfEq(JumpPointInstruction jumpPoint)
	{
		super(0x99);

		this.jumpPoint = jumpPoint;
	}

	@Override
	protected int additionalSize()
	{
		return 2;
	}

	@Override
	public void registerConstants(ConstantTable table)
	{
		// do nothing
	}

	@Override
	protected void writeInstruction(DataOutputStream out) throws IOException
	{
		out.writeShort(jumpPoint.getRelativeJump(this));
	}
	
}
