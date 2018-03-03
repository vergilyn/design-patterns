# Publish Subscribe

##
　　PUB/SUB应该算是Observer的一种"变型", 也算是"行为模式"的其中一种.  
　　Observer: 它定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象在状态变化时，会通知所有的观察者对象，使他们能够自动更新自己。  

## PUB/SUB在Redisson中的应用
　　假设有10个线程(t0...t9)并发竞争锁"lock_xx", 当t0获取锁时, 其余线程只能等待t0释放锁. 当t0释放锁时, 通知t1...t9让它们去竞争锁.

　　以前会想到的做法如下:  
```
    public boolean tryLock(long waitTime){
        long time = System.currentTimeMillis();
        
        while(true){
            // 判断是否等待超时
            if(waitTime < System.currentTimeMillis() - time){
                throw new TimeoutException();
            }
            
            // 获取锁的代码
            
            // 否则, 等待一会再尝试获取
            Thread.sleep(200);
        }
        return false;
    }
``` 
　　