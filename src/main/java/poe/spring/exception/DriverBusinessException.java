package poe.spring.exception;

public class DriverBusinessException extends Exception
{
	private static final long serialVersionUID = 1L;

	private final String text;

	public DriverBusinessException(String text)
	{
		this.text = text;
	}

	public String getText()
	{
		return this.text;
	}
}
