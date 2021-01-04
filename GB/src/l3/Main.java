package l3;

import java.io.*;

public class Main {

    //1.Добавить в сетевой чат запись локальной истории в текстовый файл на клиенте.
    private void SaveHistory() throws IOException {
        try {
            File history = new File("history.txt");
            if (!history.exists()) {
                System.out.println("Истории нет, создадим файл");
                history.createNewFile();
            }
            PrintWriter fileWriter = new PrintWriter(new FileWriter(history, false));

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(textArea.getText()); //здесь textArea наше поле откуда берем информацию для записи
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
}
