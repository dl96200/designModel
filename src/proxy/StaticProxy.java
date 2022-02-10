package proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现相同接口方便互相引用传递
 */
public class StaticProxy {
    public static void main(String[] args) {

        Car runImpl = new CarImpl();
//        1,静态代理：实现相同接口方便互相引用传递
//        Car timeProxy = new CarTimeProxy(runImpl);
//        Car logProxy = new CarLogProxy(timeProxy);
//        logProxy.run();

//        2,静态代理：实现chain方式
        ProxyChain proxyChain = new ProxyChain();
        ProxyChain proxyChain1 = new ProxyChain();
        ProxyChain proxyChain2 = new ProxyChain();
        ProxyChain proxyChainTime = new ProxyChainTime();
        ProxyChain proxyChainLog = new ProxyChainLog();
        proxyChain1.addChain(proxyChainTime).addChain(proxyChainLog);
        proxyChain2.addChain(proxyChainTime).addChain(proxyChainLog);
        proxyChain.addChain(proxyChain1).addChain(proxyChain2).addChain(proxyChainTime).setCarImpl(runImpl);
        proxyChain.run();

    }

}

interface ProxyChainI extends Car{
    void setCarImpl(Car runImpl);
    ProxyChainI addChain(ProxyChainI proxyChain);
    void before();
    void after();
}
class ProxyChain implements ProxyChainI{
    Car runImpl;
    private List<ProxyChainI> chainIList ;
    public ProxyChainI addChain(ProxyChainI proxyChain){
        if(this.chainIList == null) {
            chainIList = new ArrayList<>();
        }
        chainIList.add(proxyChain);
        return this;
    }
    @Override
    public void run() {
        this.before();
        if(this.runImpl!=null) {
            this.runImpl.run();
        }
        this.after();
    }

    public void before(){
        for(int i=0;i<chainIList.size(); i++) {
            chainIList.get(i).before();
        }
    }

    public void after(){
        for(int i=chainIList.size()-1;i>=0; i--) {
            chainIList.get(i).after();
        }
    }

    public void setCarImpl(Car runImpl){
        this.runImpl = runImpl;
    }

}

class ProxyChainTime extends ProxyChain{
    @Override
    public void before(){
        System.out.println("before time"+System.currentTimeMillis());
    }
    @Override
    public void after(){
        System.out.println("after time"+System.currentTimeMillis());
    }
}

class ProxyChainLog extends ProxyChain{
    @Override
    public void before(){
        System.out.println("before log"+System.currentTimeMillis());
    }
    @Override
    public void after(){
        System.out.println("after log"+System.currentTimeMillis());
    }
}

class CarTimeProxy implements Car{
    Car runImpl;
    public CarTimeProxy(Car runImpl) {
        this.runImpl = runImpl;
    }
    public void run() {
        System.out.println("run start:"+System.currentTimeMillis());
        this.runImpl.run();
        System.out.println("run end:"+System.currentTimeMillis());
    }
}


class CarLogProxy implements Car{
    Car runImpl;
    public CarLogProxy(Car runImpl) {
        this.runImpl = runImpl;
    }
    public void run() {
        System.out.println("run log:"+System.currentTimeMillis());
        this.runImpl.run();
        System.out.println("run log:"+System.currentTimeMillis());
    }
}


