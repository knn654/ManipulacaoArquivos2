package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ISteamController;
import controller.SteamController;

public class Principal {
	public static void main(String[] args) {
		ISteamController arqCont = new SteamController();
		// String path = "C:\\Users\\dti\\Downloads\\Exercicio_Arquivos_Steam";
		// String arquivo = "SteamCharts.csv";
		int opc = Integer.parseInt(JOptionPane.showInputDialog("Digite uma op��o: \n 1 - Buscar diretamente no arquivo e mostrar em java "
				+ "\n 2 - Buscar e gerar arquivo" + "\n 9 - Fim"));
			if (opc == 1) {
				String ano = JOptionPane.showInputDialog("Digite um ano para a busca ");
				String mes = JOptionPane.showInputDialog("Digite um m�s (em ingl�s) para a busca: ");
				double media = Integer
						.parseInt(JOptionPane.showInputDialog("Digite uma m�dia de jogadores para a busca: "));
				try {
					arqCont.readFile(ano, mes, media);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (opc == 2) {
				String ano = JOptionPane.showInputDialog("Digite um ano para a busca ");
				String mes = JOptionPane.showInputDialog("Digite um m�s (em ingl�s) para a busca: ");
				String path = JOptionPane.showInputDialog("Digite o caminho de diret�rio v�lido: ");
				String arquivo = JOptionPane.showInputDialog("Digite um nome de arquivo v�lido: ");

				try {
					arqCont.readFile2(ano, mes, path, arquivo);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Fim");
			}
	}

}
