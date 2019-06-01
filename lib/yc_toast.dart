
import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';


//参考案例：https://juejin.im/post/5c123e0c6fb9a049ff4dffbe

enum Toast { LENGTH_SHORT, LENGTH_LONG }

enum ToastGravity { TOP, BOTTOM, CENTER }

class YcToast {

  //这个与Android中的channel要对应相同
  static const  channel = "yc/flutter_toast";
  //这个show和cancel要和Android中对应
  static const  yc_show_toast = "yc_show_toast";
  static const  yc_cancel_toast = "yc_cancel_toast";

  //创建channel数据通道
  static const MethodChannel _channel = const MethodChannel(channel);

  ///取消吐司
  static Future<bool> cancel() async {
    bool res = await _channel.invokeMethod(yc_cancel_toast);
    return res;
  }

  ///直接吐司
  static Future<bool> showToast({
    //吐司标题，这个参数是必须的，需要用@required修饰
    @required String title,
    //吐司内容，不必须
    String desc,
    //吐司控件的圆角半径，默认是5
    double radius = 5,
    //吐司时间
    Toast toastLength,
    //吐司title的文字大小
    double fontSize = 16.0,
    //吐司位置
    ToastGravity gravity,
  }) async {
    //吐司时间
    String length = "short";
    if (toastLength == Toast.LENGTH_LONG) {
      length = "long";
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

    final Map<String, dynamic> params = <String, dynamic>{
      'title': title,
      'desc': desc,
      'radius':radius,
      'length': length,
      'gravity': gravityToast,
      'fontSize': fontSize,
    };
    bool isSuccess = await _channel.invokeMethod(yc_show_toast, params);
    print("flutter-onMethodCall--"+isSuccess.toString());
    return isSuccess;
  }



}
