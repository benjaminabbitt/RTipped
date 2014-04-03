package name.benjaminAbbitt.akkaSupport

import groovy.transform.Immutable

@Immutable
class AkkaProxiedMethodCall{
    private final String methodName
    final List<Object> arguments

    public getMethodName(){
        '$' + methodName
    }

}
