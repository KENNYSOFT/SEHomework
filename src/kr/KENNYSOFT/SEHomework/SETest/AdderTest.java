package kr.KENNYSOFT.SEHomework.SETest;

import org.junit.Assert;
import org.junit.Test;

import kr.KENNYSOFT.SEHomework.Operator.Adder;
import kr.KENNYSOFT.SEHomework.Operator.Operator;

public class AdderTest
{
	@Test
	public void testAddNormalInt()
	{
		Operator adder = new Adder();
		Assert.assertEquals(adder.operate(1, 2), "3");
	}

	@Test
	public void testAddLargeInt()
	{
		Operator adder = new Adder();
		Assert.assertEquals(adder.operate(2147483647, 2100000000), "4247483647");
	}

	@Test
	public void testAddLargeString()
	{
		Operator adder = new Adder();
		Assert.assertEquals(adder.operate("9223372036854775808", "18446744073709551616"), "27670116110564327424");
	}
}