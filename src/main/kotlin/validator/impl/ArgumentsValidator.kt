package validator.impl

import validator.Validator
import validator.error.Errors

class ArgumentsValidator: Validator<Array<String>> {

    override fun validate(value: Array<String>, errors: Errors): Errors {

        if(value.isEmpty()) {
            errors.addError(validator.error.Error("There is no search parameter. Please specify it as first argument"))
        }

        if(value.size > 1) {
            errors.addError(validator.error.Error("There is more than 1 search parameter. Please specify one parameter"))
        }

        return errors;
    }

}
