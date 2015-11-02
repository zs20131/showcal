package com.com.apitools.ui;

import com.com.apitools.ui.component.CheckBoxEditor;
import com.com.apitools.ui.component.EditableTable;
import com.com.apitools.ui.config.Configuration;
import com.com.apitools.ui.dialog.GenerationDialog;
import com.com.apitools.ui.dialog.SettingDialog;
import com.com.apitools.ui.utils.ClassloaderUtility;
import com.com.apitools.ui.utils.ObjectFactory;
import com.xiniunet.apitools.codeAnalysis.Domain;
import com.xiniunet.apitools.codeAnalysis.Method;
import org.jvnet.substance.skin.SubstanceOfficeSilver2007LookAndFeel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.xiniu.apitools.codeAnalysis
 *  Description:
 * ***************************************************************
 *  8/31 0031  V1.0  xiniu    New Files for com.xiniu.apitools.codeAnalysis
 * </pre>
 */
public class MainFrame extends JFrame {
    private String[] headers = {"是否生成", "方法名称", "方法含义"};
    private static Font font = new Font("宋体", Font.PLAIN, 12);
    private JPanel contentPane;
    private String classPath;
    private java.util.List<Method> loadMethods;
    private java.util.List<Domain> loadDomains;
    private Configuration configuration;
    private EditableTable tableGrid;
    private JScrollPane scrollPane;
    private JButton btnGenerate;
    private DefaultTableModel tableGridModel;

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    UIManager.put("RootPane.setupButtonVisible", false);
                    UIManager.setLookAndFeel(new SubstanceOfficeSilver2007LookAndFeel());
                    // 调整默认字体
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
//                    frame.centerScreen();
//                    frame.contentSplitPane.setDividerLocation(0.25);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void InitGlobalFont(Font font) {
        FontUIResource fontRes = new FontUIResource(font);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontRes);
            }
        }
    }

    public MainFrame() {
        setTitle("犀牛代码生成器");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 886, 566);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        scrollPane = new JScrollPane();
        scrollPane.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
//        contentPane.setBottomComponent(scrollPane);

        scrollPane.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                resizeTableGrid(true);
            }
        });

        tableGrid = new EditableTable();
        scrollPane.setViewportView(tableGrid);

        contentPane.add(scrollPane);
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.NORTH);
        JButton setting = new JButton("设置");
        setting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSettingActionPerformed(e);
            }
        });

        JButton loadContractButton = new JButton("数据加载");
        loadContractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadContractData(e);
            }
        });

        btnGenerate = new JButton("代码生成...");
        btnGenerate.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                onGenerateActionPerformed(e);
            }
        });
        buttonPanel.add(setting);
        buttonPanel.add(loadContractButton);
        buttonPanel.add(btnGenerate);
        InitGlobalFont(font);
        classPath =getAppPath(this.getClass())+ File.separator;
        System.out.println(classPath);
        configuration = new Configuration(classPath);
        try {
            configuration.loadConfiguration();
            if (configuration.getClassPathEntries().size() > 0) {
                ClassLoader classLoader = ClassloaderUtility.getCustomClassloader(classPath,
                        configuration.getClassPathEntries());
                ObjectFactory.addExternalClassLoader(classLoader);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
        drawTableGrid();
        centerScreen();
    }

    public void centerScreen() {
        Dimension dim = getToolkit().getScreenSize();
        Rectangle abounds = getBounds();
        setLocation((dim.width - abounds.width) / 2, (dim.height - abounds.height) / 2);
    }

    /**
     * 代码生成
     *
     * @param e
     */
    private void onGenerateActionPerformed(ActionEvent e) {
        //1 加载数据
        java.util.List<Method> methodList = new ArrayList<>();
        Vector<Vector> selectMethods = tableGridModel.getDataVector();
        int index = 0;
        for (Vector tempdata : selectMethods) {
            if (Boolean.valueOf(tempdata.get(0).toString())) {
                methodList.add(loadMethods.get(index));
            }
            index++;
        }

        GenerationDialog generationDialog = new GenerationDialog(configuration, methodList, loadDomains, classPath);
        generationDialog.setVisible(true);
    }

    /**
     * 加载数据
     *
     * @param e
     */
    private void loadContractData(ActionEvent e) {
        //1 加载数据
        loadMethods = DataLoad.processContractMethodList(configuration.getContractPath(), configuration.getContractName());
        loadDomains = DataLoad.processContractDomainList(configuration.getContractPath());
        //2 设置表格
        Object[][] cellData = new Object[loadMethods.size()][headers.length];
        int row = 0;
        if (loadMethods != null && !loadMethods.isEmpty()) {
            for (Method method : loadMethods) {
                cellData[row][0] = true;
                cellData[row][1] = method.getName();
                cellData[row][2] = method.getDescription();
                row++;
            }
            tableGridModel.setDataVector(cellData, headers);
            resizeTableGrid(true);
        } else {
            JOptionPane.showMessageDialog(this, "未加载到相关契约数据，请检查配置信息.", "提示", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    /**
     * 设置
     *
     * @param e
     */
    private void onSettingActionPerformed(ActionEvent e) {
        SettingDialog settingDialog = new SettingDialog(configuration);
        settingDialog.setTitle("代码生成器设置");
        settingDialog.setVisible(true);
    }

    private void drawTableGrid() {

        Object[][] cellData = new Object[0][headers.length];
        tableGridModel = new DefaultTableModel(cellData, headers) {

            private static final long serialVersionUID = 880033063879582590L;

            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return true;
                } else return false;
            }
        };
        tableGridModel.addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE && e.getLastRow() >= 0) {
                    String columnName = tableGrid.getValueAt(e.getLastRow(), 0).toString();
                    String value = tableGrid.getValueAt(e.getLastRow(), e.getColumn()).toString();
                    if (true) {
                        if (e.getColumn() == 1) {
//                            column.setJavaType(value);
                        }
                    }
                }
            }
        });
        tableGrid.setModel(tableGridModel);

        ((EditableTable) tableGrid).setComboCell(0, new CheckBoxEditor());// 第2列为下拉

        resizeTableGrid(true);
    }

    private void resizeTableGrid(boolean bool) {
        Dimension containerwidth = null;
        if (!bool) {
            containerwidth = scrollPane.getPreferredSize();
        } else {
            containerwidth = scrollPane.getSize();
        }
        int allwidth = tableGrid.getIntercellSpacing().width;
        for (int j = 0; j < tableGrid.getColumnCount(); j++) {
            int max = 0;
            for (int i = 0; i < tableGrid.getRowCount(); i++) {
                Object cellValue = tableGrid.getValueAt(i, j);
                if (cellValue == null) {
                    cellValue = "";
                }
                int width = tableGrid.getCellRenderer(i, j).getTableCellRendererComponent(tableGrid, cellValue, false,
                        false, i, j).getPreferredSize().width;
                if (width > max) {
                    max = width;
                }
            }
            int headerwidth = tableGrid.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(tableGrid,
                    tableGrid.getColumnModel().getColumn(j).getIdentifier(),
                    false,
                    false, -1,
                    j).getPreferredSize().width;
            max += headerwidth;
            tableGrid.getColumnModel().getColumn(j).setPreferredWidth(max);
            allwidth += max + tableGrid.getIntercellSpacing().width;
        }
        allwidth += tableGrid.getIntercellSpacing().width;
        if (allwidth > containerwidth.width) {
            tableGrid.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        } else {
            tableGrid.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        }
    }

    public static String getAppPath(Class cls) {
        //检查用户传入的参数是否为空
        if (cls == null)
            throw new IllegalArgumentException("参数不能为空！");
        ClassLoader loader = cls.getClassLoader();
        //获得类的全名，包括包名
        String clsName = cls.getName() + ".class";
        //获得传入参数所在的包
        Package pack = cls.getPackage();
        String path = "";
        //如果不是匿名包，将包名转化为路径
        if (pack != null) {
            String packName = pack.getName();
            //此处简单判定是否是Java基础类库，防止用户传入JDK内置的类库
            if (packName.startsWith("java.") || packName.startsWith("javax."))
                throw new IllegalArgumentException("不要传送系统类！");
            //在类的名称中，去掉包名的部分，获得类的文件名
            clsName = clsName.substring(packName.length() + 1);
            //判定包名是否是简单包名，如果是，则直接将包名转换为路径，
            if (packName.indexOf(".") < 0) path = packName + "/";
            else {//否则按照包名的组成部分，将包名转换为路径
                int start = 0, end = 0;
                end = packName.indexOf(".");
                while (end != -1) {
                    path = path + packName.substring(start, end) + "/";
                    start = end + 1;
                    end = packName.indexOf(".", start);
                }
                path = path + packName.substring(start) + "/";
            }
        }
        //调用ClassLoader的getResource方法，传入包含路径信息的类文件名
        java.net.URL url = loader.getResource(path + clsName);
        //从URL对象中获取路径信息
        String realPath = url.getPath();
        //去掉路径信息中的协议名"file:"
        int pos = realPath.indexOf("file:");
        if (pos > -1) realPath = realPath.substring(pos + 5);
        //去掉路径信息最后包含类文件信息的部分，得到类所在的路径
        pos = realPath.indexOf(path + clsName);
        realPath = realPath.substring(0, pos - 1);
        //如果类文件被打包到JAR等文件中时，去掉对应的JAR等打包文件名
        if (realPath.endsWith("!"))
            realPath = realPath.substring(0, realPath.lastIndexOf("/"));
        /*------------------------------------------------------------
  ClassLoader的getResource方法使用了utf-8对路径信息进行了编码，当路径
   中存在中文和空格时，他会对这些字符进行转换，这样，得到的往往不是我们想要
   的真实路径，在此，调用了URLDecoder的decode方法进行解码，以便得到原始的
   中文及空格路径
 -------------------------------------------------------------*/
        try {
            realPath = java.net.URLDecoder.decode(realPath, "utf-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return realPath;
    }//getAppPath定义结束
}
