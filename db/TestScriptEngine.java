package db;
 
 
import java.util.List;
import java.util.stream.Collectors;
 
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
 
public class TestScriptEngine {
 
    public static void main(String args[]) {
        
        
        ScriptEngineManager manager = new ScriptEngineManager();
        List<ScriptEngineFactory> engineFactories = manager.getEngineFactories();
 
        for (ScriptEngineFactory factory : engineFactories) {
            System.out.println("engine name: " + factory.getEngineName());
            System.out.println("engine version: " + factory.getEngineVersion());
 
            String extensions = factory.getExtensions().stream().collect(Collectors.joining(", "));
            System.out.println("extensions: " + extensions);
 
            System.out.println("language name: " + factory.getLanguageName());
            System.out.println("language version: " + factory.getLanguageVersion());
 
            String mimeTypes = factory.getMimeTypes().stream().collect(Collectors.joining(", "));
            System.out.println("mimeTypes: " + mimeTypes);
 
            String shortNames = factory.getNames().stream().collect(Collectors.joining(", "));
            System.out.println("shortNames :" + shortNames);
 
            String[] params = { ScriptEngine.NAME, ScriptEngine.ENGINE, ScriptEngine.ENGINE_VERSION,
                    ScriptEngine.LANGUAGE, ScriptEngine.LANGUAGE_VERSION };
 
            for (String param : params) {
                System.out.printf("parameter '%s': %s\n", param, factory.getParameter(param));
            }
            System.out.println("---------------");
        }
        
        
        
        
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            if(!(engine instanceof Invocable))  {
                System.out.println("Invocable 인터페이스 사용 불가");
            } else {
                System.out.println("Invocable 인터페이스 사용 가능");
            }
            System.out.println("---------------");
            
            engine.eval("print('Hello World');");
        } catch (ScriptException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

