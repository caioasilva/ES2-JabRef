package org.jabref.logic.integrity;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.jabref.logic.l10n.Localization;
import org.jabref.model.strings.StringUtil;

import java.util.Calendar;

public class YearChecker implements ValueChecker {

    private static final Predicate<String> CONTAINS_FOUR_DIGIT = Pattern.compile("([^0-9]|^)[0-9]{4}([^0-9]|$)")
            .asPredicate();
    private static final Predicate<String> ENDS_WITH_FOUR_DIGIT = Pattern.compile("[0-9]{4}$").asPredicate();
    private static final String PUNCTUATION_MARKS = "[(){},.;!?<>%&$]";

    /**
     * Checks, if the number String contains a four digit year and ends with it.
     * Official bibtex spec:
     * Generally it should consist of four numerals, such as 1984, although the standard styles
     * can handle any year whose last four nonpunctuation characters are numerals, such as ‘(about 1984)’.
     * Source: http://ftp.fernuni-hagen.de/ftp-dir/pub/mirrors/www.ctan.org/biblio/bibtex/base/btxdoc.pdf
     */
    @Override
    public Optional<String> checkValue(String value) {

        if (StringUtil.isBlank(value)) {
            return Optional.empty();
        }

        //check if is a year valid by Java Calendar
        Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        try {
            cal.set(Calendar.YEAR, Integer.parseInt(value));
            if (cal.get(Calendar.YEAR) != Integer.parseInt(value)){
                return Optional.of(Localization.lang("is not a valid year"));
            }

        } catch (Exception e) {
            return Optional.of(Localization.lang("is not a valid year"));
        }

        return Optional.empty();
    }
}
