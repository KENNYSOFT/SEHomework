package kr.KENNYSOFT.SEHomework.Operator;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

public class OperatorFactory
{
	List<Pair<String, Class<?>>> functions = new ArrayList<>();

	public OperatorFactory(List<Pair<String, String>> functions) throws ClassNotFoundException
	{
		initialize(functions);
	}

	public void initialize(List<Pair<String, String>> functions) throws ClassNotFoundException
	{
		this.functions.clear();

		if (functions != null)
		{
			for (Pair<String, String> function : functions)
			{
				this.functions.add(Pair.of(function.getLeft(), Class.forName(function.getRight())));
			}
		}
	}

	public Operator create(String operator)
	{
		for (Pair<String, Class<?>> function : functions)
		{
			if (function.getLeft().equals(operator))
			{
				try
				{
					return (Operator)function.getRight().getConstructor().newInstance();
				}
				catch (NoSuchMethodException|InvocationTargetException|IllegalAccessException|InstantiationException|IllegalArgumentException|SecurityException e)
				{
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}
}