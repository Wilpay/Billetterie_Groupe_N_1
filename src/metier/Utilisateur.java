/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author Willy
 */
public class Utilisateur {
    
    private int idUtil;
    private String login;
    private String password;
    private String nomUtil;
    private String preUtil;

    public Utilisateur(int idUtil, String login, String password, String nomUtil, String preUtil) {
        this.idUtil = idUtil;
        this.login = login;
        this.password = password;
        this.nomUtil = nomUtil;
        this.preUtil = preUtil;
    }

    public int getIdUtil() {
        return idUtil;
    }

    public void setIdUtil(int idUtil) {
        this.idUtil = idUtil;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomUtil() {
        return nomUtil;
    }

    public void setNomUtil(String nomUtil) {
        this.nomUtil = nomUtil;
    }

    public String getPreUtil() {
        return preUtil;
    }

    public void setPreUtil(String preUtil) {
        this.preUtil = preUtil;
    }

    
}
