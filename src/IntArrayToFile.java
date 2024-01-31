import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IntArrayToFile
{
    public static void saveArrayToFile (String pathToFile, int[] array)
    {
        try (PrintStream printStream = new PrintStream(new FileOutputStream(new File(pathToFile))))
        {
            for (int value : array)
            {
                printStream.println(value);
            }
            System.out.println("Array has been saved to the file.");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static int[] loadArrayFromFile (String pathToFile)
    {
        int[] array = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(pathToFile))))
        {
            String line;
            int index = 0;

            while ((line = bufferedReader.readLine()) != null)
            {
                if (array == null)
                {
                    array = new int[1];
                } else
                {
                    int[] newArray = new int[array.length + 1];
                    System.arraycopy(array, 0, newArray, 0, array.length);
                    array = newArray;
                }

                array[index++] = Integer.parseInt(line);
            }

            System.out.println("Array has been loaded from file.");
        } catch (IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }

        return array;
    }

    public static void main(String[] args)
    {
        int[] Array = {1, 2, 3, 4, 5, 6};

        saveArrayToFile("D:/JAVA/IntArrayList.txt", Array);

        int[] loadedArray = loadArrayFromFile("D:/JAVA/IntArrayList.txt");

        if (loadedArray != null)
        {
            System.out.println("Loaded Array: ");
            for (int value : loadedArray)
            {
                System.out.println(value + " ");
            }
        }
    }
}

