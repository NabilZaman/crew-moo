package com.crewmoo;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DialogueTransformer {

    private static final Pattern WORD_PATTERN = Pattern.compile("\\S+");

    public enum FallbackBehavior {
        ORIGINAL,
        MOO_ALL,
        LONG_MOO;
    }

    private Map<String, String> transformations;
    private Supplier<FallbackBehavior> fallbackBehaviorSupplier;

    public DialogueTransformer() {
        this(FallbackBehavior.ORIGINAL);
    }

    public DialogueTransformer(FallbackBehavior fallbackBehavior) {
        this(() -> fallbackBehavior);
    }

    public DialogueTransformer(Supplier<FallbackBehavior> fallbackBehaviorSupplier) {
        this.fallbackBehaviorSupplier = fallbackBehaviorSupplier;
        this.transformations = new HashMap<>();
    }

    public void registerTransformation(String orig, String replacement) {
        transformations.put(orig, replacement);
    }

    public String transform(String original) {
        return transformations.getOrDefault(original, fallback(original));
    }

    private String fallback(String original) {
        switch (fallbackBehaviorSupplier.get()) {
            case MOO_ALL:
                return mooAllTransform(original);
            case LONG_MOO:
                return longMooTransform(original);
            default:
                return original;
        }
    }

    private String mooAllTransform(String original) {
        return WORD_PATTERN.matcher(original).replaceAll(m -> toMooWord(m.group()));
    }

    private static String toMooWord(String token) {
        // Single pass: count alphanumeric chars and detect casing
        int letterCount = 0;
        boolean hasLower = false, hasUpper = false;
        char firstLetter = 0;
        for (int i = 0; i < token.length(); i++) {
            char c = token.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                if (letterCount == 0)
                    firstLetter = c;
                letterCount++;
                if (Character.isLowerCase(c))
                    hasLower = true;
                if (Character.isUpperCase(c))
                    hasUpper = true;
            }
        }
        if (letterCount == 0)
            return token;

        boolean allUpper = hasUpper && !hasLower;
        char m = allUpper || Character.isUpperCase(firstLetter) ? 'M' : 'm';
        char o = allUpper ? 'O' : 'o';
        int mooLen = Math.max(letterCount, 3);

        // Replace alphanumeric chars in-place with moo, keep punctuation
        StringBuilder result = new StringBuilder(token.length() + Math.max(0, 3 - letterCount));
        int mooIdx = 0;
        for (int i = 0; i < token.length(); i++) {
            if (Character.isLetterOrDigit(token.charAt(i)) && mooIdx < mooLen) {
                result.append(mooIdx == 0 ? m : o);
                mooIdx++;
            } else {
                result.append(token.charAt(i));
            }
        }
        // Pad if original word had fewer than 3 alphanumeric chars
        while (mooIdx < mooLen) {
            result.append(o);
            mooIdx++;
        }
        return result.toString();
    }

    private String longMooTransform(String original) {
        // Replace the full string with a single "Moo" of the same length as the
        // original, padding with 'o' as needed.
        StringBuilder moo = new StringBuilder("M");
        for (int i = 1; i < original.length(); i++) {
            moo.append('o');
        }
        if (moo.length() > 0) {
            moo.append('!');
        }
        return moo.toString();
    }
}
