package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import app.Util;
import fachada.Fachada;
import modelo.DaoException;
import modelo.Funcionario;
import view.Mensagens;
import view.Tela_Login;

public class Controlador_Tela_Login implements ActionListener, KeyListener {
	Tela_Login tela;
	Fachada fachada;
	private ControladorTela controlador;

	public Controlador_Tela_Login() {
		tela = new Tela_Login();
		fachada = new Fachada();
		tela.setVisible(true);
		tela.getEntrar().addActionListener(this);
		tela.getSenhaF().addKeyListener(this);
	}
	public void login() {
		tela.getRedimencionarTela().setEnabled(false);
		tela.getLoginF().requestFocusInWindow();
		tela.getLoginF().setText("");
		tela.getSenhaF().setText("");
		tela.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		logar();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
			logar();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {}
	@SuppressWarnings("deprecation")
	public void logar() {
		boolean logou = false;
		try {
			for(Funcionario f: fachada.getFuncionarios("")) {
				if(tela.getLoginF().getText().equals(f.getLogin()) && tela.getSenhaF().getText().equals(f.getSenha())) {
					Util.funcionarioLogado = f;
					tela.setVisible(false);
					if(controlador==null)
						controlador = new ControladorTela(tela.getRedimencionarTela().isSelected());
					else {
						controlador.tela.getInicio().getFuncionario().setText("Funcionario: "+Util.funcionarioLogado.getNome());
						controlador.setVisible(true);
						controlador.tela.setExtendedState(JFrame.NORMAL);
					}

					logou = true;
					break;
				}


			}
			if(!logou)
				Mensagens.erroF("Erro ao Realizar Login", "Login e/ou senha inválido!");
			
		} catch (DaoException e) {}
	}
}