package org.fiufiu.leetcode.toutiao.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class SimplifyPath {

    @Test
    public void test() {

//        Assert.assertEquals("/home", simplifyPath("//home/"));
//        Assert.assertEquals("/home", simplifyPath("/home/"));
        Assert.assertEquals("/", simplifyPath("/../"));
        Assert.assertEquals("/home/foo", simplifyPath("/home//foo/"));
        Assert.assertEquals("/c", simplifyPath("/a/./b/../../c/"));
        Assert.assertEquals("/c", simplifyPath("/a/../../b/../c//.//"));
        Assert.assertEquals("/a/b/c", simplifyPath("/a//b////c/d//././/.."));
    }

    public String simplifyPath(String path) {

        String[] split = path.split("/");
        LinkedList<String> ls = new LinkedList<>();
        for (int i=0;i<split.length;i++) {
            if (split[i].isEmpty()) {

            } else if (split[i].equals(".")) {

            } else if (split[i].equals("..")) {
                if (ls.size()>0) {
                    ls.removeLast();
                }
            } else {
                ls.add(split[i]);
            }
        }
        if (ls.size()==0) {
            return "/";
        }
        Iterator<String> iterator = ls.iterator();
        StringBuilder builder = new StringBuilder();
        while(iterator.hasNext()) {
            builder.append("/").append(iterator.next());
        }
        return builder.toString();
        /*char[] chars = path.toCharArray();
        //表示有效的指针,改写
        int riIndex=0;
        boolean point=false;
        boolean slash=false;
        //i表示移动的指针
        for (int i=0;i<chars.length;i++) {
            if (chars[i]=='/') {
                if (slash) {
                    //continue
                } else {
                    chars[riIndex++]=chars[i];
                    slash=true;
                }
            } else if(chars[i]=='.') {
                if (point) {
                    //huitui
                } else {
                    point=true;
                }
            } else {
                chars[riIndex++]=chars[i];
            }
        }*/

    }
}
