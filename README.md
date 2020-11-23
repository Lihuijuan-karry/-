# 计G201 李慧娟 2020322067
## 字符串方法及文件读取
## 实验目的  
掌握字符串String及其方法的使用   
掌握文件的读取/写入方法  
掌握异常处理结构 
## 实验要求
1. 存储学生基本信息及作业处理结果到A文件中  
2. 作业输入来源于B文件  
3. 加入异常处理  
4. 作业处理要求：  
&nbsp; 古诗整理对齐：七言律诗  
&nbsp; 奇数加逗号，偶数加句号。  
&nbsp; 从键盘输入参数，并统计该参数在古诗中出现的次数  
5. 采用交互式实例化学生  
## 实验过程
1. Information类：  
+ 采用交互式（Scanner类）实例化学生:从键盘输入学生姓名，性别，班级  
+ 创建指向文件B的输入流（源文件）:FileInputStream  
+ 创建指向文件A的输出流（目的文件）:FileOutputStream  
+ 创建缓冲输入、输出流增强文件读写能力：可以按行读取文件  
+ 使用缓冲流的write方法将学生基本信息写入目的文件A  
+ 上述步骤代码如下：
 ```  
   System.out.println("请输入姓名，性别，班级：");
        Scanner stu1=new Scanner(System.in);
        String name=stu1.next();
        String sex=stu1.next();
        String grade=stu1.next();
        FileInputStream in = new FileInputStream("C:\\Users\\13062\\Desktop\\B.txt");      //创建指向文件B.txt的输入流
              FileOutputStream out=new FileOutputStream("C:\\Users\\13062\\Desktop\\A.txt");     //创建指向文件A.txt的输出流
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));           //缓冲输出流
              BufferedReader reader = new BufferedReader(new InputStreamReader(in));             //缓冲输入流
              writer.write("学生基本信息："+"姓名： "+name+"  "+"性别： "+sex+"   "+" 班级： "+grade+"\n"+"处理后的作业结果如下："+"\n");    
  ```   
+ 定义7个长度的字符数组，并用缓冲输入流的read方法读取数组  
