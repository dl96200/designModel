package proxy;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 实现思路
 * 通过Poxy.newProxyInstance
 * loader 类加载器
 * interfaces 实现接口
 * handler InvocationHandler
 * 1,声明一段源码（动态代理产生）
 * 2,编译源码（JDK Compiler API）,产生新的类（代理类）
 * 3,将这个类load到内存当中，产生一个新的代理对象（代理对象）
 * 4,return 代理对象
 */
public class Proxy {
    public static Object newProxyInstance(ClassLoader loader, Class ice, InvocationHandler handler ) throws Exception {
        if(ice == null ) {
            throw new IllegalArgumentException("ice error");
        }

        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        String fileName = dir+"/out/proxy/$Proxy0.java";
        File file = new File(fileName);
        int count = 0;
        while(file.exists()){
            fileName = dir+"/out/proxy/$Proxy"+ ++count+".java";
            file = new File(fileName);

        }
        //生成源码
        String fileData = getFileData(ice,handler,count);
        //源码写入文件
        FileUtils.writeStringToFile(file,fileData,"UTF-8");

        //编译文件
        JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
        //文件管理者
        StandardJavaFileManager standardJavaFileManager = jc.getStandardFileManager(null,null,null);
//        jc.getTask()
        //获取文件
        Iterable iterable = standardJavaFileManager.getJavaFileObjects(fileName);
        //编译文件
        JavaCompiler.CompilationTask task = jc.getTask(null,standardJavaFileManager,null,null,null,iterable);
        task.call();
        standardJavaFileManager.close();

        //class文件加载到内存当中'
        Class clazz = loader.loadClass("proxy.$Proxy"+count);
        System.out.println(clazz.getName());
        Constructor ctr = clazz.getConstructor(InvocationHandler.class);
        return ctr.newInstance(handler) ;
    }

    private static String getFileData(Class ice,InvocationHandler handler,int count) {
        String st = "\r\n";
        //源码
        String str = "package proxy;"+st+
                "import java.lang.reflect.Method;"+st+
                "public class $Proxy"+count+" implements "+ice.getSimpleName()+"{"+st+
                "    public InvocationHandler handler;"+st +
                "    public $Proxy"+count+"(InvocationHandler handler) {"+st +
                "        this.handler = handler;"+st +
                "    }"+st;
        for (Method method: ice.getMethods()) {
            str += "    @Override"+st+
                    "    public "+method.getReturnType().getName()+" "+method.getName()+"() {"+st+
                    "       try{"+st+
                    "           Method m= "+ice.getSimpleName()+".class.getMethod(\""+method.getName()+"\");"+st+
                    "           handler.invoke(this,m);"+st+
                    "       }catch (Exception e){"  +st+
                    "           e.printStackTrace();"  +st+
                    "       }" +st+
                    "   }"+st+
                    "}"+st;
        }
        return str;
    }

    public static void main(String[] args) throws Exception{
        final CarImpl carImpl = new CarImpl();
        Car car = (Car) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), Car.class, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method m, Object... o) {
                try {
                    System.out.println("run start:"+System.currentTimeMillis());
                    m.invoke(carImpl);
                    System.out.println("run end:"+System.currentTimeMillis());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
        car.run();
    }
}
