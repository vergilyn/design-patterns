package com.vergilyn.examples.design.behavioral.template_method;

/**
 * web登记形式必须登记：兴趣爱好
 * @author VergiLyn
 * @bolg http://www.cnblogs.com/VergiLyn/p/6243626.html
 * @date 2017/1/2
 */
public class WebClass extends TemplateClass {
    @Override
    public void saveAfter(StudentBean bean) {
        //any code
    }

    @Override
    public void saveBefore(StudentBean bean) {
        bean.setRegisterType(StudentBean.TYPE_WEB);
        bean.setHobby("吃饭睡觉打豆豆");
    }
}
