
package awesomecucumber.factory;

import awesomecucumber.pages.*;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    private static StorePage storePage;
    private static CartPage cartPage;
    private static CheckoutPage checkoutPage;
    private static ProductPage productPage;
	private static LoginPage loginPage;

	private static PlayerPage playerPage;

	public static StorePage getStorePage(WebDriver driver) {
		/**
		 * Using Ternary Operator: Checking for storePage as null.
		 * 
		 * If it is null, then, create new object and return
		 *
		 * If it is not null, then, return storePage
		 */
		return storePage == null ? new StorePage(driver) : storePage;
	}

	public static CartPage getCartPage(WebDriver driver) {
		return cartPage == null ? new CartPage(driver) : cartPage;
	}

	public static CheckoutPage getCheckoutPage(WebDriver driver) {
		return checkoutPage == null ? new CheckoutPage(driver) : checkoutPage;
	}

	public static ProductPage getProductPage(WebDriver driver) {
		return productPage == null ? new ProductPage(driver) : productPage;
	}

	public static LoginPage getLoginPage(WebDriver driver) {
		return loginPage == null ? new LoginPage(driver) : loginPage;
	}

	public static PlayerPage getPlayerPage(WebDriver driver) {
		return playerPage == null ? new PlayerPage(driver) : playerPage;
	}
}
