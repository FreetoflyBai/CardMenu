反xposed框架

调用XPOSED installXposed 或者 crashXposed 检测
调用XPOSED disabledHook 反hook


Native 检测代码如下：

bool is_xposed()
{
   bool rel = false;
   FILE *fp = NULL;
   char* filepath = "/proc/self/maps";
   ...
   string xp_name = "XposedBridge.jar";
   fp = fopen(filepath,"r")) 
   while (!feof(fp))                                 
   {
       fgets(strLine,BUFFER_SIZE,fp);                    
       origin_str = strLine;
       str = trim(origin_str);
       if (contain(str,xp_name))
       {
           rel = true; //检测到Xposed模块
           break;
       }
   }
	...
}

