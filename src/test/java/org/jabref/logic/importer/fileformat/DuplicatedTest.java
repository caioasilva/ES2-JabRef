package org.jabref.logic.importer.fileformat;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jabref.JabRefMain;
import org.jabref.gui.AWTExceptionHandler;
import org.jabref.gui.JabRefFrame;
import org.jabref.gui.importer.ImportInspectionDialog;
import org.junit.jupiter.api.Test;

class DuplicatedTest {

    

    @Test
    public void testDuplicateEntries() throws IOException {
        FrameFixture mainFrame = findFrame(JabRefFrame.class).withTimeout(10_000).using(robot());
        String path = getTestFilePath("net/sf/jabref/es2test/es2bib.bib");
        importBibIntoNewDatabase(mainFrame, path);
        importBibIntoCurrentDatabase(mainFrame, path);

        DialogFixture importInspectionDialog = findDialog(ImportInspectionDialog.class).withTimeout(10_000)
                .using(robot());
        takeScreenshot(importInspectionDialog, "ImportInspectionDialog1");

        importInspectionDialog.button(new GenericTypeMatcher<JButton>(JButton.class) {

                    @Override
                    protected boolean isMatching(@Nonnull JButton jButton) {
                        return "OK".equals(jButton.getText());
                    }
                }).click();
        robot().settings().delayBetweenEvents(100);
        takeScreenshot(importInspectionDialog, "ImportInspectionDialog2");
        importInspectionDialog.button(new GenericTypeMatcher<JButton>(JButton.class) {

                    @Override
                    protected boolean isMatching(@Nonnull JButton jButton) {
                        return "No".equals(jButton.getText());
                    }
                }).click();

        takeScreenshot(mainFrame, "MainFrame");

        exitJabRef(mainFrame);
    }

    private void takeScreenshot(AbstractWindowFixture<?, ?, ?> dialog, String filename) throws IOException {
        ScreenshotTaker screenshotTaker = new ScreenshotTaker();
        String path = getTestFilePath("net/sf/jabref/es2test/es2bib.bib");
        Path folder = Paths.get(path.substring(0, path.length() - 10));
        // Create build/srceenshots folder if not present
        if (!Files.exists(folder)) {
            Files.createDirectory(folder);
        }
        Path file = folder.resolve(filename + ".png").toAbsolutePath();
        // Delete already present file
        if (Files.exists(file)) {
            Files.delete(file);
        }
        screenshotTaker.saveComponentAsPng(dialog.target(), file.toString());
    }
}