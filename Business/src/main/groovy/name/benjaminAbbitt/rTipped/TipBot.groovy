package name.benjaminAbbitt.rTipped

import groovy.transform.Immutable
import name.benjaminAbbitt.rTipped.exceptions.BadMatcherException
import org.joda.money.Money

@Immutable
class TipBot {
    String pattern, userName

    public Tip extractTip(String body){
        def matcher = (body =~ pattern)
        def count = matcher.groupCount()

        if(matcher.matches()){
            return new Tip(origin: matcher.group("originator"), destination: matcher.group("receiver"), tip: Money.parse("USD " + matcher.group("money")))
        }else{
            throw new BadMatcherException(body, pattern)
        }


    }
}
