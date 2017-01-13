package application.generatorController;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;

/**
 * Created by Maarten de Klerk on 13-1-2017.
 */
public class StringReplaceConf {
    private static StringReplaceConf instance = null;

    private StringReplaceConf() {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
            cfg.setDirectoryForTemplateLoading(new File("./templates/"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static StringReplaceConf getInstance(){
        if(instance == null){
            instance = new StringReplaceConf();
        }
        return instance;
    }
}
