package EpicorTest

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.net.abc

fun main() {
    val startTime = System.currentTimeMillis()
    val filePath = "https://courses.cs.washington.edu/courses/cse390c/22sp/lectures/moby.txt"
    val allFileContent = getFileContent(filePath)
    // split the words at space(s) and non characters
    val allWords = allFileContent.split(Regex("\\s+|\\W+"))
    //map to store word along with its count
    val wordsWithCountsAfterExclusion = mutableMapOf<String, Int>()
    allWords.forEach { word ->
        val lowerCaseWord = word.lowercase()
        //push the word to the map, if it is not part of exclusion list and none of its characters are digits
        if (!exclusionList.contains(lowerCaseWord) && !lowerCaseWord.any { it.isDigit() }) {
            // to consider singular and plural as same word
            val prefixRemovedWord = if (lowerCaseWord.endsWith("s")) {
                lowerCaseWord.substring(0, lowerCaseWord.length - 1)
            } else {
                lowerCaseWord
            }
            if (prefixRemovedWord.length > 1) {
                wordsWithCountsAfterExclusion[prefixRemovedWord] =
                    wordsWithCountsAfterExclusion.getOrDefault(prefixRemovedWord, 0) + 1
            }
        }
    }
    println("Total word count after exclusions = ${wordsWithCountsAfterExclusion.size}")
    println("Top 5 most frequent words:")
    wordsWithCountsAfterExclusion.getTop5Words()
    println("Top 50 alphabetically sorted unique words:")
    wordsWithCountsAfterExclusion.getAlphabeticallySorted50UniqueWords()
    val endTime = System.currentTimeMillis()
    println("time taken for execution = ${(endTime - startTime)/1000} s")
}

fun MutableMap<String, Int>.getTop5Words() {
    val top5Words = this.entries
        .sortedByDescending { it.value } //sort with count of words
        .take(5)

    top5Words.forEach {
        println("${it.key}: ${it.value}")
    }
}

fun MutableMap<String, Int>.getAlphabeticallySorted50UniqueWords() {
    //filter unique words i.e., word_count(value) is 1 and sort the words(keys) alphabetically
    val sortedUniqueWords = this.filter { it.value == 1 }.keys.sorted()
    val top50SortedUniqueWords = sortedUniqueWords.take(50)
    top50SortedUniqueWords.forEach {
        println(it)
    }
}

fun getFileContent(filePath: String): String {
    // Open a URL connection and read the content
    val urlObject = URL(filePath)
    val connection = urlObject.openConnection()

    // Read the content from the input stream
    return BufferedReader(InputStreamReader(connection.getInputStream())).use { reader ->
        reader.readText()  // Read entire content as a single string
    }
}
