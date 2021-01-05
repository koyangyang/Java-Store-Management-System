package people;

import Based.AdminerDao;
import imp.Good;

import java.util.List;
import java.util.Scanner;

public class AdminService {
    AdminerDao Adminer=new AdminerDao();
    //user��¼����
    public String login(String name,String pwd) throws Exception{
            if(Adminer.login(name,pwd)){
                return "Admin:"+name+"��½�ɹ�";
            }
            else {
                return null;
            }
    }
    
    //��ѯgoods�б�
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
    
    //����good(��Ʒ)����
    public String insert_good(String id,String name,double price,int num) throws Exception {
    	Good new_good=new Good();
    	new_good.setId(id);
    	new_good.setName(name);
    	new_good.setNum(num);
    	new_good.setPrice(price);
    	int rs=Adminer.insertgood(new_good);
    	if(rs!=0) {
    		return "��ӳɹ�";
    	}
    	return "���ʧ��";
	}
    
    //������Ʒ����
    public String update_good(String id,String name,double price,int num) throws Exception{
    	Good new_good=new Good();
    	new_good.setId(id);
    	new_good.setName(name);
    	new_good.setNum(num);
    	new_good.setPrice(price);
    	int i=Adminer.updategood(new_good);
    	if (i!=0) {
    		return "���³ɹ�";
		}
    	else {
    		return "����ʧ��";
		}
	}
}
