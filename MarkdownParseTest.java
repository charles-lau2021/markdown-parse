import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinksTestFile() throws IOException{
        Path fileName= Path.of("test-file.md");
        String contents=Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));

    }
    @Test
    public void testGetLinksNewFile() throws IOException{
        Path fileName= Path.of("new-file.md");
        String contents=Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));

    }
    @Test
    public void testGetLinksEmptyFile() throws IOException{
        Path fileName= Path.of("empty-file.md");
        String contents=Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));

    }
    @Test
    public void testGetLinksBracketFile() throws IOException{
        Path fileName= Path.of("bracket-file.md");
        String contents=Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));

    }
}

