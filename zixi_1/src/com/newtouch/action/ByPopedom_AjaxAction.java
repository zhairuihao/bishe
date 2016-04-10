package com.newtouch.action;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.newtouch.entity.User;
import com.newtouch.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class ByPopedom_AjaxAction  extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	 private UserService userservice;
	    private int popedom;
	    private List<User> alluser;
		public UserService getUserservice() {
			return userservice;
		}
		public void setUserservice(UserService userservice) {
			this.userservice = userservice;
		}
		public int getPopedom() {
			return popedom;
		}
		public void setPopedom(int popedom) {
			this.popedom = popedom;
		}
		public List<User> getAlluser() {
			return alluser;
		}
		public void setAlluser(List<User> alluser) {
			this.alluser = alluser;
		}
		@Override
		public String execute() throws Exception {
			// TODO Auto-generated method stub
			
			alluser = userservice.queryAll(popedom);
			@SuppressWarnings("unchecked")
			Map<String, List<User>> session = ActionContext.getContext().getSession();
			session.put("alluser", alluser);
			HttpServletResponse response = ServletActionContext.getResponse();	
			
     /*       if(null == alluser){
                return null ;
            }
            for(User a : alluser){
                System.out.println(a.getUsername());
            }
            JSONArray json = new JSONArray();
           for(User a : alluser){
                JSONObject jo = new JSONObject();
                jo.put("userId", a.getUserId());
                jo.put("username", a.getUsername());
                jo.put("password", a.getPassword());
                json.add(jo);
            }	*/

				//然后你便利那个List
				String json ="" ;//"{v:[";
				int i=0;
				for(User a : alluser){
					
					if(i<alluser.size()-1)
				   json = json+"{"+"'"+"userId"+"':"+"'"+a.getUserId()+"',"
				   		+"'"+"username"+"':"+"'"+a.getUsername()+"',"
				   		+"'"+"password"+"':"+"'"+a.getPassword()+"',"
				   		+"'"+"sex"+"':"+"'"+a.getSex()+"',"
				   		+"'"+"age"+"':"+"'"+a.getAge()+"',"
				   		+"'"+"birthd"+"':"+"'"+a.getBirthd()+"',"
				   		+"'"+"popedom"+"':"+"'"+a.getPopedom()+"',"
				   		+"'"+"integral"+"':"+"'"+a.getIntegral()+"',"
				   		+"'"+"d_delete"+"':"+"'"+a.getD_delete()+"'"
				   		+ "},";
					else
						 json = json+"{"+"'"+"userId"+"':"+"'"+a.getUserId()+"',"
							   		+"'"+"username"+"':"+"'"+a.getUsername()+"',"
							   		+"'"+"password"+"':"+"'"+a.getPassword()+"',"
							   		+"'"+"sex"+"':"+"'"+a.getSex()+"',"
							   		+"'"+"age"+"':"+"'"+a.getAge()+"',"
							   		+"'"+"birthd"+"':"+"'"+a.getBirthd()+"',"
							   		+"'"+"popedom"+"':"+"'"+a.getPopedom()+"',"
							   		+"'"+"integral"+"':"+"'"+a.getIntegral()+"',"
							   		+"'"+"d_delete"+"':"+"'"+a.getD_delete()+"'"
							   		+ "}";	
					i++;
				//+"]}";
				   
				}
				json="{v:["+json+"]}";
			System.out.println("====="+json);
			//JSONArray jsonarray = JSONArray.fromObject(alluser);  
			
			PrintWriter out = response.getWriter();
			System.out.println("pwd:"+popedom);
			//System.out.println(json);
			out.print(json);
			out.flush();
			out.close();
			
			return null;
		}

}
