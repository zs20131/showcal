package com.showcal.framework.participle;

import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.cfg.DefaultConfig;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
import org.wltea.analyzer.dic.Dictionary;
import org.wltea.analyzer.dic.Hit;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: com.showcal.framework.participle
 *  Description:
 * ***************************************************************
 *  9/29 0029  V1.0  xiniu    New Files for com.showcal.framework.participle
 * </pre>
 */
public class Participle {
    /**
     * 分词操作，获取第一个命中的单词作为关键字
     * @param keywords 关键字
     * @param message  消息
     * @return  第一个命中的关键字
     */
    public static String doParticiple(List<String> keywords,String message) {
        Configuration cfg = DefaultConfig.getInstance();
        cfg.setUseSmart(true);
        Dictionary.initial(cfg);
        Dictionary dictionary = Dictionary.getSingleton();
        dictionary.addWords(keywords);
        StringReader input = new StringReader(message.trim());
        IKSegmenter ikSeg = new IKSegmenter(input, true);// true　用智能分词　，false细粒度
        try {
            for (Lexeme lexeme = ikSeg.next(); lexeme != null; lexeme = ikSeg.next()) {
                String parsekey = lexeme.getLexemeText();
                if(keywords.contains(parsekey)){
                    return parsekey;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
