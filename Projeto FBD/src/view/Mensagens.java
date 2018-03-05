package view;

import javax.swing.JOptionPane;

public class Mensagens {
	public static void erro(String menssagem){
		JOptionPane.showInternalMessageDialog(Tela.desk, menssagem, "ERRO", JOptionPane.ERROR_MESSAGE);
	}
	public static void erro(String titulo, String menssagem){
		JOptionPane.showInternalMessageDialog(Tela.desk, menssagem, titulo, JOptionPane.ERROR_MESSAGE);
	}
	public static void erroF(String titulo, String menssagem){
		JOptionPane.showMessageDialog(null, menssagem, titulo, JOptionPane.ERROR_MESSAGE);
	}
	public static void confirmado(String menssagem){
		JOptionPane.showInternalMessageDialog(Tela.desk, menssagem, "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	public static boolean pergunta(String titulo, String msg) {
		int i = JOptionPane.showInternalConfirmDialog(Tela.desk, msg, titulo,JOptionPane.YES_NO_OPTION);
		if(i == 0)
			return true;
		return false;

	}
	public static void informacao(String string) {
		JOptionPane.showInternalMessageDialog(Tela.desk, string, "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
	}
}
