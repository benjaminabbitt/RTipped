package name.benjaminAbbitt.rTipped

import org.joda.money.Money
import org.junit.Test

import static junit.framework.Assert.assertEquals

class TipBotTest {
    @Test
    public void extractTipShouldExtractValidTip(){
        def pattern = /.*Verified\*\*\:.*\[(?<originator>\w+).*(?<money>\d+.\d+)\s+USD.*\[(?<receiver>\w+)\].*/

        def tipBot = new TipBot(pattern: pattern, userName: "changeTip")

        Tip actual = tipBot.extractTip("[[\\u2714](https://blockchain.info/tx/b59002899fe5f82c6ae693c05b69b3de8b34e44cbaa2df240a092f3667843a5c)] **Verified**: [yak_kharka](http://reddit.com/u/yak_kharka) &amp;#8594; **&amp;#36;0.75 USD** *(m&amp;#3647; 1.29731 millibitcoins)* &amp;#8594; [prashant_sh](http://reddit.com/u/prashant_sh) [[**sign up!**](http://www.reddit.com/message/compose?to=bitcointip&amp;subject=Sign%20Up&amp;message=SIGN%20UP)] [[**what is this?**](http://www.reddit.com/r/bitcointip/comments/13iykn/bitcointip_documentation/)]")


        Tip expected = new Tip(origin: "yak_kharka", destination: "prashant_sh", tip: Money.parse("USD 0.75"))

        assertEquals expected, actual
    }

    @Test
    public void basicMatcherTest(){
        def matcher = 'John 19' =~ /(?<name>\w+) (?<age>\d+)/
        if( matcher.matches() ) {
            println "Matches"
            assert matcher.group( 'name' ) == 'John'
            assert matcher.group( 'age' ) == '19'
        }
        else {
            println "No Match"
        }
    }

}
