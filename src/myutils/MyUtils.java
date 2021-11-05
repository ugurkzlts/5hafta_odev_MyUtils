import java.util.Scanner;
class MyUtils {
    
    
    
  public static float UcgenCevre(float a,float b,float c){
    float Ucevre=a+b+c;
   // System.out.println("cevre="+Ucevre);
    return Ucevre;
  }

  
  
  public static float UcgenAlan(float a,float b,float c){

    float Ucevre=UcgenCevre(a, b, c);
    float u=Ucevre/2;
    double UcAlan=Math.sqrt(u*(u-a)*(u-b)*(u-c));
    //System.out.println("Ucgen alan="+UcAlan);
    float UAlan=(float) UcAlan;
    return UAlan;
  }

  
  
  public static float DuzgunCokgenCevre(float _kcgn,float _R){
    float aci=360/_kcgn;
    float cosinus=(float)Math.round(Math.cos(aci));
    float kenar=(_R*_R)+(_R*_R)-(2*_R*_R)*cosinus;
    float kenar_uzun_bul=(float)Math.sqrt(kenar);
    float CokgenCevre=Math.round(_kcgn*kenar_uzun_bul);
    return CokgenCevre;
  }
  
  
  
  public static float DuzgunCokgenAlan(float _kcgn,float _R){
    float aci=360/_kcgn;
    float sinus=(float)Math.round(Math.sin(aci));
    double z=0.5;
    float z_float=(float)z;
    float CokgenAlan=z_float*(_kcgn*_R*_R)*(sinus);
    return CokgenAlan;
  }

  
  
  public static void Fonk(float par1,float par2){
  
    double[] fonkdizi1=new double[201];
    double[] fonkdizi2=new double[201];
    int sayac=0;
    double e=2.3;
    double eust=1;
    double fx1,fx2;
    int par1_1=(int)par1;
    int par2_2=(int)par2;
      for(int i=par1_1;i<=par2_2;i++){   // -100 ile 100 arası deger yazılabılır   
          if(i<0){
            for(int j=0;j>i;j--){ 
              eust=eust*e;
              }
            eust=1/eust;  
          }else{
            for(int j=0;j<i;j++){ 
            eust=eust*e;
            }
          }    
        fx1= (3*i*i)-(2*eust)+Math.sqrt(Math.abs(i));
        fx2=1/(1+eust);
        fonkdizi1[sayac]=fx1;
        fonkdizi2[sayac]=fx2;
        sayac++;
        System.out.println("f("+i+")=3."+i+"^2-2.e^"+i+"+√"+i+"="+fx1);
        System.out.println("f("+i+")=1/(1+e^"+i+")="+fx2+"\n");
        eust=1;
        } 
    }
  
  
  
  public static void main(String[] args) {
      
       Scanner Adegeri=new Scanner(System.in);
       Scanner Bdegeri=new Scanner(System.in);
       Scanner Cdegeri=new Scanner(System.in);
       Scanner Kacgen=new Scanner(System.in);
       Scanner BirKenarUzun=new Scanner(System.in);
       Scanner Parametre1=new Scanner(System.in);
       Scanner Parametre2=new Scanner(System.in);
        //---------------------------------------------------------------------------------------------------
        int kontrol_1=0;
        do{
            System.out.println("Üçgenin 1. Kenarını giriniz");
            float a=Adegeri.nextFloat();
            System.out.println("Ücgenın 2. Kenarını giriniz");
            float b=Bdegeri.nextFloat();
            System.out.println("Ücgenın 3. Kenarını giriniz");
            float c=Cdegeri.nextFloat();
        
            // gırılen degerler üçgen olusturuyormu kontrol edılmesi
            if(a+b>c && Math.abs(a-b)<c ||a+c>b && Math.abs(a-c)<b ||b+c>a && Math.abs(b-c)<a ){
                float Gelen_UcgenCevre=UcgenCevre(a,b,c);
                System.out.println("ÜCGEN CEVRESI="+Gelen_UcgenCevre);
                float Gelen_UcgenAlan=UcgenAlan(a,b,c);
                System.out.println("ÜCGEN ALAN="+Gelen_UcgenAlan+"\n \n");
                kontrol_1=1;
            }else{ 
                System.out.println("GİRİLEN DEGERLER ÜCGEN OLUSTURMUYOR \n YENİDEN GIRIS YAPINIZ");
            }
        }while(kontrol_1!=1);
        //---------------------------------------------------------------------------------------------------------------------
    // cokgenın parametrelerının gırıs yapıldıgı blok
        int kontrol_3=0;
        do{
            System.out.println("Cokgen Kacgen Olsun deger giriniz ");
            float kcgn=Kacgen.nextFloat();
            System.out.println("Cokgenin R yarıcap degerini giriniz; ");
            float R=BirKenarUzun.nextFloat();
            if(kcgn<=3 || R<=0){
                System.out.println("cokgen ıcın 3 den buyuk R capı ıcın 0 dan buyuk deger gırınız");
            
            }else{
                float Gelen_DuzgunCokgenCevre=DuzgunCokgenCevre(kcgn,R);
                System.out.println("COKGENIN  CEVRESİ= "+Gelen_DuzgunCokgenCevre+"\n");

                float Gelen_DuzgunCokgenAlan=DuzgunCokgenAlan(kcgn,R);
                System.out.println("ÇOKGENİN ALANI= "+Gelen_DuzgunCokgenAlan+"\n");   
                kontrol_3=1;
            }
        }while(kontrol_3!=1);
    //--------------------------------------------------------------------------------------------------------------

    
    
        System.out.println("------------------ \n");
        System.out.println("f(x)=3x^2-2e^x+√x  \n");
        System.out.println("f(x)=1/(1+e^x)     \n");
        System.out.println("------------------ \n");
        int kontrol_2=0;
        do{
            System.out.println("f(x) Fonksıyonu icin 1. Parametreyı Negatıf olarak  giriniz");
            float par1=Parametre1.nextFloat();
            System.out.println("f(x) Fonksıyonu icin 2. Parametreyı Pozitif olarak  giriniz");
            float par2=Parametre2.nextFloat();
            if(par1>0 || par2<0 || par1<par2){
                System.out.println("Deger aralıgını dogru girınız 1. parametre '-'  2.parametre '+' deger almalıdır tekrar giris yapınız");
            }else {
                Fonk(par1,par2);
                kontrol_2=1;}
        }while(kontrol_2!=1);
   
  } 
}

