package poe.spring.TPSpringSprong.api;

public class LoginCreationDelegate
{
	private final int	minLength	= 4;
	private final int	maxLength	= 10;

	private enum forbiddenWord
	{
		TOTO("toto"), TITI("titi"), LOGIN("login"), ADMIN("admin");
		private String word;

		forbiddenWord(String word)
		{
			this.word = word;
		}

		private String getWord()
		{
			return this.word;
		}

		public static boolean isForbidden(String word)
		{
			for (forbiddenWord fw: forbiddenWord.values())
			{
				if (word.toLowerCase().equals(fw.getWord().toLowerCase()))
					return true;
			}
			return false;
		}
	}

	public boolean checkLoginLength(String login)
	{
		return (login.length() >= this.minLength) && (login.length() <= this.maxLength);
	}

	public boolean checkLoginWords(String login)
	{
		return !forbiddenWord.isForbidden(login);
	}
}
