package fi.rinkkasatiainen.demo.screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class RepositoryList {

    public static Target ITEMS = Target.the("List of repositories").locatedBy(".js-repo-list li a");
}
