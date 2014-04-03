package name.benjaminAbbitt.akkaSupport

import groovy.transform.Immutable

@Immutable
class AkkaProxiedMethodCallVoid{
    private final String methodName
    final List<Object> arguments

    public getMethodName(){
        '$' + methodName
    }


}
