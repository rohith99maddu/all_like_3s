package EpicorTest

val prepositions = setOf(
    "in",
    "on",
    "at",
    "by",
    "for",
    "with",
    "about",
    "as",
    "to",
    "of",
    "from",
    "before",
    "after",
    "during",
    "between",
    "under",
    "over",
    "through",
    "above",
    "below",
    "up",
    "down",
    "across",
    "along",
    "around",
    "among"
)
val pronouns = setOf(
    "his",
    "he",
    "she",
    "it",
    "they",
    "we",
    "i",
    "you",
    "him",
    "her",
    "them",
    "us",
    "me",
    "mine",
    "yours",
    "ours",
    "theirs",
    "there",
    "that",
    "this"
)
val conjunctions = setOf("and", "or", "but", "nor", "not", "so", "yet", "for", "either", "neither", "whether")
val articles = setOf("the", "a", "an")
val modalVerbs = setOf("is", "was", "am", "are", "were", "be", "been", "being", "had", "has", "have")

val exclusionList = (prepositions + pronouns + conjunctions + articles + modalVerbs)