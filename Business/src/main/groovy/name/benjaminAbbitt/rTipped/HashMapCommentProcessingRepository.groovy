package name.benjaminAbbitt.rTipped

import name.benjaminAbbitt.rTipped.reddit.commentProcessing.CommentProcessingRepository


class HashMapCommentProcessingRepository implements CommentProcessingRepository{
    HashMap<String, Boolean> processed = new HashMap<String, String>()

    public Boolean isProcessed(String userName, String id){
        return processed.get(userName.userName + id)

    }

    public void hasBeenProcessed(String userName, String id){
        processed.put(userName.userName + id, true)

    }

}
