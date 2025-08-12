package utilities;

public class DeepLinks {

    private static final String completeCheckout = "swaglabs://complete";
    private static final String itemDetail = "swaglabs://swag-item/%d";
    private static final String webView = "swaglabs://webview";
    private static final String yourCart = "swaglabs://cart/%s";
    private static final String shopping = "swaglabs://swag-overview/%s";
    private static final String drawing = "swaglabs://drawing";


    private static void goTo(String deepLink) {
        new DriverProvider().get().get(deepLink);
    }

    public static void goToCompleteCheckout() {
        goTo(completeCheckout);
    }

    public static void goToItemDetail(int index) {
        final var deepLink = String.format(itemDetail, index);
        goTo(deepLink);
    }

    public static void goToYourCart(String list) {
        final var deepLink = String.format(yourCart, list);
        goTo(deepLink);
    }

    public static void goToWebView() {
        goTo(webView);
    }

    public static void goToShopping(String list) {
        final var deepLink = String.format(shopping, list);
        goTo(deepLink);
    }

    public static void goToDrawing() {
        goTo(drawing);
    }

}
