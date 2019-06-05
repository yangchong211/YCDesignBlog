# YCFlutterToast flutter版本的吐司库，使用十分方便
#### 目录介绍
- 01.flutter版吐司介绍
- 02.具有的优势分析
- 03.使用说明文档
- 04.相关的属性介绍
- 05.优化点说明
- 06.自定义吐司图片展示
- 07.遇到的问题介绍
- 08.其他更多内容


### 01.flutter版吐司介绍
- flutter中没有吐司这个widget，所以想要用吐司，则可以用原生java或者kotlin代码实现吐司效果。然后通过MethodChannel数据通道，flutter和Android建立连接，既可以让flutter调用到Android中的吐司，达到想要的效果。
- 自定义吐司支持设置吐司标题，内容，背景颜色，文字颜色，字体大小，背景圆角，吐司时间等等。系统吐司则只可设置文字。可以直接运行example中的main.dart查看实际效果！



### 02.具有的优势分析
- 自定义吐司，可以设置多种属性，可以满足不同的需求场景。同时可以手动设置吐司取消状态等等。


### 03.使用说明文档
- yc_toast依赖方式
    - 待更新，暂时无法上传到pub上，可以看07问题介绍，要是有人提出解决方案就好了。
- flutter调用吐司介绍
    - 最简单的吐司
    ```
    YcToast.showToast(
      title: "逗比吐司",
    );
    ```
    - 设置位置在中间
    ```
    YcToast.showToast(
        title: "逗比吐司",
        toastLength: Toast.LENGTH_SHORT,
        gravity: ToastGravity.CENTER);
    ```
    - 设置字体大小
    ```
    YcToast.showToast(
        title: "逗比",
        fontSize: 14,);
    ```
    - 设置吐司圆角
    ```
    YcToast.showToast(
        title: "逗比",
        radius:25,
        gravity: ToastGravity.CENTER);
    ```
    - 设置背景和颜色
    ```
    YcToast.showToast(
        title: "逗比",
        desc: "这个是内容",
        toastLength: Toast.LENGTH_SHORT,
        fontSize: 14,
        radius:20,
        bgColor: Color(0xFFB71C1C),
        textColor: Color(0xFF4A148C),
        gravity: ToastGravity.CENTER,);
    ```
    - 设置系统吐司
    ```
    YcToast.showToast(
        title: "逗比",
        type: Type.SYSTEM,
        toastLength: Toast.LENGTH_SHORT);
    ```
- 如何取消吐司呢？
    ```
    YcToast.cancel();
    ```



### 04.相关的属性介绍
- 调用show吐司的参数说明
    - 其中，title是必须要传递的参数。其他可以选择性传递参数……
    ```
    static Future<bool> showToast({
        //吐司标题，这个参数是必须的，需要用@required修饰
        @required String title,
        //吐司类型，这个参数是必须的
        Type type,
        //吐司内容，不必须
        String desc,
        //吐司控件的圆角半径，默认是5
        double radius = 10,
        //吐司时间
        Toast toastLength,
        //吐司title的文字大小
        double fontSize = 16.0,
        //吐司位置
        ToastGravity gravity,
        //吐司标题颜色
        Color textColor,
        //吐司背景颜色
        Color bgColor,
    })
    ```
- 几个枚举属性介绍
    ```
    ///吐司类型，SYSTEM是系统默认吐司，CUSTOM是自定义吐司
    enum Type { SYSTEM, CUSTOM }
    ///吐司时间
    enum Toast { LENGTH_SHORT, LENGTH_LONG }
    ///吐司的位置
    enum ToastGravity { TOP, BOTTOM, CENTER }
    ```
- 部分参数默认值说明，代码如下所示
    - 可以发现，吐司时间默认是short，吐司类型默认是自定义，吐司位置默认值底部的，吐司颜色默认白色文字，黑色背景。
    ```
     async {
        //吐司时间
        String length = "short";
        if (toastLength == Toast.LENGTH_LONG) {
          length = "long";
        }

        //吐司类型
        String typeToast = "SYSTEM";
        if(type == Type.SYSTEM){
          typeToast = "SYSTEM";
        }else{
          typeToast = "CUSTOM";
        }

        //吐司位置
        String gravityToast = "center";
        if (gravity == ToastGravity.TOP) {
          gravityToast = "top";
        } else if (gravity == ToastGravity.CENTER) {
          gravityToast = "center";
        } else {
          gravityToast = "bottom";
        }

        //吐司背景颜色
        if(bgColor == null) {
          bgColor = Colors.black;
        }

        //吐司标题颜色
        if(textColor == null) {
          textColor = Colors.white;
        }

        final Map<String, dynamic> params = <String, dynamic>{
          'title': title,
          'desc': desc,
          'typeToast':typeToast,
          'radius':radius,
          'length': length,
          'gravity': gravityToast,
          'fontSize': fontSize,
          'bgColor': bgColor != null ? bgColor.value : null,
          'textColor': textColor != null ? textColor.value: null,
        };
        bool isSuccess = await _channel.invokeMethod(yc_show_toast, params);
        print("flutter-onMethodCall--"+isSuccess.toString());
        return isSuccess;
      }
    ```


### 05.优化点说明
- 注意问题
    - 关于MethodChannel数据通道需要一个CHANNEL名称需要对应一样，否则无法通信。
    ```
    //在flutter中
    //这个与Android中的channel要对应相同
    static const  channel = "yc/flutter_toast";
    //创建channel数据通道
    static const MethodChannel _channel = const MethodChannel(channel);


    //在kotlin中
    companion object {
        // ANDROID_CHANNEL 是我们 method channel 的名称，很重要，Dart 代码里还需要用到它。
        private const val ANDROID_CHANNEL = "yc/flutter_toast"

        @JvmStatic
        fun registerWith(registrar: Registrar) {
            val channel = MethodChannel(registrar.messenger(), ANDROID_CHANNEL)
            val context = registrar.context()
            channel.setMethodCallHandler(YcToastPlugin(context))
        }
    }
    ```




### 07.遇到的问题介绍
- 01.flutter Failed to handle method call
    - 问题：flutter无法处理方法调用，查看channel名称是否一致。注意，flutter和Android原生通信的channel字段要一样哦！
- 02.pub上传失败
    - 错误场景：
        - 已经通过西游vpn翻墙，已经通过flutter packages pub publish指令提交代码，同时也打开了提示中的链接https:开头，以.email结尾的地址授权。最后还是报错！
        - 网上有说下面的错误产生的根源是，需要给终端设置代理，也就是命令行代理。但是不知道window端该如何解决……参考文章链接：[发布失败问题解决](https://blog.csdn.net/qq_26287435/article/details/89313269)
    - 错误日志：
        ```
        Pub needs your authorization to upload packages on your behalf.
        In a web browser, go to https://accounts.google.com/o/oauth2/auth?access_type=offline&approval_prompt=force&response_type=code&client_id=818368855108-8grd2eg9tj9f38os6f1urbcvsq399u8n.apps.googleusercontent.com&redirect_uri=http%3A%2F%2Flocal
        host%3A53203&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email
        Then click "Allow access".

        Waiting for your authorization...
        Authorization received, processing...
        It looks like accounts.google.com is having some trouble.
        Pub will wait for a while before trying to connect again.
        OS Error: 信号灯超时时间已到
        , errno = 121, address = accounts.google.com, port = 53491
        pub finished with exit code 69
        ```


### 08.其他更多内容
#### 关于博客汇总链接
- 1.[技术博客汇总](https://www.jianshu.com/p/614cb839182c)
- 2.[开源项目汇总](https://blog.csdn.net/m0_37700275/article/details/80863574)
- 3.[生活博客汇总](https://blog.csdn.net/m0_37700275/article/details/79832978)
- 4.[喜马拉雅音频汇总](https://www.jianshu.com/p/f665de16d1eb)
- 5.[其他汇总](https://www.jianshu.com/p/53017c3fc75d)


#### 其他推荐
- 博客笔记大汇总【15年10月到至今】，包括Java基础及深入知识点，Android技术博客，Python学习笔记等等，还包括平时开发中遇到的bug汇总，当然也在工作之余收集了大量的面试题，长期更新维护并且修正，持续完善……开源的文件是markdown格式的！同时也开源了生活博客，从12年起，积累共计47篇[近20万字]，转载请注明出处，谢谢！
- 链接地址：https://github.com/yangchong211/YCBlogs
- 如果觉得好，可以star一下，谢谢！当然也欢迎提出建议，万事起于忽微，量变引起质变！


#### 关于LICENSE
```
Copyright 2017 yangchong211（github.com/yangchong211）

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```








