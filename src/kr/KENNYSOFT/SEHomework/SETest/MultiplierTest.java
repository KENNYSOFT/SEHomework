package kr.KENNYSOFT.SEHomework.SETest;

import org.junit.Assert;
import org.junit.Test;

import kr.KENNYSOFT.SEHomework.Operator.Multiplier;
import kr.KENNYSOFT.SEHomework.Operator.Operator;

public class MultiplierTest
{
	@Test
	public void testMultiplyNormalInt()
	{
		Operator multiplier = new Multiplier();
		Assert.assertEquals(multiplier.operate(1, 2), "2");
	}

	@Test
	public void testMultiplyLargeInt()
	{
		Operator multiplier = new Multiplier();
		Assert.assertEquals(multiplier.operate(2147483647, 2100000000), "4509715658700000000");
	}

	@Test
	public void testMultiplyLargeString()
	{
		Operator multiplier = new Multiplier();
		Assert.assertEquals(multiplier.operate("9223372036854775808", "18446744073709551616"), "170141183460469231731687303715884105728");
	}
}