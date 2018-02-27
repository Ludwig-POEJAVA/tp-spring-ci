package poe.spring.delegate;

public class PhoneNumberFormaterDelegateService
{
	private PhoneNumberFormaterDelegateService()
	{
	}

	/**
	 * @param number
	 *            : un numéro qui ne réspecte pas de format précis
	 * @return string au format 06123456789
	 */
	public static String format(String number)
	{
		String formatedNumber = null;
		//gestion de +33
		formatedNumber = number.replaceAll("\\+33", "0");
		return formatedNumber;
	}
}
