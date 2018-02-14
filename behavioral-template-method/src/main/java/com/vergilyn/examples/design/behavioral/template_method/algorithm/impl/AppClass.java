package com.vergilyn.examples.design.behavioral.template_method.algorithm.impl;

import com.vergilyn.examples.design.behavioral.template_method.algorithm.TemplateClass;
import com.vergilyn.examples.design.behavioral.template_method.bean.StudentBean;

/**
 * app登记形式必须登记: 电话号码
 * @author VergiLyn
 * @blog http://www.cnblogs.com/VergiLyn/p/6243626.html
 * @date 2017/1/2
 */
public class AppClass extends TemplateClass {

    @Override
    public void saveAfter(StudentBean bean) {
        //any code
    }

    @Override
    public void saveBefore(StudentBean bean) {
        bean.setRegisterType(StudentBean.TYPE_APP);
        bean.setPhoneNumber("10086");
    }
}
