package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class SteamController implements ISteamController {

	public SteamController() {
		super();
	}

	@Override
	public void readFile(String ano, String mes, double media) throws IOException {
		String path = "C:\\Users\\dti\\Downloads\\Exercicio_Arquivos_Steam";
		String arquivo = "SteamCharts.csv";
		File arq = new File(path, arquivo);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			System.out.println("Jogos: ");
			while (linha != null) {
				String[] vetLinha = linha.split(",");
				if ((vetLinha[1].contains(ano))) {
					if (vetLinha[2].contains(mes)) {
						double mediaS = Double.parseDouble(vetLinha[3]);
						if (mediaS >= media) {
							System.out.println(" ( " + vetLinha[0] + " |  " + vetLinha[3] + " )");
							linha = buffer.readLine();
						} else {
							linha = buffer.readLine();
						}
					} else {
						linha = buffer.readLine();
					}
				} else {
					linha = buffer.readLine();
				}

			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo inválido!!!");
		}
	}

	@Override
	public void readFile2(String ano, String mes, String path2, String file2) throws IOException {
		String path = "C:\\Users\\dti\\Downloads\\Exercicio_Arquivos_Steam";
		String arquivo = "SteamCharts.csv";
		StringBuffer sBuffer = new StringBuffer();
		File arq = new File(path, arquivo);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(",");
				if ((vetLinha[1].contains(ano) && vetLinha[2].contains(mes))) {
					sBuffer.append(vetLinha[0] + " ; " + vetLinha[3] + "\r\n");
					linha = buffer.readLine();
				} else {
					linha = buffer.readLine();
				}
			}
			File arq2 = new File(path2, file2);
			File dir = new File(path2);
			arq2.createNewFile();
			if (dir.exists() && dir.isDirectory()) {
				if (arq.exists() && arq.isFile()) {
					String conteudo = sBuffer.toString();
					FileWriter abreArq = new FileWriter(arq2, true);
					PrintWriter escreveArq = new PrintWriter(abreArq);
					escreveArq.write(conteudo);
					escreveArq.flush();
					escreveArq.close();
					abreArq.close();
					System.out.println("Arquivo gerado com sucesso!!");
				}
			}

		} else {
			throw new IOException("Arquivo inválido!!!");

		}
	}

}
