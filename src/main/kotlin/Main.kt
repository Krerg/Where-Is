import search.SearchEngine
import validator.error.Errors
import validator.impl.ArgumentsValidator

fun main(args: Array<String>) {

    val errors = ArgumentsValidator().validate(args, Errors());

    if(!errors.isEmpty()) {
        errors.print()
        return;
    }

    SearchEngine().search(args[0], null)

}


