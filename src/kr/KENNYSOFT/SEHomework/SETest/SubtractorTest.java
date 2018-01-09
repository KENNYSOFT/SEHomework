package kr.KENNYSOFT.SEHomework.SETest;

import org.junit.Assert;
import org.junit.Test;

import kr.KENNYSOFT.SEHomework.Operator.Operator;
import kr.KENNYSOFT.SEHomework.Operator.Subtractor;

public class SubtractorTest
{
	@Test
	public void testSubtractNormalInt()
	{
		Operator subtractor = new Subtractor();
		Assert.assertEquals("-1", subtractor.operate(1, 2));
	}

	@Test
	public void testSubtractLargeInt()
	{
		Operator subtractor = new Subtractor();
		Assert.assertEquals("47483647", subtractor.operate(2147483647, 2100000000));
	}

	@Test
	public void testSubtractLargeString()
	{
		Operator subtractor = new Subtractor();
		Assert.assertEquals("-9223372036854775808", subtractor.operate("9223372036854775808", "18446744073709551616"));
	}
}