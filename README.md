# EX3
## 一.SimpleAdapter
### 1.设计思路
#### （1）先在SimpleAdapter.xml里添加ListView
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/list_item.xml.png)
####  (2)再创建一个list_item.xml
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/simpleadapter.xml.png)
####  (3)SimpleAdapter的五个参数：
         * Context:上下文

         * data：数据源（List<Map<String,?>>data）一个有Map组成的集合

         *       每一个Map都会对应ListView列表中的一行

         *       每一个Map(键-值对)中的键必须包含所有在from参数中所指定的键

         *resource: ListView中每一项的布局文件ID

         *from：Map中的键名

         *to：绑定item.xml文件中的view控件ID，与from，Map的键形成对应
####  (4)创建一个java类ItemData来存放data
####  (5)在SimpleAdapterActiviry里创建出SimpleAdapter
### 2.运行截图
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/simpledapter.jpg)
#### 点击列表中的一个选项，会跳出其的toast信息
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/simpleadapter1.jpg)
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/simpleadapter2.jpg)
## 二.AlertDialog
### 1.设计思路
#### （1）在AlertDialog.xml里添加两个EditText
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/aletdialog.xml.png)
#### （2）在AlertDialogActivity里创建出AlertDialog
### 2.运行截图
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/aletdialog1.png)
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/aletdialog2.png)
