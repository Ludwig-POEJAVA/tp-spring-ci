package poe.spring.delegate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneNumberFormaterDelegateServiceTests
{
	@Test
	public void checkFormatOK5645646874()
	{
		String phone = "0600000000";
		String formated = PhoneNumberFormaterDelegateService.format(phone);
		assertThat(formated).isEqualTo(phone);
	}

	@Test
	public void checkFormat33()
	{
		String phone = "+33600000000";
		String formated = PhoneNumberFormaterDelegateService.format(phone);
		assertThat(formated).isEqualTo("0600000000");
	}
}
