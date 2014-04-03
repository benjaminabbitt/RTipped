package name.benjaminAbbitt.rTipped.exceptions

class BadMatcherException extends RuntimeException{
    private final String pattern
    private final String body

    BadMatcherException(String body, String pattern) {
        this.body = body
        this.pattern = pattern
    }
}
