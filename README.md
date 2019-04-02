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
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/simpledapter1.jpg)
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/simpledapter2.jpg)
## 二.AlertDialog
### 1.设计思路
#### （1）在AlertDialog_layout.xml里添加两个EditText
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/alertdialog_layout.png)
#### （2）在AlertDialogActivity里创建出AlertDialog
### 2.运行截图
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/alertdialog1.jpg)
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/alertdialog2.jpg)
## 三.XML
### 1.设计思路
#### （1）在Xml.xml里添加一个TextView
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/xml.xml.png)
#### （2）创建一个menu，在menu里添加菜单布局
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/menu.xml.png)
#### （3）在XmlActivity里创建出Xml
### 2.运行截图
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/xml.jpg)
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/xml1.jpg)
#### (1)字体大小
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/size.jpg)
##### 小
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/small.jpg)
##### 中
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/middle.jpg)
##### 大
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/big.jpg)
#### (2)普通菜单项
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/toast.jpg)
#### （3）字体颜色
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/color.jpg)
##### 红色
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/red.jpg)
##### 黑色
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/black.jpg)
## 四.ActionMode
### 1.设计思路
#### （1）先跟SimpleAdapter一样，创建出一个适配器来放列表
#### （2）创建出上下文菜单
#### （3）创建出在导航栏的菜单进行信息提示
#### （4）在ActionModeAdapter中创建出ActionMode
### 2.运行截图
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/actionmode.jpg)
#### 长按一个列表，会跳出上下文菜单
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/select1.jpg)
#### 选择两个
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/select2.jpg)
#### 删除
![linearlayout](https://github.com/PresidentChao/EX3/blob/master/delete.jpg)
