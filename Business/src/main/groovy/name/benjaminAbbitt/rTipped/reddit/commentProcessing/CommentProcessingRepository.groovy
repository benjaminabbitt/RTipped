package name.benjaminAbbitt.rTipped.reddit.commentProcessing

public interface CommentProcessingRepository {
    public Boolean isProcessed(String userName, String id)

    public void hasBeenProcessed(String userName, String id)
}