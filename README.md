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
+ 创建指向文件B的字节输入流（源文件）:FileInputStream  
+ 创建指向文件A的字节输出流（目的文件）:FileOutputStream  
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
+ 定义7个长度的字符数组，并用缓冲输入流的read方法读取数组使其七个字对齐；  
+ 用while方法读取数组，并将其写入目的文件；    
+ if语句判断奇偶数，奇数加逗号，偶数加句号。  
+ 上述代码如下：  
```
char[] buff = new char[7];        //定义char数组，长度为7
            int len = reader.read(buff);      //从输入流文件读取一个char数组长度
            int index = 1;              
            while (len != -1) {
                writer.write(buff,0,len);     //使用write方法将输入流文件的字符数量（7）写入输出流文件
                if (index %2 ==0){            //判断奇数偶数
                    writer.write("。\n");     //当为偶数时，加句号并换行
                }else{
                    writer.write("，");       //当为奇数时，加逗号
                }
                len = reader.read(buff);      //增加输入流文件的长度
                index++;
                
            }
```  
+ 最后关闭流  
+ 创建缓冲流读取源文件，用read方法读取文件行数；  
+ 再从键盘接收学生要查询的古诗关键字，并判断行数中是否包含其关键字，是则次数加1，不是则忽略；判断下一行。    
+ 上述步骤如下：  
```
FileInputStream input1=new FileInputStream("C:\\Users\\13062\\Desktop\\A.txt");    
			  BufferedReader reader1=new BufferedReader(new InputStreamReader(input1));     
				String s = reader1.readLine(); //读取行数 
				System.out.println("请输入要查询的古诗关键字：");
				Scanner sc=new Scanner(System.in);//从键盘接收数据
				String str=sc.nextLine();
				char[] ch=str.toCharArray();       //将字符串转换为字符数组
				int count=0;
		        while (s != null) //确定行数不为空
				{            
					boolean b=s.contains(str);//子字符串是否被包含在此字符串之中,包含输出true，否则输出false
					String[] st=new String[s.length()-ch.length+1];			
					if(b==true)
					{
						for(int i=0;i<st.length;i++)
						{
							st[i]= s.substring(i,i+ch.length);  
							if(st[i].equals(str))     //判断内容是否相等
							{
								count++;
							}
						}
					}
					s = reader1.readLine();     //读取行数
		        } 
				System.out.println("古诗中包含 "+str+" 字的"+" 次数为："+count+"次");//调用count，输出包含次数
			
	}
```  
+ 判断异常FileNotFoundException、IOException  
2. 学生类：  
+ 定义学生的姓名、性别、班级信息  
## 实验结果  
![alt=点击图片](http://m.qpic.cn/psc?/V51PA3o90d17IF0JFyFi0lN3aB2Fw6re/bqQfVz5yrrGYSXMvKr.cqSv2B2nkM9wBDalZdDOlNfvafSft2f0iEscGcUCmUDKahWBhr75V8J*j2jfRtKf8P9SVENBmmrF71GEtSin*FDU!/b&bo=BgL5AAAAAAADB98!&rf=viewer_4)  
## 实验感想  
&nbsp;&nbsp; &nbsp;&nbsp; 通过此次对字符串的处理，了解了字节流与字符流的使用及基本方法，懂得缓冲流的作用，并学会利用这些类的方法去操作文件及文件内容，以及异常的处理。

