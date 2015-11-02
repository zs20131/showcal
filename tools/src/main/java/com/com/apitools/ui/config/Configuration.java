package com.com.apitools.ui.config;


import com.com.apitools.ui.utils.StringUtil;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Configuration {

    private static final String CONFIGURATION_FILE = "configuration.xml";
    private String configurationFile;
    //    private List<DatabaseElement> connectionHistory;
    private List<String> classPathEntries;
    private String tagertProject;
    private String basePackage;
    private String moduleName;
    private String contractPath;
    private String contractName;
    private String author;
    private String company;
    private List<TemplateElement> templates;

    public Configuration(String classPath) {
        this.configurationFile = classPath + CONFIGURATION_FILE;
//        connectionHistory = new ArrayList<DatabaseElement>();
        classPathEntries = new ArrayList<String>();
        templates = new ArrayList<TemplateElement>();
    }

    public void loadConfiguration() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(configurationFile);
        // Get the root element <configuration>
        Element rootNode = doc.getDocumentElement();

        NodeList nodeList = rootNode.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node childNode = nodeList.item(i);

            if (childNode.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            if ("classpath".equals(childNode.getNodeName())) { //$NON-NLS-1$
                parseClassPathEntry(childNode);
            } else if ("tagertProject".equals(childNode.getNodeName())) { //$NON-NLS-1$
                tagertProject = parseElementNodeValue(childNode);
            } else if ("basePackage".equals(childNode.getNodeName())) { //$NON-NLS-1$
                basePackage = parseElementNodeValue(childNode);
            } else if ("moduleName".equals(childNode.getNodeName())) { //$NON-NLS-1$
                moduleName = parseElementNodeValue(childNode);
            } else if ("contractPath".equals(childNode.getNodeName())) { //$NON-NLS-1$
                contractPath = parseElementNodeValue(childNode);
            } else if ("contractName".equals(childNode.getNodeName())) { //$NON-NLS-1$
                contractName = parseElementNodeValue(childNode);
            } else if ("author".equals(childNode.getNodeName())) { //$NON-NLS-1$
                author = parseElementNodeValue(childNode);
            } else if ("company".equals(childNode.getNodeName())) { //$NON-NLS-1$
                company = parseElementNodeValue(childNode);
            } else if ("templates".equals(childNode.getNodeName())) { //$NON-NLS-1$
                parseTemplates(childNode);
            }
        }

    }

    private void parseClassPathEntry(Node node) {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node childNode = nodeList.item(i);

            if (childNode.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if ("entry".equals(childNode.getNodeName())) {
                String entry = parseElementNodeValue(childNode);
                if (StringUtil.isNotEmpty(entry)) {
                    classPathEntries.add(entry);
                }
            }
        }
    }


    private void parseTemplates(Node node) {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node childNode = nodeList.item(i);

            if (childNode.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if ("template".equals(childNode.getNodeName())) {
                parseTemplate(childNode);
            }
        }
    }

    private void parseTemplate(Node node) {
        NodeList nodeList = node.getChildNodes();
        String name = null, engine = null, templateFile = null, targetPath = null, targetFileName = null, encoding = null;
        boolean selected;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node childNode = nodeList.item(i);

            if (childNode.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            Properties attrs = parseAttributes(node);
            name = attrs.getProperty("name");
            engine = attrs.getProperty("engine");
            selected = Boolean.parseBoolean(attrs.getProperty("selected"));
            TemplateElement templateElement = new TemplateElement(name, engine, selected);

            if ("group".equals(childNode.getNodeName())) {
                List<SubTemplateElement> subTemplateElements = parseSubTemplate(childNode);
                templateElement.setGroup(subTemplateElements);
            }
            templates.add(templateElement);
        }
    }

    /**
     * 解析所有子标签
     *
     * @param node
     * @return
     */
    private List<SubTemplateElement> parseSubTemplate(Node node) {
        NodeList nodeList = node.getChildNodes();
        String templateFile = null, targetPath = null, targetFileName = null, encoding = null;
        boolean isdomain = false, issingle = false;
        List<SubTemplateElement> subTemplateElements = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node childNode = nodeList.item(i);
            if (childNode.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if ("subtemplate".equals(childNode.getNodeName())) {
                // 明细模板
                NodeList subtemplatelist = childNode.getChildNodes();
                Properties attrs = parseAttributes(childNode);
                isdomain = Boolean.valueOf(attrs.getProperty("isdomain"));
                issingle = Boolean.valueOf(attrs.getProperty("single"));
                for (int j = 0; j < subtemplatelist.getLength(); j++) {
                    Node subchildNode = subtemplatelist.item(j);
                    if (subchildNode.getNodeType() != Node.ELEMENT_NODE) {
                        continue;
                    }
                    if ("templateFile".equals(subchildNode.getNodeName())) {
                        templateFile = parseElementNodeValue(subchildNode);
                    } else if ("targetPath".equals(subchildNode.getNodeName())) {
                        targetPath = parseElementNodeValue(subchildNode);
                    } else if ("targetFileName".equals(subchildNode.getNodeName())) {
                        targetFileName = parseElementNodeValue(subchildNode);
                    } else if ("encoding".equals(subchildNode.getNodeName())) {
                        encoding = parseElementNodeValue(subchildNode);
                    }

                }
                SubTemplateElement subTemplateElement = new SubTemplateElement(templateFile, targetPath, targetFileName, encoding, isdomain, issingle);
                subTemplateElements.add(subTemplateElement);
            }

        }
        return subTemplateElements;
    }

    private String parseElementNodeValue(Node node) {
        if (node.getFirstChild() != null) {
            return node.getFirstChild().getNodeValue();
        } else {
            return null;
        }
    }


    private Properties parseAttributes(Node node) {
        Properties attributes = new Properties();
        NamedNodeMap nnm = node.getAttributes();
        for (int i = 0; i < nnm.getLength(); i++) {
            Node attribute = nnm.item(i);
            String value = attribute.getNodeValue();
            attributes.put(attribute.getNodeName(), value);
        }

        return attributes;
    }

    public void save() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element root = doc.createElement("configuration");
            doc.appendChild(root);

            Element classpathEle = doc.createElement("classpath");
            root.appendChild(classpathEle);
            for (String s : classPathEntries) {
                Element e = doc.createElement("entry");
                e.appendChild(doc.createTextNode(s));
                classpathEle.appendChild(e);
            }
            Element e = doc.createElement("tagertProject");
            e.appendChild(doc.createTextNode(tagertProject));
            root.appendChild(e);

            e = doc.createElement("basePackage");
            e.appendChild(doc.createTextNode(basePackage));
            root.appendChild(e);

            e = doc.createElement("moduleName");
            e.appendChild(doc.createTextNode(moduleName));
            root.appendChild(e);

            e = doc.createElement("contractPath");
            e.appendChild(doc.createTextNode(contractPath));
            root.appendChild(e);

            e = doc.createElement("contractName");
            e.appendChild(doc.createTextNode(contractName));
            root.appendChild(e);

            e = doc.createElement("author");
            e.appendChild(doc.createTextNode(author));
            root.appendChild(e);

            e = doc.createElement("company");
            e.appendChild(doc.createTextNode(company));
            root.appendChild(e);

            Element templatesEle = doc.createElement("templates");
            root.appendChild(templatesEle);
            for (TemplateElement t : templates) {
                writeTemplate(templatesEle, t);
            }

            // Write the file
            DOMSource ds = new DOMSource(doc);
            StreamResult sr = new StreamResult(new File(configurationFile));
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.METHOD, "xml");
            t.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.setOutputProperty(OutputKeys.STANDALONE, "yes");
            t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            t.transform(ds, sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void writeTemplate(Element elem, TemplateElement t) {
        Element e = elem.getOwnerDocument().createElement("template");
        e.setAttribute("name", t.getTemplateName());
        e.setAttribute("engine", t.getEngine());
        e.setAttribute("selected", String.valueOf(t.isSelected()));
        Element group = e.getOwnerDocument().createElement("group");
        e.appendChild(group);
        List<SubTemplateElement> subTemplateElements = t.getGroup();
        if(subTemplateElements!=null&&!subTemplateElements.isEmpty()){
            for(SubTemplateElement subTemplateElement:subTemplateElements){
                Element subelement = group.getOwnerDocument().createElement("subtemplate");
                subelement.setAttribute("single",String.valueOf(subTemplateElement.isSingle()));
                subelement.setAttribute("isdomain",String.valueOf(subTemplateElement.getIsDomain()));
                setTextChild(subelement,"templateFile",subTemplateElement.getTemplateFile());
                setTextChild(subelement,"targetPath",subTemplateElement.getTargetPath());
                setTextChild(subelement,"targetFileName",subTemplateElement.getTargetFileName());
                setTextChild(subelement,"encoding",subTemplateElement.getEncoding());
                group.appendChild(subelement);
            }
        }
        elem.appendChild(e);
    }

//    /**
//     * Convenience function to set the text of a child element.
//     */
    private void setTextChild(Element elem, String name, String value) {
        Document doc = elem.getOwnerDocument();
        Element e = doc.createElement(name);
        e.appendChild(doc.createTextNode(value));
        elem.appendChild(e);
    }


    public List<String> getClassPathEntries() {
        return classPathEntries;
    }

    public String getTagertProject() {
        return tagertProject;
    }

    public void setTagertProject(String tagertProject) {
        this.tagertProject = tagertProject;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public List<TemplateElement> getTemplates() {
        return templates;
    }

    public String getContractPath() {
        return contractPath;
    }

    public void setContractPath(String contractPath) {
        this.contractPath = contractPath;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
