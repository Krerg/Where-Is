package validator.impl

import validator.Validator
import validator.error.Errors

class ResultsValidator: Validator<MutableList<String>> {

    override fun validate(value: MutableList<String>, errors: Errors): Errors {

        if(value.isEmpty()) {
            errors.addError(validator.error.Error("There is no files matches your parameter"))
        }

        return errors;
    }

}