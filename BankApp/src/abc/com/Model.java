package abc.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Model {
	private String name;
	private int accno;
	private int balance;
	private String custid;
	private String pwd;
	private String email;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rst = null;
	private int raccno;
	private ArrayList<Integer> arrayList;

	public ArrayList<Integer> getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList<Integer> arrayList) {
		this.arrayList = arrayList;
	}
	
	
	public int getRaccno() {
		return raccno;
	}

	public void setRaccno(int raccno) {
		this.raccno = raccno;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	Model() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "system");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean login()
	{
		try {
			pstmt=con.prepareStatement("SELECT * FROM SWISS_BANK WHERE CUSTID=? AND PWD=?");
			pstmt.setString(1, custid);
		    pstmt.setString(2, pwd);
		    
			rst=pstmt.executeQuery();
			if(rst.next()){
				accno=rst.getInt("ACCNO");
				return true;
		} 
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
			finally
			{
				try{
					if(rst!=null)
						rst.close();
					if(con!=null)
						con.close();
					if(pstmt!=null)
						pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
					
				}
		}
		return false;
		
	}	
	public boolean changePwd() {
		try {
			pstmt = con.prepareStatement("UPDATE SWISS_BANK SET PWD=? WHERE ACCNO=?");
			pstmt.setString(1, pwd);
			pstmt.setInt(2, accno);
			int result = pstmt.executeUpdate();

			if (result == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rst != null)
					rst.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}

		return false;
	}	
	
	public boolean transfer() {
		try {
			pstmt = con.prepareStatement("UPDATE SWISS_BANK SET BALANCE = BALANCE - ? WHERE ACCNO = ?");
			pstmt.setInt(1, balance);
			pstmt.setInt(2, accno);
			int qry1 = pstmt.executeUpdate();

			if (qry1 == 1) {
				pstmt = con.prepareStatement("UPDATE SWISS_BANK SET BALANCE = BALANCE + ? WHERE ACCNO = ?");
				pstmt.setInt(1, balance);
				pstmt.setInt(2, raccno);
				int qry2 = pstmt.executeUpdate();

				if (qry2 == 1) {
					pstmt = con.prepareStatement("INSERT INTO STATEMENT VALUES(?,?)");
					pstmt.setInt(1, accno);
					pstmt.setInt(2, (balance * -1));
					int qry3 = pstmt.executeUpdate();

					if (qry3 == 1) {
						pstmt = con.prepareStatement("INSERT INTO STATEMENT VALUES(?,?)");
						pstmt.setInt(1, raccno);
						pstmt.setInt(2, balance);
						int qry4 = pstmt.executeUpdate();

						if (qry4 == 1)
						return true;
					}
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				e.printStackTrace();

			}

		}

		return false;
	}
	public void getStatement() {
		try {
			pstmt = con.prepareStatement("SELECT * FROM STATEMENT WHERE ACCNO=?");
			pstmt.setInt(1, accno);
			rst = pstmt.executeQuery();

			arrayList = new ArrayList<Integer>();

			while (rst.next()) {
				arrayList.add(rst.getInt("AMT"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rst != null)
					rst.close();
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}

		}

	}
	public boolean checkBalance() {

		try {
			pstmt = con.prepareStatement("SELECT * FROM SWISS_BANK WHERE ACCNO=?");
			pstmt.setInt(1, accno);
			rst = pstmt.executeQuery();
			if (rst.next()) {
				balance = rst.getInt("BALANCE");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null)
					rst.close();
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

}
}


