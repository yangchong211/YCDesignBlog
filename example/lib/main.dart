import 'package:flutter/material.dart';
import 'package:yc_toast/yc_toast.dart';
void main() => runApp(MyApp());



class MyApp extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return new AppState();
  }

}

class AppState extends State<MyApp>{

  @override
  initState() {
    super.initState();
  }


  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      home: new Scaffold(
        appBar: new AppBar(
          title: new Text('小杨逗比吐司工具库'),
        ),
        body: new ListView(
          children: <Widget>[
            new ListTile(
              title: new Text("1.吐司工具，最简单的吐司"),
              onTap: (){
                YcToast.showToast(
                  title: "普通吐司一下",
                );
              },
            ),
            new Divider(),
            new ListTile(
              title: new Text("2.吐司工具，设置背景和字体颜色"),
              onTap: (){
                YcToast.showToast(
                    title: "逗比吐司",
                    toastLength: Toast.LENGTH_SHORT,
                    gravity: ToastGravity.CENTER);
              },
            ),
            new Divider(),
            new ListTile(
              title: new Text("3.吐司工具，设置位置在中间"),
              onTap: (){
                YcToast.showToast(
                    title: "逗比",
                    toastLength: Toast.LENGTH_SHORT,
                    fontSize: 14,
                    gravity: ToastGravity.CENTER);
              },
            ),
            new Divider(),
            new ListTile(
              title: new Text("4.吐司工具，设置吐司圆角"),
              onTap: (){
                YcToast.showToast(
                    title: "逗比",
                    toastLength: Toast.LENGTH_SHORT,
                    fontSize: 14,
                    radius:15,
                    gravity: ToastGravity.CENTER);
              },
            ),
            new Divider(),
          ],
        ),
      ),
    );
  }



}

