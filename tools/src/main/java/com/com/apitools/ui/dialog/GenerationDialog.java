package com.com.apitools.ui.dialog;

import com.com.apitools.ui.component.CheckBoxList;
import com.com.apitools.ui.config.Configuration;
import com.com.apitools.ui.config.SubTemplateElement;
import com.com.apitools.ui.config.TemplateElement;
import com.com.apitools.ui.engine.EngineBuilder;
import com.com.apitools.ui.engine.TemplateEngine;
import com.com.apitools.ui.utils.StringUtil;
import com.xiniunet.apitools.codeAnalysis.Domain;
import com.xiniunet.apitools.codeAnalysis.Method;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GenerationDialog extends JDialog {

    private static final long serialVersionUID = 6159091936841897188L;

    private final JPanel contentPanel = new JPanel();
    private JTextField textTargetProject;
    private JTextField textBasePackage;
    private JTextField textModuleName;
    private CheckBoxList templatesList;

    private Configuration configuration;
    private List<Method> selectMethods;
    private List<Domain> loadDomains;
    private EngineBuilder engineBuilder;

    /**
     * Create the dialog.
     */
    public GenerationDialog(Configuration configuration, List<Method> selectMethods,List<Domain> loadDomains, String classPath) {

        setModal(true);
        // setModalityType(ModalityType.APPLICATION_MODAL);
        setTitle("生成代码");
        setResizable(false);
        setBounds(100, 100, 419, 485);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        this.selectMethods = selectMethods;
        this.loadDomains = loadDomains;
        JLabel lblTagertProject = new JLabel("代码保存路径");
        lblTagertProject.setHorizontalAlignment(SwingConstants.TRAILING);
        lblTagertProject.setBounds(10, 13, 72, 15);
        contentPanel.add(lblTagertProject);

        textTargetProject = new JTextField();
        textTargetProject.setBounds(92, 10, 311, 21);
        contentPanel.add(textTargetProject);
        textTargetProject.setColumns(10);

        textBasePackage = new JTextField();
        textBasePackage.setBounds(92, 41, 311, 21);
        contentPanel.add(textBasePackage);
        textBasePackage.setColumns(10);

        textModuleName = new JTextField();
        textModuleName.setBounds(92, 72, 130, 21);
        contentPanel.add(textModuleName);
        textModuleName.setColumns(10);

        JLabel lblBasePackage = new JLabel("基准包");
        lblBasePackage.setHorizontalAlignment(SwingConstants.TRAILING);
        lblBasePackage.setBounds(28, 44, 54, 15);
        contentPanel.add(lblBasePackage);

        JLabel lblModuleName = new JLabel("模块名");
        lblModuleName.setHorizontalAlignment(SwingConstants.TRAILING);
        lblModuleName.setBounds(28, 75, 54, 15);
        contentPanel.add(lblModuleName);

        JPanel panel = new JPanel();
        panel.setBounds(92, 103, 311, 234);
        contentPanel.add(panel);
        panel.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane);

        templatesList = new CheckBoxList();
        templatesList.setBounds(0, 0, 1, 1);
        scrollPane.setViewportView(templatesList);

        JLabel lblTemplates = new JLabel("代码模板");
        lblTemplates.setHorizontalAlignment(SwingConstants.TRAILING);
        lblTemplates.setBounds(28, 103, 54, 15);
        contentPanel.add(lblTemplates);
        JPanel buttonPane = new JPanel();
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        JButton btnOK = new JButton("生成");
        buttonPane.add(btnOK);
        btnOK.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                okButtonClick(e);
            }
        });
        btnOK.setMnemonic(KeyEvent.VK_ENTER);
        btnOK.setActionCommand("OK");
        getRootPane().setDefaultButton(btnOK);

        JButton btnCancel = new JButton("取消");
        buttonPane.add(btnCancel);
        btnCancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                doClose();
            }
        });
        btnCancel.setMnemonic(KeyEvent.VK_CANCEL);
        btnCancel.setActionCommand("Cancel");

        this.configuration = configuration;

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        centerScreen();
        loadConfiguration();

        engineBuilder = new EngineBuilder(classPath);
    }

    public void centerScreen() {
        Dimension dim = getToolkit().getScreenSize();
        Rectangle abounds = getBounds();
        setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
    }

    private void loadConfiguration() {
        textTargetProject.setText(configuration.getTagertProject());
        textBasePackage.setText(configuration.getBasePackage());
        textModuleName.setText(configuration.getModuleName());

        templatesList.setListData(configuration.getTemplates().toArray());

        templatesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        for (int i = 0; i < configuration.getTemplates().size(); i++) {
            TemplateElement templateElement = configuration.getTemplates().get(i);
            if (templateElement.isSelected()) {
                templatesList.addSelectionInterval(i, i);
            }
        }

//        textTableName.setText(tableModel.getTableName());
//        textTableAlias.setText(tableModel.getTableAlias());
    }

    private void doClose() {
        setVisible(false);
        dispose();
    }

    private void okButtonClick(ActionEvent evt) {
        Object[] selectedValues = templatesList.getSelectedValues();
        if (selectedValues.length == 0) {
            JOptionPane.showMessageDialog(this, "请选择模板.", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String targetProject = textTargetProject.getText();
        if (StringUtil.isEmpty(targetProject)) {
            JOptionPane.showMessageDialog(this, "请输入代码保存路径.", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String basePackage = textBasePackage.getText();
        if (StringUtil.isEmpty(basePackage)) {
            JOptionPane.showMessageDialog(this, "请输入基准包.", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String moduleName = textModuleName.getText();
        if (StringUtil.isEmpty(moduleName)) {
            JOptionPane.showMessageDialog(this, "请输入模块名.", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        configuration.setTagertProject(targetProject);
        configuration.setBasePackage(basePackage);
        configuration.setModuleName(moduleName);

        for (TemplateElement templateElement : configuration.getTemplates()) {
            templateElement.setSelected(false);
        }

        int count = selectedValues.length;
        for (int i = 0; i < count; i++) {
            try {
                Object selectedObject = selectedValues[i];
                TemplateElement templateElement = (TemplateElement) selectedObject;
                templateElement.setSelected(true);

                TemplateEngine templateEngine = engineBuilder.getTemplateEngine(templateElement.getEngine());
                if (templateEngine == null) {
                    JOptionPane.showMessageDialog(this, "没有对应的模板引擎: " + templateElement.getEngine(), "错误", JOptionPane.ERROR_MESSAGE);
                } else {
                    List<SubTemplateElement> subTemplateElements = templateElement.getGroup();
                    if(subTemplateElements!=null&&!subTemplateElements.isEmpty()){
                        for(SubTemplateElement subTemplateElement:subTemplateElements){
                            boolean single = subTemplateElement.isSingle();
                            boolean isdomain = subTemplateElement.getIsDomain();
                            if (!isdomain) {
                                if (!single) {
                                    Map<String, Object> model = new HashMap<String, Object>();
                                    model.put("tagertProject", configuration.getTagertProject());
                                    model.put("basePackage", configuration.getBasePackage());
                                    model.put("moduleName", configuration.getModuleName());
                                    model.put("author", configuration.getAuthor());
                                    model.put("company", configuration.getCompany());
                                    model.put("methods", selectMethods);
                                    templateEngine.processToFile(model, subTemplateElement);
                                } else {
                                    for (Method method : selectMethods) {
                                        Map<String, Object> model = new HashMap<String, Object>();
                                        model.put("tagertProject", configuration.getTagertProject());
                                        model.put("basePackage", configuration.getBasePackage());
                                        model.put("moduleName", configuration.getModuleName());
                                        model.put("author", configuration.getAuthor());
                                        model.put("company", configuration.getCompany());
                                        model.put("method", method);
                                        templateEngine.processToFile(model, subTemplateElement);
                                    }
                                }
                            }
                            if (isdomain) {
                                for (Domain domain : loadDomains) {
                                    Map<String, Object> model = new HashMap<String, Object>();
                                    model.put("tagertProject", configuration.getTagertProject());
                                    model.put("basePackage", configuration.getBasePackage());
                                    model.put("moduleName", configuration.getModuleName());
                                    model.put("author", configuration.getAuthor());
                                    model.put("company", configuration.getCompany());
                                    model.put("domain", domain);
                                    templateEngine.processToFile(model, subTemplateElement);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
        configuration.save();
        JOptionPane.showMessageDialog(this, "生成完毕.", "提示", JOptionPane.INFORMATION_MESSAGE);
    }
}
