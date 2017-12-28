package freemarker;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class testFreemarker {
	public static void main(String[] args) throws IOException, TemplateException {
		//配置ftl查找目录
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File("template"));
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		//设置数据抓取模式
		Map latest = new HashMap();
		latest.put("url", "products/greenmouse.html");
		latest.put("name", "green mouse");
		
		//构建数据
		Map root = new HashMap();
		root.put("latestProduct", latest);
		root.put("user", "Big Joe");
		root.put("sex", 1);
		String[] arr = {"1","2","3","4"};
		root.put("arr", arr);
		
		//实例模板对象
		Template temp = cfg.getTemplate("helloworld.ftl");
		
		//生成html 输出到目标
		Writer out = new OutputStreamWriter(System.out);
		temp.process(root, out);
		out.flush();
		
	}
}
