package starter;

public enum WebServiceEndPoints {

    SERVICES("http://ec2-3-15-24-92.us-east-2.compute.amazonaws.com:3030/services"),
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
