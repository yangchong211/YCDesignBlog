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
              title: new Text("1.吐司工具，位置设置在中间"),
              onTap: (){
                YcToast.showToast(
                  title: "普通吐司一下",
                  toastLength: Toast.LENGTH_LONG,
                );
              },
            ),
            new Divider(),
            new ListTile(
              title: new Text("2.吐司工具，设置背景和字体颜色"),
              onTap: (){
                YcToast.showToast(
                    title: "This is Colored Toast with android duration of 5 Sec",
                    toastLength: Toast.LENGTH_SHORT,
                    backgroundColor: Colors.black87,
                    textColor: Colors.white);
              },
            ),
            new Divider(),
            new ListTile(
              title: new Text("1.吐司工具，位置设置在中间"),
              onTap: (){
              },
            ),
            new Divider(),
          ],
        ),
      ),
    );
  }



}

