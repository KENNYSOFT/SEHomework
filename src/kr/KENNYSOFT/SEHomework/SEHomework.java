package kr.KENNYSOFT.SEHomework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.lang3.tuple.Pair;

import kr.KENNYSOFT.SEHomework.Exception.PropertiesNotMatchingException;
import kr.KENNYSOFT.SEHomework.Operator.Operator;
import kr.KENNYSOFT.SEHomework.Operator.OperatorFactory;

public class SEHomework
{
	static List<Pair<String, String>> functions = new ArrayList<>();
	static OperatorFactory factory;
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args)
	{
		try
		{
			functions = getFunctions();
			factory = new OperatorFactory(functions);
		}
		catch (PropertiesNotMatchingException|ClassNotFoundException e)
		{
			functions.clear();
			e.printStackTrace();
		}

		while (true)
		{
			printInfo();
			printFunction();
			System.out.println();

			try
			{
				String input = getUserInput("");
				int mode = Integer.parseInt(input);

				if (mode >= 1 && mode <= functions.size())
				{
					String operand1 = getUserInput(" x: ");
					String operand2 = getUserInput(" y: ");

					Operator operator = factory.create(functions.get(mode - 1).getLeft());
					System.out.println("> Result: " + operator.operate(operand1, operand2));
					System.out.println();
				}
				else if (mode == functions.size() + 1)
				{
					return;
				}
			}
			catch (NumberFormatException e)
			{
				e.printStackTrace();
				continue;
			}
		}
	}

	public static List<Pair<String, String>> getFunctions() throws PropertiesNotMatchingException
	{
		List<Pair<String, String>> functions = new ArrayList<>();

		try
		{
			Properties prop = new Properties();
			prop.load(new FileInputStream("operator.properties"));

			String operatorName = prop.getProperty("operatorName", "");
			String className = prop.getProperty("className", "");

			String[] operatorNames = operatorName.length() > 0 ? operatorName.split(",") : new String[0];
			String[] classNames = className.length() > 0 ? className.split(",") : new String[0];

			if (operatorNames.length != classNames.length)
			{
				throw new PropertiesNotMatchingException(String.format("Count of names: %d, Count of classes: %d", operatorNames.length, classNames.length));
			}

			for (int idx = 0; idx < operatorNames.length; idx++)
			{
				functions.add(Pair.of(operatorNames[idx], classNames[idx]));
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			try
			{
				Properties prop = new Properties();
				prop.setProperty("operatorName", "");
				prop.setProperty("className", "");
				prop.store(new FileOutputStream("operator.properties"), "");
			}
			catch (IOException e2)
			{
				e2.printStackTrace();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return functions;
	}

	static void printInfo()
	{
		System.out.println("[ ID: 1770661 ]");
		System.out.println("[ Name: Hyeonmin Park ]");
		System.out.println();
	}

	static void printFunction()
	{
		for (int idx = 0; idx < functions.size(); idx++)
		{
			System.out.println(String.format("%d. %s two numbers", idx + 1, functions.get(idx).getLeft()));
		}
		System.out.println(String.format("%d. Quit", functions.size() + 1));
	}

	static String getUserInput(String info)
	{
		System.out.print(">" + info);
		return in.nextLine();
	}
}