package fi.rinkkasatiainen.demo.screenplay.user_interface;


import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;

@DefaultUrl("https://github.com/")
@NamedUrls(
        {
                @NamedUrl(name = "actor.profile.page", url = "https://github.com/{1}")
        }
)
public class ApplicationHomePage extends PageObject {
}
