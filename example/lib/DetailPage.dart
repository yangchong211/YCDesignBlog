

import 'package:flutter/material.dart';
import 'package:yc_toast/yc_toast.dart';
/*
 * <pre>
 *     @author yangchong
 *     blog  : https://github.com/yangchong211
 *     time  : 2019/5/30
 *     desc  : 详情页面
 *     revise:
 * </pre>
 */
class DetailPage extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    return new DetailState();
  }

}

class DetailState extends State<DetailPage>{

  @override
  initState() {
    super.initState();
  }


  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('这个是详情页'),
      ),
      body: new ListView(
        children: <Widget>[
          new ListTile(
            title: new Text("1.吐司工具，位置设置在中间"),
            onTap: (){
              showShortToast();
            },
          ),
          new Divider(),
          new ListTile(
            title: new Text("1.吐司工具，位置设置在中间"),
            onTap: (){
              showLongToast();
            },
          ),
          new Divider(),
          new ListTile(
            title: new Text("1.吐司工具，位置设置在中间"),
            onTap: (){
              YcToast.showToast(title: "逗比，吐司一下");
            },
          ),
          new Divider(),
        ],
      ),
    );
  }



  void showLongToast() {
    YcToast.showToast(
      title: "This is Long Toast",
      toastLength: Toast.LENGTH_LONG,
    );
  }

  void showColoredToast() {
    YcToast.showToast(
        title: "This is Colored Toast with android duration of 5 Sec",
        toastLength: Toast.LENGTH_SHORT,
        backgroundColor: Colors.red,
        textColor: Colors.white);
  }

  void showShortToast() {
    YcToast.showToast(
        title: "This is Short Toast",
        toastLength: Toast.LENGTH_SHORT,
        );
  }

  void showTopShortToast() {
    YcToast.showToast(
        title: "This is Top Short Toast",
        toastLength: Toast.LENGTH_SHORT,
        gravity: ToastGravity.TOP,
        );
  }

  void showCenterShortToast() {
    YcToast.showToast(
        title: "This is Center Short Toast",
        toastLength: Toast.LENGTH_SHORT,
        gravity: ToastGravity.CENTER,
        );
  }


}



