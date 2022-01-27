import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks_testFile() throws IOException {
        String test_file = Files.readString(Path.of("test-file.md"));
        assertEquals(
            "getLinks() should get all links in a valid file",
            List.of("https://something.com", "some-page.html"),
            MarkdownParse.getLinks(test_file)
        );
    }
}