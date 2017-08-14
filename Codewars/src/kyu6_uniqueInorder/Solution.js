/**
 * Created by Larvinion on 2017-08-14.
 */

var uniqueInOrder=function(iterable) {
    var solution = [];

    if(iterable.length == 0) {
        return solution;
    } else if(typeof iterable == "string"){
        solution.push(iterable.charAt(0));

        for (var i = 0; i < iterable.length - 1; i++) {
            if (iterable.charAt(i) != iterable.charAt(i + 1))
                solution.push(iterable.charAt(i + 1));
        }
    } else if(typeof iterable == "object"){
        solution.push(iterable[0]);

        for (var i = 0; i < iterable.length - 1; i++) {
            if (iterable[i] != iterable[i + 1])
                solution.push(iterable[i + 1]);
        }
    }
    return solution;
}