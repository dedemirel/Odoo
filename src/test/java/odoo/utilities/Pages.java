package odoo.utilities;

import odoo.pages.BasePage;
import odoo.pages.CreatePage;
import odoo.pages.LoginPage;

public class Pages {
   /* I create the objects on pages class under utils
     so we don't need to create so much objets on all step definition pages. We can add
     our page objects under the pages class and call them by creating only one objects in
     this page def. classes*/

    public LoginPage loginPage=new LoginPage();
    public CreatePage crt=new CreatePage();

}
