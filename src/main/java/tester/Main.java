package tester;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import tester.grammar.Java8Lexer;
import tester.grammar.Java8LexerNO;
import tester.grammar.Java8Parser;
import tester.grammar.Java8ParserBaseListener;
import tester.grammar.Java8ParserNO;
import tester.grammar.Java8ParserNOBaseListener;
import tester.grammar.Java9Lexer;
import tester.grammar.Java9Parser;
import tester.grammar.Java9ParserBaseListener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

@SuppressWarnings({"UseOfSystemOutOrSystemErr", "CallToPrintStackTrace"})
public final class Main {

    private static final AtomicLong FILE_SUCCESS_COUNTER = new AtomicLong();
    private static final AtomicLong FILE_FAIL_COUNTER = new AtomicLong();

    private Main() {
    }

    public static void main(String... args) {
        String dirName = args[0];
        /*
        setupAndRunJava8Grammar(dirName);
        for (int i = 0; i < 100; i ++) {
            System.out.print("*");
        }
        System.out.println();
        setupAndRunJava9Grammar(dirName);
         */
        for (int i = 0; i < 100; i++) {
            System.out.print("*");
        }
        System.out.println();

        setupAndRunJava8NOGrammar(dirName);
    }

    private static void setupAndRunJava8Grammar(String dirName) {
        final long startTime = System.currentTimeMillis();
        System.out.println("Recursively parsing: " + new File(dirName).getAbsolutePath());

        try (Stream<Path> paths = Files.walk(Paths.get(dirName))) {
            paths.map(Path::toString)
                    .filter(Main::isJavaFile)
                    .forEach(Main::parseWithJava8Grammar);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final long endTime = System.currentTimeMillis();
        System.out.println("Total Java 8 grammar execution time: " + (endTime - startTime) + " ms");
        System.out.println("Number of successfully parsed files: " + FILE_SUCCESS_COUNTER.get());
        System.out.println("Number of files failed to parse: " + FILE_FAIL_COUNTER.get());

        // Clear counter
        FILE_SUCCESS_COUNTER.getAndSet(0);
        FILE_FAIL_COUNTER.getAndSet(0);
    }

    private static void setupAndRunJava8NOGrammar(String dirName) {
        final long startTime = System.currentTimeMillis();
        System.out.println("Recursively parsing: " + new File(dirName).getAbsolutePath());

        try (Stream<Path> paths = Files.walk(Paths.get(dirName))) {
            paths.map(Path::toString)
                    .filter(Main::isJavaFile)
                    .forEach(Main::parseWithJava8NOGrammar);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final long endTime = System.currentTimeMillis();
        System.out.println("Total Java 8 NO grammar execution time: " + (endTime - startTime) + " ms");
        System.out.println("Number of successfully parsed files: " + FILE_SUCCESS_COUNTER.get());
        System.out.println("Number of files failed to parse: " + FILE_FAIL_COUNTER.get());

        // Clear counter
        FILE_SUCCESS_COUNTER.getAndSet(0);
        FILE_FAIL_COUNTER.getAndSet(0);
    }

    private static void setupAndRunJava9Grammar(String dirName) {
        final long startTime = System.currentTimeMillis();
        System.out.println("Recursively parsing: " + new File(dirName).getAbsolutePath());

        try (Stream<Path> paths = Files.walk(Paths.get(dirName))) {
            paths.map(Path::toString)
                    .filter(Main::isJavaFile)
                    .forEach(Main::parseWithJava9Grammar);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final long endTime = System.currentTimeMillis();
        System.out.println("Total Java 9 grammar execution time: " + (endTime - startTime) + " ms");
        System.out.println("Number of successfully parsed files: " + FILE_SUCCESS_COUNTER.get());
        System.out.println("Number of files failed to parse: " + FILE_FAIL_COUNTER.get());

        // Clear counter
        FILE_SUCCESS_COUNTER.getAndSet(0);
        FILE_FAIL_COUNTER.getAndSet(0);
    }

    private static boolean isJavaFile(String filename) {
        return filename.endsWith(".java");
    }

    private static void parseWithJava8Grammar(String filename) {
        try {
            CharStream codePointCharStream =
                    CharStreams.fromFileName(filename);
            //System.out.printf("Java 8 grammar: Parsing %s\n", filename);

            // Setup lexer with custom error handling
            final Java8Lexer lexer = new Java8Lexer(codePointCharStream);
            lexer.removeErrorListeners();
            lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

            final CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Setup parser with custom error handling
            final Java8Parser parser = new Java8Parser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(ThrowingErrorListener.INSTANCE);

            final ParseTree tree = parser.compilationUnit();

            final ParseTreeWalker walker = new ParseTreeWalker();

            walker.walk(new Java8ParserBaseListener(), tree);
            FILE_SUCCESS_COUNTER.getAndIncrement();

            // Print LISP-style tree
            //System.out.println(tree.toStringTree(parser));
        } catch (IOException | ParseCancellationException e) {
            // TODO Auto-generated catch block
            FILE_FAIL_COUNTER.getAndIncrement();
            System.out.print(filename + ": ");
            System.out.println(e.getMessage());
        }
    }

    private static void parseWithJava9Grammar(String filename) {
        try {
            CharStream codePointCharStream =
                    CharStreams.fromFileName(filename);
            //System.out.printf("Java 9 grammar: Parsing %s\n", filename);

            // Set up lexer with custom error handling
            final Java9Lexer lexer = new Java9Lexer(codePointCharStream);
            lexer.removeErrorListeners();
            lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

            final CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Set up parser with custom error handling
            final Java9Parser parser = new Java9Parser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(ThrowingErrorListener.INSTANCE);

            final ParseTree tree = parser.compilationUnit();

            final ParseTreeWalker walker = new ParseTreeWalker();

            walker.walk(new Java9ParserBaseListener(), tree);
            FILE_SUCCESS_COUNTER.getAndIncrement();

            // Print LISP-style tree
            //System.out.println(tree.toStringTree(parser));
        } catch (IOException | ParseCancellationException e) {
            // TODO Auto-generated catch block
            FILE_FAIL_COUNTER.getAndIncrement();
            System.out.print(filename + ": ");
            System.out.println(e.getMessage());
        }
    }

    private static void parseWithJava8NOGrammar(String filename) {
        try {
            CharStream codePointCharStream =
                    CharStreams.fromFileName(filename);
            //System.out.printf("Java 8 grammar: Parsing %s\n", filename);

            // Setup lexer with custom error handling
            final Java8LexerNO lexer = new Java8LexerNO(codePointCharStream);
            lexer.removeErrorListeners();
            lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

            final CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Setup parser with custom error handling
            final Java8ParserNO parser = new Java8ParserNO(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(ThrowingErrorListener.INSTANCE);

            final ParseTree tree = parser.compilationUnit();

            final ParseTreeWalker walker = new ParseTreeWalker();

            walker.walk(new Java8ParserNOBaseListener(), tree);
            FILE_SUCCESS_COUNTER.getAndIncrement();

            // Print LISP-style tree
            //System.out.println(tree.toStringTree(parser));
        } catch (IOException | ParseCancellationException e) {
            // TODO Auto-generated catch block
            FILE_FAIL_COUNTER.getAndIncrement();
            System.out.print(filename + ": ");
            System.out.println(e.getMessage());
        }
    }
}
