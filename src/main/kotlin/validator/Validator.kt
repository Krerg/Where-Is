package validator

import validator.error.Errors

interface Validator<T> {

    fun validate(value: T, errors: Errors): Errors;

}
