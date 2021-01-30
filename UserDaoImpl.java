import java.io.*;

public class UserDaoImpl implements UserDao {

    final String dataFile = "data.txt";

    public static void main(String[] args) {

        UserUIControl u = new UserUIControl();
        u.startUI();

    }


    public void insertUser(User user) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(dataFile));
            writer.write(user.getName());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (Exception ex) {
                System.out.println("Error in closing the BufferedWriter" + ex);
            }
        }
    }

    public User getUsers() {

        String data = null;

        try {
            File file = new File(dataFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader reader = new BufferedReader(new FileReader((dataFile)));

            data = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (data == null) {
            data = "new user";
        }
        return new User(data);
    }
}
