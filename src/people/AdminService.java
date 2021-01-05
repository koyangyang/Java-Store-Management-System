package people;

import Based.AdminerDao;
import imp.Good;

import java.util.List;
import java.util.Scanner;

public class AdminService {
    AdminerDao Adminer=new AdminerDao();
    //user登录方法
    public String login(String name,String pwd) throws Exception{
            if(Adminer.login(name,pwd)){
                return "Admin:"+name+"登陆成功";
            }
            else {
                return null;
            }
    }
    
    //查询goods列表
    public String show(){
    	String str = "";
        try {
            List<Good> Goods=Adminer.selectgoods();
            for (Good good:Goods){
            	if(good.getNum()==0) {
            		continue;
            	}
                str+=(good+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
    
    //插入good(商品)方法
    public String insert_good(String id,String name,double price,int num) throws Exception {
    	Good new_good=new Good();
    	new_good.setId(id);
    	new_good.setName(name);
    	new_good.setNum(num);
    	new_good.setPrice(price);
    	int rs=Adminer.insertgood(new_good);
    	if(rs!=0) {
    		return "添加成功";
    	}
    	return "添加失败";
	}
    
    //更新商品数量
    public String update_good(String id,String name,double price,int num) throws Exception{
    	Good new_good=new Good();
    	new_good.setId(id);
    	new_good.setName(name);
    	new_good.setNum(num);
    	new_good.setPrice(price);
    	int i=Adminer.updategood(new_good);
    	if (i!=0) {
    		return "更新成功";
		}
    	else {
    		return "更新失败";
		}
	}
}
