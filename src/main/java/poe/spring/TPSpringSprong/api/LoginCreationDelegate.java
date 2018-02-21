package poe.spring.TPSpringSprong.api;

public class LoginCreationDelegate
{
	private final int	minLength	= 4;
	private final int	maxLength	= 10;

	//courtesy of https://github.com/ubernostrum/django-registration/blob/1d7d0f01a24b916977016c1d66823a5e4a33f2a0/registration/validators.py#L25
	private String[] forbiddenWords = {"ToTo", "autoconfig", "autodiscover", "broadcasthost", "isatap",
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

	public boolean checkLoginLength(String login)
	{
		return (login.length() >= this.minLength) && (login.length() <= this.maxLength);
	}

	public boolean checkLoginWords(String login)
	{
		for (String forbiddenWord: this.forbiddenWords)
		{
			if (login.toLowerCase().equals(forbiddenWord.toLowerCase()))
				return true;
		}
		return false;
	}
}
