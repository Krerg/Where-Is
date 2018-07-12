package search

import org.jetbrains.annotations.Nullable
import validator.error.Errors
import validator.impl.ResultsValidator
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class SearchEngine {

    private val resultsValidator = ResultsValidator();

    fun search(searchParameter: String, @Nullable searchDirectory: Path?) {
        val startDirectory = if (searchDirectory != null) searchDirectory else Paths.get("");
        val results = mutableListOf<String>()
        recursiveSearch(searchParameter, startDirectory, results)
        val errors = resultsValidator.validate(results, Errors());
        if(!errors.isEmpty()) {
            errors.print()
        } else {
            handleResults(results)
        }
    }

    private fun recursiveSearch(searchParameter: String, directory: Path, results: MutableList<String>) {
        Files.walk(directory).forEach {
            if(searchParameter.equals(it.fileName.toString())) {
                results.add(it.toAbsolutePath().toString())
            }

        }
    }

}