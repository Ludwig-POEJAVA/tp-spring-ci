package poe.spring.delegate;

public class LoginCreationDelegateService
{
	protected final static int	MIN_LENGTH	= 4;
	protected final static int	MAX_LENGTH	= 10;

	//courtesy of https://github.com/ubernostrum/django-registration/blob/1d7d0f01a24b916977016c1d66823a5e4a33f2a0/registration/validators.py#L25
	protected final static String[] FORBIDDEN_WORDS = {"ToTo", "autoconfig", "autodiscover", "broadcasthost", "isatap",
			"localdomain", "localhost", "wpad", "ftp", "imap", "mail", "news", "pop", "pop3", "smtp", "usenet", "uucp",
			"webmail", "www", "admin", "administrator", "hostmaster", "info", "is", "it", "mis", "postmaster", "root",
			"ssladmin", "ssladministrator", "sslwebmaster", "sysadmin", "webmaster", "abuse", "marketing", "noc",
			"sales", "security", "support", "mailer-daemon", "nobody", "noreply", "no-reply", "clientaccesspolicy.xml",
			"crossdomain.xml", "favicon.ico", "humans.txt", "keybase.txt", "robots.txt", ".htaccess", ".htpasswd",
			"account", "accounts", "blog", "buy", "clients", "contact", "contactus", "contact-us", "copyright",
			"dashboard", "doc", "docs", "download", "downloads", "enquiry", "faq", "help", "inquiry", "license",
			"login", "logout", "me", "myaccount", "payments", "plans", "portfolio", "preferences", "pricing", "privacy",
			"profile", "register", "secure", "settings", "signin", "signup", "ssl", "status", "subscribe", "terms",
			"tos", "user", "users", "weblog", "work" };

	public static boolean checkLogInLengthIsValid(String login)
	{
		return (login.length() >= LoginCreationDelegateService.MIN_LENGTH) && (login
				.length() <= LoginCreationDelegateService.MAX_LENGTH);
	}

	public static boolean checkLoginContainsForbiddenWords(String login)
	{
		boolean result = false;;
		for (String forbiddenWord: LoginCreationDelegateService.FORBIDDEN_WORDS)
		{
			if (login.toLowerCase().equals(forbiddenWord.toLowerCase()))
			{
				result = true;
			}
		}
		return result;
	}
}
