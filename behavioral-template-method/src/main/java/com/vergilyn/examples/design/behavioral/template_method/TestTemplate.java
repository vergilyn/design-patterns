package com.vergilyn.examples.design.behavioral.template_method;

import com.vergilyn.examples.design.behavioral.template_method.algorithm.impl.AppClass;
import com.vergilyn.examples.design.behavioral.template_method.algorithm.impl.FormClass;
import com.vergilyn.examples.design.behavioral.template_method.algorithm.impl.WebClass;
import com.vergilyn.examples.design.behavioral.template_method.bean.StudentBean;

/**
 * @author VergiLyn
 * @bolg http://www.cnblogs.com/VergiLyn/p/6243626.html
 * @date 2017/1/2
 */
public class TestTemplate {
    private static StudentBean f = new StudentBean("form",1);
    private static StudentBean w = new StudentBean("web",2);
    private static StudentBean a = new StudentBean("app",3);


    public static void main(String[] args) {
        FormClass form = new FormClass();
        form.saveStudentInfo(f);

        WebClass web = new WebClass();
        web.saveStudentInfo(w);

        AppClass app = new AppClass();
        app.saveStudentInfo(a);
    }
}
