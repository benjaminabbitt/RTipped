package name.benjaminAbbitt.rTipped

import groovy.transform.Immutable
import org.joda.money.Money


@Immutable(knownImmutableClasses = [Money])
final class Tip {
    String origin, destination
    Money tip
}
