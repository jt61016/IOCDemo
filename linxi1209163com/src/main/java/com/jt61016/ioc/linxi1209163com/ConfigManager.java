package com.jt61016.ioc.linxi1209163com;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author jiangtao
 * @Date 2018/5/7 下午4:25.
 */
public class ConfigManager {
    public static Map<String, Bean> getConfig(String path) {
        Map<String, Bean> map = new HashMap<String, Bean>();

        SAXReader saxReader = new SAXReader();
        InputStream is = ConfigManager.class.getResourceAsStream(path);
        Document document = null;

        try {
            document = saxReader.read(is);
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException("请检查xml配置文件");
        }

        final String xpath = "//bean";
        List<Element> elements = document.selectNodes(xpath);
        if (null != elements) {
            for (Element element : elements) {
                Bean bean = new Bean();
                String name = element.attributeValue("name");
                String className = element.attributeValue("className");
                bean.setName(name);
                bean.setClassName(className);

                List<Element> children = element.elements("property");
                if (null != children) {
                    for (Element child : children) {
                        Property property = new Property();
                        String pName = child.attributeValue("name");
                        String pValue = child.attributeValue("value");
                        String pRef = child.attributeValue("ref");
                        property.setName(pName);
                        property.setValue(pValue);
                        property.setRef(pRef);

                        bean.getProperties().add(property);
                    }
                }
                map.put(name, bean);
            }
        }

        return map;
    }
}
