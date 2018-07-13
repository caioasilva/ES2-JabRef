package org.jabref.logic.importer.fileformat;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.jabref.Globals;
import org.jabref.model.entry.BibEntry;
import org.jabref.preferences.JabRefPreferences;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.InputStream;



class CSVImporterTest {

	private CSVImporter importer;

    @Before
    public void setUp() {
        Globals.prefs = JabRefPreferences.getInstance();
        importer = new CSVImporter(null, null);
    }

    @Test
    public void testIsRecognizedFormat() throws IOException {
        try (InputStream stream = BibtexImporterTest.class.getResourceAsStream("CSVCasoTeste.csv")) {
            assertTrue(importer.isRecognizedFormat(stream));
        }
    }

    @Test
    public void testImportEntries() throws IOException {
        try (InputStream stream = CSVImporterTest.class.getResourceAsStream("CSVCasoTeste.csv")) {
            List<BibEntry> bibEntries = importer.importEntries(stream, new OutputPrinterToNull());

            assertEquals(5, bibEntries.size());

            for (BibEntry entry : bibEntries) {

                if (entry.getCiteKey().equals("a1t1k")) {
                    assertEquals("a1", entry.getField("AUTHOR"));
                    assertEquals("t1", entry.getField("TITLE"));
                    assertEquals("2001", entry.getField("YEAR"));
                    assertEquals("Pub1", entry.getField("PUBLISHER"));
                    assertEquals("S1", entry.getField("SERIES"));
                    assertEquals("Escrita", entry.getField("KEYWORDS"));
                    assertEquals("972-662-905-4", entry.getField("ISBN"));
                    assertEquals("note1", entry.getField("NOTE"));
                }
            }
        }
    }

    @Test
    public void testGetFormatName() {
        assertEquals("CSV", importer.getName());
    }


}
