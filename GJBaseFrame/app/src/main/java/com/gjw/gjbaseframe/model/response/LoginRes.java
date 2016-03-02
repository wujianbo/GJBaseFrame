package com.gjw.gjbaseframe.model.response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hank on 2016/1/13/16:16:16
 */
public class LoginRes extends BaseRes {

   /**
    * birthday : -28800
    * id : 23
    * imagePath : http://img.goujiawang.com/store/guber/20150923/1443003759537393915.jpg
    * nickname : 李师傅
    * phone : 13124111863
    * realName : AA啊
    * sex : 女
    * username : 13124111863
    * userpwd : e10adc3949ba59abbe56e057f20f883e
    * worker : {"adddate":1441175214000,"alipayaccountnumber":"13124111863","alipayname":"李荃荃","assess":0.8272728333333333,"assessCount":0,"id":16,"idcardcons":"http://img.goujiawang.com/store/guber/20150902/1441204014655919522.jpg","idcardhand":"http://img.goujiawang.com/store/guber/20150902/1441204014666559647.jpg","idcardno":"370686199209272224","idcardpros":"http://img.goujiawang.com/store/guber/20150902/1441204014579721575.jpg","labels":[{"adddate":1441645771000,"id":2,"labelname":"装修装饰","parentid":0,"status":0},{"adddate":1441645804000,"id":5,"labelname":"家政保洁","parentid":0,"status":0},{"adddate":1441645824000,"id":7,"labelname":"管道疏通","parentid":0,"status":0}],"latitude":"30.278513","longitude":"120.119446","realname":"AA啊","residentAddress":"西湖区文三路477号华星科技大厦","status":1,"userid":23,"workPresent":"其实什么都不会"}
    */

   private LoginResData data;

   /**
    * data : {"birthday":"-28800","id":23,"imagePath":"http://img.goujiawang.com/store/guber/20150923/1443003759537393915.jpg","nickname":"李师傅","phone":"13124111863","realName":"AA啊","sex":"女","username":"13124111863","userpwd":"e10adc3949ba59abbe56e057f20f883e","worker":{"adddate":1441175214000,"alipayaccountnumber":"13124111863","alipayname":"李荃荃","assess":0.8272728333333333,"assessCount":0,"id":16,"idcardcons":"http://img.goujiawang.com/store/guber/20150902/1441204014655919522.jpg","idcardhand":"http://img.goujiawang.com/store/guber/20150902/1441204014666559647.jpg","idcardno":"370686199209272224","idcardpros":"http://img.goujiawang.com/store/guber/20150902/1441204014579721575.jpg","labels":[{"adddate":1441645771000,"id":2,"labelname":"装修装饰","parentid":0,"status":0},{"adddate":1441645804000,"id":5,"labelname":"家政保洁","parentid":0,"status":0},{"adddate":1441645824000,"id":7,"labelname":"管道疏通","parentid":0,"status":0}],"latitude":"30.278513","longitude":"120.119446","realname":"AA啊","residentAddress":"西湖区文三路477号华星科技大厦","status":1,"userid":23,"workPresent":"其实什么都不会"}}
    * msg :
    * returnCode : 0000
    */

   public void setData(LoginResData data) {
      this.data = data;
   }

   public LoginResData getData() {
      return data;
   }

   public static class LoginResData {
      private String birthday;
      private int id;
      private String imagePath;
      private String nickname;
      private String phone;
      private String realName;
      private String sex;
      private String username;
      private String userpwd;
      /**
       * adddate : 1441175214000
       * alipayaccountnumber : 13124111863
       * alipayname : 李荃荃
       * assess : 0.8272728333333333
       * assessCount : 0
       * id : 16
       * idcardcons : http://img.goujiawang.com/store/guber/20150902/1441204014655919522.jpg
       * idcardhand : http://img.goujiawang.com/store/guber/20150902/1441204014666559647.jpg
       * idcardno : 370686199209272224
       * idcardpros : http://img.goujiawang.com/store/guber/20150902/1441204014579721575.jpg
       * labels : [{"adddate":1441645771000,"id":2,"labelname":"装修装饰","parentid":0,"status":0},{"adddate":1441645804000,"id":5,"labelname":"家政保洁","parentid":0,"status":0},{"adddate":1441645824000,"id":7,"labelname":"管道疏通","parentid":0,"status":0}]
       * latitude : 30.278513
       * longitude : 120.119446
       * realname : AA啊
       * residentAddress : 西湖区文三路477号华星科技大厦
       * status : 1
       * userid : 23
       * workPresent : 其实什么都不会
       */

      private LoginResDataWorker worker;

      public void setBirthday(String birthday) {
         this.birthday = birthday;
      }

      public void setId(int id) {
         this.id = id;
      }

      public void setImagePath(String imagePath) {
         this.imagePath = imagePath;
      }

      public void setNickname(String nickname) {
         this.nickname = nickname;
      }

      public void setPhone(String phone) {
         this.phone = phone;
      }

      public void setRealName(String realName) {
         this.realName = realName;
      }

      public void setSex(String sex) {
         this.sex = sex;
      }

      public void setUsername(String username) {
         this.username = username;
      }

      public void setUserpwd(String userpwd) {
         this.userpwd = userpwd;
      }

      public void setWorker(LoginResDataWorker worker) {
         if(worker==null)
            this.worker=new LoginResDataWorker();
         else
            this.worker = worker;
      }

      public String getBirthday() {
         return birthday;
      }

      public int getId() {
         return id;
      }

      public String getImagePath() {
         return imagePath;
      }

      public String getNickname() {
         return nickname;
      }

      public String getPhone() {
         return phone;
      }

      public String getRealName() {
         return realName;
      }

      public String getSex() {
         return sex;
      }

      public String getUsername() {
         return username;
      }

      public String getUserpwd() {
         return userpwd;
      }

      public LoginResDataWorker getWorker() {
         return worker;
      }

      public static class LoginResDataWorker {
         private long adddate;
         private String alipayaccountnumber;
         private String alipayname;
         private double assess;
         private int assessCount;
         private int id;
         private String idcardcons;
         private String idcardhand;
         private String idcardno;
         private String idcardpros;
         private String latitude;
         private String realname;
         private String longitude;
         private String residentAddress="";
         private int status;
         private int userid;
         private String workPresent;
         /**
          * adddate : 1441645771000
          * id : 2
          * labelname : 装修装饰
          * parentid : 0
          * status : 0
          */

         private List<LoginResDataWorkerLabel> labels;

         public void setAdddate(long adddate) {
            this.adddate = adddate;
         }

         public void setAlipayaccountnumber(String alipayaccountnumber) {
            this.alipayaccountnumber = alipayaccountnumber;
         }

         public void setAlipayname(String alipayname) {
            this.alipayname = alipayname;
         }

         public void setAssess(double assess) {
            this.assess = assess;
         }

         public void setAssessCount(int assessCount) {
            this.assessCount = assessCount;
         }

         public void setId(int id) {
            this.id = id;
         }

         public void setIdcardcons(String idcardcons) {
            this.idcardcons = idcardcons;
         }

         public void setIdcardhand(String idcardhand) {
            this.idcardhand = idcardhand;
         }

         public void setIdcardno(String idcardno) {
            this.idcardno = idcardno;
         }

         public void setIdcardpros(String idcardpros) {
            this.idcardpros = idcardpros;
         }

         public void setLatitude(String latitude) {
            this.latitude = latitude;
         }

         public void setLongitude(String longitude) {
            this.longitude = longitude;
         }

         public void setRealname(String realname) {
            this.realname = realname;
         }

         public void setResidentAddress(String residentAddress) {
            this.residentAddress = residentAddress;
         }

         public void setStatus(int status) {
            this.status = status;
         }

         public void setUserid(int userid) {
            this.userid = userid;
         }

         public void setWorkPresent(String workPresent) {
            this.workPresent = workPresent;
         }

         public void setLabels(List<LoginResDataWorkerLabel> labels) {
            if(labels==null)
               this.labels=new ArrayList<>();
            else
               this.labels = labels;
         }

         public long getAdddate() {
            return adddate;
         }

         public String getAlipayaccountnumber() {
            return alipayaccountnumber;
         }

         public String getAlipayname() {
            return alipayname;
         }

         public double getAssess() {
            return assess;
         }

         public int getAssessCount() {
            return assessCount;
         }

         public int getId() {
            return id;
         }

         public String getIdcardcons() {
            return idcardcons;
         }

         public String getIdcardhand() {
            return idcardhand;
         }

         public String getIdcardno() {
            return idcardno;
         }

         public String getIdcardpros() {
            return idcardpros;
         }

         public String getLatitude() {
            return latitude;
         }

         public String getLongitude() {
            return longitude;
         }

         public String getRealname() {
            return realname;
         }

         public String getResidentAddress() {
            return residentAddress;
         }

         public int getStatus() {
            return status;
         }

         public int getUserid() {
            return userid;
         }

         public String getWorkPresent() {
            return workPresent;
         }

         public List<LoginResDataWorkerLabel> getLabels() {
            return labels;
         }

         public static class LoginResDataWorkerLabel {
            private long adddate;
            private int id;
            private String labelname;
            private int parentid;
            private int status;

            public void setAdddate(long adddate) {
               this.adddate = adddate;
            }

            public void setId(int id) {
               this.id = id;
            }

            public void setLabelname(String labelname) {
               this.labelname = labelname;
            }

            public void setParentid(int parentid) {
               this.parentid = parentid;
            }

            public void setStatus(int status) {
               this.status = status;
            }

            public long getAdddate() {
               return adddate;
            }

            public int getId() {
               return id;
            }

            public String getLabelname() {
               return labelname;
            }

            public int getParentid() {
               return parentid;
            }

            public int getStatus() {
               return status;
            }
         }
      }
   }
}
