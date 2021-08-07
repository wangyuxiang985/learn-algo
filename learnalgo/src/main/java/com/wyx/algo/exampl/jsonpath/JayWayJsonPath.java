package com.wyx.algo.exampl.jsonpath;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

/**
 *@ClassName JayWayJsonPath
 *@Description TODO
 *@Author yuxiang
 *@Date 2021/6/13
 *@Version 1.0
 **/
public class JayWayJsonPath {
    public static void main(String[] args) throws Exception{

        String path = System.getProperty("user.dir") + File.separator + "learnalgo/src/main/java/com/wyx/algo/exampl/jsonpath" + File.separator + "test.json";

//        String jsonString = FileUtils.readFileToString(new File(path), "utf-8");

//        ReadContext context = JsonPath.parse(jsonString);

        Object read = JsonPath.read(new File(path), "$.store.book[1].author");
        System.out.println(read.toString());

        ReadContext context = JsonPath.parse(new File(path));
        Object read1 = context.read("$.store.book[1].author");
        System.out.println(read1.toString());
        System.out.println("===============");
        List<Object> categorys = context.read("$.store.book[?(@.category == 'reference')]");
        for(Object st: categorys){
            System.out.println(st.toString());
        }
        System.out.println("=================");

        List<Object> color = context.read("$.store.book[?(@.category)]");
        for(Object is :color){
            System.out.println(is.toString());
        }
        //输出：//{color=red, price=19.95}
        System.out.println("----------------");
        List<Object> pp = context.read("$..price");
        for(Object p :pp){
            System.out.println(p.toString());
        }

//        输出：8.95  12.99   19.95

        List<String> authors = context.read("$.store.book[*].author");
        for (String str : authors) {
            System.out.println(str);
        }

//        输出：Nigel Rees Evelyn Waugh
        System.out.println("+++++++++++++");
        Object read2 = context.read("$..book[0:2:3]");
        System.out.println(read2.toString());
    }
}
