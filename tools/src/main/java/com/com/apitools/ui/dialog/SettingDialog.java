package com.com.apitools.ui.dialog;

import com.com.apitools.ui.config.Configuration;
import com.com.apitools.ui.utils.StringUtil;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.com.apitools.ui.dialog
 *  Description:
 * ***************************************************************
 *  8/31 0031  V1.0  xiniu    New Files for com.com.apitools.ui.dialog
 * </pre>
 */
public class SettingDialog extends JDialog{
    private final JPanel contentPanel = new JPanel();
    private JTextField contractPath;
    private JTextField contractName;
    private JTextField author;
    private JTextField company;
    private Configuration configuration;
    public SettingDialog(Configuration configuration) {
        setBounds(100, 100, 574, 401);
        this.setModal(true);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        this.configuration = configuration;
        contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
                FormFactory.RELATED_GAP_COLSPEC,
                FormFactory.DEFAULT_COLSPEC,
                FormFactory.RELATED_GAP_COLSPEC,
                FormFactory.DEFAULT_COLSPEC,
                FormFactory.RELATED_GAP_COLSPEC,
                FormFactory.DEFAULT_COLSPEC,
                FormFactory.RELATED_GAP_COLSPEC,
                ColumnSpec.decode("default:grow"),},
                new RowSpec[] {
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,}));
        {
            JLabel contractPathLabel = new JLabel("\u5951\u7EA6\u5730\u5740");
            contentPanel.add(contractPathLabel, "4, 2");
        }
        {
            contractPath = new JTextField();
            contentPanel.add(contractPath, "8, 2, fill, default");
            contractPath.setColumns(10);
        }
        {
            JLabel contractNameLabel = new JLabel("\u5951\u7EA6\u540D\u79F0");
            contentPanel.add(contractNameLabel, "4, 4");
        }
        {
            contractName = new JTextField();
            contentPanel.add(contractName, "8, 4, fill, default");
            contractName.setColumns(10);
        }
        {
            JLabel authorLabel = new JLabel("\u4F5C\u8005");
            contentPanel.add(authorLabel, "4, 6");
        }
        {
            author = new JTextField();
            contentPanel.add(author, "8, 6, fill, default");
            author.setColumns(10);
        }
        {
            JLabel companyLabel = new JLabel("\u516C\u53F8");
            contentPanel.add(companyLabel, "4, 8");
        }
        {
            company = new JTextField();
            contentPanel.add(company, "8, 8, fill, default");
            company.setColumns(10);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("\u786E\u5B9A");
                okButton.setActionCommand("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //设置
                        okButtonClick(e);
                    }
                });
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("\u53D6\u6D88");
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
            }
        }
        loadConfiguration();
        centerScreen();
    }

    public void centerScreen() {
        Dimension dim = getToolkit().getScreenSize();
        Rectangle abounds = getBounds();
        setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
    }
    private void loadConfiguration() {
        contractPath.setText(configuration.getContractPath());
        contractName.setText(configuration.getContractName());
        author.setText(configuration.getAuthor());
        company.setText(configuration.getCompany());
    }

    /**
     * 设置数据
     * @param e
     */
    private void okButtonClick(ActionEvent e) {
        String contractPathStr = contractPath.getText();
        if (StringUtil.isEmpty(contractPathStr)) {
            JOptionPane.showMessageDialog(this, "请输入契约路径.", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String contractNameStr = contractName.getText();
        if (StringUtil.isEmpty(contractNameStr)) {
            JOptionPane.showMessageDialog(this, "请输入契约名称.", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String authorStr = author.getText();
        String compayStr = company.getText();
        configuration.setContractPath(contractPathStr);
        configuration.setContractName(contractNameStr);
        if(!StringUtil.isEmpty(authorStr)){
            configuration.setAuthor(authorStr);
        }
        if(!StringUtil.isEmpty(compayStr)){
            configuration.setCompany(compayStr);
        }
        configuration.save();
        dispose();
    }
}
