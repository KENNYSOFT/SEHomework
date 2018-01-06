package kr.KENNYSOFT.SEHomework.Operator;

import java.math.BigInteger;

public class Subtractor extends Operator
{
	@Override
	public String operate(String operand1, String operand2) throws NumberFormatException
	{
		BigInteger mOperand1 = new BigInteger(operand1);
		BigInteger mOperand2 = new BigInteger(operand2);

		BigInteger result = mOperand1.subtract(mOperand2);

		return result.toString();
	}
}