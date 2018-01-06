package kr.KENNYSOFT.SEHomework.SETest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.KENNYSOFT.SEHomework.SEHomework;
import kr.KENNYSOFT.SEHomework.Exception.PropertiesNotMatchingException;
import kr.KENNYSOFT.SEHomework.Operator.Operator;
import kr.KENNYSOFT.SEHomework.Operator.OperatorFactory;

public class SETest
{
	static OperatorFactory factory;

	@BeforeClass
	public static void setUpClass()
	{
		try
		{
			factory = new OperatorFactory(SEHomework.getFunctions());
		}
		catch (PropertiesNotMatchingException|ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testGetFunctions() throws PropertiesNotMatchingException
	{
		SEHomework.getFunctions();
	}

	@Test
	public void testCreateOperatorFactory() throws ClassNotFoundException
	{
		List<Pair<String, String>> functions = new ArrayList<>();

		try
		{
			functions = SEHomework.getFunctions();
		}
		catch (PropertiesNotMatchingException e)
		{
			e.printStackTrace();
			Assert.fail();
		}

		new OperatorFactory(functions);
	}
}