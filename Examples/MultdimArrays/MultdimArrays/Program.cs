using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MultdimArrays
{
    class Program
    {
        static void Main(string[] args)
        {
            int[][] a;                   // a is a NESTED array. It exists in C# and Java.
            a = new int[2][];            // a is a NESTED array of two positions, each one being an array. 
                                         // Each of those arrays may have different size
            a[0] = new int[3]; ;
            a[1] = new int[] { 4, 5, 6, 7, 8, 9 };
            a[0][0] = 1; a[0][1] = 2; a[0][2] = 3;
           

            int[,] b;                      // b is a MULTIDIMENSIONAL array. It exists in C# but not in Java.
            b = new int[2, 3];             // b is a MULTIDIMENSIONAL array of 2 lines and 3 columns
                                           // Each line has the same number of columns
            b[0, 0] = 1; b[0, 1] = 2; b[0, 2] = 3;
            b[0, 0] = 4; b[0, 1] = 5; b[0, 2] = 6;

            Console.ReadKey();
        }
    }
}
