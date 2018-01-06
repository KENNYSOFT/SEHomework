package kr.KENNYSOFT.SEHomework.Operator;

public abstract class Operator
{
	public Operator()
	{
	}

	public abstract String operate(String operand1, String operand2);

	public String operate(int operand1, int operand2)
	{
		return operate(String.valueOf(operand1), String.valueOf(operand2));
	}
}