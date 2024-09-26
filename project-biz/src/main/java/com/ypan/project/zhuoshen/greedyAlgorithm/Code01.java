package com.ypan.project.zhuoshen.greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
 * 给你每一个项目开始的时间和结束的时间（给你一个数组，里面是一个个具体的项目)，你来安排宣讲的日程，要求会议室进行的宣讲的场次最多。
 * 返回这个最多的宣讲场次。
 *
 * 经过分析可得：按照项目的结束时间从短到长安排，为最优解。
 */
public class Code01 {

    public static class Program {

        private int start;
        private int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArray(Program [] programs, int pointTime) {

        // 先按照项目结束时间的早晚排好序
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (pointTime <= programs[i].start) {
                result++;
                pointTime = programs[i].end;
            }
        }
        return result;
    }
}
