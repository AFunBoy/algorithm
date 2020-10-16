package com.funboy.中级;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName 字母异位词分组
 * @Description 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * @Author 王帆
 * @Date 2020/10/15 12:34
 * @Version 1.0
 */
public class 字母异位词分组 {


    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> solution = solution(input);
        for (List<String> strings : solution) {
            System.out.println(Arrays.toString(strings.toArray()));
        }
    }

    public static List<List<String>> solution(String[] strs) {

        HashMap<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = Arrays.toString(chars);
            resultMap.computeIfAbsent(sorted, k -> new ArrayList<>());
            resultMap.get(sorted).add(str);
        }
        List<List<String>> resultList = new ArrayList<>();
        for (String s : resultMap.keySet()) {
            resultList.add(resultMap.get(s));
        }
        return resultList;
    }


}
