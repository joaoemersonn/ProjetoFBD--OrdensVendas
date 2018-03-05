package app;

import javax.swing.UIManager;

import controller.Controlador_Tela_Login;
public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//			System.out.println(Util.inverterString("olha que coisa maiss linda"));
			Util.controladorLogin = new Controlador_Tela_Login();			
		} catch (Exception e){}


	}
}
