package people;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JOptionPane;

import Based.AdminerDao;
import Based.Basedao;
import imp.Good;

public class Costumer {
	AdminerDao Adminer=new AdminerDao();
	Basedao bd= new Basedao();
	//��ѯgoods�б�
    public String show(){
    	String str = "";
        try {
            List<Good> Goods=Adminer.selectgoods();
            for (Good good:Goods){
                str+=(good+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
    //������Ʒ
    public String bug() {
    	String str="";
    	Good good = null;
    	String id;
    	String statue;
    	boolean tag=true;
    	int num=0;
    	int bfnum=0;
    	double total=0;
    	double money=0;
    	while(tag){
    		id=JOptionPane.showInputDialog("��������Ʒid:");
    		
    		num=Integer.parseInt(JOptionPane.showInputDialog("�����빺������:"));
    		try {
				good=Adminer.selectgood(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		bfnum=good.getNum();
    		money=num*good.getPrice();
    		total+=money;
    		good.setNum(bfnum-num);
    		try {
				Adminer.updategood(good);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		str+="�㹺����"+num+"��"+good.getName()+"�ϼ�"+money+"\n";
    		statue=JOptionPane.showInputDialog("�Ƿ����yes/no?");
    		if(statue.endsWith("no")) {
    			tag=false;
    		}
		};
		return str+"һ���ϼ�"+total+"Ԫ";
    }
    //�˻�
    public String update_good(String id,int num) throws Exception{
    	Good good=Adminer.selectgood(id);
    	int bfnum=num+good.getNum();
    	double money=num*good.getPrice();
    	good.setNum(bfnum);
    	int i=Adminer.updategood(good);
    	if (i!=0) {
    		return "�˻��ɹ���Ӧ�ˣ�"+money;
		}
    	else {
    		return "�˻�ʧ��";
		}
	}
   //�鿴���
    public String bianhao(int id) throws Exception {
    	String str="";
    	ResultSet rs=Adminer.selectbianhao(id);
    	while (rs.next()) {
			str=rs.getString("content");			
		}
		return str;
	}
}
