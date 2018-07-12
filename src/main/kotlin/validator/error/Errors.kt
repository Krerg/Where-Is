package validator.error

class Errors {

    private val errorList = mutableListOf<Error>();

    fun print() {
        errorList.forEach{
            it.printError()
        }
    }

    fun addError(error: Error) {
        errorList.add(error)
    }

    fun isEmpty(): Boolean {
        return errorList.isEmpty();
    }

}