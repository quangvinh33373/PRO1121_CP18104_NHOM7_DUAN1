package vinhnqph29776.nhom_7_PRO1121_CP18104_Duan1.Objects;

public class HoaDon {

String tensp;
String soluong,gia;
int mahd,tongtien;
 public HoaDon(String tensp, String soluong, String gia, int tongtien) {
  this.tensp = tensp;
  this.soluong = soluong;
  this.gia = gia;
  this.tongtien = tongtien;
 }

 public HoaDon(String tensp, String soluong, String gia) {
  this.tensp = tensp;
  this.soluong = soluong;
  this.gia = gia;
 }

 public HoaDon() {
 }

 public int getMahd() {
  return mahd;
 }

 public void setMahd(int mahd) {
  this.mahd = mahd;
 }

 public String getTensp() {
  return tensp;
 }

 public void setTensp(String tensp) {
  this.tensp = tensp;
 }

 public String getSoluong() {
  return soluong;
 }

 public void setSoluong(String soluong) {
  this.soluong = soluong;
 }

 public String getGia() {
  return gia;
 }

 public void setGia(String gia) {
  this.gia = gia;
 }

 public int getTongtien() {
  return tongtien;
 }

 public void setTongtien(int tongtien) {
  this.tongtien = tongtien;
 }


}
