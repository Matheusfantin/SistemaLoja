package Banco;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class Validar_Usuario {
	
   
	
	
	public boolean validar (String usuario , String senha) throws Exception{		
		//criptografia 
	  
		//criptografia
		
		
		String sql = "select * from Usuario where usuario = '" +usuario+ "' and senha = '"+senha+"'  ";
		PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()){
			
			return true ;
		}
		
		else 
			 return false ;
	}

}
