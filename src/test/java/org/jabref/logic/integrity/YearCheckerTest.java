package org.jabref.logic.bibtexkeypattern;

import java.util.Optional;

import org.jabref.logic.importer.ImportFormatPreferences;
import org.jabref.logic.importer.ParseException;
import org.jabref.logic.importer.fileformat.BibtexParser;
import org.jabref.logic.integrity.YearChecker;
import org.jabref.model.database.BibDatabase;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.FieldName;
import org.jabref.model.util.DummyFileUpdateMonitor;
import org.jabref.model.util.FileUpdateMonitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class YearCheckerTest {

    private static ImportFormatPreferences importFormatPreferences;
    private final FileUpdateMonitor fileMonitor = new DummyFileUpdateMonitor();

    @BeforeEach
    public void setUp() {
        importFormatPreferences = mock(ImportFormatPreferences.class, Answers.RETURNS_DEEP_STUBS);
    }

    @Test
    public void testInvalidYear() throws ParseException {
        Optional<BibEntry> entry0 = BibtexParser.singleFromString(
                "@Article{label,\n" +
                        "  author = {Ana Linda},\n" +
                        "  title  = {Maravilhoso Mundo de Ana Linda},\n" +
                        "  year   = {199tres},\n" +
                        "}", importFormatPreferences, fileMonitor);

        String year = BibtexKeyGenerator.getFieldValue(entry0.get(), FieldName.YEAR,',', new BibDatabase());
        YearChecker yearChecker = new YearChecker();
        assertEquals("Optional[is not a valid year]",
                yearChecker.checkValue(year).toString());
    }

}
