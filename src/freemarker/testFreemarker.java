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
		//����ftl����Ŀ¼
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File("template"));
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		//��������ץȡģʽ
		Map latest = new HashMap();
		latest.put("url", "products/greenmouse.html");
		latest.put("name", "green mouse");
		
		//��������
		Map root = new HashMap();
		root.put("latestProduct", latest);
		root.put("user", "Big Joe");
		root.put("sex", 1);
		String[] arr = {"1","2","3","4"};
		root.put("arr", arr);
		
		//ʵ��ģ�����
		Template temp = cfg.getTemplate("helloworld.ftl");
		
		//����html �����Ŀ��
		Writer out = new OutputStreamWriter(System.out);
		temp.process(root, out);
		out.flush();
		
	}
}
