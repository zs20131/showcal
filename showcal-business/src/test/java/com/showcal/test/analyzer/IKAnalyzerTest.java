package com.showcal.test.analyzer;

import com.showcal.framework.participle.Participle;
import org.junit.Test;
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
 *  Title: com.showcal.test.analyzer
 *  Description:
 * ***************************************************************
 *  9/17 0017  V1.0  xiniu    New Files for com.showcal.test.analyzer
 * </pre>
 */
public class IKAnalyzerTest {
    @Test
    public void Test() throws IOException {
        String text = "您好，我的腿疼腰不疼有点疼，还可以减肥么?，你什么情况，减肥，脚痛";
        Configuration cfg = DefaultConfig.getInstance();
        cfg.setUseSmart(true);
        Dictionary.initial(cfg);
        Dictionary dictionary = Dictionary.getSingleton();
        List<String> keywords = new ArrayList<>();
        keywords.add("腰不疼");
        keywords.add("腿疼");
        System.out.println(Participle.doParticiple(keywords,text));
//        System.out.println(queryWords(text));
    }


    public static List<String> queryWords(String query) throws IOException {
        List<String> list = new ArrayList<String>();
        StringReader input = new StringReader(query.trim());

        IKSegmenter ikSeg = new IKSegmenter(input, true);// true　用智能分词　，false细粒度
        for (Lexeme lexeme = ikSeg.next(); lexeme != null; lexeme = ikSeg.next()) {
            list.add(lexeme.getLexemeText());
        }
        return list;
    }
}
