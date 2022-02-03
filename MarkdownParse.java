//mine

// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
<<<<<<< HEAD
            System.out.println("first "+ currentIndex);
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);

            if(openParen !=-1 && closeParen !=1){
                String substring = markdown.substring(openParen, closeParen);
                if(!substring.contains(" ")){
                 if(nextOpenBracket !=0 && markdown.charAt(nextOpenBracket-1)!= '!'){
                    toReturn.add(markdown.substring(openParen+1, closeParen));
                    } 
                }
            }

            if(closeParen==-1){
                break;
            }
            currentIndex = closeParen + 1;
            System.out.println("second "+ currentIndex);
=======
            int nextOpenBracket = markdown.indexOf("[", currentIndex),
                nextCloseBracket = markdown.indexOf("]", nextOpenBracket),
                openParen = markdown.indexOf("(", nextCloseBracket),
                closeParen = markdown.indexOf(")", openParen);

            if(nextOpenBracket > 0 &&
               markdown.charAt(nextOpenBracket-1) == '!'){
                // Image, skip
                currentIndex = nextCloseBracket + 1;
            } else if(nextOpenBracket >= 0 &&
                      nextCloseBracket >= 0 &&
                      nextCloseBracket > nextOpenBracket+1 &&
                      openParen == nextCloseBracket+1 &&
                      closeParen >= 0
            ){
                // Valid link, add to list
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            } else {
                // Invalid link, advance one character
                currentIndex += 1;
            }
>>>>>>> b5e97fcd6f3c9f52f177db859bad64012e104d47
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}