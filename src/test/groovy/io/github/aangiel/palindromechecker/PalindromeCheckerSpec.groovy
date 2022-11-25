package io.github.aangiel.palindromechecker

import spock.lang.Specification

import java.util.concurrent.Executors

class PalindromeCheckerSpec extends Specification {

    def "testPalindrome"() {
        expect:
        result == Executors.newFixedThreadPool(1)
                .submit(new PalindromeChecker(palindrome))
                .get()

        where:
        palindrome                  | result
        "kajak"                     | true
        "makak"                     | false
        "Mr. Owl ate my metal worm" | true
        "Mr. Owl ate my metal wor"  | false
        101                         | true
        102                         | false
    }

    def "testPalindromeList"() {
        given:
        def palindromeCallables = palindromeList.collect { new PalindromeChecker(it) }

        expect:
        result == Executors.newFixedThreadPool(palindromeList.size())
                .invokeAll(palindromeCallables)
                .collect { it.get() }

        where:
        palindromeList                | result
        ["kajak", "makak", "owwwo"]   | [true, false, true]
        ["Mr. Owl ate my metal worm",
         "Mr. Owl ate my metal wor"]  | [true, false]
        [101, 102]                    | [true, false]
        ["kajak", "makak", "owwwo",
         "Mr. Owl ate my metal worm",
         "Mr. Owl ate my metal wor",
         101, 102]                    | [true, false, true, true, false, true, false]

    }
}
