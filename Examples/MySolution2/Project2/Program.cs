using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

// we have to "add reference" to Project1
// but "using Project1" is not necessary because we have to qualify "Program" anyway
//using Project1;

namespace Project2
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("I'm project 2");
            Console.WriteLine("Project1 a = " + Project1.Program.a);
            Console.ReadKey();
        }
    }
}
