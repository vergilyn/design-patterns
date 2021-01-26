package com.vergilyn.examples.design.tplmethod;

import com.vergilyn.examples.design.tplmethod.algorithm.impl.AppClass;
import com.vergilyn.examples.design.tplmethod.algorithm.impl.FormClass;
import com.vergilyn.examples.design.tplmethod.algorithm.impl.WebClass;
import com.vergilyn.examples.design.tplmethod.bean.StudentBean;

import org.junit.jupiter.api.Test;

/**
 *
 * @author vergilyn
 * @date 2021-01-26
 */
public class TemplateTest {

    @Test
    public void test() {
        StudentBean f = new StudentBean("form",1);
        StudentBean w = new StudentBean("web",2);
        StudentBean a = new StudentBean("app",3);

        FormClass form = new FormClass();
        form.saveStudentInfo(f);

        WebClass web = new WebClass();
        web.saveStudentInfo(w);

        AppClass app = new AppClass();
        app.saveStudentInfo(a);
    }
}
