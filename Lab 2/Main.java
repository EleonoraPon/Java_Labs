import java.util.Scanner;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();


    }

    public static void task1()
    {
        String usedChars = "";

        String inputString = "abbabaaabcbbc";

        int start = 0;
        int maxStart = 0;
        int maxLength = 0;
        int currentLength = 0;

        for (int i = 0; i < inputString.length(); i++)
        {
            String currentChar = "" + inputString.charAt(i);

            if (usedChars.contains(currentChar))
            {
                start = i;
                usedChars = "";
            }

            usedChars = usedChars + currentChar;

            currentLength = i - start + 1;

            if (currentLength > maxLength)
            {
                maxLength = currentLength;
                maxStart = start;
            }
        }

        System.out.println(inputString.substring(maxStart, maxStart + maxLength));
    }

    public static void task2()
    {
        int arr1[] = {1, 3, 5, 7, 9};
        int arr2[] = {2, 4, 6, 8, 10};

        int len1 = arr1.length;
        int len2 = arr2.length;
        int Array[] = new int[len1 + len2];
        int count = 0;

        for (int i = 0; i < len1; i++)
        {
            Array[i] = arr1[i];
            count++;
        }
        for (int i = 0; i < len2; i++)
        {
            Array[count++] = arr2[i];
        }

        for (int i = 0; i < Array.length; i++)
        {
            for (int j = 0; j < Array.length; j++)
            {
                if(Array[i] < Array[j])
                {
                    int temp = Array[i];
                    Array[i] = Array[j];
                    Array[j] = temp;
                }
            }
        }

        for (int elem : Array)
        {
            System.out.println(elem);
        }
    }

    public static void task3()
    {
        int Array[] = {1, 2, 3, -5, 3, 4};

        int maxSum = -100000000; //TODO
        int sum = 0;

        for(int i=0;i<Array.length;i++)
        {
            for(int j=Array.length;j>=0;j--)
            {
                sum = 0;
                for(int k=i;k<j;k++)
                    sum+=Array[k];
                if(maxSum<sum)
                    maxSum = sum;
            }
        }

        System.out.println(maxSum);

    }

    public static void task4()
    {

        int n = 3;
        int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int matT[][] = new int [n][n];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matT[i][j] = mat[j][i];
            }
        }

        for(int i = 0; i < n; i++)
        {
            for (int j = 0; j < n / 2; j++)
            {
                int temp = matT[i][j];
                matT[i][j] = matT[i][n - 1 - j];
                matT[i][n - 1 - j] = temp;
            }
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(matT[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void task5()
    {
        int[] mas = {1, 2, 4, 6, 9};
        int target = 15;

        boolean flag = false;

        for (int i = 0; i < mas.length; i++)
        {
            for (int j = 0; j < mas.length; j++)
            {
                if (mas[i] + mas[j] == target)
                {
                    System.out.println(mas[i]);
                    System.out.println(mas[j]);
                    flag = true;
                    break;
                }
                else
                {
                    flag = false;
                }

            }
        }

        if (flag == false)
        {
            System.out.println("null");
        }
    }

    public static void task6()
    {
        int[] mas = {1, 2, 3, 4, 5, 6, 7};
        int sum = 0;

        for(int i = 0; i < mas.length; i++)
        {
            sum += mas[i];
        }

        System.out.println(sum);
    }

    public static void task7()
    {
        //int n = 3;
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int[] ans = new int [mat.length];

        for(int i = 0; i < mat.length; i++)
        {
            ans[i] = mat[i][0];
            for(int j = 0; j < mat.length; j++)
            {
                if(ans[i] < mat[i][j])
                {
                    ans[i] = mat[i][j];
                }
            }
        }

        System.out.println(Arrays.toString(ans));

    }

    public static void task8()
    {
        int n = 3;
        int[][] mat = {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};
        int matT[][] = new int [n][n];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matT[i][j] = mat[j][i];
            }
        }

        for(int i = 0; i < n/2; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int temp = matT[i][j];
                matT[i][j] = matT[n - 1 - i][j];
                matT[n - 1 - i][j] = temp;
            }
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(matT[i][j] + " ");
            }
            System.out.println();
        }
    }
}