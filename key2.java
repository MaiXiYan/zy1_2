import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class key2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        ArrayList list2 =  new ArrayList(16);
        System.out.println("请输入16位以下的密码：");
        Scanner sc = new Scanner(System.in);
        //String str1=sc.nextLine();
        list.add(sc.nextLine());

        //System.out.println(str1);
        //

        for (String rawPassword:list){
            System.out.println(rawPassword);
        }
        System.out.println("请再次输入密码：");
        String rawPassword=sc.next();
        System.out.println(rawPassword);
        //
        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));


        System.out.print("经过加密后的密码是：");

        //(1)将每个字符的ASCII码加上它在字符串中的位置(1开始)和偏移值3
        int num[] = new int[16];
        System.out.println();
        for (int i = 0; i < rawPassword.length(); i++) {
            if (rawPassword.charAt(i)<128){
            num[i] = (rawPassword.charAt(i))+ (i + 1 + 3);
            }else {
                num[i]=rawPassword.charAt(i)+(i+1+3-20);
            }
            System.out.print((char) (num[i]));
            list2.add((char)(num[i]));
        }
        System.out.println("");
//        Object[] objects2 = list2.toArray();
//        System.out.println("before list2:"+Arrays.toString(objects2));

        //(2)将字符串的第一位和最后一位调换顺序
        Collections.swap(list2,0,list2.size()-1);
        System.out.println("after list2:"+list2);
        //(3)反转
        Collections.reverse(list2);
        System.out.println("经过加密后的密码是："+list2.toString());



        //解密
        System.out.println("请输入加密后的密码(用逗号隔开)：");
        Scanner sc2=new Scanner(System.in);
        String encPassword=sc2.nextLine();
        ArrayList decryptlist =new ArrayList(16);

        String[] array1 = encPassword.split( ","/*\x00-\x7F*/);
        for (int i=0;i<array1.length;i++){
            decryptlist.add(array1[i]);
        }
        //System.out.println("testdecryptlist："+decryptlist);
        //(1)
        Collections.reverse(decryptlist);
        //System.out.println("反转后的密码是："+decryptlist);
        //(2)
        Collections.swap(decryptlist,0,decryptlist.size()-1);
        //System.out.println("after decryptlist:"+decryptlist);
        encPassword = decryptlist.toString();
        System.out.println(encPassword);
        //(3)
        System.out.println("请将以上内容重新输入（直接输入，无需用逗号隔开）：");
        Scanner sc3=new Scanner(System.in);
        String str3=sc3.nextLine();
        System.out.println(str3);
        System.out.println("");
        int num2[]=new int[16];
        System.out.print("解密后的密码是：");
        decryptlist.clear();
        for (int i = 0; i < array1.length; i++) {
            num2[i] = (str3.charAt(i))-(i + 1 + 3);
            System.out.print((char) (num2[i]));
            decryptlist.add((char)(num2[i]));
        }

//        System.out.println("");
//        Object[] objects3 =decryptlist.toArray();
//        System.out.println("解密后的密码是:"+Arrays.toString(objects3));
    }


//    public String Enc(){
//
//
//        return "";
//    }

//     static String stringTranfromAscii(String value){
//        StringBuffer sbu =new StringBuffer();
//        char[]chars =value.toCharArray();
//        for (int i=0;i<chars.length;i++){
//            if (i!=chars.length-1){
//                sbu.append((int)chars[i]).append(",");
//            }else{
//                sbu.append((int)chars[i]);
//            }
//        }
//        return sbu.toString();
//     }



    //
    //public String Cne(){return "";}



}
ceshidaima