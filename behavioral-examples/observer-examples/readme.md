# observer-examples

1. observer
2. publish-subscribe

## 场景
　　比如weibo, 当用户关注了一个博主时, 当博主更新weibo时通知所有关注者.

+ Subject: 抽象主题（抽象被观察者），抽象主题角色把所有观察者对象保存在一个集合里，每个主题都可以有任意数量的观察者，抽象主题提供一个接口，可以增加和删除观察者对象。
+ ConcreteSubject: 具体主题（具体被观察者），该角色将有关状态存入具体观察者对象，在具体主题的内部状态发生改变时，给所有注册过的观察者发送通知。
+ Observer: 抽象观察者，是观察者者的抽象类，它定义了一个更新接口，使得在得到主题更改通知时更新自己。
+ ConcreteObserver: 具体观察者，实现抽象观察者定义的更新接口，以便在得到主题更改通知时更新自身的状态。

用户就是观察者, 博主就是是被观察者, 有多个的用户关注了"zard"这个微博, 当更新时就会通知这些关注的用户.

拉模式: 用户主动去获取更新的信息
推模式: 不管用户需求, 直接推送个用户


3.使用观察者模式的场景和优缺点
使用场景
关联行为场景，需要注意的是，关联行为是可拆分的，而不是“组合”关系。
事件多级触发场景。
跨系统的消息交换场景，如消息队列、事件总线的处理机制。
优点
解除耦合，让耦合的双方都依赖于抽象，从而使得各自的变换都不会影响另一边的变换。

缺点
在应用观察者模式时需要考虑一下开发效率和运行效率的问题，程序中包括一个被观察者、多个观察者，开发、调试等内容会比较复杂，而且在Java中消息的通知一般是顺序执行，那么一个观察者卡顿，会影响整体的执行效率，在这种情况下，一般会采用异步实现。