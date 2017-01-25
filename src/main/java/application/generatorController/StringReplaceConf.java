package application.generatorController;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;

public class StringReplaceConf {
    private Configuration cfg;
    private static StringReplaceConf instance = null;

    private StringReplaceConf() {
        try {
            cfg = new Configuration(Configuration.VERSION_2_3_25);
            cfg.setDirectoryForTemplateLoading(new File("/"));
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

    public Configuration getCfg(){return cfg;}
}
