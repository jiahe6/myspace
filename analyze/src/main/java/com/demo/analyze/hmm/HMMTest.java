package com.demo.analyze.hmm;

import com.demo.analyze.util.FileOperation;

public class HMMTest {
    public static void main(String[] args) throws Exception {
        HMM hmm = HMMFactory.createHMM(FileOperation.getFileContent("E:/技术学习/分词工具/人民日报语料库/199801.txt").replaceAll("[0-9]{8}-[0-9]{2}-[0-9]{3}-[0-9]{3}/m", ""));
        System.out.println(hmm.getEmission());
        String str[] = {
                "台湾 是 中国 领土 不可分割 的 部分",
                "这部 电视片 还 强调 表现 敦煌 文化 的 珍贵性 和 观赏性",
                "湖南 备耕 安排 早 动手 快",
                "我 第一 次 听到 这 首 歌 ， 是 在 六 年 前 的 大年三十 春节 联欢 晚会 上"};
        String s2[] ={
                "[ns, r, ns, n, l, u, n]",
                "[r, n, v, d, v, ns, n, u, n, c, n]",
                "[ns, vn, v, a, v, a]",
                "[r, m, q, v, r, q, n, w, v, p, m, q, f, u, t, t, vn, n, f]"};
        double value = 0;
        for(int i =  0;i<str.length;i++){
            value = value + access(hmm.viterbi(str[i].split(" ")),s2[i]);
        }
        System.out.println("评分结果:");
        System.out.printf("%.2f",value/str.length);
    }

    private static double access(String answer, String result) {
        System.out.println("计算结果: "+answer);
        System.out.println("真实结果: "+result);
        String[] s1 = answer.split(", ");
        String[] s2 = result.split(", ");
        double count = 0;
        for(int i = 0;i<s1.length;i++){
            if(s1[i].equals(s2[i]))
                count++;
        }
        System.out.println("命中率: "+count/s1.length);
        System.out.println("=======================================");
        return count/s1.length;
    }
}
