 虚拟机检测
 
 CHECKJVM checkjvm=CHECKJVM.with(this);
 checkjvm.setDebug(false);
 checkjvm.setCheckQumeProps(false);
 boolean bool=checkjvm.detect();