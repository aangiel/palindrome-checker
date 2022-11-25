package io.github.aangiel.palindromechecker;

import java.util.Objects;
import java.util.concurrent.Callable;

public final class PalindromeChecker implements Callable<Boolean> {

    private final String palindrome;

    public PalindromeChecker(String palindrome) {
        Objects.requireNonNull(palindrome, "palindrome can't be null");
        this.palindrome = palindrome;
    }

    public PalindromeChecker(int palindrome) {
        this.palindrome = String.valueOf(palindrome);
    }

    private boolean check(String palindrome) {

        // https://en.wikipedia.org/wiki/Palindrome
        // Types -> Sentences and phrases says:
        // "Punctuation, capitalization, and spaces are usually ignored."

        palindrome = palindrome.replaceAll("[^a-zA-Z0-9]", "");
        String reversed = new StringBuilder(palindrome).reverse().toString();
        return palindrome.equalsIgnoreCase(reversed);
    }

    @Override
    public Boolean call() throws Exception {
        return check(this.palindrome);
    }
}
