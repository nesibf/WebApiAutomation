package starter;

public enum WebServiceEndPoints {

    USERS("https://api.github.com/users"),
    EVENTS("https://api.github.com/events"),
    FEEDS("https://api.github.com/feeds");

    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
