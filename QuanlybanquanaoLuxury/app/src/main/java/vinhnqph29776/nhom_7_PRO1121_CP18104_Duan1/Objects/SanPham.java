package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects;

import android.media.Image;

public class SanPham {
   int masp;
    String tensp,soluong;
    String size ,money;
    String image;





    public SanPham() {
    }


    public SanPham( String tensp, String money, String image,String soluong,String size) {
        this.tensp = tensp;
        this.money = money;
        this.image = image;
        this.soluong=soluong;
        this.size=size;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }



    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return String.valueOf(masp);
    }
}
