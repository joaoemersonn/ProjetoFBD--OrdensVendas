/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import view.Mensagens;

/**
 *
 * @author prof Heldon
 */
@SuppressWarnings("serial")
public class DaoException extends Exception{

    public DaoException(String msg) {
        super(msg);
        Mensagens.erro(msg);
    } 
    public DaoException(String titulo, String msg) {
        super(msg);
        Mensagens.erro(titulo,msg);
    }
    
}
