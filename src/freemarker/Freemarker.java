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

public class Freemarker {
	public static void main(String[] args) throws IOException, TemplateException {
		Configuration cfg = new Configuration();
		//����ftl����Ŀ¼
		cfg.setDirectoryForTemplateLoading(
		        new File("template"));
		//�������ݵ�ץȡģʽ
		cfg.setObjectWrapper(new DefaultObjectWrapper()); 
		
		Map root = new HashMap();
		root.put("user", "Big Joe");
		root.put("sex", 0);


		Map latest = new HashMap();
		root.put("latestProduct", latest);
		//��������
		latest.put("url", "products/greenmouse.html");
		latest.put("name", "green mouse"); 
		
		String[] str = new String[]{"1","2","3"};
		root.put("arr", str);
		
		
		//ʵ����ģ�����
		Template temp = cfg.getTemplate("helloworld.ftl"); 
		//����html  �����Ŀ��
		Writer out = new OutputStreamWriter(System.out);
		temp.process(root, out);
		out.flush();
	}
}
