package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Information {
	Student stu=new Student();
	public static void main(String[] args){
		try
		{
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
            reader.close();
            writer.close();
			in.close();
			out.close(); 
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
		catch(FileNotFoundException e)
		{
			System.out.println("文件找不到");
		}
		catch(IOException e)
		{
			System.out.println("输入路径错误");
		}
	}
}
