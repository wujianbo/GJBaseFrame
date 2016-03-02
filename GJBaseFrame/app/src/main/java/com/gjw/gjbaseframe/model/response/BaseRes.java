package com.gjw.gjbaseframe.model.response;
/**
 * Created by hank on 2015/12/24/16:16:50
 */
public class BaseRes {
   private String msg;
   private String returnCode;

   public String getMsg() {
      return msg;
   }

   public void setMsg(String msg) {
      this.msg = msg;
   }

   public String getReturnCode() {
      return returnCode;
   }

   public void setReturnCode(String returnCode) {
      this.returnCode = returnCode;
   }
}
