import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class EvilExecutor {
  private String separator = File.separator;
  
  private static void printLines (String cmd, InputStream ins) throws Exception {
    String line;
    BufferedReader in = new BufferedReader(new InputStreamReader(ins));
    while ((line = in.readLine()) != null) {
      System.out.println(cmd + " " + line);
    }
  }
  
  private static void runProcess (String command) throws Exception {
    Process pro = Runtime.getRuntime().exec(command);
    printLines(command + " stdout:", pro.getInputStream());
    printLines(command + " stderr:", pro.getErrorStream());
    pro.waitFor();
    System.out.println(command + " exitValue() " + pro.exitValue());
  }
  
  public static void main (String... args) throws Exception {
    String separator = File.separator;
    String path = System.getProperty("user.dir") + separator + "JavaNet" + separator + "src" + separator + "harmless.txt";
    new EvilExecutor().doEvil(path);
  }
  
  private String readCode (String sourcePath) throws FileNotFoundException {
    InputStream stream = new FileInputStream(sourcePath);
    String separator = System.getProperty("line.separator");
    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
    return reader.lines().collect(Collectors.joining(separator));
  }
  
  private Path saveSource (String source) throws IOException {
    
    String tmpProperty = System.getProperty("user.dir") + separator + "JavaNet" + separator + "src";
    Path sourcePath = Paths.get(tmpProperty, "Harmless.java");
    Files.write(sourcePath, source.getBytes(UTF_8));
    return sourcePath;
  }
  
  private Path compileSource (Path javaFile) {
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    compiler.run(null, null, null, javaFile.toFile().getAbsolutePath());
    return javaFile.getParent().resolve("Harmless.class");
  }
  
  private void runClass (Path javaClass)
          throws Exception {
    URL classUrl = javaClass.getParent().toFile().toURI().toURL();
    URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{classUrl});
    Class<?> clazz = Class.forName("Harmless", true, classLoader);
    runProcess("cmd /K start cmd.exe /K \"cd JavaNet\\src && java " + clazz.getSimpleName() + "\"");
    clazz.newInstance();
  }
  
  private void doEvil (String sourcePath) throws Exception {
    String source = readCode(sourcePath);
    Path javaFile = saveSource(source);
    Path classFile = compileSource(javaFile);
    runClass(classFile);
  }
}
